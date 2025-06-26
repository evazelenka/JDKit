package fruits;

public class Main {
    private static void swap(Object[] arr, int from, int to){
        Object temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }

    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        appleBox.putFruitInBox(new Apple());
        appleBox.putFruitInBox(new Apple());
        appleBox.putFruitInBox(new Apple());
        System.out.println("appleBoxWeight = " + appleBox.getWeight());

        Box<Apple> secondAppleBox = new Box<>();
        System.out.println("secondAppleBoxWeight = " + secondAppleBox.getWeight());
        appleBox.changeBox(secondAppleBox);
        System.out.println("appleBoxWeight = " + appleBox.getWeight());
        System.out.println("secondAppleBoxWeight = " + secondAppleBox.getWeight());


        Box<Orange> orangeBox = new Box<>();
        orangeBox.putFruitInBox(new Orange());
        orangeBox.putFruitInBox(new Orange());

//        System.out.println(appleBox.getWeight());
        System.out.println(appleBox.compare(secondAppleBox));
    }
}
