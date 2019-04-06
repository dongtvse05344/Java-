package dongtv.bean;

import dongtv.dao.AccountDAO;
import dongtv.dao.EventDAO;
import dongtv.dao.PrizeDAO;
import dongtv.dao.RankDAO;
import dongtv.dto.AccountDTO;
import dongtv.dto.EventDTO;
import dongtv.dto.PrizeDTO;
import dongtv.dto.RankDTO;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author xhunt
 */
public class DongtvBean {
    private EventDTO eventDTO;
    private final EventDAO eventDAO = new EventDAO();
    private final RankDAO rankDAO = new RankDAO();
    private final AccountDAO accountDAO = new AccountDAO();
    private final PrizeDAO prizeDAO = new PrizeDAO();
    private int  eventId,prizeId;
    private RankDTO rankDTO;
    private List<RankDTO> ranks;
    private AccountDTO acountDTO;
    private String eventName;
    private String username;
    
    public boolean updateEvent() throws Exception
    {
        return eventDAO.update(eventDTO);
    }

    public void setPrizeId(int prizeId) {
        this.prizeId = prizeId;
    }
    
    public boolean updatePoint() throws Exception
    {
        return rankDAO.update(rankDTO);
    }

    public PrizeDTO getPrize() throws Exception
    {
        return prizeDAO.get(prizeId);
    }
    public List<RankDTO> searchRankByUsername() throws Exception
    {
        return rankDAO.search(username);
    }
    public boolean updateRankPrize() throws Exception
    {
        return rankDAO.updateRanks(rankDTO);
    }
    
    public List<PrizeDTO> getPrizes() throws Exception
    {
        return prizeDAO.getAll();
    }
    
    public boolean addManager() throws Exception
    {
        return accountDAO.addManager(username);
    }
    
    public boolean unManager() throws Exception
    {
      return accountDAO.unManager(username);
    }
    
    public List<AccountDTO> getManagers() throws Exception
    {
        return accountDAO.getManagers();
    }
    
    public boolean updateRank() throws Exception
    {
        return rankDAO.updateRanks(rankDTO);
    }
    
    public String getNameAccount() throws Exception
    {
        return accountDAO.get(username).getName();
    }
    
    public AccountDTO getAcount() throws Exception
    {
        return accountDAO.get(username);
    }
    
    public boolean changeActiveAccount() throws Exception
    {
        return accountDAO.changeActive(username);
    }

    public List<AccountDTO> getMembers() throws Exception
    {
        return accountDAO.getUsers();
    }
    
    public List<AccountDTO> getMembers(String nameSearch) throws Exception
    {
        return accountDAO.search(nameSearch);
    }
    
    public void setEvenName(String eventName) {
        this.eventName = eventName;
    }
    
    public AccountDTO getAcountDTO() {
        return acountDTO;
    }

    public void setAcountDTO(AccountDTO acountDTO) {
        this.acountDTO = acountDTO;
    }
    
    public boolean createAccount() throws Exception
    {
        return accountDAO.create(acountDTO);
    }
    
    public void searchRanksByEventId() throws Exception
    {
        ranks = rankDAO.search(eventId);
    }

    public List<RankDTO> getRanks() {
        return ranks;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public RankDTO getRankDTO() {
        return rankDTO;
    }

    public void setRankDTO(RankDTO rankDTO) {
        this.rankDTO = rankDTO;
    }

    public boolean createRank() throws Exception
    {
        return rankDAO.create(rankDTO);
    }
    
    public void getRank() throws Exception
    {
        rankDTO = rankDAO.get(username, eventId);
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public EventDTO getEvent() throws Exception
    {
        return eventDAO.get(eventId);
    }
    
    public EventDTO getEventDTO() {
        return eventDTO;
    }

    public void setEventDTO(EventDTO eventDTO) {
        this.eventDTO = eventDTO;
    }
    
    public int createEvent() throws Exception
    {
        return eventDAO.create(eventDTO);
    }
    
    
    public List<EventDTO> getEventFuture() throws Exception
    {
        return eventDAO.getEventsFuture();
    }
    
    public List<EventDTO> getEventPast() throws Exception
    {
        return eventDAO.getEventsPast();
    }
    
    public List<EventDTO> getEventNow() throws Exception
    {
        return eventDAO.getEventsNow();
    }
    
    public List<EventDTO> getEventNow(String username) throws Exception
    {
        return eventDAO.getEventsNow(username);
    }
    
    public List<EventDTO> getEventAll() throws Exception
    {
        return eventDAO.getAll();
    }
    
    public List<EventDTO> searhEvents() throws Exception
    {
        return eventDAO.searchEvents(eventName);
    }
    
    
}
