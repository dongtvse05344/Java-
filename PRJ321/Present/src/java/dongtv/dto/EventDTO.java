/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongtv.dto;

import java.io.Serializable;
import java.sql.Timestamp;



/**
 *
 * @author linh
 */
public class EventDTO implements Serializable{
    private int id;
    private String name;
    private Timestamp dateCreated,dateStarted,dateEnded;
    private String managerId,banner,location,description;
    private int noUser;
    
    public EventDTO(String name, Timestamp dateStarted, Timestamp dateEnded, String managerId, String banner, String location, String description, int noUser) {
        this.name = name;
        this.dateStarted = dateStarted;
        this.dateEnded = dateEnded;
        this.managerId = managerId;
        this.banner = banner;
        this.location = location;
        this.description = description;
        java.util.Date date = new java.util.Date();
        dateCreated = new Timestamp(new java.util.Date().getTime());
        this.noUser =noUser;
    }

   

    public EventDTO(int id, String name, Timestamp dateCreated, Timestamp dateStarted, Timestamp dateEnded, String managerId, String banner, String location, String description, int noUser) {
        this.id = id;
        this.name = name;
        this.dateCreated = dateCreated;
        this.dateStarted = dateStarted;
        this.dateEnded = dateEnded;
        this.managerId = managerId;
        this.banner = banner;
        this.location = location;
        this.description = description;
        this.noUser = noUser;
    }
    
    

    public int getNoUser() {
        return noUser;
    }

    public void setNoUser(int noUser) {
        this.noUser = noUser;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Timestamp getDateStarted() {
        return dateStarted;
    }

    public void setDateStarted(Timestamp dateStarted) {
        this.dateStarted = dateStarted;
    }

    public Timestamp getDateEnded() {
        return dateEnded;
    }

    public void setDateEnded(Timestamp dateEnded) {
        this.dateEnded = dateEnded;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
}
