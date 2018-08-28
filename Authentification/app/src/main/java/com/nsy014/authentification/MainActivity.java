package com.nsy014.authentification;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText login;
    private EditText pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = findViewById(R.id.login);
        pwd = findViewById(R.id.pwd);
        Button bt = findViewById(R.id.button);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((login.getText().toString()).equals(pwd.getText().toString())){
                    Intent myIntent = new Intent(getApplicationContext(), authOkActivity.class);
                    myIntent.putExtra("logRecup", login.getText().toString());
                    startActivity(myIntent);

                }else {
                    Toast.makeText(getApplicationContext(), "Mauvaise Connexion", Toast.LENGTH_LONG).show();
                }
            }
        }); // fin onclickListener
    }
}
