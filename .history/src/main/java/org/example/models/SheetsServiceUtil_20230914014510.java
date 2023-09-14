package org.example.models;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.io.InputStream;

public class SheetsServiceUtil {

    private static final String CREDENTIALS_FILE_PATH = "jsonKey3.json";

    public static Sheets getSheetsService() throws IOException, GeneralSecurityException {
        InputStream credentialsStream = SheetsServiceUtil.class.getClassLoader().getResourceAsStream(CREDENTIALS_FILE_PATH);

        GoogleCredential credentials = GoogleCredential.fromStream(credentialsStream)
                .createScoped(Collections.singleton(SheetsScopes.SPREADSHEETS));

        return new Sheets.Builder(credentials.getTransport(), credentials.getJsonFactory(), credentials)
                .setApplicationName("Your Application Name")
                .build();
    }

    
}
