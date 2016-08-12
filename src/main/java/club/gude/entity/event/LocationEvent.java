package club.gude.entity.event;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Author Gude.
 * @Date 2016/8/12.
 * 上报地理位置事件
 */
@XmlRootElement(name = "xml")
public class LocationEvent extends BaseEvent {
    /**
     * 地理位置纬度
     */
    @XmlElement
    private Double Latitude;
    /**
     * 地理位置经度
     */
    @XmlElement
    private Double Longitude;
    /**
     * 地理位置精度
     */
    @XmlElement
    private Double Precision;

    public Double getLatitude() {
        return Latitude;
    }

    public void setLatitude(Double latitude) {
        Latitude = latitude;
    }

    public Double getLongitude() {
        return Longitude;
    }

    public void setLongitude(Double longitude) {
        Longitude = longitude;
    }

    public Double getPrecision() {
        return Precision;
    }

    public void setPrecision(Double precision) {
        Precision = precision;
    }
}
