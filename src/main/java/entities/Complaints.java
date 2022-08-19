package entities;

import java.util.Objects;

public class Complaints {
    int complain_id;
    String description;
    String status;
    int meeting_id;

public Complaints() {

}

    public Complaints(int complain_id, String description, String status, int meeting_id) {
        this.complain_id = complain_id;
        this.description = description;
        this.status = status;
        this.meeting_id = meeting_id;
    }

    public int getComplain_id() {
        return complain_id;
    }

    public void setComplain_id(int complain_id) {
        this.complain_id = complain_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getMeeting_id() {
        return meeting_id;
    }

    public void setMeeting_id(int meeting_id) {
        this.meeting_id = meeting_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Complaints that = (Complaints) o;
        return complain_id == that.complain_id && meeting_id == that.meeting_id && description.equals(that.description) && status.equals(that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(complain_id, description, status, meeting_id);
    }

    @Override
    public String toString() {
        return "Complaints{" +
                "complain_id=" + complain_id +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", meeting_id=" + meeting_id +
                '}';
    }
}

