package org.example;

import java.util.Date;
import java.util.List;

public class Course {
    private String name;
    private Schedule schedule;
    private Date startDate;
    private int totalHours;
    private List<Participant> participants;

    public Course(String name, Schedule schedule, Date startDate, int totalHours,List<Participant> participants){
        this.name = name;
        this.schedule = schedule;
        this.startDate = startDate;
        this.totalHours = totalHours;
        this.participants = participants;
    }

    public String getName() {
        return name;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public Date getStartDate() {

        return startDate;
    }

    public int getTotalHours() {
        return totalHours;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setTotalHours(int totalHours) {
        this.totalHours = totalHours;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }
}
