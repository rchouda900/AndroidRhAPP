package com.example.pc.tritux;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.pc.tritux.tasks.SearchTaskEtat;



public class DetailsCandidature extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailscandidature);


        TextView lib=(TextView)findViewById(R.id.libelle);
        TextView datecreate=(TextView)findViewById(R.id.creat);
        TextView lastmod=(TextView)findViewById(R.id.lastmod);
        TextView modby=(TextView)findViewById(R.id.modifby);

        Intent intent70=getIntent();
        String mail=intent70.getStringExtra("mail");
        String numeroetat=intent70.getStringExtra("numeroetat");

        new SearchTaskEtat(this,mail,3,lib,datecreate,lastmod,modby,Integer.parseInt(numeroetat)).execute();

    }
}
