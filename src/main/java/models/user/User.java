package models.user;

import com.google.gson.annotations.*;

import java.util.Date;

public class User {

    @SerializedName("avatar")
    @Expose
    private Avatar avatar;
    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("_id")
    @Expose
    private String _id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email ;
    @SerializedName("password")
    @Expose
    private String password ;
    @SerializedName("createdAt")
    @Expose
    private Date createdAt;
    @SerializedName("__v")
    @Expose
    private int __v;


    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_id() {
        return _id;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    public Avatar getAvatar() {
        return avatar;
    }

}
