package com.jekirdek.microservicespost;

import java.util.Objects;

public class AuthObject {
    private String sessionId;
    private Long id;

    public AuthObject() {};
    public AuthObject(String sessionId, Long id) {
        this.sessionId = sessionId;
        this.id = id;
    }
    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthObject that = (AuthObject) o;
        return sessionId.equals(that.sessionId) && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sessionId, id);
    }
}
