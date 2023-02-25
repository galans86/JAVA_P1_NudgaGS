
/*
 * Дана строка sql-запроса "select * from students where ".
 * Сформируйте часть WHERE этого запроса, используя StringBuilder.
 * Если значение null, то параметр не должен попадать в запрос.
 * Параметры для фильтрации: {"name":"Ivanov", "country":"Russia","city":"Moscow", "age":"null"}
 */

//import java.util.Scanner;

public class Lesson2_1 {

    public static void main(String[] args) {
        String sql = "select * from students where ";
        StringBuilder json = new StringBuilder(getJson());
        StringBuilder where = new StringBuilder("");
        StringBuilder str = new StringBuilder("");
        String line = "";
        char ch = ' ';
        for (int i = 1; i < json.length() - 1; i++) {
            ch = json.charAt(i);
            switch (ch) {
                case '\"':
                case ' ':
                    break;
                case ':':
                    line = json.subSequence(i + 2, i + 6).toString();
                    if (line.equals("null")) {
                        str.delete(0, str.length());
                        i = i + 7;
                    } else
                        str.append(" = '");
                    break;
                case ',':
                    where.append(str + "'");
                    str.delete(0, str.length());
                    str.append(" and ");
                    break;
                default:
                    str.append(ch);
            }
        }
        if (str.toString().isEmpty()) 
            sql = sql + where.toString() + ";";
        else
            sql = sql + where.toString() + " and " + str + "';";

        System.out.println('\n' + sql + '\n');
    }

    public static String getJson() {
        // Scanner iScanner = new Scanner(System.in);
        // System.out.printf("Введите строку: ");
        // String json = iScanner.nextLine();
        // iScanner.close();

        String json = "{\"name\":\"Ivanov\", \"country\":\"Russia\",\"city\":\"Moscow\", \"age\":\"null\"}";
        return json;
    }
}
