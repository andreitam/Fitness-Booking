package com.andreitam.web.service;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
/**
 * Service class for Google Calendar API
 *
 * @author  Andrei Tamasanu
 * @version 1.0
 * @since   2021-01-23
 */
public class GoogleCalendarService {
    Calendar service;
    static final Logger logger = LogManager.getLogger();

    public GoogleCalendarService(HttpTransport httpTransport, JacksonFactory jacksonFactory,GoogleCredential credential, String applicationName) {
        this.service = new Calendar.Builder(httpTransport, jacksonFactory, credential)
                .setApplicationName(applicationName)
                .build();
    }

    public String setGoogleCalendarEvent(String summary, String location, String description,
                                       LocalDateTime startDateTimeEvent, LocalDateTime endDateTimeEvent) throws IOException {
        //convert from LocalDateTime to Date for passing to google DateTime
        Date startDateTimeEventConverted = java.sql.Timestamp.valueOf(startDateTimeEvent);
        Date endDateTimeEventConverted = java.sql.Timestamp.valueOf(endDateTimeEvent);

        //set event
        Event event = new Event()
                .setSummary(summary)
                .setLocation(location)
                .setDescription(description);
        DateTime startDateTime = new DateTime(startDateTimeEventConverted);
        EventDateTime start = new EventDateTime()
                .setDateTime(startDateTime);
        event.setStart(start);

        DateTime endDateTime = new DateTime(endDateTimeEventConverted);
        EventDateTime end = new EventDateTime()
                .setDateTime(endDateTime);
        event.setEnd(end);

        EventReminder[] reminderOverrides = new EventReminder[] {
                new EventReminder().setMethod("email").setMinutes(24 * 60),
                new EventReminder().setMethod("popup").setMinutes(2*60),
                new EventReminder().setMethod("popup").setMinutes(60),
        };
        Event.Reminders reminders = new Event.Reminders()
                .setUseDefault(false)
                .setOverrides(Arrays.asList(reminderOverrides));
        event.setReminders(reminders);

        String calendarId = "primary";
        event = service.events().insert(calendarId, event).setSendNotifications(true).execute();
        System.out.printf("Event created: %s\n", event.getHtmlLink());
        logger.warn("Event created: %s\n", event.getHtmlLink());
        System.out.println("Event id is: "+event.getId());
        logger.warn("Event id is: "+event.getId());
        return event.getId();
    }

    public Event getEvent(String eventId) throws IOException {
        Event searchedEvent = null;
        DateTime now = new DateTime(System.currentTimeMillis());
        Events events = service.events().list("primary")
                .setTimeMin(now)
                .setOrderBy("startTime")
                .setSingleEvents(true)
                .execute();
        List<Event> items = events.getItems();
        if (items.isEmpty()) {
            System.out.println("No upcoming events found.");
            logger.warn("No upcoming events found.");
        } else {
            System.out.println("Upcoming events");
            logger.warn("Upcoming events");
            for (Event event : items) {
                String eventIdFromList = event.getId();
                System.out.println(event.toPrettyString());
                logger.warn(event.toPrettyString());
                if (eventIdFromList.equals(eventId)) {
                    searchedEvent = event;
                    return searchedEvent;
                }
            }
        }
        return searchedEvent;
    }

    public void deleteGoogleCalendarEvent(Event event) throws IOException {
        service.events().delete("primary", event.getId()).execute();
        System.out.println("deleted event: "+event.toPrettyString());
        logger.warn("deleted event: "+event.toPrettyString());
    }

    public void updateGoogleCalendarEvent(String summary,
                                          LocalDateTime startDateTimeEvent, LocalDateTime endDateTimeEvent, String eventId) throws IOException {

        Event event = service.events().get("primary", eventId).execute();
        event.setSummary(summary);

        Date startDateTimeEventConverted = java.sql.Timestamp.valueOf(startDateTimeEvent);
        DateTime startDateTime = new DateTime(startDateTimeEventConverted);
        EventDateTime start = new EventDateTime().setDateTime(startDateTime);
        event.setStart(start);

        Date endDateTimeEventConverted = java.sql.Timestamp.valueOf(endDateTimeEvent);
        DateTime endDateTime = new DateTime(endDateTimeEventConverted);
        EventDateTime end = new EventDateTime().setDateTime(endDateTime);
        event.setEnd(end);

        Event updatedEvent = service.events().update("primary", event.getId(), event).execute();
        System.out.println("updated event: "+event.toPrettyString());
        logger.warn("updated event: "+event.toPrettyString());
    }

    public void setGoogleCalendarUpcomingEvents() throws IOException {
        DateTime now = new DateTime(System.currentTimeMillis());
        Events events = service.events().list("primary")
                .setMaxResults(10)
                .setTimeMin(now)
                .setOrderBy("startTime")
                .setSingleEvents(true)
                .execute();
        List<Event> items = events.getItems();
        if (items.isEmpty()) {
            System.out.println("No upcoming events found.");
        } else {
            System.out.println("Upcoming events");
            for (Event event : items) {
                DateTime start = event.getStart().getDateTime();
                if (start == null) {
                    start = event.getStart().getDate();
                }
                System.out.printf("%s (%s)\n", event.getSummary(), start);
                System.out.println("event id: "+event.getId());
            }
        }
    }

}
