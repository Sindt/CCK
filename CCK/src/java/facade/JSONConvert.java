/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import entity.Flightinstance;

/**
 *
 * @author Sindt
 */
public class JSONConvert {

    private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").setPrettyPrinting().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create();

    private static facade facade = new facade();

    public static Flightinstance getLinkFromJson(String js) {
        return gson.fromJson(js, Flightinstance.class);
    }

    public static String getJSONFromLink(Flightinstance fi) {
        return gson.toJson(fi);
    }

}
