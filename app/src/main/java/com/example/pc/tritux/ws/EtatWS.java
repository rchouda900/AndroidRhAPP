package com.example.pc.tritux.ws;

import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;



public interface EtatWS {
    public static final String ENDPOINT = "http://10.0.2.2:8181/";

    @FormUrlEncoded
    @POST("/etats/retourner")
    public Etat getEtat(@Field("email") String email);


}
