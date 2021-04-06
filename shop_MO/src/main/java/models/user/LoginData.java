package models.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import models.user.User;

public class LoginData {
    @SerializedName("success")
    @Expose
    private Boolean success ;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("user")
    @Expose
    private User user;


    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setSuccess(boolean status) {
        this.success = status;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

}
