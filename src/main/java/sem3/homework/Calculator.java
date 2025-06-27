package sem3.homework;
//Написать класс Калькулятор (необобщенный), который содержит
// обобщенные статические методы: sum(), multiply(), divide(),
// subtract(). Параметры этих методов – два числа разного типа, над
// которыми должна быть произведена операция. Методы должны
// возвращать результат своей работы.

public class Calculator {
    public static <T extends Number, V extends Number> Number sum(T t, V v){
       return t.doubleValue() + v.doubleValue();
    }

    public static <T extends Number, V extends Number> Number multiply(T t, V v){
        return t.doubleValue() * v.doubleValue();
    }

    public static <T extends Number, V extends Number> Number divide(T t, V v){
        if (v.doubleValue() == 0){
            throw new ArithmeticException("деление на ноль не допустимо");
        }
        return t.doubleValue()/v.doubleValue();
    }

    public static <T extends Number, V extends Number> Number subtract(T t, V v){
        return t.doubleValue() - v.doubleValue();
    }

    public static void main(String[] args) {
        System.out.println(Calculator.sum(5, 1.0f));
        System.out.println(Calculator.multiply(5, 1.0f));
        System.out.println(Calculator.divide(5, 1.0f));
        System.out.println(Calculator.subtract(5, 1.0f));
    }
}
