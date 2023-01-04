import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Subset {
    List<List<Integer>> output = new ArrayList<>();
    int n, k;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int size = s.nextInt();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = s.nextInt();
        }
        s.close();

        Subset obj = new Subset();
        System.out.println(obj.subsets(arr));
        
    }

    public void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
        if (curr.size() == k) {
            output.add(new ArrayList<>(curr));
            return;
        }
        for (int i = first; i < n; ++i) {
            curr.add(nums[i]);
            backtrack(i + 1, curr, nums);
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        for (k = 0; k < n + 1; ++k) {
            backtrack(0, new ArrayList<Integer>(), nums);
        }
        return output;
    }
}