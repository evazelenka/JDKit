package sem4.ex02;

import java.util.*;

public class Names {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(
                Arrays.asList("Dima","Aleksander","Igor", "Kirill", "Eva", "Nikita", "Eva", "Irina"));
        Set<String> set = convertListToSet(names);
        System.out.println(set);
        System.out.println(minLength(set));
        System.out.println(maxLength(set));
        System.out.println(minAlphabet(set));
        removeByChar(set, "A");
        System.out.println(set);
    }

    public static Set<String> convertListToSet(List<String> list){
        return new HashSet<>(list);
    }

    public static String minAlphabet(Set<String> set){
        return set.stream().min(Comparator.naturalOrder()).orElse(null);
    }

    public static String minLength(Set<String> set){
        return set.stream().min(Comparator.comparing(String::length)).orElse(null);
    }

    public static String maxLength(Set<String> set){
        return set.stream().max(Comparator.comparing(String::length)).orElse(null);
    }

    public static void removeByChar(Set<String> setString, String a){
        setString.removeIf(s -> s.contains(a));
    }

    public static List<String> minAndMaxLengthNames(Set<String> names){
        List<String> result = new ArrayList<>();
        result.add(minLength(names));
        result.add(maxLength(names));
        return result;
    }
}
