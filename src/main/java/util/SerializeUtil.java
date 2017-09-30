package util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Formatter;

public class SerializeUtil {
    /**
     * 序列化
     *
     * @param object object
     * @return byte[]
     */
    public static byte[] serialize(Object object) {
        if (object == null) {
            return null;
        }

        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        try {

            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 反序列化
     *
     * @param bytes bytes
     * @return Object
     */
    public static Object unserialize(byte[] bytes) {
        if (bytes == null) {
            return null;
        }

        ByteArrayInputStream bais = null;
        try {
            bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 友好的Bytes显示
     * ascii在 32 - 126 的，显示ascii字符，其余的显示\x(byte).
     * 这个输出和redis-cli一致~~~~
     *
     * @param bytes jedis bytes结果
     * @return String
     */
    public static String bytesToHex(final byte[] bytes) {
        Formatter formatter = new Formatter();
        for (byte b : bytes) {
            if (b > 31 && b < 127) {
                formatter.format("%s", (char) b);
            } else {
                formatter.format("\\x%02x", b);
            }
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }
}
