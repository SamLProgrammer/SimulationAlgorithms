package org.example;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.*;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
/**
 * Hello world!
 *
 */
public class App 
{

    public static void main(String[] args) throws IOException, GeneralSecurityException {
        // Initialize Sheets service
        getNormSINV(0.975);
    }

    private static String getNormSINV(double number) {
        Sheets sheetsService = null;
        String spreadsheetId = "13ZBZcbLJuyOdMOftAW7Q1CONDQO05f-q3RSZ9qJdGFQ";
        String range = "Sheet1!C1"; // Update with your desired cell

        int row = 1; // Update with the row number (1-based index)
        int column = 3; // Update with the column number (1-based index)

        try {
            sheetsService = SheetsServiceUtil.getSheetsService();
        


        updateCell(sheetsService, spreadsheetId, row, column, "=NORM.S.INV(" + number + ")");
        } catch (IOException | GeneralSecurityException e) {
            e.printStackTrace();
        }
        return getCellValue(sheetsService, spreadsheetId, range);
    }

    private static String getCellValue(Sheets sheetsService, String spreadsheetId, String range) {
        List<List<Object>> values = new ArrayList<>();
        ValueRange response = new ValueRange();

        try {
            response = sheetsService.spreadsheets().values()
                    .get(spreadsheetId, range)
                    .execute();
                    values = response.getValues();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (values == null || values.isEmpty()) {
            return "";
        }

        return values.get(0).get(0).toString();
    }

    private static void updateCell( Sheets sheetsService, String spreadsheetId, int row, int column, String value) {
        String range = String.format("Sheet1!%s%s", getColumnLetter(column), row);

        List<List<Object>> newValues = new ArrayList<>();
        List<Object> newRow = new ArrayList<>();
        newRow.add(value);
        newValues.add(newRow);

        ValueRange body = new ValueRange().setValues(newValues);
        UpdateValuesResponse result = new UpdateValuesResponse();
        try {
            result = sheetsService.spreadsheets().values()
                    .update(spreadsheetId, range, body)
                    .setValueInputOption("USER_ENTERED")
                    .execute();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Updated cell: " + result.getUpdatedRange());
    }

    private static String getColumnLetter(int column) {
        StringBuilder columnLetter = new StringBuilder();
        while (column > 0) {
            int rem = (column - 1) % 26;
            columnLetter.insert(0, (char) (rem + 'A'));
            column = (column - 1) / 26;
        }
        return columnLetter.toString();
    }
}