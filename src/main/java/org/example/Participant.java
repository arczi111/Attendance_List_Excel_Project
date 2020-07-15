package org.example;

public class Participant {
    private String name;
    private String mail;

    public Participant(String name,String mail){
        this.name = name;
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return name;
    }
}
