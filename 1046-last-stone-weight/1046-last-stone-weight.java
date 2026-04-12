class Solution {
    public int lastStoneWeight(int[] ar) {
        int n = ar.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            max_heapify(ar, n, i);
        }
        while (n > 1) {
            int max1 = ar[0];
            ar[0] = ar[n - 1];
            n--;
            max_heapify(ar, n, 0);
            int max2 = ar[0];
            ar[0] = ar[n - 1];
            n--;
            max_heapify(ar, n, 0);
            if (max1 != max2) {
                n++;
                ar[n - 1] = Math.abs(max1 - max2);
                heapify_Up(ar, n - 1);
            }
        }
        return (n == 0) ? 0 : ar[0];
    }

    private void heapify_Up(int[] ar, int i) {
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (ar[parent] < ar[i]) {
                int temp = ar[parent];
                ar[parent] = ar[i];
                ar[i] = temp;
                i = parent;
            } else
                break;
        }
    }

    private void max_heapify(int[] ar, int n, int i) {
        int largest = i, left = 2 * i + 1, right = 2 * i + 2;
        if (left < n && ar[largest] < ar[left])
            largest = left;
        if (right < n && ar[largest] < ar[right])
            largest = right;
        if (largest != i) {
            int temp = ar[largest];
            ar[largest] = ar[i];
            ar[i] = temp;
            max_heapify(ar, n, largest);
        }
    }
}