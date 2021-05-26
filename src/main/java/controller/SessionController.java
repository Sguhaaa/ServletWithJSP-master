package controller;

import dbService.dataSets.UsersDataSet;

import java.util.HashMap;
import java.util.Map;

class SessionController {
    private static SessionController Instance = new SessionController();
    private final Map<String, UsersDataSet> sessionIdToProfile;

    private SessionController() {
        sessionIdToProfile = new HashMap<String, UsersDataSet>();
    }

    static SessionController getInstance() {
        return Instance;
    }

    UsersDataSet getUserBySessionId(String sessionId) {
        return sessionIdToProfile.get(sessionId);
    }

    void addSession(String sessionId, UsersDataSet userProfile) {
        sessionIdToProfile.put(sessionId, userProfile);
    }

    void deleteSession(String sessionId) {
        sessionIdToProfile.remove(sessionId);
    }
}
