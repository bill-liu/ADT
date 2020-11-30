package wise.liu.datastructure.collection.tree.binarytree.exercises;

import wise.liu.datastructure.collection.tree.binarytree.BinaryTreeNode;

/**
 * 98. 验证二叉搜索树
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。

 假设一个二叉搜索树具有如下特征：

 节点的左子树只包含小于当前节点的数。
 节点的右子树只包含大于当前节点的数。
 所有左子树和右子树自身必须也是二叉搜索树。
 示例 1:

 输入:
 2
 / \
 1   3
 输出: true
 示例 2:

 输入:
 5
 / \
 1   4
      / \
     3   6
 输出: false
 解释: 输入为: [5,1,4,null,null,3,6]。
      根节点的值为 5 ，但是其右子节点值为 4 。

 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * @author wise liu
 * @date 2020/11/26
 */
public class ValidBSTSolution {

    /**
     * 二叉搜索树根节点比左子树的最大值要大 比右子树的最小值要小
     * @param root
     * @return
     */
    public boolean isValidBST0(BinaryTreeNode root) {
        if(root  == null){
            return true;
        }
        if(root.left==null && root.right==null){
            return true;
        }
        return isValid(root, Integer.MIN_VALUE-1L, Integer.MAX_VALUE+1L);
    }

    public boolean isValid(BinaryTreeNode root, Long min, Long max){
        if(root  == null){
            return true;
        }
        if(root.val  >  min && root.val  < max){
            return isValid(root.left, min, (long)root.val)  && isValid(root.right, (long)root.val, max);
        }
        return false;
    }

    BinaryTreeNode pre = null;

    /**
     * 二叉搜索树中序遍历前继节点都比根节点小
     * @param root
     * @return
     */
    public boolean isValidBST(BinaryTreeNode root){
        if(root  == null){
            return true;
        }
        if(!isValidBST(root.left)){
            return false;
        }
        if (pre != null && pre.val >= root.val){
            return false;
        }
        pre = root;
        return isValidBST(root.right);
    }
}
