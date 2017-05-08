package com.example.pc.tritux;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pc.tritux.tasks.ModifmdpTask;
import com.example.pc.tritux.tasks.SearchTask;
import com.example.pc.tritux.tasks.SearchTaskEtat;





public class ModifierCompte extends AppCompatActivity implements View.OnClickListener {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modifier_compte);


        Button btnmodifier = (Button) findViewById(R.id.btnmodifier);

        btnmodifier.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        if (view.getId()==R.id.btnmodifier)
        {
            EditText ancienmdp=(EditText) findViewById(R.id.editText2);
            EditText nouvmdp=(EditText) findViewById(R.id.editText);
            EditText confnouvmdp=(EditText) findViewById(R.id.editText3);

            String ancienmdp1=ancienmdp.getText().toString();
            String nouvmdp1=nouvmdp.getText().toString();
            String confnouvmdp1=confnouvmdp.getText().toString();

            Intent intent50=getIntent();
            String Login=intent50.getStringExtra("lelogin");
            String mdp=intent50.getStringExtra("lemdp");

            if (nouvmdp1.equals(confnouvmdp1)==false) Toast.makeText(ModifierCompte.this,"Les mots des passe ne correspondent pas", Toast.LENGTH_SHORT).show();
            else if (mdp.equals(ancienmdp1)==false)Toast.makeText(ModifierCompte.this,"Ancien mot de passe incorrect", Toast.LENGTH_SHORT).show();
            else if (nouvmdp1.length()<8) Toast.makeText(ModifierCompte.this,"Longueur mdp incorrecte",Toast.LENGTH_SHORT).show();
            else {
                new ModifmdpTask(ModifierCompte.this,Login,nouvmdp1).execute();
                Toast.makeText(ModifierCompte.this,"Succés de la modification",Toast.LENGTH_SHORT).show();
            }
            }
        }
    }
