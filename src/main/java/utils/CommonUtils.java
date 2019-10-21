package utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class CommonUtils {

    public static String getEmail() {
        SimpleDateFormat sdf = new SimpleDateFormat("yy_dd_MM_HH_mm_ss");
        Date date = new Date();
        String email = "t" + sdf.format(date);
        email += "@test.com";

        return email;
    }

    public static String getPhone() {
        return String.format("74832%s", getRandomString("int", 6));
    }

    public static String getLogin() {
        return "test" + getRandomString("engint", 6);
    }

    public static String getRandomString(String stringType, int length) {
        char[] chars = null;
        StringBuilder result = new StringBuilder();

        switch (stringType.toLowerCase().trim()) {
            case "eng":
                chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
                break;
            case "engint":
                chars = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
                break;
            case "ru":
                chars = "абвгдеёжзийклмннопрстуфхцчшщъвьэюя".toCharArray();
                break;
            case "ruint":
                chars = "абвгдеёжзийклмннопрстуфхцчшщъвьэюя0123456789".toCharArray();
                break;
            case "int":
                chars = "0123456789".toCharArray();
                break;
            default:
                chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
                break;
        }

        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int i = 0; i < length; i++) {
            char c = chars[random.nextInt(chars.length)];
            result.append(c);
        }
        return result.toString();
    }

    public static String getValidFirstName() {
        return getValidFirstName(true);
    }

    public static String getValidFirstName(boolean man) {
        String[] firstNames;
        if (man)
            firstNames = new String[]{
                    "Виктор", "Петр", "Алексей", "Владимир", "Иван", "Евгений", "Михаил",
                    "Александр", "Сергей", "Дмитрий", "Андрей", "Максим"
            };
        else
            firstNames = new String[]{
                    "Елена", "Ольга", "Наталья", "Екатерина", "Анна", "Татьяна",
                    "Юлия", "Анастасия", "Ирина", "Мария", "Вера"
            };

        String result = firstNames[ThreadLocalRandom.current().nextInt(firstNames.length)];
        return result;
    }

    public static String getValidLastName() {
        return getValidLastName(true);
    }

    public static String getValidLastName(boolean man) {
        String[] lastNames = {
                "Иванов", "Смирнов", "Кузнецов", "Попов", "Васильев", "Петров", "Соколов", "Михайлов",
                "Новиков", "Федоров", "Морозов", "Волков", "Алексеев", "Лебедев", "Семенов", "Егоров",
                "Павлов", "Козлов", "Степанов", "Николаев", "Орлов", "Андреев", "Макаров", "Никитин", "Захаров",
                "Зайцев", "Соловьев", "Борисов", "Яковлев", "Григорьев", "Романов", "Воробьев", "Сергеев",
                "Кузьмин", "Фролов", "Александров", "Дмитриев", "Королев", "Гусев", "Киселев", "Ильин",
                "Максимов", "Поляков", "Сорокин", "Виноградов", "Ковалев", "Белов", "Медведев", "Антонов",
                "Тарасов", "Жуков", "Баранов", "Филиппов", "Комаров", "Давыдов", "Беляев", "Герасимов",
                "Богданов", "Осипов", "Сидоров", "Матвеев", "Титов", "Марков", "Миронов", "Крылов",
                "Куликов", "Карпов", "Власов", "Мельников", "Денисов", "Гаврилов", "Тихонов", "Казаков"
        };

        String result = lastNames[ThreadLocalRandom.current().nextInt(lastNames.length)];
        return man ? result : result + "а";
    }

    public static String getValidPatronymic() {
        return getValidPatronymic(true);
    }

    public static String getValidPatronymic(boolean man) {
        String[] patronymics;
        if (man)
            patronymics = new String[]{
                    "Петрович", "Иванович", "Алексеевич", "Денисович"
            };
        else patronymics = new String[]{
                "Петровна", "Ивановна", "Алексеевна", "Денисовна"
        };
        String result = patronymics[ThreadLocalRandom.current().nextInt(patronymics.length)];
        return result;
    }
}
