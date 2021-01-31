package HW3;

import java.util.HashMap;
import java.util.Map;

public class Task1 {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();
        String[] words = {
                "зима", "лыжи", "коньки",
                "сноуборд", "лед", "дождь",
                "снежинки", "снеговик", "снегурочка",
                "дедмороз", "посох", "мешок",
                "подарки", "палки", "снеговик",
                "зима", "шарф", "шапка"};
        for (int i = 0; i < words.length; i++) {
            if (hashMap.containsKey(words[i]))
                hashMap.put(words[i], hashMap.get(words[i] + 1));
            else
                hashMap.put(words[i], 1);
        }

        System.out.println(hashMap);
    }
}
