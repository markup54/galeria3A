package com.example.wprowadzzenie3apol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private  boolean ukryty = false;
    private ArrayList<Integer> obrazki = new ArrayList<>();
    private int aktualny = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        obrazki.add(R.drawable.kwiat);
        obrazki.add(R.drawable.obraz2);
        obrazki.add(R.drawable.obraz3);
        obrazki.add(R.drawable.obraz4);
        Button przycisk = findViewById(R.id.button);
        ImageView obrazek = findViewById(R.id.imageView);
        Button przyciskWstecz = findViewById(R.id.button2);
        przyciskWstecz.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        aktualny--;
                        if(aktualny<0){
                            aktualny = obrazki.size()-1;
                        }
                        obrazek.setImageResource(obrazki.get(aktualny));
                    }
                }
        );
        Button przyciskDalej = findViewById(R.id.button3);
        przyciskDalej.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        aktualny++;
                        if(aktualny==obrazki.size()){
                            aktualny = 0;
                        }
                        obrazek.setImageResource(obrazki.get(aktualny));
                    }
                }
        );


        przycisk.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Kliknięto przycisk", Toast.LENGTH_SHORT)
                                .show();
                        if(!ukryty) {
                            obrazek.setVisibility(View.INVISIBLE);
                            przycisk.setText(R.string.opis_przycisku_pokaz);
                            ukryty = false;
                        }
                        else{
                            obrazek.setVisibility(View.VISIBLE);
                            przycisk.setText(R.string.opis_przycisku_ukryj);
                            ukryty = true;
                        }
                    }
                }
        );
    }
}