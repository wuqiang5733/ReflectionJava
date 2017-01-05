import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

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

        // System.out.println(Person.numPeople); // Error, not accessible.

        try {
            Field field = Person.class.getDeclaredField("numPeople");
            field.setAccessible(true);
            System.out.println(field.get(null)); // 因为是表态变量，所以不需要类名
        }

        catch (Exception e) {
            e.printStackTrace();
        }
        // 345678983578938975434898434589
        System.out.println(p.getName());

        try {
            Method method = p.getClass().getDeclaredMethod("getName");
            // 因为是 public 的，所以不需要 setAccessible
            System.out.println(method.invoke(p));
        }

        catch (Exception e) {
            e.printStackTrace();
        }

        p.setName("PogoStick29");
        System.out.println(p.getName());
        p.setName("Pogo");

        try {
            Method method = p.getClass().getDeclaredMethod("setName", String.class);
            method.invoke(p, "PogoStick30");
            System.out.println(p.getName());
        }

        catch (Exception e) {
            e.printStackTrace();
        }
                    /*
                ...
                 */

        Person.printPerson(p);

        try {
            Method method = Person.class.getDeclaredMethod("printPerson", Person.class);
            method.invoke(null, p);
        }

        catch (Exception e) {
            e.printStackTrace();
        }
                  /*
                ...
                 */

        Person other = new Person("Ogop");
        Person.printPerson(other);

        try {
            Constructor<Person> constructor = Person.class.getDeclaredConstructor(String.class);
            other = constructor.newInstance("Ogop2");
            Person.printPerson(other);
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }


}
