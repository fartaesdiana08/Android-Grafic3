package com.example.grafic1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class  MainActivity extends AppCompatActivity {

    private FloatingActionButton floatingActionButton;
    private Button normalize;

    public static final int REQUEST_CODE = 132;

    public Intent intent;
    List<Apartament> list = new ArrayList<>();

    LinearLayout grafic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), AdaugaApartamentActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        populareLista(list);

        grafic = (LinearLayout)findViewById(R.id.grafic);
        grafic.addView(new GraficView(getApplicationContext(), list));

        normalize = findViewById(R.id.btn_Normalizare);
        normalize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        intent=getIntent();
    }

    private void populareLista(List<Apartament> list) {
        Apartament a1=new Apartament(); //are etaj 1 bydefault
        Apartament a2=new Apartament();
        Apartament a3=new Apartament();
        Apartament a4=new Apartament();
        Apartament a5=new Apartament();
        Apartament a6=new Apartament();
        a4.setEtaj(Etaj.ETAJ_2);
        a5.setEtaj(Etaj.ETAJ_2);
        a6.setEtaj(Etaj.ETAJ_3);
        a1.setChirie(1200);
        a2.setChirie(1779);
        a3.setChirie(1397);
        a4.setChirie(1934);
        a5.setChirie(1178);
        a6.setChirie(1589);

        list.add(a1);
        list.add(a2);
        list.add(a3);
        list.add(a4);
        list.add(a5);
        list.add(a6);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {

            Bundle bundle = data.getExtras();
            Apartament s = (Apartament) bundle.getSerializable("apt");
            list.add(s);
            grafic.removeAllViews();
            grafic.addView(new GraficView(getApplicationContext(), list));
        }
    }
}