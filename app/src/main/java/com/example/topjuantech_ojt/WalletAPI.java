package com.example.topjuantech_ojt;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class WalletAPI {

    private static final String TAG = "WalletAPI";
    private static final String API_KEY = "YOUR_API_KEY";

    public boolean createNewWalletAccount(String username, String password) {
        String url = "https://api.topwallet.com/v1/wallets/create";

        try {
            // Create a new HttpsURLConnection object to send the request
            HttpsURLConnection conn = (HttpsURLConnection) new URL(url).openConnection();

            // Set the request method to POST
            conn.setRequestMethod("POST");

            // Set the request headers
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Authorization", "Bearer " + API_KEY);

            // Set the request body
            String requestBody = "{\"username\":\"" + username + "\",\"password\":\"" + password + "\"}";
            OutputStream os = conn.getOutputStream();
            os.write(requestBody.getBytes());
            os.flush();
            os.close();

            // Read the response from the server
            InputStream is = conn.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = br.readLine()) != null) {
                response.append(line);
            }
            br.close();

            // Parse the response and handle any errors
            JSONObject jsonResponse = new JSONObject(response.toString());
            if (jsonResponse.has("error")) {
                String errorMessage = jsonResponse.getString("error");
                // Handle the error
            } else {
                // The wallet account was created successfully
                String accountId = jsonResponse.getString("accountId");
                String walletAddress = jsonResponse.getString("walletAddress");
                // Save the account ID and wallet address to your backend database
            }

        } catch (IOException e) {
            // Handle any IOExceptions that may occur
            Log.e(TAG, "IOException: " + e.getMessage());
        } catch (JSONException e) {
            // Handle any JSONExceptions that may occur
            Log.e(TAG, "JSONException: " + e.getMessage());
        }
        return false;
    }

    private class CreateNewWalletTask extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... params) {
            String username = params[0];
            String password = params[1];
            createNewWalletAccount(username, password);
            return null;
        }
    }

    public void createNewWalletAccountAsync(String username, String password) {
        new CreateNewWalletTask().execute(username, password);
    }
}

