package book.javaspecialtroops.propertydescriptor;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;

/**
 * PropertyDescriptor usage.
 * @author phideon
 *
 */
public class PropertyDescriptorExample {

    public static void main(String[] args) throws IntrospectionException {
        Field[] fields = Node.class.getDeclaredFields();

        for (Field field : fields) {
            System.out.println("========>" + field.getName() + "\t" + field.getType());
            PropertyDescriptor pd = new PropertyDescriptor(field.getName(), Node.class);
            printDesc(pd);
        }
    }

    private static void printDesc(PropertyDescriptor pd) {
        System.out.println(pd.getDisplayName());
        System.out.println(pd.getShortDescription());
        System.out.println(pd.getPropertyEditorClass());
        System.out.println(pd.getPropertyType());
        System.out.println(pd.getReadMethod());
        System.out.println(pd.getWriteMethod());
    }
}
