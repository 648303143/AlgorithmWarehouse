package sort;

/**
 * @author zhangqingyang02
 * @date 2022-05-09-19:55
 */
public class Heap implements ISort {
    private int heapSize;

    @Override
    public void sort(int[] arr) {
        heapSize = 0;
        for (int i=0 ; i<arr.length ; i++) {
            heapInsert(arr, i);
        }

        while (heapSize > 0) {
            swap(arr, 0, --heapSize);
            heapify(arr, 0);
        }
    }

    private void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
        heapSize++;
    }

    private void heapify(int[] arr, int index) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && arr[left] < arr[left + 1] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index){
                break;
            }
            swap(arr, largest , index);
            index = largest;
            left = index * 2 + 1;
        }

    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Checker.check(new Heap());
    }
}
