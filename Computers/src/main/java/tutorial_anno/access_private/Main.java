package tutorial_anno.access_private;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        PrivateObject privateObject = new PrivateObject("The Private Value", 17);

        Field privateStringField = PrivateObject.class.getDeclaredField("privateString");

        privateStringField.setAccessible(true);

        String fieldValue = (String) privateStringField.get(privateObject);
        System.out.println("fieldValue = " + fieldValue);
    }
}
