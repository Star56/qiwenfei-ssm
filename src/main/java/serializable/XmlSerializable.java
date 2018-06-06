package serializable;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * 2018/6/5
 * sunshine
 */
public class XmlSerializable implements ISerializable {

    XStream  xStream = new XStream(new DomDriver());
    @Override
    public <T> byte[] doserialize(T obj) throws Exception {
        return xStream.toXML(obj).getBytes();
    }

    @Override
    public <T> T deserialize(byte[] datas, Class<T> clazz) throws Exception {
        return (T)xStream.fromXML(new String(datas));
    }
}
