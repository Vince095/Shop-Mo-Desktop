package models.user.allUsers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import models.user.Avatar;

import java.util.Date;

public class UserData {
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
    @SerializedName("createdAt")
    @Expose
    private Date createdAt;
    @SerializedName("__v")
    @Expose
    private int __v;
}
