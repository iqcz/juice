package crazy;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ObjectPoolFactory {

    // 定义一个对象池，key 是对象名，value 是实际对象
    private Map<String, Object> objectPool = new HashMap<>();

    /**
     * 创建对象
     *
     * @param className 字符串类名
     * @return 该类名所指定的 Java 对象
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    private Object createObject(String className)
            throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> clazz = Class.forName(className);

        return clazz.newInstance();
    } // end method createObject

    /**
     * 加载配置文件，根据配置文件中的信息生成对应的对象。
     *
     * @param fileName
     */
    public void initPool(String fileName) {
        try (FileInputStream fis = new FileInputStream(fileName)) {
            Properties props = new Properties();
            props.load(fis);

            for (String name : props.stringPropertyNames()) {
                objectPool.put(name, createObject(props.getProperty(name)));
            }
        } catch (ClassNotFoundException | IOException | InstantiationException
                | IllegalAccessException e) {
            e.printStackTrace();
        }
    } // end method initPool

    /**
     *
     * @param className 字符串类名
     * @return 具体的对象
     */
    public Object getObject(String className) {
        return objectPool.get(className);
    } // end method getObject

    public static void main(String[] args) {
        ObjectPoolFactory factory = new ObjectPoolFactory();
        factory.initPool("obj.txt");

        System.out.println(factory.getObject("a"));
    }

}
