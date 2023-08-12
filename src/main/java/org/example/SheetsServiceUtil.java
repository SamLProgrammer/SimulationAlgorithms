package org.example;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Collections;

public class SheetsServiceUtil {

    private static final String CREDENTIALS_FILE_PATH = "../jsonKey.json";

    public static Sheets getSheetsService() throws IOException, GeneralSecurityException {
        InputStream credentialsStream = new FileInputStream(CREDENTIALS_FILE_PATH);

        GoogleCredential credentials = GoogleCredential.fromStream(credentialsStream)
                .createScoped(Collections.singleton(SheetsScopes.SPREADSHEETS));

        return new Sheets.Builder(credentials.getTransport(), credentials.getJsonFactory(), credentials)
                .setApplicationName("Your Application Name")
                .build();
    }
}
