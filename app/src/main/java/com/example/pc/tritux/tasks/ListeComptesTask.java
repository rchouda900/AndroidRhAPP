package com.example.pc.tritux.tasks;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;

import com.example.pc.tritux.adapter.CompteAdapter;
import com.example.pc.tritux.ws.Compte;
import com.example.pc.tritux.ws.CompteWS;

import java.util.List;

import retrofit.RestAdapter;




public class ListeComptesTask extends AsyncTask<Void,Void,List<Compte>>{

    private Context context;
    private ListView listView;
    int x;

    public ListeComptesTask(Context context, ListView listView,int x) {
        this.context = context;
        this.listView = listView;
        this.x=x;
    }

    ProgressDialog pdialog;

    @Override
    public void onPreExecute(){
        pdialog = ProgressDialog.show(context,"Chargement en cours...","Veuillez patienter");
    }

    @Override
    protected List<Compte> doInBackground(Void... params) {
        CompteWS compteWS = new RestAdapter.Builder()
                .setEndpoint(CompteWS.ENDPOINT)
                .build()
                .create(CompteWS.class);
        try {
            return compteWS.getAll();
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void onPostExecute(List<Compte> comptes){
        pdialog.dismiss();
        if(comptes==null){
        }
       else{
            CompteAdapter adapter = new CompteAdapter(context,comptes,x);
            listView.setAdapter(adapter);
        }
    }
}
