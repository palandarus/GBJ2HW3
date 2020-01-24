import java.util.HashMap;

/*
 1. Создать массив с набором слов (20-30 слов, должны встречаться повторяющиеся):
         - Найти список слов, из которых состоит текст (дубликаты не считать);
         - Посчитать сколько раз встречается каждое слово (использовать HashMap);
         2. Написать простой класс PhoneBook(внутри использовать HashMap):
         - В качестве ключа использовать фамилию
         - В каждой записи всего два поля: phone, e-mail
         - Отдельный метод для поиска номера телефона по фамилии (ввели фамилию, получили ArrayList телефонов), и отдельный метод для поиска e-mail по фамилии. Следует учесть, что под одной фамилией может быть несколько записей. Итого должно получиться 3 класса Main, PhoneBook, Person.
*/

public class Main {
    static String text = "Крошка сын к отцу пришёл, и спросила крошка: — Что такое тест хорошо и что такое плохо? — У меня секретов нет, — слушайте, детишки, — папа этот отвечал.\n" +
            "— Если ветер крыши рвёт, если град загрохал, — каждый знает — Тест это вот для тест прогулок плохо. А для папа хорошо\n";

    public static void main(String[] args) {
        System.out.println(parse(text));
    }

    private static HashMap<String, Integer> parse(String text) {
        HashMap<String, Integer> map = new HashMap<>();     // ключ - слово, значение - сило повторений в тексте
        String[] words = prepareString(text).split(" ");
        for (String word : words
        ) {
            word = word.toLowerCase();
            if (!word.equals("")) map.put(word.toLowerCase(), map.get(word) != null ? map.get(word) + 1 : 1);
        }

        return map;
    }

    private static String prepareString(String text) {
        text = text.replace("\n", " ");
        text = text.replace(",", "");
        text = text.replace(".", "");
        text = text.replace("-", "");
        text = text.replace("  ", "");
        text = text.replace(";", "");
        text = text.replace(":", "");
        text = text.replace("—", "");
        text = text.replace("?", "");
        text = text.replace("\t", "").trim();
        return text;
    }

}
