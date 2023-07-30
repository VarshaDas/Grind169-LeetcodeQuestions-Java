package CyclicSort;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedFromArray {

        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> result = new ArrayList<>();


            // Perform cyclic sort
            /*
            The inner while loop is used to swap elements until the current number (nums[i]) is in its correct position.
            The condition nums[i] != nums[nums[i] - 1] ensures that we swap the element until it is in its correct position.
            The correct variable is unnecessary in this case as it holds the same value as correctIndex, so you can remove it
            from the code.
            The increment i++ is moved outside the inner while loop to ensure that we move to the next element only when
            the current element is in its correct position.
             */
            int i = 0;
            while (i < nums.length) {
                while(nums[i] != nums[nums[i] - 1]){
                    int correct = nums[i] - 1;
                    swap(nums, i, correct);
                }
                i++;
            }

            // Find missing numbers
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] != j + 1) {
                    result.add(j + 1);
                }
            }

            return result;
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

    }


