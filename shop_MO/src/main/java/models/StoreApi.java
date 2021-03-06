package models;

public class StoreApi {
    public static final String dbUrl = "mongodb+srv://user:pass@shopmo.ixkhz.mongodb.net/shopMO?retryWrites=true&w=majority";
    public static final String baseUrl = "http://shop-mo.herokuapp.com/";
    private static final String apiUrl = "api/v1/";
    private static final String adminUrl = apiUrl+"admin/";

    private static final String loginUrl = baseUrl+apiUrl+"login";
    private static final String registerUrl = baseUrl+apiUrl+"register";
    private static final String orderUrl = baseUrl+adminUrl+"orders";

    public static String getLoginUrl() {
        return loginUrl;
    }

    public static String getRegisterUrl() {
        return registerUrl;
    }

    public static String getOrderUrl() {
        return orderUrl;
    }
}
