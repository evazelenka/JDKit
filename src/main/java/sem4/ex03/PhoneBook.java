package sem4.ex03;

import java.util.*;
import java.util.stream.Collectors;

public class PhoneBook {

    public static void main(String[] args) {
        Map<String, String> phoneBook = new HashMap<>();
        phoneBook.put("123456", "ilya");
        phoneBook.put("1234567", "vitya");
        phoneBook.put("1234568", "dima");
        phoneBook.put("12345699", "nikita");
        phoneBook.put("123456432", "olga");
        phoneBook.put("12345612", "masha");
        phoneBook.put("123", "nika");

        System.out.println(findByMinPhoneNumber(phoneBook));
        System.out.println(findMaxAlphabetName(phoneBook));

    }

    public static String findByMinPhoneNumber(Map<String, String> phonebook){
        Set<Long> numbers = phonebook.keySet().stream().map(Long::valueOf).collect(Collectors.toSet());
        long num = numbers.stream().min(Comparator.naturalOrder()).get();
        return String.format("min number: %s, owner: %s", num, phonebook.get(String.valueOf(num)));
    }

    public static String findMaxAlphabetName(Map<String, String> pb){
        Set<Map.Entry<String, String>> set = pb.entrySet();
        Map.Entry<String, String> name = set.stream().max((e1, e2) -> e1.getValue().compareTo(e2.getValue())).get();
        return String.format("max name: %s, number: %s", name.getValue(), name.getKey());
    }
}
