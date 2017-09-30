package TestDemo1;

import model.User;
import redis.clients.jedis.Jedis;
import util.SerializeUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 */
public class App {
    private Jedis jedis;

    public void testAA(){
        System.out.println("testA");
    }
    public static void main(String[] args) {
        //        List<String> testList = new ArrayList<String>();
        Jedis jedis = new Jedis("localhost");
        User user1 = new User(1, "xiaoming", "24");
        User user2 = new User(2, "xiaohong", "24");
        List<Map> testList = new ArrayList<Map>();
        //        List<String> testList = new ArrayList<String>();
        Map<String, Object> testMap1 = new HashMap<String, Object>();
        Map<String, Object> testMap2 = new HashMap<String, Object>();
        testMap1.put("id", user1.getId());
        testMap1.put("name", user1.getName());
        testMap1.put("sex", user1.getSex());
        testMap2.put("id", user2.getId());
        testMap2.put("name", user2.getName());
        testMap2.put("sex", user2.getSex());
        testList.add(testMap1);
        //        List<String> testList = new ArrayList<String>();
        testList.add(testMap2);
        jedis.set("my1".getBytes(), SerializeUtil.serialize(testList));
        System.out.println(SerializeUtil.unserialize(jedis.get("my1".getBytes())));
    }
}
