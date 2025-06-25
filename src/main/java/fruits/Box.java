package fruits;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> fruits = new ArrayList<>();
    private static final float BOX_WEIGHT = 10.0f;

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

    public <O extends Fruit> boolean compare(Box<O> box){
        return this.getWeight() == box.getWeight();
    }

    public void changeBox(Box<T> box){
       while (!fruits.isEmpty()){
           box.putFruitInBox(fruits.get(0));
           fruits.remove(0);
       }
    }
}
