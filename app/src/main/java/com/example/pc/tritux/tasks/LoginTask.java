package com.example.pc.tritux.tasks;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.pc.tritux.CandidaturesEnCours;
import com.example.pc.tritux.CreerUnCompte;
import com.example.pc.tritux.MenuAdmin;
import com.example.pc.tritux.ws.Compte;
import com.example.pc.tritux.ws.CompteWS;

import retrofit.RestAdapter;



public class LoginTask extends AsyncTask<Void,Void,Compte> {

    private Context context;
    private String login;
    private String passwd;



    public LoginTask(Context context, String login, String passwd) {
        this.context = context;
        this.login = login;
        this.passwd = passwd;
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
            return compteWS.authentifier(login, passwd);
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void onPostExecute(Compte compte){
        pdialog.dismiss();
        if(compte==null){
            Toast.makeText(context,"Authentification échouée",Toast.LENGTH_SHORT).show();
        }
        else{
            if(compte.getRole().equals("ADMIN"))
            {
                context.startActivity(new Intent(context,MenuAdmin.class));

                Intent intent_mail=new Intent(context, CreerUnCompte.class);
                intent_mail.putExtra("lemail",compte.getEmail());
                intent_mail.putExtra("lelogin",compte.getLogin());
                context.startService(intent_mail);
            }

            else{

                Intent intent20=new Intent(context,CandidaturesEnCours.class);
                intent20.putExtra("lelogin",compte.getLogin());
                intent20.putExtra("lemdp",compte.getMdp());
                intent20.putExtra("mail_co",compte.getEmail());
                intent20.putExtra("specialite",compte.getSpecialite());
                context.startActivity(intent20);


            }

        }
    }


}
