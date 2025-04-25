import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] numbers = generate(1, 100, 10000); // Generate 10,000 random numbers between 1 and 100
        mergesort(numbers, 0, numbers.length - 1); // Sort the array using merge sort
        display(numbers); // Display the sorted numbers
    }

    // Generate random integers between 'low' and 'high' with the given 'size'
    public static int[] generate(int low, int high, int size) {
        int[] result = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            result[i] = rand.nextInt(high - low + 1) + low; // Random number between low and high
        }
        return result;
    }

    // Merge Sort algorithm
    public static void mergesort(int[] a, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergesort(a, low, mid); // Sort the left half
            mergesort(a, mid + 1, high); // Sort the right half
            merge(a, low, mid, high); // Merge the sorted halves
        }
    }

    // Merge two sorted halves of the array
    public static void merge(int[] a, int low, int mid, int high) {
        int[] left = new int[mid - low + 1];
        int[] right = new int[high - mid];

        // Copy data to temporary arrays left[] and right[]
        System.arraycopy(a, low, left, 0, left.length);
        System.arraycopy(a, mid + 1, right, 0, right.length);

        int i = 0, j = 0, k = low;

        // Merge the temporary arrays back into the original array a[]
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                a[k] = left[i];
                i++;
            } else {
                a[k] = right[j];
                j++;
            }
            k++;
        }

        // Copy the remaining elements of left[], if any
        while (i < left.length) {
            a[k] = left[i];
            i++;
            k++;
        }

        // Copy the remaining elements of right[], if any
        while (j < right.length) {
            a[k] = right[j];
            j++;
            k++;
        }
    }

    // Display the array elements
    public static void display(int[] a) {
        for (int x : a) {
            System.out.print(x);
            System.out.print("\t");
        }
    }
}
