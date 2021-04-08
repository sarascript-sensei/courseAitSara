import com.sun.tools.javac.Main;

import java.util.Arrays;
import java.util.Scanner;

public class binsearch {
    public int runBinarySearchIteratively(int[] mitte, int key, int erst, int letzte) {
        int index = Integer.MAX_VALUE;

        while (erst <= letzte) {
            int mid = (erst + letzte) / 2;
            if (mitte[mid] < key) {
               erst = mid + 1;
            } else if (mitte[mid] > key) {
                letzte = mid - 1;
            } else if (mitte [mid] == key) {
                index = mid;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        binsearch obj = new binsearch();
        int [] a = {1,2,3,45,62,61,62};
        int n = a.length;

        // get input from user for element to be searched
        Scanner input = new Scanner(System.in);

        System.out.println("Впишите элемент, который нужно найти:");

        // element to be searched
        int element = input.nextInt();
        input.close();

        // call the binary search method
        // pass arguments: array, element, index of first and last element
        int result = obj.runBinarySearchIteratively(a, element, 0, n - 1);
        if (result == -1)
            System.out.println("Не найден");
        else
            System.out.println("Элемент найден на индексе " + result);
    }
}
