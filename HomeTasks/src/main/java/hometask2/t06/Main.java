package hometask2.t06;

public class Main {

    public static void main(String[] args) {
        NuclearSubmarine project955 = new NuclearSubmarine(new NuclearSubmarine.NuclearSubmarineReactor("Водо-водяной"),
                NuclearSubmarine.SubmarineClass.Ballistic_missile);
        project955.swim();
    }
}
