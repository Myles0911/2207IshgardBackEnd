package entities;

import java.util.Objects;

public class Ishgardians {
    int userid;
    String name;
    String password;
    String role;

    public Ishgardians() {

    }

    public Ishgardians(int userid, String name, String password, String role) {
        this.userid = userid;
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ishgardians that = (Ishgardians) o;
        return userid == that.userid && name.equals(that.name) && password.equals(that.password) && role.equals(that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid, name, password, role);
    }

    @Override
    public String toString() {
        return "Ishgardians{" +
                "userid=" + userid +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
