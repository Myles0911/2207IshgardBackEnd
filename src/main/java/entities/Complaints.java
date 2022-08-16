package entities;

import java.util.Objects;

public class Complaints {
    int id;
    String complain;

    public Complaints(int id, String complain) {
        this.id = id;
        this.complain = complain;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComplain() {
        return complain;
    }

    public void setComplain(String complain) {
        this.complain = complain;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Complaints that = (Complaints) o;
        return id == that.id && complain.equals(that.complain);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, complain);
    }

    @Override
    public String toString() {
        return "complaints{" +
                "id=" + id +
                ", complain='" + complain + '\'' +
                '}';
    }
}

