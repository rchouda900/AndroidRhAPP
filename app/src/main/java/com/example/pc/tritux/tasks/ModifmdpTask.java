package com.example.pc.tritux.tasks;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pc.tritux.ws.Compte;
import com.example.pc.tritux.ws.CompteWS;

import retrofit.RestAdapter;



public class ModifmdpTask extends AsyncTask<Void,Void,Integer> {

    private Context context;

    private String login;
    private String mdp;

    ProgressDialog pdialog;
    @Override
    public void onPreExecute(){
        pdialog = ProgressDialog.show(context,"Authentification","Veuillez patienter");
    }


    public ModifmdpTask(Context context, String login, String mdp) {
        this.context = context;
        this.login = login;
        this.mdp = mdp;
    }

    @Override
    protected Integer doInBackground(Void... params) {

        CompteWS compteWS = new RestAdapter.Builder()
                .setEndpoint(CompteWS.ENDPOINT)
                .build()
                .create(CompteWS.class);
        try {
            return compteWS.ModifierCompte(login,mdp);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }


    }

    @Override
    public void onPostExecute(Integer i){
        pdialog.dismiss();
        if (i!=1)
        {
            Toast.makeText(context,"Modification échouée", Toast.LENGTH_SHORT).show();
        }
        else Toast.makeText(context,"Succés de la Modification", Toast.LENGTH_SHORT).show();
    }

}
