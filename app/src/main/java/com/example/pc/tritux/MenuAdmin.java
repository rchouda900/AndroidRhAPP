package com.example.pc.tritux;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.pc.tritux.tasks.SearchTask;
import com.example.pc.tritux.tasks.SearchTaskEtat;



public class MenuAdmin  extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_admin);




        Button btncreer=(Button) findViewById(R.id.btncreercompte);
        btncreer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
Intent intent=new Intent(MenuAdmin.this,CreerUnCompte.class);
                startActivity(intent);
            }
        });


        Button btnsearch=(Button) findViewById(R.id.btnsearch);
        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText email=(EditText) findViewById(R.id.cherchermail);

                EditText login=(EditText) findViewById(R.id.afficherlogin);
                EditText mdp=(EditText) findViewById(R.id.affichermotdepasse);
                EditText etape=(EditText) findViewById(R.id.afficheretape);
                String adresse=email.getText().toString();

                new SearchTask(MenuAdmin.this,adresse,login,mdp).execute();
                new SearchTaskEtat(MenuAdmin.this,adresse,etape,1).execute();

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuliste, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.emplist:
            {
                Intent intentliste=new Intent(MenuAdmin.this,ListeComptesActivity.class);
                intentliste.putExtra("numero",String.valueOf(0));
                startActivity(intentliste);
                break;
            }
            case R.id.canlist:
            {
                Intent intentliste=new Intent(MenuAdmin.this,ListeComptesActivity.class);
                intentliste.putExtra("numero",String.valueOf(1));
                startActivity(intentliste);
            }






        }
        return true;
    }


}


