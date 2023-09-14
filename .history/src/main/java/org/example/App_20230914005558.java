package org.example;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import org.example.controller.Controller;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.OAuth2Utils;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.appengine.repackaged.com.google.api.client.auth.oauth2.Credential;

import java.io.IOException;
import java.util.Arrays;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.*;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;

public class App {
    private static final String SPREADSHEET_ID = "1jzWLIqNzy7kcPl724yCjpr4_Xg407c2AITIIG8eznBo";
    private static final String API_KEY = "AIzaSyCaWkoxsakMEQeRphykfKIhH7aCmiGuRXs";

    public static void main(String[] args) throws IOException, GeneralSecurityException {
        // Initialize the Sheets service with API key
        HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
        GoogleCredential credential = new GoogleCredential().setAccessToken(API_KEY);
        Sheets service = new Sheets.Builder(httpTransport, jsonFactory, credential)
            .setApplicationName("Your Application Name")
            .build();

        ValueRange newValue = new ValueRange().setValues(Collections.singletonList(Collections.singletonList("xxx")));

        // Update the cell in your Google Sheet
        UpdateValuesResponse response = service.spreadsheets().values()
            .update(SPREADSHEET_ID, "Sheet1!A1", newValue)
            .setValueInputOption("RAW")
            .execute();

        System.out.println("Cell updated successfully.");
    }
}

// public class App {

//     // public static void main(String[] args) {

//     //     new Controller();

//     // }
// }
