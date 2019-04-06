/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongtv.controller.admin;

import java.text.SimpleDateFormat;

/**
 *
 * @author linh
 */
public class Utils {

    public static final String LOGIN = "Login.jsp";
    public static final String ERROR = "admin/error.jsp";
    public static final String ADMIN_HOME = "Admin";
    public static final String CHECK_LOGIN = "LoginController";
    public static final String CREATE_EVENT_FORM = "admin/CreateEvent.jsp";
    public static final String CREATE_EVENT = "CreateEventController";
    public static final String CREATE_EVENT_BANNER = "CreateBanner";

    public static final String MEMBER = "Member";
    public static final String MEMBER_VIEW = "admin/Member.jsp";
    public static final String MEMBER_VIEW_PARTIAL = "PartialView/Member.jsp";

    public static final String MAYMUA_VIEW = "admin/maymua.jsp";
    public static final String MAYMUA = "Ranking";
    public static final String RANKING = "RankingController";

    public static final String TEAM_VIEW = "admin/team.jsp";
    public static final String PRIZE_VIEW = "admin/prize.jsp";
    public static final String SETPRIZE_VIEW = "admin/setPrize.jsp";
    public static final String SET_PRIZE = "SetPrizeController";

    public static final String CONTACT_VIEW = "admin/Contact.jsp";

    public static String UPDATE_EVENT_VIEW = "admin/UpdateEvent.jsp";
    public static String UPDATE_EVENT = "UpdateEventController";

    public static final SimpleDateFormat OBJ_SDF = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm");

}
