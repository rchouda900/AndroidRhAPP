package com.example.pc.tritux.tasks;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pc.tritux.ws.Compte;
import com.example.pc.tritux.ws.CompteWS;

import retrofit.RestAdapter;


public class SearchTask extends AsyncTask<Void,Void,Compte> {

    private Context context;

    private String mail;
    EditText e1;EditText e2;



    public SearchTask(Context context, String mail,EditText e1,EditText e2) {
        this.context = context;
        this.mail = mail;
        this.e1=e1;
        this.e2=e2;

    }


    ProgressDialog pdialog;
    @Override
    public void onPreExecute(){
        pdialog = ProgressDialog.show(context,"Authentification","Veuillez patienter");
    }



    @Override
    protected Compte doInBackground(Void... params) {

        CompteWS compteWS = new RestAdapter.Builder()
                .setEndpoint(CompteWS.ENDPOINT)
                .build()
                .create(CompteWS.class);
        try {
            return compteWS.getEmail(mail);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }


    @Override
    public void onPostExecute(Compte compte){
pdialog.dismiss();
        if(compte==null){
            Toast.makeText(context,"Compte Inexistant",Toast.LENGTH_SHORT).show();
        }
        else{

            e1.setText(compte.getLogin());
            e2.setText(compte.getMdp());

        }
    }

}