package hometask2.t07;

public class Main {
    public static void main(String[] args) {
        try {
            Class c1 = Class.forName("hometask2.t06.NuclearSubmarine");
            if (!c1.isAnnotationPresent(Weapon.class))
                System.out.println("Annotation not found");
            else
                System.out.println("Class annotated with " + c1.getAnnotation(Weapon.class));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
