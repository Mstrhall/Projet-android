package com.example.project_2gsb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity6 extends AppCompatActivity {
    /**definition des variables qui vont etre utiliser dans cet ecran */
    CalendarView calendarView1;// variable qui recupere le calendrier
    String curDAte;// variable qui concatene la date et l'heure
    SQLiteDataBaseHelper db;// variable de la base de données


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        /**liason avec le xml et appel de bd  */
        calendarView1=findViewById(R.id.calendarView1);

        db=new SQLiteDataBaseHelper(this);
        calendarView1.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            /**appele de la methode qui permet de recupere la date courante */
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                curDAte=String.valueOf(dayOfMonth)+"/"+String.valueOf(month+1);

            }

        });

    }
    /** methode d'insertion dans la bd */
    public void insertBD(View view){
        /**recuperation des texte saisie */
        EditText heurREU=(EditText)findViewById(R.id.label_rdv_heurereu);
        EditText salle=(EditText) findViewById(R.id.label_salle);
        EditText type=(EditText)findViewById(R.id.label_type);

        /**appel de la methode d'insertion avec les parametre pour insert un reunion */
        db.insertReunion(curDAte,heurREU.getText().toString(),salle.getText().toString(),type.getText().toString());

    }
}

