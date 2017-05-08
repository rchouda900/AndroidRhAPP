package com.example.pc.tritux;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.widget.ListView;
import android.widget.TextView;

import com.example.pc.tritux.tasks.ListeComptesTask;

import org.w3c.dom.Text;

public class ListeComptesActivity extends Activity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_comptes);

        TextView tx=(TextView)findViewById(R.id.listetv);

        Intent intentliste=getIntent();
        int x=Integer.parseInt(intentliste.getStringExtra("numero"));

        if (x==0) tx.setText("Liste des Employés");
        else tx.setText("Liste des candidats");

        listView = (ListView) findViewById(R.id.listViewComptes);
        new ListeComptesTask(this,listView,x).execute();
    }


}
