package com.example.pc.tritux.ws;

import java.util.List;

import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Field;
import retrofit.http.PUT;


public interface CompteWS {

    public static final String ENDPOINT = "http://10.0.2.2:8181/";

    @FormUrlEncoded
    @POST("/comptes/authentifier")
    public Compte authentifier(@Field("login") String login, @Field("mdp") String mdp);

    @GET("/comptes/affichertous")
    public List<Compte> getAll();

    @FormUrlEncoded
    @POST("/comptes/creer")
    public Compte creer(@Field("login") String login,@Field("mdp") String mdp, @Field("email") String email,@Field("role") String role,@Field("specialite")String specialite);


    @FormUrlEncoded
    @POST("/comptes/afficheremail")
    public Compte getEmail(@Field("email") String mail);

    @FormUrlEncoded
    @PUT("/comptes/modifier")
    public int ModifierCompte(@Field("login") String login,@Field("mdp") String mdp);


}
