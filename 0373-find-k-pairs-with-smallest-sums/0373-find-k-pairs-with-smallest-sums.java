import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        return new AbstractList<>() {

            private List<List<Integer>> pairs;

            @Override
            public List<Integer> get(int index) {
                init();
                return pairs.get(index);
            }

            @Override
            public int size() {
                init();
                return pairs.size();
            }

            private void init() {
                if (pairs == null) {
                    loadPairs();
                }
            }

            private void loadPairs() {
                int m = nums1.length, n = nums2.length;
                int low = nums1[0] + nums2[0];
                int high = nums1[m - 1] + nums2[n - 1];

                while (low <= high) {
                    int mid = (low + high) / 2;
                    long count = countPairsLessThanOrEqual(nums1, nums2, mid, k);

                    if (count < k) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }

                collectPairs(nums1, nums2, low, k);
            }

            private long countPairsLessThanOrEqual(int[] nums1, int[] nums2, int threshold, int k) {
                int count = 0;
                int n = nums2.length;
                int j = n - 1;

                for (int i = 0; i < nums1.length && nums1[i] + nums2[0] <= threshold; i++) {
                    int left = 0, right = j, pos = -1;
                    while (left <= right) {
                        int mid = (left + right) / 2;
                        if (nums1[i] + nums2[mid] <= threshold) {
                            pos = mid;
                            left = mid + 1;
                        } else {
                            right = mid - 1;
                        }
                    }

                    if (pos != -1) {
                        count += (pos + 1);
                        j = pos;
                    }

                    if (count > k) break;
                }

                return count;
            }

            private void collectPairs(int[] nums1, int[] nums2, int threshold, int k) {
                pairs = new ArrayList<>();

                for (int i = 0; i < nums1.length; i++) {
                    for (int j = 0; j < nums2.length && nums1[i] + nums2[j] < threshold; j++) {
                        pairs.add(Arrays.asList(nums1[i], nums2[j]));
                    }
                }

                for (int i = 0; i < nums1.length; i++) {
                    for (int j = 0; j < nums2.length && nums1[i] + nums2[j] <= threshold && pairs.size() < k; j++) {
                        if (nums1[i] + nums2[j] == threshold) {
                            pairs.add(Arrays.asList(nums1[i], nums2[j]));
                        }
                    }
                }
            }
        };
    }
}