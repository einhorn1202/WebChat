package PresentationLayer;

import java.awt.Color;
import java.awt.Image;

import TransferObjects.User;

public class UserBean {

    User user;
    int user_id;
    String username;
    String password;
    Image profile_pic;
    String color;

    public UserBean() {
        // TODO Auto-generated constructor stub
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser_id(int userId) {
        this.user_id = userId;
    }

    public void setUsername(String username) {

    }

    public void setPassword() {

    }

    public void setProfile_pic() {

    }

    public void setColor() {

    }

    public int getID() {
        return user_id;

    }

    public String getUsername() {
        return username;

    }

    public String getPassword() {
        return password;

    }

    public Image getProfile_pic() {
        return profile_pic;

    }

    public Color getColor() {
        return null;

    }

    public String save() {
        return "";
    }

}
