package ua.externaljava.droid_wars.models.user;

import ua.externaljava.droid_wars.models.droids.BattleDroid;

import java.util.List;

public class User {
    private String nickName;
    private String email;
    private String password;
    private String role;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public BattleDroid chooseDroidForBattle(List<BattleDroid> droids, int droidNumber){
        return droids.get(--droidNumber);
    }

    @Override
    public String toString() {
        return "User{" +
                "nickName='" + nickName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
