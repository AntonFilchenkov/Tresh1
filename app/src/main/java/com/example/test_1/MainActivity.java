package com.example.test_1;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonWelcome = findViewById(R.id.button_welcome);
        Button buttonEmail = findViewById(R.id.button_email);
        Button buttonWebsite = findViewById(R.id.button_website);

        buttonWelcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, getString(R.string.welcome_message), Toast.LENGTH_LONG).show();
            }
        });

        buttonEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:")); // only email apps should handle this
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.email_subject));
                if (emailIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(emailIntent);
                }
            }
        });

        buttonWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://innovationcampus.ru"));
                startActivity(webIntent);
            }
        });
    }
}