package club.gude.utils.xml;

import club.gude.entity.msg.in.*;
import club.gude.entity.msg.out.OutBaseMsg;
import com.google.common.base.Strings;
import com.sun.xml.internal.bind.marshaller.CharacterEscapeHandler;

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
     * jaxb xml转为对象
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
            if (msgType.equalsIgnoreCase("text")) {
                InTextMsg inTextMsg = (InTextMsg) jaxbStrToXml(InTextMsg.class, strXml);
                return inTextMsg;
            } else if (msgType.equalsIgnoreCase("image")) {
                InImageMsg inImageMsg = (InImageMsg) jaxbStrToXml(InImageMsg.class, strXml);

                return inImageMsg;

            } else if (msgType.equalsIgnoreCase("voice")) {
                InVoiceMsg inVoiceMsg = (InVoiceMsg) jaxbStrToXml(InVoiceMsg.class, strXml);

                return inVoiceMsg;

            } else if (msgType.equalsIgnoreCase("video") || msgType.equalsIgnoreCase("shortvideo")) {
                InVedioMsg inVedioMsg = (InVedioMsg) jaxbStrToXml(InVedioMsg.class, strXml);

                return inVedioMsg;

            } else if (msgType.equalsIgnoreCase("location")) {
                InLocationMsg inLocationMsg = (InLocationMsg) jaxbStrToXml(InLocationMsg.class, strXml);

                return inLocationMsg;

            } else if (msgType.equalsIgnoreCase("link")) {
                InLinkMsg inLinkMsg = (InLinkMsg) jaxbStrToXml(InLinkMsg.class, strXml);

                return inLinkMsg;
            }
            return null;
        }
    }

    public static Object jaxbStrToXml(Class clz, String strXml) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(clz);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return jaxbUnmarshaller.unmarshal(new StringReader(strXml));
    }

    /**
     * 对象转化为XML
     *
     * @param outBaseMsg
     * @return
     * @throws JAXBException
     */

    public static String xmlCreate_MsgOut(OutBaseMsg outBaseMsg) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(outBaseMsg.getClass(), OutBaseMsg.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        //是否输出头 True不输出 <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
        jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
        //格式化
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
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
}
