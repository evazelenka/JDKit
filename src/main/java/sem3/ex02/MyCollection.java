package sem3.ex02;

import java.util.Arrays;

public class MyCollection<T> {
    private Object[] array;
    private int size = 0;

    public MyCollection(int length) {
        this.array = new Object[length];
    }

    public void add(T t){
        if(size >= array.length){
            Object[] arr = Arrays.copyOf(array, array.length * 2);
            array = arr;
        }
        this.array[size++] = t;
    }

    public void remove(T t){
        for (int i = 0; i < size; i++) {
            if (array[i].equals(t)) {
                for (int j = i; j < size - 1; j++) {
                    array[j] = array[j+1];
                }
                array[size -1] = null;
                break;
            }
        }
    }

    public void remove(int index){
        for (int j = index; j < size - 1; j++) {
            array[j] = array[j+1];
        }
        array[size -1] = null;
    }
}
