package com.example.pc.tritux.tasks;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.pc.tritux.ws.Compte;
import com.example.pc.tritux.ws.CompteWS;

import retrofit.RestAdapter;




public class CreerCompteTask extends AsyncTask<Void,Void,Compte> {

    private Context context;
    private String login;
    private String mail;
    private String role;
    private String mdp;
    private String specialite;




    public CreerCompteTask(Context context, String login, String mdp, String mail, String role,String specialite) {
        this.context = context;
        this.login = login;
        this.mdp = mdp;
        this.mail = mail;
        this.role = role;
        this.specialite=specialite;
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
            return compteWS.creer(login, mdp, mail, role,specialite);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }


    @Override
    public void onPostExecute(Compte compte){
pdialog.dismiss();
        if(compte==null){
            Toast.makeText(context,"Création échouée",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context,"Succés de la création",Toast.LENGTH_SHORT).show();
        }
    }

}