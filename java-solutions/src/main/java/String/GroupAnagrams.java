package String;

import java.util.*;

public class GroupAnagrams {
    /**
     * Given an array of strings, this method groups the anagrams together and returns a list of groups.
     *
     * Approach: The approach used here is based on sorting.
     * For each word in the input array, we convert it to a character array, sort the array, and then convert it back to a string.
     * This sorted string serves as a unique key to group anagrams together.
     * We use a hashmap, where the keys are the sorted strings and the values are lists of words
     * that have the same sorted string. Finally, we convert the hashmap values to a list of groups and return it.
     *
     * Time Complexity: O(n * m * log m) Here, n refers to the number of words in the input array,
     * and m refers to the maximum length of a word. Sorting each word takes O(m * log m) time,
     * and we perform this operation for each of the n words. Hence, the overall time complexity is O(n * m * log m).
     *
     * Space Complexity: O(n * m) The space complexity is determined by the hashmap and the resulting list of groups.
     * In the worst case, all words may be unique, and the hashmap will contain n entries.
     * Additionally, each word may have a length of up to m. Therefore, the space complexity is O(n * m).
     *
     * @param strs An array of strings to be grouped.
     * @return A list of groups where each group contains anagrams.
     *
     * Leetcode link: https://leetcode.com/problems/group-anagrams/description/
     *
     *
     */
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
