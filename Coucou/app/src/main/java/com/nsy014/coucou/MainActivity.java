package com.nsy014.coucou;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    private Button envoyer;
    private EditText saisie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        envoyer = findViewById(R.id.envoyer);
        saisie = findViewById(R.id.saisie);

        envoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                String res = saisie.getText().toString();
                intent.putExtra("returnValue", res);
                Log.i("myError", "avt setresult()");
                setResult(Activity.RESULT_OK, intent);
                finish();
                Log.i("myError", "apres finish()");
            }
        });
    }
}
