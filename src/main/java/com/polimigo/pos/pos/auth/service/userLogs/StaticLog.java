package com.polimigo.pos.pos.auth.service.userLogs;


import com.polimigo.pos.pos.auth.models.UsersLogs;

/**
 * @author michael wagih
 */
public class StaticLog {
    public static UsersLogs createLogin(String userName){
        UsersLogs usersLogs = new UsersLogs();
        usersLogs.setDescription(userName+"Login at System");
        return usersLogs;
    }
}
