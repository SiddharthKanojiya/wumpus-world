package com.example.wumpusworldv4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity2 extends AppCompatActivity {
    Button send_button;
    EditText send_text;
    Spinner dropdown;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        send_button = findViewById(R.id.send_button_id);
        send_text = findViewById(R.id.send_text_id);
        Spinner dropdown = findViewById(R.id.spinner);
//create a list of items for the spinner.
        String[] items = new String[]{"4", "5", "6"};
//create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
//set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);

        // add the OnClickListener in sender button after clicked this button following Instruction will run
        send_button.setOnClickListener(v -> {
            // get the value which input by user in EditText and convert it to string
            String level = dropdown.getSelectedItem().toString();
            String str = send_text.getText().toString();
            if (level=="4")
            {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                // now by putExtra method put the value in key, value pair key is
                // message_key by this key we will receive the value, and put the string
                intent.putExtra("message_key", str);
                intent.putExtra("level", level);
                // start the Intent
                startActivity(intent);
            }
            else if (level=="5"){
                Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                // now by putExtra method put the value in key, value pair key is
                // message_key by this key we will receive the value, and put the string
                intent.putExtra("message_key", str);
                intent.putExtra("level", level);
                // start the Intent
                startActivity(intent);
            }

            // Create the Intent object of this class Context() to Second_activity class

        });
    }
}