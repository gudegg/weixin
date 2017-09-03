package club.gude.utils.xml;

import club.gude.entity.msg.in.*;
import club.gude.entity.msg.out.OutBaseMsg;
import club.gude.utils.msg.MsgType;
import com.google.common.base.Strings;
import com.sun.xml.bind.marshaller.CharacterEscapeHandler;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;


/**
 * @Author Gude
 * @Date 2016/4/11.
 */
public class XmlJaxbUtil {
    /**
     * xml转为对象
     *
     * @param strXml xml
     * @return 对象
     * @throws JAXBException
     */
    public static InBaseMsg xmlResolve_MsgIn(String strXml) throws JAXBException {
        if (Strings.isNullOrEmpty(strXml)) {
            return null;
        } else {
            String msgType = XmlUtil.inMsgType(strXml);
            if (msgType.equalsIgnoreCase(MsgType.TEXT)) {
                InTextMsg inTextMsg = StrToObj(InTextMsg.class, strXml);
                return inTextMsg;
            } else if (msgType.equalsIgnoreCase(MsgType.IMAGE)) {
                InImageMsg inImageMsg = StrToObj(InImageMsg.class, strXml);

                return inImageMsg;

            } else if (msgType.equalsIgnoreCase(MsgType.VOICE)) {
                InVoiceMsg inVoiceMsg = StrToObj(InVoiceMsg.class, strXml);

                return inVoiceMsg;

            } else if (msgType.equalsIgnoreCase(MsgType.VIDEO) || msgType.equalsIgnoreCase(MsgType.SHORT_VIDEO)) {
                InVedioMsg inVedioMsg = StrToObj(InVedioMsg.class, strXml);

                return inVedioMsg;

            } else if (msgType.equalsIgnoreCase(MsgType.LOCATION)) {
                InLocationMsg inLocationMsg = StrToObj(InLocationMsg.class, strXml);

                return inLocationMsg;

            } else if (msgType.equalsIgnoreCase(MsgType.LINK)) {
                InLinkMsg inLinkMsg = StrToObj(InLinkMsg.class, strXml);

                return inLinkMsg;
            }
            return null;
        }
    }

    /**
     * xml转为对象
     *
     * @param strXml
     * @param clz
     * @param <T>
     * @return
     * @throws JAXBException
     */
    public static <T> T xmlResolve_MsgIn(String strXml, Class<T> clz) throws Exception {
        if (Strings.isNullOrEmpty(strXml)) {
            return null;
        } else {
           return StrToObj(clz,strXml);
        }
    }

    /**
     * xml字符串转化为对象
     * @param clz
     * @param strXml
     * @param <T>
     * @return
     * @throws JAXBException
     */
    public static <T> T StrToObj(Class<T> clz, String strXml) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(clz);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (T) jaxbUnmarshaller.unmarshal(new StringReader(strXml));
    }

    /**
     * 发送消息 对象转化为XML
     *
     * @param outBaseMsg
     * @return
     * @throws JAXBException
     */

    public static <T extends OutBaseMsg> String xmlCreate_MsgOut(T outBaseMsg) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(outBaseMsg.getClass(), OutBaseMsg.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        //是否输出头 True不输出 <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
        jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
        //格式化
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
        jaxbMarshaller.setProperty(CharacterEscapeHandler.class.getName(), new CharacterEscapeHandler() {
            @Override
            public void escape(char[] ac, int i, int j, boolean flag, Writer writer) throws IOException {
                writer.write(ac, i, j);
            }
        });
        StringWriter writer = new StringWriter();
        jaxbMarshaller.marshal(outBaseMsg, writer);
        return writer.toString();
    }

    /**
     * 通用对象转化为XML
     *
     * @param obj
     * @return
     * @throws JAXBException
     */
    public static String ObjToXml(Object obj) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
        jaxbMarshaller.setProperty(CharacterEscapeHandler.class.getName(), new CharacterEscapeHandler() {
            @Override
            public void escape(char[] ac, int i, int j, boolean flag, Writer writer) throws IOException {
                writer.write(ac, i, j);
            }
        });
        StringWriter writer = new StringWriter();
        jaxbMarshaller.marshal(obj, writer);
        return writer.toString();
    }


}
