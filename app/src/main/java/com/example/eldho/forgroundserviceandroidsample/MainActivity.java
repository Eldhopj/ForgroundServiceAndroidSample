package com.example.eldho.forgroundserviceandroidsample;
/**Create notification in Application Class
 * Register app class in Manifest file - > inside application ->  <android:name=".App"/>
 * Create Service class
 * Register the service in Manifest file -> inside application ->   <service android:name=".ServiceClass"/>
 * */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editTextInput;
    public static final String SERVICE_INTENT_NAME = "inputExtra";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextInput = findViewById(R.id.edit_text_input);

    }

    public void startService(View view) {
        String input = editTextInput.getText().toString();

/**To start our service we call intent service*/
        Intent serviceIntent = new Intent(this,ServiceClass.class);
        serviceIntent.putExtra(SERVICE_INTENT_NAME,input); //passing string into the service class
        ContextCompat.startForegroundService(this,serviceIntent);

//        startService(serviceIntent); // starting the service while app is running ; not recommented
    }

    public void stopService(View view) {
        Intent serviceIntent = new Intent(this,ServiceClass.class);
        stopService(serviceIntent); // stop the service
    }

}
