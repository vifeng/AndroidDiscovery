package com.nsy014.authentification;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class authOkActivity extends AppCompatActivity{
    // !!!!!!!
    // NE PAS OUBLIER DE DECLARER cette nouvelle activity dans AndroidManifest.xml
    // !!!!!!!

    private Button map;
    private Button nav;
   // private Button coucouApp;
    private Button recupApp;
    private TextView res;
    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auth_ok); // associe la vue correspondante
        String logRecup = getIntent().getExtras().getString("logRecup", "Prob ?"); // récupère d'une autre page
        TextView authOk = (TextView)findViewById(R.id.auth_ok);
        authOk.setText(authOk.getText() +" Bravo " + logRecup); // affichage du texte sur la page courante

        map = findViewById(R.id.map);
        nav = findViewById(R.id.nav);
       // coucouApp = findViewById(R.id.btAutreApp);
        recupApp = findViewById(R.id.recupApp);
        res = findViewById(R.id.res);

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double latitude = 48.858370;
                double longitude = 2.294481;
                int zoom = 17;
                Uri uri = Uri.parse("geo:" + latitude + ","+ longitude + "?z=" + zoom);
                showMap(uri);
            }
        });

        nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.google.com"));
                startActivity(intent);
            }
        });

        /**
         * NE PAS OUBLIER DE TELECHARGER l'APPLI COUCOU AVANT !!!
         * Bouton qui permet de passer dans l'application coucou
         */
       /* coucouApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setAction("monAction.COUCOU");
                startActivity(intent);
            }
        });*/

        // Bouton qui permet de récupérer des infos de l'appli Coucou
        recupApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setAction("monAction.COUCOU");
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

    } //Fin onCreate

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            String getres = data.getStringExtra("returnValue");
            res.setText(getres);
        }
    }

    public void showMap(Uri geoLocation) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
