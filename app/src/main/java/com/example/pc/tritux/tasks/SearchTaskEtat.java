package com.example.pc.tritux.tasks;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.annotation.DrawableRes;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pc.tritux.CandidaturesEnCours;
import com.example.pc.tritux.DetailsCandidature;
import com.example.pc.tritux.R;
import com.example.pc.tritux.ws.Etat;
import com.example.pc.tritux.ws.EtatWS;

import org.w3c.dom.Text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import retrofit.RestAdapter;



public class SearchTaskEtat extends AsyncTask<Void,Void,Etat> {

    private Context context;

    private String mail;
    EditText e1;
    int x;
    View v1;
    View v2;
    View v3;
    View v4;
    TextView t1;
    TextView t2;
    TextView t3;
    TextView t4;
    int numetat; ///// connaitre l'etat et le comparaitre avec le libellé


    public SearchTaskEtat(Context context, String mail,EditText e1,int x) {
        this.context = context;
        this.mail = mail;
        this.e1=e1;
        this.x=x;
    }

    public SearchTaskEtat(Context context, String mail, int x, View v1, View v2, View v3, View v4) {
        this.context = context;
        this.mail = mail;
        this.x = x;
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        this.v4 = v4;

    }

    public SearchTaskEtat(Context context, String mail, int x, TextView t1, TextView t2, TextView t3, TextView t4,int numetat) {
        this.context = context;
        this.mail = mail;
        this.x = x;
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
        this.t4 = t4;
        this.numetat=numetat;
    }

    public SearchTaskEtat(Context context, String mail, int x,int numetat) {
        this.context = context;
        this.mail = mail;
        this.x = x;
        this.numetat=numetat;
    }

    ProgressDialog pdialog;
    @Override
    public void onPreExecute(){
        pdialog = ProgressDialog.show(context,"Authentification","Veuillez patienter");
    }


    @Override
    protected Etat doInBackground(Void... params) {

        EtatWS etatWS = new RestAdapter.Builder()
                .setEndpoint(EtatWS.ENDPOINT)
                .build()
                .create(EtatWS.class);
        try {
            return etatWS.getEtat(mail);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }


    @Override
    public void onPostExecute(Etat etat){
pdialog.dismiss();
        if(etat.getLibelle().equals("")){
            Toast.makeText(context,"Une erreur s'est produite",Toast.LENGTH_SHORT).show();
        }
        else{
if (x==1)
            e1.setText(etat.getLibelle());

            else if (x==0){
    switch (etat.getLibelle())
    {
        case "TestsEnligne" :
        {
            v1.setBackgroundResource(R.drawable.col2);
            v2.setBackgroundResource(R.drawable.colblanc);
            v3.setBackgroundResource(R.drawable.colblanc);
            v4.setBackgroundResource(R.drawable.colblanc);
            break;
        }
        case "EntretienTechnique" :
        {
            v1.setBackgroundResource(R.drawable.col1);
            v2.setBackgroundResource(R.drawable.col2);
            v3.setBackgroundResource(R.drawable.colblanc);
            v4.setBackgroundResource(R.drawable.colblanc);
            break;
        }
        case "entretienRh" :
        {
            v1.setBackgroundResource(R.drawable.col1);
            v2.setBackgroundResource(R.drawable.col1);
            v3.setBackgroundResource(R.drawable.col2);
            v4.setBackgroundResource(R.drawable.colblanc);
            break;
        }
        case "EntretienDemandeur" :
        {
            v1.setBackgroundResource(R.drawable.col1);
            v2.setBackgroundResource(R.drawable.col1);
            v3.setBackgroundResource(R.drawable.col2);
            v4.setBackgroundResource(R.drawable.colblanc);
            break;
        }
        case "Acceptation" :
        {
            v1.setBackgroundResource(R.drawable.col1);
            v2.setBackgroundResource(R.drawable.col1);
            v3.setBackgroundResource(R.drawable.col1);
            v4.setBackgroundResource(R.drawable.col2);
        }
    }
            }

            else if (x==2)
{
    Intent intent70=new Intent(context, DetailsCandidature.class);
    intent70.putExtra("mail",mail);
    intent70.putExtra("numeroetat",String.valueOf(numetat));
    context.startActivity(intent70);

}
        else {
    if (etat.getNumetat()==numetat)
    {
    t1.setText(etat.getLibelle());
    t2.setText("01-05-2017");



        t3.setText("02-05-2017");



    t4.setText(etat.getLastModifBy()); }

    else {
        t1.setText("Ce n'est pas l'etat actuel");
        t2.setText("indisponible");
        t3.setText("indisponible");
        t4.setText("indisponible");

    }



             }

        }
    }

}
