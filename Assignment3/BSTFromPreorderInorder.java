package Assignment3;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

// / Approach:
//    1) First things first, find the root which is at preorder[0]
//    2) Pass it to a function to create the root node
//    3) set the left and right children using recursion, call same function for root.left and root right
//    4) Every time we use preorder to find the current root, we can also use inorder to tell us
//       which elements will be in the left/right subtrees
///
class BSTFromPreorderInorder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
     int preorderIndex = 0;
     HashMap<Integer,Integer> inorderIndexes;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // To construct a tree we need to know how to find the correct root: 
        // a) We find the root of the entire tree by accessing index 0 of preorder array
        // b) We can do the same for the roots of all the subtrees

        // Use map for quick access to root index
        inorderIndexes = new HashMap<>();

        for(int i = 0; i < inorder.length; i++){
            inorderIndexes.put(inorder[i], i);
        }

        return buildTreeHelper(preorder, 0, inorder.length-1);
    }

    // This helper function constructs the tree, subtree by subtree
// This is very similar to how one would copy a tree
// First by constructing a node, then setting up left/right children w/ recursion
    private TreeNode buildTreeHelper(int[] preorder, int leftBound, int rightBound){
        if(leftBound > rightBound){// if this happens the subarray is empty/null 
            return null;
        }

        // Retrieve the current root for the current subtree
        int rootVal = preorder[preorderIndex++];
        // Build the actual node for the current rootVal 
        TreeNode root = new TreeNode(rootVal);

        // Set up left and right subtrees
        // Left subtree is everything to the left of the root location in inorder array
        root.left = buildTreeHelper(preorder, leftBound, inorderIndexes.get(rootVal) - 1);
        // right subtree is everything to the right of the root location
        root.right = buildTreeHelper(preorder, inorderIndexes.get(rootVal)+ 1, rightBound);

        return root;

    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int [] inorder = {9,3,15,20,7};

        BSTFromPreorderInorder test = new BSTFromPreorderInorder();
        TreeNode ans = test.buildTree(preorder,inorder);
        ArrayList<Integer> results = new ArrayList<>();
        // BFS traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(ans);
        while(!queue.isEmpty()){
            int currentLevel = queue.size();

            for(int i = 0; i < currentLevel; i++){
                TreeNode node = queue.poll();
                results.add(node.val);

                if(node.left != null){queue.offer(node.left);}
                if(node.right != null){queue.offer(node.right);}
            }

        }
        System.out.println("Result " + results);
    }
}