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
import entity.FlightInfo;
import entity.Flightinstance;
import java.util.List;

/**
 *
 * @author Sindt
 */
public class JSONConvert {

    private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").setPrettyPrinting().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create();

    private static facade facade = new facade();

    public static Flightinstance getFlightInstanseFromJson(String js) {
        return gson.fromJson(js, Flightinstance.class);
    }

    public static String getJSONFromFlightInstance(Flightinstance fi) {
        return gson.toJson(fi);
    }

    public static String getJSONFromFlightInfo(List<FlightInfo> fi) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static String getJSONFromFlightInfoList(List<FlightInfo> fi) {
        return gson.toJson(fi);
    }

}
