package sem3.ex01;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.DataInput;
import java.io.InputStream;

@Getter
@AllArgsConstructor
public class BigClass<T extends Comparable<T>, V extends InputStream & DataInput, K extends Number> {
    private T t;
    private V v;
    private K k;

    public void getClassName(){
        System.out.println(t.getClass().getName());
        System.out.println(v.getClass().getName());
        System.out.println(k.getClass().getName());
    }
}
