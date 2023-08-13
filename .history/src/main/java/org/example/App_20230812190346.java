package org.example;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.*;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        System.out.println(getNormSINV(0.975));
    }

    private static String getNormSINV(double baseNumber) {
        Sheets sheetsService;
        String spreadsheetId = "13ZBZcbLJuyOdMOftAW7Q1CONDQO05f-q3RSZ9qJdGFQ";
        String range = "Sheet1!C1";

        int row = 1;
        int column = 3;
        String calculatedResult = "";

        try {
            sheetsService = SheetsServiceUtil.getSheetsService();
            // updateCell(sheetsService, spreadsheetId, row, column, "=NORM.S.INV(" + String.valueOf(baseNumber).replace('.', ',') + ")");
            updateCell(sheetsService, spreadsheetId, row, column, "=NORM.S.INV(" + baseNumber + ")");
            calculatedResult = getCellValue(sheetsService, spreadsheetId, range);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (GeneralSecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return calculatedResult;
    }

    private static String updateCell(Sheets sheetsService, String spreadsheetId, int row, int column, String value) {
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

       return result.getUpdatedRange();
    }

    private static String getCellValue(Sheets sheetsService, String spreadsheetId, String range){
        ValueRange response = new ValueRange();
        try {
            response = sheetsService.spreadsheets().values()
                    .get(spreadsheetId, range)
                    .execute();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        List<List<Object>> values = response.getValues();
        if (values == null || values.isEmpty()) {
            return "";
        }
        return values.get(0).get(0).toString();
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