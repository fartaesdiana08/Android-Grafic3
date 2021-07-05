package com.example.grafic1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class AdaugaApartamentActivity extends AppCompatActivity {

    EditText adresa;
    EditText nume_proprietar;
    EditText chirie;
    CheckBox e_renovat;
    RadioGroup radioGroup;
    RadioButton radioButton;

    Button btnSalveaza;
    public static final String ADD_APARTAMENT = "apartament";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adauga_apartament);

        adresa=findViewById(R.id.adresa);
        nume_proprietar=findViewById(R.id.numeProp);
        chirie=findViewById(R.id.chirie);
        e_renovat=findViewById(R.id.renovat);
        radioGroup=findViewById(R.id.radioGroup);

        btnSalveaza=findViewById(R.id.btnSalveaza);

        radioButton=findViewById(R.id.rbEt1);

        btnSalveaza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(adresa.getText().toString().isEmpty())
                {
                    Toast.makeText(AdaugaApartamentActivity.this, "Introduceti adresa!",Toast.LENGTH_SHORT).show();
                }
                else if(nume_proprietar.getText().toString().isEmpty() )
                {
                    Toast.makeText(AdaugaApartamentActivity.this, "Introduceti nume proprietar",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String txt_adresa=adresa.getText().toString();
                    String txt_nume_prop=nume_proprietar.getText().toString();
                    int txt_chirie=Integer.parseInt(chirie.getText().toString());
                    boolean txt_e_renovat=e_renovat.isChecked();

                    radioButton=findViewById(radioGroup.getCheckedRadioButtonId());
                    Etaj txt_etaj=Etaj.valueOf(radioButton.getText().toString().toUpperCase());

                   // RadioButton radioButton = findViewById(radioGroup.getCheckedRadioButtonId());
                    //Etaj txt_etaj = Etaj.valueOf(radioButton.getText().toString());

                    Apartament apt=new Apartament(txt_adresa,txt_nume_prop,txt_chirie,txt_e_renovat,txt_etaj);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("apartament",apt);

                    Intent intent = new Intent();
                    intent.putExtras(bundle);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
    }
}