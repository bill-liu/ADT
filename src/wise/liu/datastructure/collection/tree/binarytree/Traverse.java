package wise.liu.datastructure.collection.tree.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树遍历
 */
public class Traverse {

    List<Integer> result = new ArrayList<>();

    public static void preOrder(BinaryTreeNode root){
        if (root == null){
            return;
        }

        //result.add(root.val);
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }


    public static void buildBinaryTree(BinaryTreeNode root, List<Integer> list, int index){
        if (index >= list.size()){
            return;
        }
        if (root == null){
            return;
        }
        Integer value = list.get(index);
        if (value != null) {
            root.val = value;
        }
        if (++index < list.size()){
            root.left = new BinaryTreeNode();
            buildBinaryTree(root.left, list, index);
        }
        if (++index < list.size()){
            root.right = new BinaryTreeNode();
            buildBinaryTree(root.right, list, index);
        }
    }

    public static BinaryTreeNode buildBinaryTree(String preOrderTreeStr){
        if (preOrderTreeStr == null || preOrderTreeStr.trim()==""){
            return null;
        }
        preOrderTreeStr = preOrderTreeStr.replace("[","").replace("]", "");
        String[] array = preOrderTreeStr.split(",");
        List<Integer> result = new ArrayList<>();
        for (String str : array){
            Integer value = null;
            if (!(str==null || str.trim()=="" || "null".equals(str))){
                value = Integer.valueOf(str);
            }

            result.add(value);
        }
        if (result.isEmpty()){
            return  null;
        }
        Integer rootValue = result.get(0);
        if (rootValue == null){
            return null;
        }
        BinaryTreeNode root = new BinaryTreeNode();
        buildBinaryTree(root, result, 0);
        return root;
    }

    public static void main(String[] args) {
        String treeStr = "[5,1,4,null,null,3,6]";
        BinaryTreeNode root = buildBinaryTree(treeStr);
        preOrder(root);
    }
}
