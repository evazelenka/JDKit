package sem3.homework;
//Напишите обобщенный класс Pair, который представляет собой пару значений разного
// типа. Класс должен иметь методы getFirst(), getSecond() для получения значений
// каждого из составляющих пары, а также переопределение метода toString(),
// возвращающее строковое представление пары.


public class Pair<K, V> {
    private K k;
    private V v;

    public Pair(K k, V v){
        this.k = k;
        this.v = v;
    }

    public K getFirst() {
        return k;
    }

    public V getSecond() {
        return v;
    }

    @Override
    public String toString() {
        return "first element: " + k.toString() + " second element: " + v.toString();
    }

    public static void main(String[] args) {
        Pair<Integer, String> pair = new Pair<>(3, "3");
        System.out.println(pair);
    }
}
