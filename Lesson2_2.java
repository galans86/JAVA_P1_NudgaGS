
import java.util.Arrays;
import java.util.logging.FileHandler;
// import java.util.logging.Level;
import java.util.logging.Logger;
// import java.util.logging.SimpleFormatter;
import java.util.logging.XMLFormatter;

//Реализуйте алгоритм сортировки пузырьком числового массива, 
//результат после каждой итерации запишите в лог-файл.
public class Lesson2_2 {
    public static void main(String[] args) {
        int[] mas = { 11, 3, 14, 16, 7 };
        try {
            Logger logger = Logger.getLogger(Lesson2_2.class.getName());
            FileHandler fh = new FileHandler("log2_2.xml");
            logger.addHandler(fh);
            //SimpleFormatter sFormat = new SimpleFormatter();
            XMLFormatter xFormat = new XMLFormatter();
            //fh.setFormatter(sFormat);
            fh.setFormatter(xFormat);

            boolean isSorted = false;
            int buf;
            while (!isSorted) {
                isSorted = true;
                for (int i = 0; i < mas.length - 1; i++) {
                    if (mas[i] > mas[i + 1]) {
                        isSorted = false;

                        buf = mas[i];
                        mas[i] = mas[i + 1];
                        mas[i + 1] = buf;
                    }
                }
                logger.info( Arrays.toString(mas));
            }

        } catch (Exception e) {
            System.err.println("Error write log file");
        }
    }
}
