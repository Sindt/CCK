/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import deploy.DeploymentConfiguration;
import entity.Flightinstance;
import entity.FlightInfo;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Sindt
 */
public class facade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory(DeploymentConfiguration.PU_NAME);

    public facade() {
    }

    
    //Quick Fix! Not the right way
    public List<FlightInfo> getFromDatePassenger(String from, String date, int passengers) {
        List<FlightInfo> fInfoList = new ArrayList();

        EntityManager em = emf.createEntityManager();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Query q = em.createNamedQuery("Flightinstance.findAll");
            List<Flightinstance> fInstanceList = q.getResultList();
            System.out.println(fInstanceList.toString());
            for (Flightinstance fIns : fInstanceList) {
                String dates = df.format(fIns.getDepartureDate());
                if (fIns.getOrigin().getIatacode().equalsIgnoreCase(from) && dates.equalsIgnoreCase(date)) {
                    System.out.println(dates);
                    System.out.println(date);
                    FlightInfo fInfo = new FlightInfo();
                    fInfo.setDate(fIns.getDepartureDate());
                    fInfo.setDestination(fIns.getDestination().getIatacode());
                    fInfo.setFlightID(fIns.getFlightnumber().getFlightnumber());
                    fInfo.setNumberOfSeats(passengers);
                    fInfo.setOrigin(fIns.getOrigin().getIatacode());
                    fInfo.setTotalPrice(fIns.getPrice());
                    fInfo.setTravelTime(fIns.getFlighttime());
                    fInfoList.add(fInfo);
                    System.out.println(fInfo.toString());
                }

            }

        } catch (Exception e) {
        }
        return fInfoList;
    }

    public List<FlightInfo> getFromToDatePassenger(String from, String to, String date, int passengers) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
