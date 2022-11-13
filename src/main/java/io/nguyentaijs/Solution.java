package io.nguyentaijs;

import java.util.*;

public class Solution {

    // Longest common prefix
    public String longestCommonPrefix(String[] strs) {
        if (strs.length <= 0) {
            return "";
        }
        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(result)) {
                result = result.substring(0, result.length() - 1);
                if (result == "") {
                    return "";
                }
            }

        }
        return result;
    }


    // Palindrome number
    public boolean isPalindrome(int x) {
        return getSoDoiXung(x) == x;
    }

    public int getSoDoiXung(int soBanDau) {
        int soDoiXung = 0;
        while (soBanDau > 0) {
            int i = soBanDau % 10;
            soDoiXung = soDoiXung * 10 + i;
            soBanDau /= 10;
        }
        return soDoiXung;
    }

    // Remove duplicated
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!st.isEmpty()) {
                if (st.peek() == s.charAt(i)) {
                    st.pop();
                } else {
                    st.push(s.charAt(i));
                }
            } else {
                st.push(s.charAt(i));
            }
        }
        StringBuilder ns = new StringBuilder("");
        while (!st.isEmpty()) {
            ns.append(st.pop());
        }
        return ns.reverse().toString();
    }


    // Roman to Integer
    public int romanToInt(String s) {

        int num = 0;
        int prev = 0;
        int cur = 0;

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'M':
                    cur = 1000;
                    break;
                case 'D':
                    cur = 500;
                    break;
                case 'C':
                    cur = 100;
                    break;
                case 'L':
                    cur = 50;
                    break;
                case 'X':
                    cur = 10;
                    break;
                case 'V':
                    cur = 5;
                    break;
                case 'I':
                    cur = 1;
                    break;
            }
            if (prev < cur) {
                num -= 2 * prev;
            }
            num += cur;
            prev = cur;
        }
        return num;
    }

    // Two sum
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] <= target) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }
        }
        return new int[2];
    }

    // Valid parentheses
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '(') {
                stack.push(')');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    // Remove element
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    // Max depth of binary tree
    public int maxDepth(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        return Math.max(maxDepth(treeNode.left), maxDepth(treeNode.right)) + 1;
    }

    // Sort the people
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> peopleMap = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < names.length; i++) {
            peopleMap.put(heights[i], names[i]);
        }
        String[] finalResult = new String[names.length];
        int i = 0;
        for (String value : peopleMap.values()) {
            finalResult[i] = value;
            i++;
        }
        return finalResult;
    }

    // Sort peoples 2
    public String[] sortPeople2ndApproach(String[] names, int[] heights) {
        int arrLength = names.length;
        int[][] heightOfPeople = new int[arrLength][2];

        // Init array with current index and actual height
        for (int i = 0; i < arrLength; i++) {
            heightOfPeople[i][0] = i;
            heightOfPeople[i][1] = heights[i];
        }

        // Sort descendent by height
        Arrays.sort(heightOfPeople, (x, y) -> y[1] - x[1]);

        // Fill the result array with names according to index
        String[] results = new String[arrLength];
        for (int i = 0; i < arrLength; i++) {
            results[i] = names[heightOfPeople[i][0]];
        }

        return results;
    }
}
