/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sindt
 */
@Entity
@Table(name = "airport")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Airport.findAll", query = "SELECT a FROM Airport a"),
    @NamedQuery(name = "Airport.findByIatacode", query = "SELECT a FROM Airport a WHERE a.iatacode = :iatacode"),
    @NamedQuery(name = "Airport.findByName", query = "SELECT a FROM Airport a WHERE a.name = :name"),
    @NamedQuery(name = "Airport.findByCity", query = "SELECT a FROM Airport a WHERE a.city = :city"),
    @NamedQuery(name = "Airport.findByTimezone", query = "SELECT a FROM Airport a WHERE a.timezone = :timezone")})
public class Airport implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "iatacode")
    private String iatacode;
    @Column(name = "name")
    private String name;
    @Column(name = "city")
    private String city;
    @Column(name = "timezone")
    private String timezone;
    @OneToMany(mappedBy = "destination")
    private List<Flightinstance> flightinstanceList;
    @OneToMany(mappedBy = "origin")
    private List<Flightinstance> flightinstanceList1;

    public Airport() {
    }

    public Airport(String iatacode) {
        this.iatacode = iatacode;
    }

    public String getIatacode() {
        return iatacode;
    }

    public void setIatacode(String iatacode) {
        this.iatacode = iatacode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @XmlTransient
    public List<Flightinstance> getFlightinstanceList() {
        return flightinstanceList;
    }

    public void setFlightinstanceList(List<Flightinstance> flightinstanceList) {
        this.flightinstanceList = flightinstanceList;
    }

    @XmlTransient
    public List<Flightinstance> getFlightinstanceList1() {
        return flightinstanceList1;
    }

    public void setFlightinstanceList1(List<Flightinstance> flightinstanceList1) {
        this.flightinstanceList1 = flightinstanceList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iatacode != null ? iatacode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Airport)) {
            return false;
        }
        Airport other = (Airport) object;
        if ((this.iatacode == null && other.iatacode != null) || (this.iatacode != null && !this.iatacode.equals(other.iatacode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Airport[ iatacode=" + iatacode + " ]";
    }
    
}
