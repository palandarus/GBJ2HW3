import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
    //39 names
    static String names = "Мечеслав  Милан Мирон Мирослав Михаил Мичлов Модест Моисей Мурат Муслим Назар Назарий Натан Наум Никита Никифор Николай Никон Нисон Нифонт Олан Олег Олесь Онисим Орест Осип Оскар Павел Парамон Петр Платон Порфирий Прохор Равиль Радий (Радик) Радомир Раис Раймонд";
    //51 lnames
    static String lnames = "АВРАМОВ АВРАМЧИК АВРАСИН АВРАШИН АВРАШКОВ АВРЕЛИН АВРОРИН АВРОРОВ АВРОСИМОВ АВРОСИНОВ АВСЕЕВ АВСЕЕНКО АВСЕЙКИН АВСЮКОВ АВТАЙКИН ПАЛАМАРЧУК ПАЛАМОНОВ ПАЛАШИН ПАЛАШОВ ПАЛЕЕВ ПАЛЕЙ ПАЛЕМОНОВ ПАЛЕНОВ ПАЛЕЧЕК ПАЛИВОДА ПАЛИВОДОВ ПАЛИЙ ПАЛИМПСЕСТОВ ПАЛИН ПАЛИНОВ ПАЛИЧЕВ ПАЛКИН ПАЛЛАДИН ПАЛУХИН ПАЛЫВОДА ПАЛЬГИН ПАЛЬГОВ ПАЛЬГУЕВ ПАЛЬГУНОВ УРАЛОВ УРАЛЬСКИЙ УРАЛЬСКИХ УРАНИЕВ УРАНОВ УРАНОСОВ УРБАНОВ УРБАНОВИЧ УРБАНСКИЙ УРВАНИН УРВАНОВ УРВАНЦЕВ";

    public static void main(String[] args) throws IOException {
        System.out.println(parse(text));

        PhoneBook book = new PhoneBook(genArrayListPerson(80));
        book.print();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputText = "";
        while (!inputText.toLowerCase().equals("exit")) {
            System.out.println("Введите фамилию для поиска, для выхода введите exit");
            inputText = reader.readLine().toString().toLowerCase();
            System.out.println("Нашлись телефоны:");
            System.out.println(book.searchPhone(inputText).toString());
            System.out.println("Нашлись emails:");
            System.out.println(book.searchEmail(inputText).toString());
        }
    }


    private static ArrayList<Person> genArrayListPerson(int size) {
        String[] nameVacabulary = names.split(" ");
        String[] lnameVacabulary = lnames.split(" ");
        ArrayList<Person> generated = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            generated.add(new Person(nameVacabulary[(int) (Math.random() * 39)].toLowerCase(), lnameVacabulary[(int) (Math.random() * 51)].toLowerCase()));
        }
        return generated;
    }

    private static HashMap<String, Integer> parse(String text) {
        HashMap<String, Integer> map = new HashMap<>();     // ключ - слово, значение - число повторений в тексте
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
