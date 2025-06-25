package fruits;

public class Main {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        appleBox.putFruitInBox(new Apple(1.0f));
        appleBox.putFruitInBox(new Apple(1.0f));
        appleBox.putFruitInBox(new Apple(1.0f));
        System.out.println("appleBoxWeight = " + appleBox.getWeight());

        Box<Apple> secondAppleBox = new Box<>();
        System.out.println("secondAppleBoxWeight = " + secondAppleBox.getWeight());
        appleBox.changeBox(secondAppleBox);
        System.out.println("appleBoxWeight = " + appleBox.getWeight());
        System.out.println("secondAppleBoxWeight = " + secondAppleBox.getWeight());


        Box<Orange> orangeBox = new Box<>();
        orangeBox.putFruitInBox(new Orange(1.5f));
        orangeBox.putFruitInBox(new Orange(1.5f));

//        System.out.println(appleBox.getWeight());
//        System.out.println(appleBox.compare(orangeBox));
    }
}
