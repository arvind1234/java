import com.livingthings.Human;
import com.livingthings.LivingThings;

public class Inheritance {

    public static void main(String[] args) {
        Human h1 = new Human("Arvind");
        System.out.println(h1.name1);
        Human h2 = new Human("Nithya");
        System.out.println(h1.name1);

        System.out.println(h1.getName() + " " + LivingThings.name1);
        System.out.println(h2.getName() + " " + LivingThings.name1);
        LivingThings.name1 = "xwyx";

        h1.breathe();

    }

}
