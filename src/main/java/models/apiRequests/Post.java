package models.apiRequests;

import okhttp3.*;

import java.io.IOException;
import java.util.Objects;

public class Post {

    private static final MediaType JSON = MediaType.parse("application/json; charset = 'utf-8'");

    OkHttpClient client = new OkHttpClient();

    public String post(String url, String json)throws IOException {
        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .url(url)
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();

        try(Response response = client.newCall(request).execute()){
            return Objects.requireNonNull(response.body()).string();
        }
    }

    public String userLogin(String email, String password){

       return "{\r\n \"email\": \"" +email +"\",\r\n" +
                "\r\r \"password\":\"" +password + "\"\r\n}";
     }

     //Get admin Request
    public String getRequest(String url, String token) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .method("GET" , null)
                .addHeader("cookie", "token="+token)
                .build();

        try(Response response = client.newCall(request).execute()){
            return Objects.requireNonNull(response.body()).string();
        }
    }



}
