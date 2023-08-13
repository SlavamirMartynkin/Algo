package AlgoLesson2;

public class HomeWork2 {
    public static void main(String[] args) { // управляющая функция
        int arr[] = new int[]{1,5,4,6,3,2,1,7,8,5,4,1,2,3,6};
        System.out.println("Исходнфый массив: ");
        printArray(arr);
        sortHeap(arr);
        System.out.println("Отсортированный массив: ");
        printArray(arr);
    }
    // функция описывающая процесс создания кучи по формуле: 1ребенок = родитель+1, 2ребенок = родитель+2
    private static void makeHeap(int[] array, int heapSize, int rootIndex){
        int max = rootIndex; // принимаем родительский за максимальный
        int leftCh = 2 * rootIndex +1; // вычисляем дочерний элемент слева
        int rightCh = 2 * rootIndex + 2; // и дочерний элемент спарва

        if (leftCh < heapSize && array[leftCh] > array[max]){
            max = leftCh; //если левый дочерний элемент больше максимального на данный момент, он становится на место максимального
        }
        if (rightCh < heapSize && array[rightCh] > array[max]){
            max = rightCh; //если правый дочерний элемент больше максимального на данный момент, он становится на место максимального
        }
        if (max != rootIndex){ //если индексы максимального элемента и родительского не равны, то меняем значения по этим индексам местами
            int temp = array[rootIndex];
            array[rootIndex] = array[max];
            array[max] = temp;

            makeHeap(array, heapSize, max); // рекурсивно преобразуем ветку
        }
    }

    //функция сортировки
    public static void sortHeap(int[] array){
        for (int i = array.length / 2 - 1; i >= 0; i--){
            makeHeap(array, array.length, i); // делаем из массива кучу
        }
        for (int i = array.length - 1; i >= 0; i--){ // для каждого элемента кучи
            int temp = array[0]; // перемещаем текущий корень в конец
            array[0] = array[i];
            array[i] = temp;

            makeHeap(array,i,0); // и применяем makeHeap к уменьшеной куче т.к. i--
        }
    }


    // функция для печати массива
    static void printArray(int array[]) {
        for (int i = 0; i < array.length; ++i) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
