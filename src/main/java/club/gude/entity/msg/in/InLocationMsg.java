package club.gude.entity.msg.in;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Author Gude
 * @Date 2016/4/5.
 */
@XmlRootElement(name = "xml")
public class InLocationMsg extends InBaseMsg {
    //地理位置维度
    @XmlElement
    private Double Location_X;
    //经度
    @XmlElement
    private Double Location_Y;
    //地图缩放大小
    @XmlElement
    private Integer Scale;
    //地理位置信息
    @XmlElement
    private String Label;

    public Double getLocation_X() {
        return Location_X;
    }

    public void setLocation_X(Double location_X) {
        Location_X = location_X;
    }

    public Double getLocation_Y() {
        return Location_Y;
    }

    public void setLocation_Y(Double location_Y) {
        Location_Y = location_Y;
    }

    public Integer getScale() {
        return Scale;
    }

    public void setScale(Integer scale) {
        Scale = scale;
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String label) {
        Label = label;
    }
}
