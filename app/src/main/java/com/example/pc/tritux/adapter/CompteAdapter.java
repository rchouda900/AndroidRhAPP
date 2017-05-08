package com.example.pc.tritux.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.pc.tritux.R;
import com.example.pc.tritux.ws.Compte;

import java.util.List;



public class CompteAdapter extends BaseAdapter{

    Context context;
    List<Compte> comptes;
    int x=0;


    public CompteAdapter(Context context, List<Compte> comptes,int x) {
        this.context = context;
        this.comptes = comptes;
        this.x=x;
    }

    @Override
    public int getCount() {
        return comptes.size();
    }

    @Override
    public Compte getItem(int i) {
        return comptes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null)
            view = LayoutInflater.from(context).inflate(R.layout.item_compte,null);

        TextView nom = (TextView) view.findViewById(R.id.itemCompteNom);
        TextView role = (TextView) view.findViewById(R.id.itemCompteRole);
        TextView specialite = (TextView) view.findViewById(R.id.itemCompteSpecialite);

        Compte compte = getItem(i);

        if (x==0)
        { if (compte.getRole().equals("ADMIN")) {
        nom.setText(compte.getEmail());
        role.setText("Role: " + compte.getRole());
        specialite.setText("Specialite: "+compte.getSpecialite());}}
        if (x==1){
            if (compte.getRole().equals("USER")) {
                nom.setText(compte.getEmail());
                role.setText("Role: " + compte.getRole());
                specialite.setText("Specialite: "+compte.getSpecialite());}  ////////// si if USER==false alors il remet la derniere valeur : il faut corriger ca pour que le systeme saute si n'est pas USER


        }
        return view;
    }
}
