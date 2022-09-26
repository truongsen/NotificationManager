package com.example.notificationmanager.db;


public class Notification {
    private String pkg;
    private String content;

    public String getPkg() {
        return pkg;
    }

    public void setPkg(String pkg) {
        this.pkg = pkg;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Notification(String pkg, String content) {
        this.pkg = pkg;
        this.content = content;
    }
}
