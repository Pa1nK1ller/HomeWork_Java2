package HW3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task2 {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Васильев", "2233456");
        phoneBook.add("Дмитриев", "5435720");
        phoneBook.add("Гусев", "524321");
        phoneBook.add("Пупкин", "123455564");
        phoneBook.add("Запупкин", "12112244");
        phoneBook.add("Лосев", "525431240");
        phoneBook.add("Васильев", "112245554");
        phoneBook.add("Конев", "23148762");
        phoneBook.add("Федоров", "54442213");
        phoneBook.add("Лосев", "11122244556");


        System.out.println(phoneBook.get("Васильев"));
        System.out.println(phoneBook.get("Дмитриев"));
        System.out.println(phoneBook.get("Гусев"));
        System.out.println(phoneBook.get("Пупкин"));
        System.out.println(phoneBook.get("Запупкин"));
        System.out.println(phoneBook.get("Лосев"));
        System.out.println(phoneBook.get("Конев"));
        System.out.println(phoneBook.get("Федоров"));

    }
}

class PhoneBook {

    private Map<String, List<String>> phoneBook_hm = new HashMap<>();
    private List<String> phone_number_list;

    public void add(String surname, String phone_number) {
        if (phoneBook_hm.containsKey(surname)) {
            phone_number_list = phoneBook_hm.get(surname);
        } else {
            phone_number_list = new ArrayList<>();
        }
        phone_number_list.add(phone_number);
        phoneBook_hm.put(surname, phone_number_list);
    }

    public List<String> get(String surname) {
        return phoneBook_hm.get(surname);
    }

}
