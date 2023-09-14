package org.example.models;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Collections;

public class SheetsServiceUtil {

    // private static final String CREDENTIALS_FILE_PATH = "jsonkey2.json";

    // public static Sheets getSheetsService() throws IOException, GeneralSecurityException {
    //     InputStream credentialsStream = SheetsServiceUtil.class.getClassLoader().getResourceAsStream(CREDENTIALS_FILE_PATH);

    //     GoogleCredential credentials = GoogleCredential.fromStream(credentialsStream)
    //             .createScoped(Collections.singleton(SheetsScopes.SPREADSHEETS));

    //     return new Sheets.Builder(credentials.getTransport(), credentials.getJsonFactory(), credentials)
    //             .setApplicationName("Your Application Name")
    //             .build();
    // }

    
}
