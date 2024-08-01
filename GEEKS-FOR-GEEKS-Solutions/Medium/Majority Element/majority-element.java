
Brute Force Algorithm

public class MajorityElement {
    // Brute force approach
    public static int majorityElementBruteForce(int[] nums) {
        int n = nums.length;
        // Iterate through each element in the array
        for (int i = 0; i < n; i++) {
            int count = 0;
            // Count the occurrences of the current element
            for (int j = 0; j < n; j++) {
                if (nums[j] == nums[i]) {
                    count++;
                }
            }
            // Check if the count exceeds half the array length
            if (count > n / 2) {
                return nums[i]; // Return the majority element
            }
        }
        return -1; // No majority element found
    }

    public static void main(String[] args) {
        int[] nums = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        System.out.println("Majority Element (Brute Force): " + majorityElementBruteForce(nums));
    }
}



Better Algorithm (Sorting)

    
import java.util.Arrays;

public class MajorityElement {
    // Better approach using sorting
    public static int majorityElementBetter(int[] nums) {
        Arrays.sort(nums); // Sort the array
        int mid = nums.length / 2; // Find the middle index
        int candidate = nums[mid]; // Candidate for majority element
        int count = 0;
        // Count occurrences of the candidate element
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }
        return count > nums.length / 2 ? candidate : -1; // Return majority element if found
    }

    public static void main(String[] args) {
        int[] nums = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        System.out.println("Majority Element (Better): " + majorityElementBetter(nums));
    }
}




Optimal Algorithm (Moore's Voting Algorithm)
    

public class MajorityElement {
    // Optimal approach using Moore's Voting Algorithm
    public static int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        // Finding the potential candidate
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        // Verifying the candidate
        count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }

        return count > nums.length / 2 ? candidate : -1; // Return majority element if found
    }

    public static void main(String[] args) {
        int[] nums = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        System.out.println("Majority Element (Optimal): " + majorityElement(nums));
    }
}

