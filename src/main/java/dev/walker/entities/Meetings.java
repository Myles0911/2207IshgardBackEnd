package dev.walker.entities;

import java.util.Objects;

public class Meetings {
    int meeting_id;
    String address;
    String summary;
    long time;

public Meetings() {

}

    public Meetings(int meeting_id, String address, String summary, long time) {
        this.meeting_id = meeting_id;
        this.address = address;
        this.summary = summary;
        this.time = time;
    }

    public int getMeeting_id() {
        return meeting_id;
    }

    public void setMeeting_id(int meeting_id) {
        this.meeting_id = meeting_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meetings meetings = (Meetings) o;
        return meeting_id == meetings.meeting_id && time == meetings.time && address.equals(meetings.address) && summary.equals(meetings.summary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(meeting_id, address, summary, time);
    }

    @Override
    public String toString() {
        return "Meetings{" +
                "meeting_id=" + meeting_id +
                ", address='" + address + '\'' +
                ", summary='" + summary + '\'' +
                ", time=" + time +
                '}';
    }
}
