package com.example.gioele.musica;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.farng.mp3.MP3File;
import org.farng.mp3.id3.ID3v2_2;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    EditText txt;
    MP3File file;
    EditText stampa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = new EditText(getApplicationContext());
        txt.setText("inserire percorso file");
        ConstraintLayout finestra = (ConstraintLayout) findViewById(R.id.finestra);
        Button invia = new Button(getApplicationContext());
        invia.setText("conferma");
        finestra.addView(txt);
        finestra.addView(invia);

        stampa = new EditText(getApplicationContext());
        finestra.addView(stampa);
        txt.setY(0);
        invia.setY(100);
        stampa.setY(400);
        invia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File sourceFile = new File(txt.getText().toString());
                try {
                    file = new MP3File(sourceFile);
                }catch(Exception e ){

                }
                ID3v2_2 tag = new ID3v2_2(file.getID3v2Tag());
                stampa.setText(tag.getAlbumTitle() + tag.getYearReleased());
            }
        });


    }


}
