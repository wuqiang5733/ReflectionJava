import java.lang.reflect.Field;

/**
 * Created by WuQiang on 2016/12/2.
 */
public class Main {
    public static void main(String[] args) {

                     /*
                If you are using something that is inherited, replace...

                getDeclaredField -> getField
                getDeclaredMethod -> getMethod
                 */

        Person p = new Person("Pogo");

        // System.out.println(p.name); // Error, not accessible.

        try {
            Field field = p.getClass().getDeclaredField("name");
            field.setAccessible(true);
            System.out.println(field.get(p));
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }


}
