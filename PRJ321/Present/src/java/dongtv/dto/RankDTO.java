/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongtv.dto;

import java.io.Serializable;

/**
 *
 * @author xhunt
 */
public class RankDTO implements Serializable{
    private String username;
    private String name;
    private int EventId,point,prizeId;
    
    private EventDTO event;
    private PrizeDTO prize;

    public EventDTO getEvent() {
        return event;
    }

    public void setEvent(EventDTO event) {
        this.event = event;
    }

    public PrizeDTO getPrize() {
        return prize;
    }

    public void setPrize(PrizeDTO prize) {
        this.prize = prize;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(int prizeId) {
        this.prizeId = prizeId;
    }
    
    

    
    public RankDTO(String username, int EventId, int point,int prizeId) {
        this.username = username;
        this.EventId = EventId;
        this.point = point;
        this.prizeId = prizeId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public int getEventId() {
        return EventId;
    }

    public void setEventId(int EventId) {
        this.EventId = EventId;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
    
}
