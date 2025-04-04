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
    static class Pair{
        int include;
        int exclude;
        public Pair(int i,int e){
            this.include=i;
            this.exclude=e;
        }
    }
    public int rob(TreeNode root) {
        Pair result=helper(root);
        return Math.max(result.include,result.exclude);
    }
    public static Pair helper(TreeNode root){
        if(root==null){
            return new Pair(0,0);
        }
        Pair leftChild=helper(root.left);
        Pair rightChild=helper(root.right);
        int include=root.val+leftChild.exclude+rightChild.exclude;
        int exclude=Math.max(leftChild.include,leftChild.exclude)+Math.max(rightChild.include,rightChild.exclude);
        return new Pair(include,exclude);
    }
}
