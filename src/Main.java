import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        long[] longs = randomArr(100);
        System.out.println(Arrays.toString(longs));
        ArraySortUtil.heapSort(longs);
        System.out.println(Arrays.toString(longs));

        ArraySortUtil.shuttleSort(longs);
        System.out.println(Arrays.toString(longs));
    }

    /**
     * Random
     * @param sizeArr
     * @return
     */
    public static long[] randomArr (int sizeArr) {
        long[] arr = new long[sizeArr];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100 + 1);
        }
        return arr;
    }
}
