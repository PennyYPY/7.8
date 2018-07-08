package subtree;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @program: 7.8
 * @description:
 * @author: py
 * @create: 2018-07-08 18:49
 *(二叉树的题目哦)
 * 题目 ： 现在有一棵合法的二叉树，树的节点都是用数字表示，现在给定这棵树上所有的父子关系，求这棵树的高度
 **/

//构造二叉树model；
public class xiaomi1 {
    static class TreeNode{
        public TreeNode left;//左指向子树的链接；
        public TreeNode right;//右指向子树的链接；
        public int value;//值

        //
        public TreeNode(int value){
            this.value = value;
        }
    }

    //
    public static void createTree(TreeNode root,int father,int child){
        if (root == null){
            return;
        }if (root != null && root.value == father){
            if (root.left == null){
                root.left = new TreeNode(child);
            }else {
                root.right = new TreeNode(child);
            }
            return;
        }
        createTree(root.left,father,child);
        createTree(root.right,father,child);
    }

    public static int getHigh(TreeNode root,int level){
        if(root == null){
            return level;
        }
        int left = getHigh(root.left,level+1);
        int right = getHigh(root.right,level+1);
        return  Math.max(left,right);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<TreeNode> list = new ArrayList<>();
        //初始化数组
        for (int i = 0; i < n; i++) {
            TreeNode node = new TreeNode(i);
            node.right = null;
            node.left = null;
            list.add(node);
        }
        //建树
        for (int i = 0; i < n -1 ; i++) {
            int father = scanner.nextInt();
            int child = scanner.nextInt();
            if (list.get(father).left == null){
                list.get(father).left=list.get(child);
            }else {
                list.get(father).right = list.get(child);
            }
        }
        int high = 0;
        for (int i = 0;i < n; i++){
            high = Math.max(high,getHigh(list.get(i),0));
        }
        System.out.println(high);
        scanner.close();

    }
}
