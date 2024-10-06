//Subsets

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Reading input
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        String[] parts = line.split(" ");
        int[] arr = new int[parts.length];
        
        // Parsing input
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }
        
        // Get subsets
        List<List<Integer>> result = subsets(arr);
        
        // Print results
        for (List<Integer> subset : result) {
            for (int num : subset) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
    
    // Function to generate all subsets
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sorting for lexicographical order
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    // Backtracking function
    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        if (!tempList.isEmpty()) {
            result.add(new ArrayList<>(tempList));
        }
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(result, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1); // remove last element to backtrack
        }
    }
}
