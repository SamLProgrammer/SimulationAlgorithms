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
import com.google.api.services.sheets.v4.model.ValueRange;

public class App {

    // public static void main(String[] args) {

    //     new Controller();

    // }

    private static final String SPREADSHEET_ID = "your-spreadsheet-id";

    public static void main(String[] args) throws IOException, GeneralSecurityException {
        // Load credentials from your service account JSON key file
        HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
        GoogleCredential credentials = GoogleCredential.fromStream(
            App.class.getResourceAsStream("your-service-account-key.json")
        ).createScoped(Collections.singleton(SheetsScopes.SPREADSHEETS));

        // Initialize the Sheets service
        Sheets service = new Sheets.Builder(httpTransport, jsonFactory, (HttpRequestInitializer) credentials)
            .setApplicationName("Your Application Name")
            .build();

        // Define the new cell value
        ValueRange newValue = new ValueRange().setValues(Collections.singletonList(Collections.singletonList("New Value")));
OAuth2Utils.Credential
        // Update the cell in your Google Sheet
        service.spreadsheets().values()
            .update(SPREADSHEET_ID, "Sheet1!A1", newValue)
            .setValueInputOption("RAW")
            .execute();

        System.out.println("Cell updated successfully.");
    }
}
