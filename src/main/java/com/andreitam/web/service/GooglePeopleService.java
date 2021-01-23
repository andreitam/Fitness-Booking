package com.andreitam.web.service;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.people.v1.PeopleService;
import com.google.api.services.people.v1.model.Person;

import java.io.IOException;
/**
 * Service class for Google People API
 *
 * @author  Andrei Tamasanu
 * @version 1.0
 * @since   2021-01-23
 */
public class GooglePeopleService {
    PeopleService peopleService;

    public GooglePeopleService(HttpTransport httpTransport, JacksonFactory jacksonFactory, GoogleCredential credential, String applicationName) {
        this.peopleService = new PeopleService.Builder(httpTransport, jacksonFactory, credential)
                .setApplicationName(applicationName)
                .build();
    }

    public Person returnProfile() throws IOException {
        return peopleService.people().get("people/me")
                .setPersonFields("names,emailAddresses,phoneNumbers,genders,birthdays")
                .execute();
    }
}
