package fruits;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private final ArrayList<T> fruits;
    private static final float BOX_WEIGHT = 10.0f;

    Box(){
        fruits = new ArrayList<>();
    }

    public float getWeight(){
        if(fruits.isEmpty()){
            return BOX_WEIGHT;
        }else return getFruitWeight() * fruits.size() + BOX_WEIGHT;
    }

    private float getFruitWeight(){
        return fruits.get(0).getWeight();
    }

    public void putFruitInBox(T t){
        fruits.add(t);
    }

    public boolean compare(Box<?> box){
        return this.getWeight() == box.getWeight();
    }

    public void changeBox(Box<? super T> box){
       box.fruits.addAll(fruits);
       this.fruits.clear();
    }
}
