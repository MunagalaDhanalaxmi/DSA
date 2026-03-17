/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums,0,nums.length-1);
        
    }
    public TreeNode helper(int arr[], int i,int j){
        if(i>j){
            return null;
        }
        int max = arr[i];
        int idx = i;
        for(int k=i;k<=j;k++){
            if(arr[k]>max){
                idx=k;
                max=arr[k];
            }
        }
        TreeNode nn = new TreeNode();
        nn.val=max;
        nn.left=helper(arr,i,idx-1);
        nn.right=helper(arr,idx+1,j);
        return nn;
    }
}
 