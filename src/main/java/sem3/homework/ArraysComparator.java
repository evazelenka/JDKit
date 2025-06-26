package sem3.homework;

public class ArraysComparator {

    public static <T> boolean compareArrays(T[] array, T[] array2){
        if(array.length != array2.length){
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            if(!array[i].equals(array2[i])){
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
