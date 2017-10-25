package hometask4.t03;

public class CharsetChangerDemo {

    public static void main(String[] args) {
        String source = "HomeTasks/src/main/java/hometask4/t03/Example.txt";
        String target = "HomeTasks/src/main/java/hometask4/t03/Target.txt";
        CharsetChanger charsetChanger = new CharsetChanger();
        charsetChanger.writeAsUTF16(charsetChanger.readAsUTF8(source), target);
    }
}
