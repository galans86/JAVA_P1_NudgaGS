
//Реализовать алгоритм сортировки слиянием

public class Lesson3 {
    public static void main(String[] args) {
        int[] testMerge = new int[] { 9, 8, 4, 3 , 0, 1};
        int[] result = sortArray(testMerge);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static int[] sortArray(int[] arrayR) {
        if (arrayR == null) {
            return null;
        }

        if (arrayR.length < 2) {
            return arrayR;
        }
        // копируем левую часть от начала до середины
        int[] arrayL = new int[arrayR.length / 2];
        System.arraycopy(arrayR, 0, arrayL, 0, arrayR.length / 2);

        // копируем правую часть от середины до конца массива
        int[] arrayM = new int[arrayR.length - arrayR.length / 2];
        System.arraycopy(arrayR, arrayR.length / 2, arrayM, 0, arrayR.length - arrayR.length / 2);

        // рекурсия крутится до тех пор, пока не дойдет до 1 элемента в массиве,
        arrayL = sortArray(arrayL); 
        arrayM = sortArray(arrayM); 

        // далее опять рекурсия возврата слияния двух отсортированных массивов
        return mergeArray(arrayL, arrayM);
    }

    public static int[] mergeArray(int[] arrayL, int[] arrayR) {

        int[] arrayMerge = new int[arrayL.length + arrayR.length];
        int positionA = 0, positionB = 0;

        for (int i = 0; i < arrayMerge.length; i++) {
            if (positionA > arrayL.length - 1) {
                arrayMerge[i] = arrayR[positionB];
                positionB++;
            } else if (positionB > arrayR.length - 1) {
                arrayMerge[i] = arrayL[positionA];
                positionA++;
            } else if (arrayL[positionA] < arrayR[positionB]) {
                arrayMerge[i] = arrayL[positionA];
                positionA++;
            } else {
                arrayMerge[i] = arrayR[positionB];
                positionB++;
            }
        }
        return arrayMerge;
    }
  
}