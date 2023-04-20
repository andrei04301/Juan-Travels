package com.example.topjuantech_ojt;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class WalletRegistration extends AppCompatActivity {
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the UI elements
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        registerButton = findViewById(R.id.registerButton);

        // Set a click listener for the register button
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the username and password from the UI elements
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Call the WalletAPI class to create a new wallet account
                WalletAPI walletAPI = new WalletAPI();
                boolean success = walletAPI.createNewWalletAccount(username, password);

                // Show a toast message based on the result of the API call
                if (success) {
                    Toast.makeText(WalletRegistration.this, "Wallet account created successfully!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(WalletRegistration.this, "Failed to create wallet account.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
