package models.user.allUsers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Users {
    @SerializedName("success")
    @Expose
    private String success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("users")
    @Expose
    private List<UserData> users;

    public String getMessage() {
        return message;
    }

    public List<UserData> getUsers() {
        return users;
    }

    public String getSuccess() {
        return success;
    }
}
