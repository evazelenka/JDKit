package sem4.ex01;

import java.util.*;

public class Names {
    public static void sortByAlphabet(List<String> list){
        Collections.sort(list);
    }

    public static void sortByLength(List<String> list){
        list.sort(Comparator.comparing(String::length));
    }

    public static void reverseList(List<String> list){
        Collections.reverse(list);
    }

    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("Eva", "Dima","Aleksander", "Nikita", "Irina"));
        System.out.println(names);
        sortByAlphabet(names);
        System.out.println(names);
        sortByLength(names);
        System.out.println(names);
        reverseList(names);
        System.out.println(names);
    }

}
