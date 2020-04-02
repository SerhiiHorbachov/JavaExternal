package tutorial_anno;

import java.lang.annotation.*;

public class Application {
    public static void main(String[] args) {
        NokiaASeries obj = new NokiaASeries("Fire", 5);
        obj.toString();

        Class cl = obj.getClass();
        Annotation an = cl.getAnnotation(SmartPhone.class);
        SmartPhone s = (SmartPhone) an;
        System.out.println(s.OS());
    }
}

@SmartPhone(OS = "Android", version = 2)
class NokiaASeries {
    String model;
    int size;

    public NokiaASeries(String model, int size) {
        this.model = model;
        this.size = size;
    }

    @Override
    public String toString() {
        return "NokiaASeries{" +
                "model='" + model + '\'' +
                ", size=" + size +
                '}';
    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface SmartPhone {
    String OS() default "Symbian";

    int version() default 1;
}