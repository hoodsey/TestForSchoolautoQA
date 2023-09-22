import java.util.Random;
import java.util.List;
import java.util.Iterator;
import java.util.stream.IntStream;


public class Main {

    public static void Massive( int n) {
        int maxSize = 10;

        Random random = new Random();
        IntStream ds_count = random.ints(1, maxSize).distinct().limit(n);  // создание уникальных размеров массивов в диапазон с 1 до 10
        // ds_count.forEach( );
        // int[] intArray = ds_count.toArray();

        System.out.println("Stream ds_count:");
        Iterator<Integer> it1 = ds_count.iterator();
        int k = 0; //
        while (it1.hasNext()) { // перебор по потоку из n массивов
            IntStream ds = random.ints().distinct().limit(it1.next());  // создание уникальных размеров массивов в диапазон с 1 до 10
            Iterator<Integer> it2 = ds.iterator();
            System.out.println("Маcсив " + k);

            while (it2.hasNext()) {
                // List<Integer> intArray = ds.toArray();

                System.out.println(it2.next());

            }
            System.out.println("");
            k=k+1;


        }
    }

    public static void main(String[] args) {
        int n = 5;
        Massive(n);
    }


}