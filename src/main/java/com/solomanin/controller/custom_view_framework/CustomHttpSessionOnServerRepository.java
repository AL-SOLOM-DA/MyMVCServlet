package com.solomanin.controller.custom_view_framework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CustomHttpSessionOnServerRepository {
    private final static Map<String, CustomHttpSession> sessions = new ConcurrentHashMap<>();

    public static CustomHttpSession getSession(String sessionID){
        return getSession(sessionID, true);
    }

    public static CustomHttpSession getSession(String sessionID, boolean canCreate){
        CustomHttpSession result = sessions.get(sessionID);
        if((result == null) && canCreate) {
            result = new CustomHttpSession();
            sessions.put(sessionID, result);
        }
        return result;
    }
}
