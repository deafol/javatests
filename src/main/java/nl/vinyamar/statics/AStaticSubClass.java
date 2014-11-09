package nl.vinyamar.statics;

/**
 * Created by Milan on 25-4-2014.
 */
public class AStaticSubClass  extends AStaticClass {

    static void aStaticMethod(){
        System.out.println("aStaticMethod in SubClass");
    }

    public static void main(String[] args) {
        AStaticSubClass.aStaticMethod();
    }

}
