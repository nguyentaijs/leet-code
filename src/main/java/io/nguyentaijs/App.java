package io.nguyentaijs;

public class App
{
    public static void main( String[] args )
    {
        // Remove element
        int[] nums = new int[]{2,3,2,3};
        int val = 3;
        Solution solution = new Solution();
        System.out.println(solution.removeElement(nums, val));
    }
}
