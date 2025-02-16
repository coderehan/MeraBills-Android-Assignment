package com.rehan.merabillassignment;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {
    private static final String FILE_NAME = "LastPayment.txt";

    public static void savePayments(Context context, List<Payment> payments) {
        try {
            String json = new Gson().toJson(payments);
            Log.d("FileHelper", "Saving JSON: " + json);
            FileWriter writer = new FileWriter(new File(context.getFilesDir(), FILE_NAME));
            writer.write(json);
            writer.close();
            Log.d("FileHelper", "Data successfully saved to " + FILE_NAME);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("FileHelper", "Error saving data: " + e.getMessage());
        }
    }


    public static List<Payment> loadPayments(Context context) {
        try {
            File file = new File(context.getFilesDir(), FILE_NAME);
            if (!file.exists()) return new ArrayList<>();
            FileReader reader = new FileReader(file);
            Type listType = new TypeToken<ArrayList<Payment>>() {
            }.getType();
            List<Payment> payments = new Gson().fromJson(reader, listType);
            reader.close();
            return payments;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}