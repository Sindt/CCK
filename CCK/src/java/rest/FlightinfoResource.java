/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import entity.FlightInfo;
import facade.JSONConvert;
import facade.facade;
import java.io.IOException;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Sindt
 */
@Path("flightinfo")
public class FlightinfoResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Flightinfo
     */
    public FlightinfoResource() {
    }
    facade facade = new facade();

    //Quick fix!
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{from}/{date}/{passengers}")
    public Response getJson(@PathParam("from") String from, @PathParam("date") String date, @PathParam("passengers") int passengers) throws IOException {
        List<FlightInfo> fiList = facade.getFromDatePassenger(from, date, passengers);
        String json = JSONConvert.getJSONFromFlightInfoList(fiList);
        String links = "{\"airlines\": \"CCK\",\n\"flights\":" + json + "}";
        return Response.ok(links).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{from}/{to}/{date}/{passengers}")
    public Response getJson(@PathParam("from") String from, @PathParam("to") String to, @PathParam("date") String date, @PathParam("passengers") int passengers) throws IOException {
        List<FlightInfo> fiList = facade.getFromDatePassenger(from, date, passengers);
        String json = JSONConvert.getJSONFromFlightInfoList(fiList);
        String links = "{\"airlines\": \"CCK\",\n\"flights\":" + json + "}";
        return Response.ok(links).build();
    }

    /**
     * PUT method for updating or creating an instance of FlightinfoResource
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
