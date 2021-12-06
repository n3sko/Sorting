public final class ArraySortUtil {

    private ArraySortUtil() {
    }

    /**
     * Сортировка пузырьком
     * @param array the array to be sorted
     */
    public static void bubbleSort(long[] array) {
        boolean flagIsSorted = false;
        long buf;
        while (!flagIsSorted) {
            flagIsSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    flagIsSorted = false;
                    buf = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = buf;
                }
            }
        }
    }

    /**
     * Сортировка вставками
     * @param array the array to be sorted
     */
    public static void insertsSort(long[] array) {
        for (int i = 1; i < array.length; i++) {
            long current = array[i];
            int j = i - 1;
            while (j >= 0 && current < array[j]) {
                array[j + 1] = array[j];
                j--;
                array[j + 1] = current;
            }
        }
    }

    /**
     * Сортировка выбором
     * @param array the array to be sorted
     */
    public static void selectionSort(long[] array) {
        for (int i = 0; i < array.length; i++) {
            long min = array[i];
            int minId = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    minId = j;
                }
            }
            long buf = array[i];
            array[i] = min;
            array[minId] = buf;
        }
    }

    /**
     * Челночная сортировка
     * @param array the array to be sorted
     */
    public static void shuttleSort (long[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
//                long buf = array[i];
//                array[i] = array[i - 1];
//                array[i - 1] = buf;
                swap(array, i, i - 1);
                for (int z = i - 1; (z - 1) >= 0; z--) {
                    if (array[z] < array[z - 1]) {
//                        buf = array[z];
//                        array[z] = array[z - 1];
//                        array[z - 1] = buf;
                        swap(array, z, z - 1);
                    } else {
                        break;
                    }
                }
            }
        }
    }

//    /**
//     * Сортировка слиянием
//     * @param array the array to be sorted
//     */
//    public static int[] mergeSort(int[] array) {
//        int[] buf;
//        int[] currentSrc = array;
//        int[] currentDest = new int[array.length];
//
//        int size = 1;
//        while (size < array.length) {
//            for (int i = 0; i < array.length; i += 2 * size) {
//                merge(currentSrc, i, currentSrc, i + size, currentDest, i, size);
//            }
//
//            buf = currentSrc;
//            currentSrc = currentDest;
//            currentDest = buf;
//
//            size = size * 2;
//        }
//        return currentSrc;
//    }
//
//    private static void merge(int[] src1, int src1Start, int[] src2, int src2Start, int[] dest,
//                              int destStart, int size) {
//        int index1 = src1Start;
//        int index2 = src2Start;
//
//        int src1End = Math.min(src1Start + size, src1.length);
//        int src2End = Math.min(src2Start + size, src2.length);
//
//        if (src1Start + size > src1.length) {
//            for (int i = src1Start; i < src1End; i++) {
//                dest[i] = src1[i];
//            }
//            return;
//        }
//
//        int iterationCount = src1End - src1Start + src2End - src2Start;
//
//        for (int i = destStart; i < destStart + iterationCount; i++) {
//            if (index1 < src1End && (index2 >= src2End || src1[index1] < src2[index2])) {
//                dest[i] = src1[index1];
//                index1++;
//            } else {
//                dest[i] = src2[index2];
//                index2++;
//            }
//        }
//    }

     /** Быстрая сортировка
     * @param array the array to be sorted
     * @param from first index
     * @param to last index
     */
    public static void quickSort(long[] array, int from, int to) {

        if (from < to) {

            int divideIndex = partition(array, from, to);

            quickSort(array, from, divideIndex - 1);

            quickSort(array, divideIndex, to);
        }
    }

    private static int partition(long[] array, int from, int to) {
        int leftIndex = from;
        int rightIndex = to;

        long pivot = array[from + (to - from) / 2];
        while (leftIndex <= rightIndex) {

            while (array[leftIndex] < pivot) {
                leftIndex++;
            }

            while (array[rightIndex] > pivot) {
                rightIndex--;
            }

            if (leftIndex <= rightIndex) {
                swap(array, rightIndex, leftIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }

    private static void swap(long[] array, int index1, int index2) {
        long buf  = array[index1];
        array[index1] = array[index2];
        array[index2] = buf;
    }

    /**
     * Пирамидальная сортировка
     * @param array the array to be sorted
     */
    public static void heapSort(long[] array) {
        if (array.length == 0) return;

        int length = array.length;

        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(array, length, i);
        }

        for (int i = length - 1; i >= 0 ; i--) {
            long buf = array[0];
            array[0] = array[i];
            array[i] = buf;
            heapify(array, i, 0);
        }
    }

    private static void heapify(long[] array, int length, int i) {
        int leftChildInx = 2 * i + 1;
        int rightChildIInx = 2 * i + 2;
        int largestInx = i;

        // если левый дочерний больше родительского
        if (leftChildInx < length && array[leftChildInx] > array[largestInx]) {
            largestInx = leftChildInx;
        }

        // если правый дочерний больше родительского
        if (rightChildIInx < length && array[rightChildIInx] > array[largestInx]) {
            largestInx = rightChildIInx;
        }

        // если должна произойти замена
        if (largestInx != i) {
            long buf = array[i];
            array[i] = array[largestInx];
            array[largestInx] = buf;
            heapify(array, length, largestInx);
        }
    }
}
