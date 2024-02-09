package String;

import java.util.*;

/*
     * Given an array of strings strs, group the anagrams together.
     * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, 
     * typically using all the original letters exactly once.
     * 
     * @param strs An array of strings to be grouped.
     * @return A list of groups where each group contains anagrams.
     *
     * Approach: 
     * 
     * Brute Force:
     * The brute-force approach for grouping anagrams involves comparing each pair of strings in the given array to determine if they are anagrams of each other. 
     *  
     * 1. Initialize an empty list of groups to store the anagram groups.
     * 2. Iterate through each pair of strings in the array. 
     * 3. For each pair of strings, check if they are anagrams.
     * 4. If anagrams, find the group they belong to in the list of groups.
     * 5. If a group is found, add the current pair to that group.
     * 6. If no group is found, create a new group and add the current pair to it.
     * 7. Repeat for all pairs of strings.
     * 
     * The time complexity for this approach is  O(n^2 * m), where n is the number of strings in the array and m is the maximum length of any string. 
     * This is because, for each pair of strings, a comparison of characters and counts is required, and the process is repeated for all pairs.
     * 
     * Optimal Solution: 
     * The optimal approach to grouping anagrams is based on sorting.
     * 
     * 1. For each word in the input array, we convert it to a character array, sort the array, and then convert it back to a string.
     * 2. This sorted string serves as a unique key to group anagrams together.
     * 3. We use a hashmap, where the keys are the sorted strings and the values are lists of words that have the same sorted string. 
     * 4. Finally, we convert the hashmap values to a list of groups and return it.
     *
     * Time Complexity: O(n * m * log m). Here, n refers to the number of words in the input array,
     * and m refers to the maximum length of a word. Sorting each word takes O(m * log m) time,
     * and we perform this operation for each of the n words. Hence, the overall time complexity is O(n * m * log m).
     *
     * Space Complexity: O(n * m) The space complexity is determined by the hashmap and the resulting list of groups.
     * In the worst case, all words may be unique, and the hashmap will contain n entries.
     * Additionally, each word may have a length of up to m. Therefore, the space complexity is O(n * m).
     *
     *
     * Leetcode link: https://leetcode.com/problems/group-anagrams/description/
     *
     *
*/

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        // Create a hashmap to store the groups of anagrams
        Map<String, List<String>> anagramGroups = new HashMap<>();

        // Iterate through each word in the array
        for (String word : strs) {
            // Convert the word to a character array, sort it, and convert it back to a string
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);

            // Add the word to its corresponding group in the hashmap
            List<String> group = anagramGroups.getOrDefault(sortedWord, new ArrayList<>());
            group.add(word);
            anagramGroups.put(sortedWord, group);
        }

        // Convert the hashmap values to a list of groups
        List<List<String>> result = new ArrayList<>(anagramGroups.values());

        return result;
    }

    public static void main(String[] args) {
        String[] arr = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(arr));
    }
}
