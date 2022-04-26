package com.example.saveload;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etText;
    TextView tv;
    Button btnSave, btnLoad;

    SharedPreferences sPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etText = (EditText) findViewById(R.id.editTextTextPersonName);
        tv = (TextView) findViewById(R.id.textView2);
    }

    public void saveText(View view) {
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        //Сохраняем текст по метке MARK
        ed.putString("MARK", etText.getText().toString());
        ed.commit();
        tv.setText(etText.getText().toString());
        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();
    }

    public void loadText(View view) {
        sPref = getPreferences(MODE_PRIVATE);
        String savedText = sPref.getString("MARK", "");
        etText.setText(savedText);
        tv.setText(etText.getText().toString());
        Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show();
    }
}