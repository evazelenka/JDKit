package sem3.homework;
//Напишите обобщенный метод compareArrays(), который принимает два массива и
// возвращает true, если они одинаковые, и false в противном случае. Массивы могут
// быть любого типа данных, но должны иметь одинаковую длину и содержать элементы
// одного типа по парно по индексам.



public class ArraysComparator {

    public static <T> boolean compareArrays(T[] array, T[] array2){
        if(array.length != array2.length){
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            if(!array[i].getClass().equals(array2[i].getClass())){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] str = new String[]{"18", "15", "14"};
        String[] str2 = new String[]{"18", "15", "14"};
        String[] str3 = new String[]{"18", "15", "14", null};

        System.out.println(ArraysComparator.compareArrays(str, str2));
        System.out.println(ArraysComparator.compareArrays(str, str3));
    }
}
