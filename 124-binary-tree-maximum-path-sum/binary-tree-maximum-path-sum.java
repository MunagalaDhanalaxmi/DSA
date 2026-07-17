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
 /
 Anode should only be used once
 can start from any node and can end at any node.
 No root compulsion
 Approach:   
                       10
                    5       6

1)What the current node contribute. maxGain = 10+max(5,6)
 node.val+max(node.left, node.right)
2)how much gain to get through this node?
 start = Node 10 = max-16
 Start = Node 6/Node 5
 max: 5+6+10=21
3)Remove negatives(if any)
For every node:
 -Consider that node to be highest 
 -Compute every possible path
 -compare and update the max
4)maxPathsum-helper
   maxGain-recursive
 */
/*class Solution {
    public int maxPathSum(TreeNode root) {
     if(root == null)
     return Integer.MIN_VALUE;
     int left = maxPathSum(root.left);
     int right = maxPathSum(root.right);
     int current = root.val + Math.max(0, maxGain(root.left))+Math.max(0, maxGain(root.right));
     return Math.max(current, Math.max(left,right));
    }
    private int maxGain(TreeNode node) {
        if(node == null)
        return 0;
    return node.val + Math.max(Math.max(maxGain(node.left),0),Math.max(maxGain(node.right),0));
    }
}*/
class Solution {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }
    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftGain = Math.max(dfs(node.left), 0);
        int rightGain = Math.max(dfs(node.right), 0);
        int currentPath = node.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, currentPath);
        return node.val + Math.max(leftGain, rightGain);
    }
}