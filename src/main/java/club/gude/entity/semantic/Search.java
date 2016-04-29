package club.gude.entity.semantic;

/**
 * @Author Gude
 * @Date 2016/4/25.
 */
public class Search {
    private String access_token;
    private String query;
    private String category;
    private float latitude;
    private float longitude;
    private String city;
    private String region;
    private String appid;
    private String uid;

    public Search() {
    }

    public Search(String access_token, String query, String appid, String category) {
        this.access_token = access_token;
        this.query = query;
        this.appid = appid;
        this.category = category;
    }

    public Search(String access_token, String query, String category, float latitude, float longitude, String city, String region, String appid, String uid) {
        this.access_token = access_token;
        this.query = query;
        this.category = category;
        this.latitude = latitude;
        this.longitude = longitude;
        this.city = city;
        this.region = region;
        this.appid = appid;
        this.uid = uid;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
