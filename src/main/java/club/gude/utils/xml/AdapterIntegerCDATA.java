package club.gude.utils.xml;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * @Author Gude
 * @Date 2016/4/16.
 */
public class AdapterIntegerCDATA extends XmlAdapter<Integer, Integer> {

    @Override
    public Integer unmarshal(Integer v) throws Exception {
        return v;
    }

    @Override
    public Integer marshal(Integer v) throws Exception {
        return v;
    }


}
