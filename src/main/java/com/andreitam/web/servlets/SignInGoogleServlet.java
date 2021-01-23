package com.andreitam.web.servlets;

import com.andreitam.web.service.GooglePeopleService;
import com.andreitam.web.entity.FitnessGoogleClient;
import com.andreitam.web.service.GoogleUserService;
import com.google.api.client.googleapis.auth.oauth2.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

import com.google.api.services.people.v1.model.*;
import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet(urlPatterns = {"/signinGoogle"})
public class SignInGoogleServlet extends HttpServlet {
    static final Logger logger = LogManager.getLogger();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // (Receive authCode via HTTPS POST) get from ajax body
        String authCode = req.getReader().lines()
                .reduce("", (accumulator, actual) -> accumulator + actual);
        System.out.println("this is the authCode: " + authCode);
        logger.warn("this is the authCode: " + authCode);

        if (req.getHeader("X-Requested-With") == null) {
            // Without the `X-Requested-With` header, this request could be forged. Aborts.
        }

        // Set path to the Web application client_secret_*.json file you downloaded from the
        // Google API Console: https://console.developers.google.com/apis/credentials
        // You can also find your Web application client ID and client secret from the
        // console and specify them directly when you create the GoogleAuthorizationCodeTokenRequest
        // object.
        /*String CLIENT_SECRET_FILE = getServletContext().getRealPath("/")+ "/credentials/client_secret.json";*/
        String CLIENT_SECRET_FILE = getServletContext().getRealPath("/")+ "credentials/client_secret.json";
        logger.warn(CLIENT_SECRET_FILE);
        // Exchange auth code for access token
        GoogleClientSecrets clientSecrets =
                GoogleClientSecrets.load(
                        JacksonFactory.getDefaultInstance(), new FileReader(CLIENT_SECRET_FILE));
        GoogleTokenResponse tokenResponse =
                new GoogleAuthorizationCodeTokenRequest(
                        new NetHttpTransport(),
                        JacksonFactory.getDefaultInstance(),
                        "https://oauth2.googleapis.com/token",
                        clientSecrets.getDetails().getClientId(),
                        clientSecrets.getDetails().getClientSecret(),
                        authCode,
                        "https://immense-sierra-70031.herokuapp.com")  // Specify the same redirect URI that you use with your web
                        // app. If you don't have a web version of your app, you can
                        // specify an empty string.
                        .execute();

        String accessToken = tokenResponse.getAccessToken();
        req.getSession().setAttribute("accessToken", accessToken);
        System.out.println("the access token:"+accessToken);
        logger.warn("the access token:"+accessToken);
        //Get refresh token
        String refreshToken = tokenResponse.getRefreshToken();
        System.out.println("the refresh token: " + refreshToken);
        logger.warn("the refresh token: " + refreshToken);
        req.getSession().setAttribute("refreshToken", refreshToken);
        // Get profile info from ID token - can be deleted we use People API
        GoogleIdToken idToken = tokenResponse.parseIdToken();
        System.out.println("the idtoken:"+idToken);
        logger.warn("the idtoken:"+idToken);
        GoogleIdToken.Payload payload = idToken.getPayload();

        // Use access token to call APIs
        GoogleCredential credential = new GoogleCredential().setAccessToken(accessToken);
        //get account info from People API and write to data base new user
        GooglePeopleService googleProfile = new GooglePeopleService(new NetHttpTransport(), JacksonFactory.getDefaultInstance(), credential, "FitnessWebApp");
        Person profile = googleProfile.returnProfile();
        System.out.println("print profile: "+ profile);
        logger.warn("print profile: "+ profile);
        //authenticate user
        Gson gson = new Gson();
        if (profile != null) {
            //authenticate google client
            FitnessGoogleClient fitnessGoogleClient = GoogleUserService.getInstance().authenticateGoogleUser(GoogleUserService.getInstance().getEmailAddres(profile));
            if (fitnessGoogleClient != null) {
                //set attributes
                setAttributesAutneticatedUser(req, fitnessGoogleClient);
                //send ajax redirect to main because user is authenticated
                resp.setContentType("application/json");
                resp.getWriter().write(gson.toJson(req.getContextPath()+"/main"));

            } else {
                //register user
                System.out.println("google user not registered");
                logger.warn("google user not registered");
                GoogleUserService.getInstance().registerUser(profile);
                //authenticate again after registering
                fitnessGoogleClient = GoogleUserService.getInstance().authenticateGoogleUser(GoogleUserService.getInstance().getEmailAddres(profile));
                //set attributes
                setAttributesAutneticatedUser(req, fitnessGoogleClient);
                //send ajax redirect to main because user is registered and therefore autehnticated
                resp.setContentType("application/json");
                resp.getWriter().write(gson.toJson(req.getContextPath()+"/main"));
            }
        }
        else {
            System.out.println("google user not ok, register the old way");
            logger.warn("google user not ok, register the old way");
            //send ajax redirect to main because user is registered and therefore autehnticated
            resp.setContentType("application/json");
            resp.getWriter().write(gson.toJson(req.getContextPath()+"/register"));
        }
    }

    private void setAttributesAutneticatedUser(HttpServletRequest req, FitnessGoogleClient fitnessGoogleClient) {
        req.getSession().setAttribute("authenticatedUser", fitnessGoogleClient);
        req.getSession().setAttribute("authUserEmail", fitnessGoogleClient.getEmailAddress());
        req.getSession().setAttribute("authWithGoogleSignIn", "yes");
        //check if power user and set attribute
        if (fitnessGoogleClient.getIs_power()) {
            req.getSession().setAttribute("authUserPower", true);
        } else {
            req.getSession().setAttribute("authUserPower", false);
        }
    }
}
