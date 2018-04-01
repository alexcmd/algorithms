package learn.trees.binary.travers;

import java.util.LinkedList;
import java.util.List;


public class Solution {
    public TreeNode init(){
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = null;
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        return treeNode;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        if(root ==null)
            return list;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while (stack.size()!=0){
            TreeNode current = stack.removeLast();
            list.add(current.val);
            if (current.right!=null)
                stack.add(current.right);
            if (current.left!=null)
                stack.add(current.left);
        }

        return list;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode current = root;
        while (current!=null){
            stack.add(current);
            current = current.left;
        }
        while (stack.size()>0){
            TreeNode node = stack.removeLast();
            list.add(node.val);
            current = node.right;
            while (current!=null){
                stack.add(current);
                current = current.left;
            }
        }

        return list;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        if (root==null)
            return list;
        LinkedList<TreeNode> stack1 = new LinkedList<>();
        LinkedList<TreeNode> stack2 = new LinkedList<>();
        stack1.add(root);
        while (stack1.size()>0){
            TreeNode node = stack1.removeLast();
            stack2.add(node);
            if (node.left!=null)
                stack1.add(node.left);
            if (node.right !=null)
                stack1.add(node.right);
        }
        while (stack2.size()>0){
            TreeNode node = stack2.removeLast();
            list.add(node.val);
        }

        return list;
    }
}