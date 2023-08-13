package AlgoLesson2;

public class HomeWork2 {
    public static void main(String[] args) {
        int arr[] = new int[]{1,5,4,6,3,2,1,7,8,5,4,1,2,3,6};
        System.out.println("Исходнфый массив: ");
        printArray(arr);
        sortHeap(arr);
        System.out.println("Отсортированный массив: ");
        printArray(arr);
    }

    private static void makeHeap(int[] array, int heapSize, int rootIndex){
        int max = rootIndex;
        int leftCh = 2 * rootIndex +1;
        int rightCh = 2 * rootIndex + 2;

        if (leftCh < heapSize && array[leftCh] > array[max]){
            max = leftCh;
        }
        if (rightCh < heapSize && array[rightCh] > array[max]){
            max = rightCh;
        }
        if (max != rootIndex){
            int temp = array[rootIndex];
            array[rootIndex] = array[max];
            array[max] = temp;

            makeHeap(array, heapSize, max);
        }
    }

    public static void sortHeap(int[] array){
        for (int i = array.length / 2 - 1; i >= 0; i--){
            makeHeap(array, array.length, i);
        }
        for (int i = array.length - 1; i >= 0; i--){
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            makeHeap(array,i,0);
        }
    }

    static void printArray(int array[]) {
        for (int i = 0; i < array.length; ++i) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
