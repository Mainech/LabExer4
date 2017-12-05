    package com.example.greetingcard.labexer4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.EditText;
import android.widget.TextView;


    public class MainActivity extends AppCompatActivity {

        private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
    }


    public void saveDisplay(View view){
        SharedPreferences.Editor editor = preferences.edit();
        EditText input = (EditText)findViewById(R.id.input);
        editor.putString("text", input.getText().toString());
        editor.commit();
        editor.apply();

    }

    public void clearDisplay(View view){
        EditText input = (EditText)findViewById(R.id.input);
        input.setText("");
        TextView text = (TextView)findViewById(R.id.textView3);
        text.setText("");

    }

    public void showDisplay(View view){
        TextView text = (TextView)findViewById(R.id.textView3);
        text.setText(preferences.getString("text", ""));
    }
}
