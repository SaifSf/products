
package com.ats.asus.test.utilities;

import android.net.Uri;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;


public class NetworkUtils {

    final static String Products_BASE_URL =
            "http://internal.ats-digital.com:3066/api/products";

    final static String PARAM_QUERY = "q";
    final static String Category="Baby";


    public static URL buildUrl(String CategoriesSearch) {
        Uri builtUri = Uri.parse(Products_BASE_URL).buildUpon()
                .appendQueryParameter(PARAM_QUERY, CategoriesSearch)
                .build();

        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        Log.i("usrl", String.valueOf(builtUri));
        return url;

    }
    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }
}