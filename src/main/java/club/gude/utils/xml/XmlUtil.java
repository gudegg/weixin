package club.gude.utils.xml;

import club.gude.entity.msg.in.*;
import club.gude.utils.msg.MsgType;
import com.google.common.base.Strings;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
     * @return 节点值封装到map里
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

    /**
     * @param strXml 接收到用户的消息
     * @return 消息类型 text image vedio 等等
     */
    public static String inMsgType(String strXml) {
        return getNode(strXml, "MsgType");
    }

    /**
     * {@code
     * <xml>
     * <ToUserName><![CDATA[toUser]]></ToUserName>
     * <FromUserName><![CDATA[FromUser]]></FromUserName>
     * <CreateTime>123456789</CreateTime>
     * <MsgType><![CDATA[event]]></MsgType>
     * <Event><![CDATA[subscribe]]></Event>
     * </xml>
     * node传入Event得到subscribe
     *}
     * <p>
     * 查找节点内容
     * </p>
     * @param str  xml数据
     * @param node 选择查找的节点
     * @return
     */
    public static String getNode(String str, String node) {
        if (Strings.isNullOrEmpty(str)) {
            throw new RuntimeException("str不能为空");
        } else {

            try {
                Document document = DocumentHelper.parseText(str);
                Element MsgType_element = (Element) document.selectSingleNode("//" + node);
                String msgType = MsgType_element.getText();
                return msgType;
            } catch (DocumentException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    /**
     * @param strXml
     * @return 传入消息对象 用户自己进行强制转换
     */
    public static InBaseMsg xmlResolve_MsgIn(String strXml) {
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
            Element MsgType_element = (Element) document.selectSingleNode("//MsgType");
            String msgType = MsgType_element.getText();

            // 获得文档的根节点
            Element root = document.getRootElement();
            // 遍历根节点下所有子节点
            Iterator<?> iter = root.elementIterator();

            if (msgType.equalsIgnoreCase(MsgType.TEXT)) {
                InTextMsg inTextMsg = new InTextMsg();
                reflectVal(inTextMsg, iter);
                return inTextMsg;
            } else if (msgType.equalsIgnoreCase(MsgType.IMAGE)) {
                InImageMsg inImageMsg = new InImageMsg();
                reflectVal(inImageMsg, iter);
                return inImageMsg;

            } else if (msgType.equalsIgnoreCase(MsgType.VOICE)) {
                InVoiceMsg inVoiceMsg = new InVoiceMsg();
                reflectVal(inVoiceMsg, iter);
                return inVoiceMsg;

            } else if (msgType.equalsIgnoreCase(MsgType.VIDEO) || msgType.equalsIgnoreCase(MsgType.SHORT_VIDEO)) {
                InVedioMsg inVedioMsg = new InVedioMsg();
                reflectVal(inVedioMsg, iter);
                return inVedioMsg;

            } else if (msgType.equalsIgnoreCase(MsgType.LOCATION)) {
                InLocationMsg inLocationMsg = new InLocationMsg();
                reflectVal(inLocationMsg, iter);
                return inLocationMsg;

            } else if (msgType.equalsIgnoreCase(MsgType.LINK)) {
                InLinkMsg inLinkMsg = new InLinkMsg();
                reflectVal(inLinkMsg, iter);
                return inLinkMsg;
            }
            return null;
        }
    }

    public static void reflectVal(Object o, Iterator<?> iter) {
        Class clz = o.getClass();
        Element ele = null;
        Field field = null;
        Method method = null;
        while (iter.hasNext()) {
            ele = (Element) iter.next();

            try {
                field = clz.getDeclaredField(ele.getName());

                method = clz.getDeclaredMethod("set" + ele.getName(), field.getType());
                if (Long.class.isAssignableFrom(field.getType())) {
                    method.invoke(o, Long.parseLong(ele.getTextTrim()));
                } else if (Integer.class.isAssignableFrom(field.getType())) {
                    method.invoke(o, Integer.parseInt(ele.getTextTrim()));
                } else if (Double.class.isAssignableFrom(field.getType())) {
                    method.invoke(o, Double.parseDouble(ele.getTextTrim()));
                } else {
                    method.invoke(o, field.getType().cast(ele.getTextTrim()));
                }
            } catch (Exception e) {
                try {
                    field = clz.getSuperclass().getDeclaredField(ele.getName());
                    method = clz.getSuperclass().getDeclaredMethod("set" + ele.getName(), field.getType());
                    if (Long.class.isAssignableFrom(field.getType())) {
                        method.invoke(o, Long.parseLong(ele.getTextTrim()));
                    } else if (Integer.class.isAssignableFrom(field.getType())) {
                        method.invoke(o, Integer.parseInt(ele.getTextTrim()));
                    } else if (Double.class.isAssignableFrom(field.getType())) {
                        method.invoke(o, Double.parseDouble(ele.getTextTrim()));
                    } else {
                        method.invoke(o, field.getType().cast(ele.getTextTrim()));
                    }

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }

        }
    }

    /**
     * 生成xml文件
     *
     * @param map 节点以key-val传入生成
     * @return
     */
    public static String xmlCreate(Map<String, String> map) {
        Document document = DocumentHelper.createDocument();
        Element rootElement = document.addElement("xml");
        Element e = null;
        for (String s : map.keySet()) {
            e = rootElement.addElement(s);
            e.addCDATA(map.get(s));
        }
        //抛弃头<?xml version="1.0" encoding="UTF-8"?> document.asXML()会有这个头
        return document.getRootElement().asXML();
    }
}
