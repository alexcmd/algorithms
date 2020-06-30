package learn.design;

import learn.common.TreeNode;

import java.util.LinkedList;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored
 * in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or
 * another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree.
 * There is no restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to
 * the original tree structure.
 *
 * Example:
 *
 * You may serialize the following tree:
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * as "[1,2,3,null,null,4,5]"
 */
public class Codec {

    /**
     * Encodes a tree to a single string.
     * Complexity: O(N)
     * Space: O(N)
      * @param root
     * @return
     */
    public String serialize(TreeNode root) {

        //FYI:  !!!Should be replaced with StringJoiner but Leetcode doesn't know this class!!!
        LinkedList<String> builder = new LinkedList<>();

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        int nullCounter = root==null?1:0;
        while (!queue.isEmpty() && queue.size() > nullCounter){
            var node = queue.poll();
            if (node == null){
                builder.add("null");
                nullCounter--;
                continue;
            }
            builder.add(String.valueOf(node.val));
            if (node.left == null)
                nullCounter++;
            if (node.right==null)
                nullCounter++;

            queue.add(node.left);
            queue.add(node.right);
        }

        return String.format("[%s]", String.join(",", builder));

    }



    /**
     * Decodes your encoded data to tree.
     * Complexity: O(N)
     * Space: O(N)
     *
     * @param data
     * @return
     */
    public TreeNode deserialize(String data) {
        if (data.length()<3)
            return null;
        String numbers = data.trim().substring(1,data.length()-1);
        var items = numbers.split(",");
        if (items.length ==0 || items[0].equals("null"))
            return null;

        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode head = new TreeNode(Integer.parseInt(items[0]));
        queue.push(head);
        TreeNode current = null;

        for (int i = 1; i < items.length; i++) {
            TreeNode nextNode;
            if (items[i].trim().equals("null"))
                nextNode = null;
            else {
                nextNode = new TreeNode(Integer.parseInt(items[i]));
                queue.add(nextNode);
            }
            if (i%2==1) {
                current = queue.poll();
                current.left = nextNode;
            }
            else {
                current.right = nextNode;
            }

        }
        return head;
    }
}
