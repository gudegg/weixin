package club.gude.utils;

import com.google.common.base.Strings;
import com.google.common.xml.XmlEscapers;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author Gude
 * @Date 2016/4/6.
 * 微信接收、发送 xml解析、生成
 */
public class XmlUtil {
    /**
     * xml解析
     *
     * @param strXml
     */
    public static Map<String, String> xmlResolve(String strXml) {
        if (Strings.isNullOrEmpty(strXml)) {
            return null;
        } else {
            Map<String, String> map = new HashMap<String, String>();
            // 将字符串转化为XML文档对象
            Document document = null;
            try {
                document = DocumentHelper.parseText(strXml);
            } catch (DocumentException e) {
                e.printStackTrace();
                return null;
            }
            // 获得文档的根节点
            Element root = document.getRootElement();
            // 遍历根节点下所有子节点
            Iterator<?> iter = root.elementIterator();
            while (iter.hasNext()) {
                Element ele = (Element) iter.next();
                // 获取set方法中的参数字段（实体类的属性）
                map.put(ele.getName(), ele.getText());
            }
            return map;
        }
    }
}
