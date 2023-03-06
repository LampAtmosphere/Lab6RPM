import java.util.Arrays;
import java.util.Scanner;

public class Lab6RPM {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество элементов массива: ");
        int n = scanner.nextInt();
        
        int[] arr = new int[n];
        System.out.println("Введите элементы массива:");
        
        for (int i = 0; i < n; ++i) {
            arr[i] = scanner.nextInt();
        }
        System.out.println("До Сортировки: " + Arrays.toString(arr));
        
        combSort(arr);
        
        System.out.println("После Сортировки: " + Arrays.toString(arr));
    }

    public static void combSort(int[] arr) {
        int gap = arr.length;
        double shrink = 1.3;
        boolean sorted = false;
        
        while (!sorted) {
            gap = (int) Math.floor(gap / shrink);
            if (gap > 1) {
                sorted = false;
            } else {
                gap = 1;
                sorted = true;
            }
            int i = 0;
            while (i + gap < arr.length) {
                if (arr[i] > arr[i + gap]) {
                    swap(arr, i, i + gap);
                    sorted = false;
                }
                i++;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
