package com.example.secd_q4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button open_website;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        open_website = findViewById(R.id.openWebsiteBtn);

       open_website.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               //url to open
               String url = "https://www.google.com/?ptid=19027681&ptt=8&fpts=0&pli=1";

               //create implicit intent with ACTION_VIEW to open browser
               //ACTION_VIEW signals that you want to display the data
               //Uri class is used to represent the data you want to act upon
               //Uri.parse(url) converts the string url into a Uri object
               Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

               //check if there's a browser
               //intent.resolveActivity() checks if theres is an app available that can handle the intent
               if(intent.resolveActivity(getPackageManager()) != null){
                   startActivity(intent);
               }
               else {
                   Toast.makeText(MainActivity.this, "No web browser found to open this link", Toast.LENGTH_SHORT).show();
               }

           }
       });

    }
}