package http;

/**
 * Created by flashing on 2016/9/19.
 */
public class Contants {
    public static final String CAMPAIGN_ID = "campaign_id";
    public static final String WARE = "ware";

    public static final String USER_JSON = "user_json";
    public static final String TOKEN = "token";

    public static final int REQUEST_CODE = 0;

    public static class API{
        public static final String BASE_URL = "http://101.200.167.75:8080/phoenixshop/";
//        public static final String BASE_URL = "http://192.168.0.102:8080/hlshop/";

        public static final String BANNER_URL = BASE_URL+"banner/query";
        public static final String CAMPAIGN_HOME = BASE_URL+"campaign/recommend";
        public static final String CAMPAIGN_LIST = BASE_URL+"campaign/list";

        public static final String WARES_HOT = BASE_URL+"wares/hot";
        public static final String WARES_LIST = BASE_URL+"wares/list";
        public static final String WARES_DETAIL = BASE_URL+"wares/detail.html";

        public static final String CATEGORY_LIST = BASE_URL+"category/list";

        public static final String USER_DETAIL = BASE_URL+"user/get?id=1";

        public static final String LOGIN = BASE_URL+"auth/login";
        public static final String REG = BASE_URL+"auth/reg";

        public static final String ORDER_CREATE = BASE_URL+"user/ordercreate";
        public static final String ORDER_COMPLETE = BASE_URL+"user/ordercomplete";
        public static final String ORDER_LIST = BASE_URL+"user/orderlist";

        public static final String ADDRESS_LIST = BASE_URL+"user/addrlist";
        public static final String ADDRESS_UPDATE = BASE_URL+"user/addrupdate";
        public static final String ADDRESS_DELETE = BASE_URL+"user/addrdel";
        public static final String ADDRESS_CREATE = BASE_URL+"user/addrcreate";

        public static final String FAVORITE_CREATE = BASE_URL+"user/favoritecreate";
        public static final String FAVORITE_LIST = BASE_URL+"user/favoritelist";
        public static final String FAVORITE_DELETE = BASE_URL+"user/favoritedel";
    }
}
