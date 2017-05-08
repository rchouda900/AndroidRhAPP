package com.example.pc.tritux;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.IdRes;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.pc.tritux.tasks.CreerCompteTask;

import java.util.Random;




public class CreerUnCompte extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creercompte);
        Button btnvalider = (Button) findViewById(R.id.btnvalider);

        CheckBox role = (CheckBox) findViewById(R.id.checkBox);
        RadioGroup rg=(RadioGroup)findViewById(R.id.rgroup);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                CheckBox role = (CheckBox) findViewById(R.id.checkBox);
                if (checkedId==R.id.radio1||checkedId==R.id.radio2)
                    role.setEnabled(false);
            }
        });


        role.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                RadioButton r1=(RadioButton)findViewById(R.id.radio1);
                RadioButton r2=(RadioButton)findViewById(R.id.radio2);
                if (isChecked==true){
                    r1.setEnabled(false);
                    r2.setEnabled(false);
                }
                else{  r1.setEnabled(true);
                    r2.setEnabled(true);
            }}
        });

        btnvalider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText login = (EditText) findViewById(R.id.editText2);
                EditText mail = (EditText) findViewById(R.id.editText);
                 CheckBox role = (CheckBox) findViewById(R.id.checkBox);

                String lelogin = login.getText().toString();
                String lemail = mail.getText().toString();
                Random rand = new Random();
                long mdp = rand.nextInt(99999999 - 10000000 + 1) + 10000000;

                String lerole = "";
                if (role.isChecked()) lerole = "ADMIN";
                else lerole = "USER";

                Intent intent_mail=getIntent();
                String mail_int=intent_mail.getStringExtra("lemail");
                String login_int=intent_mail.getStringExtra("lelogin");

                RadioButton r1=(RadioButton)findViewById(R.id.radio1);
                RadioButton r2=(RadioButton)findViewById(R.id.radio2);
                String specialite;
                if (r1.isChecked())specialite="Informatique";
                else if (r2.isChecked())specialite="Autres";
                else specialite="Administrateur";


                new CreerCompteTask(CreerUnCompte.this, lelogin, String.valueOf(mdp), lemail, lerole,specialite).execute();

            }


        });


    }
}