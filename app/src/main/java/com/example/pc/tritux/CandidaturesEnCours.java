package com.example.pc.tritux;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pc.tritux.tasks.SearchTaskEtat;

import org.w3c.dom.Text;



public class CandidaturesEnCours   extends AppCompatActivity implements View.OnClickListener{




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.candidature_en_cours);

        View v1=(View) findViewById(R.id.view1);
        View v2=(View) findViewById(R.id.view2);
        View v3=(View) findViewById(R.id.view3);
        View v4=(View) findViewById(R.id.view4);

        TextView tv=(TextView)findViewById(R.id.textView3);

        v1.setOnClickListener(this);
        v2.setOnClickListener(this);
        v3.setOnClickListener(this);
        v4.setOnClickListener(this);

        Intent intent20=getIntent();
        String specialite=intent20.getStringExtra("specialite");
        if (specialite.equals("Autres"))tv.setText("Entretien Demandeur");

        new SearchTaskEtat(this,intent20.getStringExtra("mail_co"),0,v1,v2,v3,v4).execute();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.reglages, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
            {
                Intent intent20=getIntent();

                Intent intent50= new Intent(CandidaturesEnCours.this, ModifierCompte.class);
                intent50.putExtra("lelogin",intent20.getStringExtra("lelogin"));
                intent50.putExtra("lemdp",intent20.getStringExtra("lemdp"));

                startActivity(intent50);
            }
            case R.id.annulation:
            {

            }






        }
        return true;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.view1)
        {
            Intent intent20=getIntent();
            new SearchTaskEtat(CandidaturesEnCours.this,intent20.getStringExtra("mail_co"),2,1).execute();
        }
        if (v.getId()==R.id.view2)
        {
            Intent intent20=getIntent();
            new SearchTaskEtat(CandidaturesEnCours.this,intent20.getStringExtra("mail_co"),2,2).execute();
        }
        if (v.getId()==R.id.view3)
        {
            Intent intent20=getIntent();
            new SearchTaskEtat(CandidaturesEnCours.this,intent20.getStringExtra("mail_co"),2,3).execute();
        }
        if (v.getId()==R.id.view4)
        {
            Intent intent20=getIntent();
            new SearchTaskEtat(CandidaturesEnCours.this,intent20.getStringExtra("mail_co"),2,4).execute();
        }
    }
}


