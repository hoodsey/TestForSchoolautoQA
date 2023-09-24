import java.util.Random;
import java.util.*;
import java.util.Iterator;
import java.util.stream.IntStream;
import java.util.Collections;

public class Main {
    /*функция создания и соритровки массива по алгоритму
    входные данные : n - натуральное число для генерации массивов
    выходгые данные: resultArr = отсортированный массив с масиванми
    */
    public static int[][] AlgorithmArray(int n) {
        int maxSize = 10; // максимальное количество эл-тов в массив
        Random random = new Random();
        IntStream generateSizeArr = random.ints(1, maxSize).distinct().limit(n);  // запись в поток уникальных размеров массивов в диапазон с 1 до maxSize
        Iterator<Integer> iteratorArr = generateSizeArr.iterator(); // преобразование в Iterator для перебора по массиву размеров

        int indexItr = 0; // индекс элемента
        int[][] resultArr = new int[n][]; // инициализация двумерного массива

        while (iteratorArr.hasNext()) { // перебор по элементам каждого массива
            IntStream generateArr = random.ints().distinct().limit(iteratorArr.next()).sorted();  // создание уникальных размеров массивов в диапазон с 1 до 10 и их сортировка по возврастанию
            int[] arr = generateArr.toArray(); // преобразование в тип int
            if (indexItr % 2 == 1) { // условие сортировки по убыванию
                arr = Arrays.stream(arr).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray(); // сортировка по убыванию  для чётных массивов
            }
            resultArr[indexItr] = arr; // запись в итоговый массив
            indexItr = indexItr + 1;
        }
        return resultArr;
    }

    public static void main(String[] args) {
        int n = 10; //  n = натуральное число, количество массивов
        int[][] result = AlgorithmArray(n); // вызов функции алгоритма

        // вывод в консоль результат вызова функции
        System.out.println("Результат работы алгоритма:");
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}