package Assignment3;

class MaxPathSum {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int maxSum = 0;
    public int maxPathSum(TreeNode root) {
        pathSumHelper(root);
        return maxSum;
    }
    public int pathSumHelper(TreeNode root){
        if(root == null){
            return 0;
        }

        // Computes max path of left and right subtrees, if pathSum < 0, we consider it 0
        // and will not go down that path
        int leftMax = Math.max(pathSumHelper(root.left),0);
        int rightMax = Math.max(pathSumHelper(root.right),0);

        // This variable checks if max path sum has been exceeded and will replace if necessary
        maxSum = Math.max(maxSum, leftMax + rightMax + root.val);

        return root.val + Math.max(leftMax,rightMax);
    }

    public static void main(String[] args) {
        MaxPathSum test = new MaxPathSum();

        // set up tree
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int ans = test.maxPathSum(root);

        System.out.println("Expected: 42\n" + "Result: " + ans);

    }
}
