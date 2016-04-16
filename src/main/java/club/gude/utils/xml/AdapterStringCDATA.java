package club.gude.utils.xml;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * @Author Gude
 * @Date 2016/4/16.
 */
public class AdapterStringCDATA extends XmlAdapter<String, String> {

    @Override
    public String unmarshal(String v) throws Exception {
        return v;
    }

    @Override
    public String marshal(String v) throws Exception {
        return "<![CDATA[" + v + "]]>";
    }



}
