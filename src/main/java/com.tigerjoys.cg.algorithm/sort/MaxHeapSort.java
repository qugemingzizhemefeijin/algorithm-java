package com.tigerjoys.cg.algorithm.sort;

/**
 * 大根堆排序
 *
 * 其实就是把数组组合成一个完全二叉树，最大的节点是根节点，然后拿出来，依次往复。。
 *
 * 满二叉树特点：
 * 1.叶子只能出现在最下层，出现在其他层就不可能达到平衡。
 * 2.非叶子节点的度一定是2。否则就是“缺胳膊少腿”了。
 * 3.在同样深度的二叉树中，满二叉树的节点个数最多，叶子数最多。
 *
 * 完全二叉树特点：
 * 1.叶子节点只能出现在最下两层。
 * 2.最下层的叶子一定集中在左部连续位置。
 * 3.倒数二层，若有叶子节点，一定都在右部连续位置。
 * 4.如果节点度为1，则该节点只有左孩子，即不存在只有右子树的情况。
 * 5.同样节点数的二叉树，完全二叉树的深度最小。
 *
 * 二叉树性质：
 * 1.在二叉树的第i层上至多有2(i-1)指数个节点(i>=1)。
 * 2.深度为 k 的二叉树至多有 2(k)-1 个结点 (k>=l)。
 * 3.对任何一棵二叉树 T，如果其终端结点数为n0，度为 2 的结点数n2，则 n0=n2+ 1。
 * 4.具有 n 个结点的完全二叉树的深度为 log2n +1。
 * 5.如果对一棵有 n 个结点的完全二叉树(其深度为 log2n+1 ) 的结点按层序编号(从第 1 层到第 log2n+1层，每层从左到右) ，
 *      对任一结点 i (1<=i<=n)有:
 *      1.如果 i=1 ，则结点 i 是二叉树的根，无双亲;如果i> 1 ，则其双亲是结点i/2。
 *      2.如果 2i>n ，则结点 i 无左孩子(结点 i 为叶子结点) ;否则其左孩子是结点2i 。
 *      3.如果 2i+1>n ，则结点 i 无右孩子;否则其右孩子是结点 2i+1 。
 *      4.节点数=n/2。
 *
 * @author chengang
 * @create 2018-04-15 15:36
 */
public class MaxHeapSort {

    public static void main(String[] args) {
        int i;
        for(i=ArrayUtils.SQLIST.length/2;i>=0;i--) {
            ArrayUtils.cryleCounter();
            heapAdjust(i,ArrayUtils.SQLIST.length);
        }

        for(i=ArrayUtils.SQLIST.length-1;i>=0;i--) {
            ArrayUtils.cryleCounter();
            ArrayUtils.swap(0 , i);
            heapAdjust(0 , i);
        }

        ArrayUtils.print();
    }

    /**
     * 构建大根堆
     * @param s - 构建的节点[非子节点]
     * @param m - 截止位置
     */
    private static void heapAdjust(int s , int m) {
        int temp = ArrayUtils.SQLIST[s];
        for(int i=s*2;i<m-1;i*=2) {
            ArrayUtils.cryleCounter();
            if(i<m && ArrayUtils.SQLIST[i] < ArrayUtils.SQLIST[i+1]) {
                i++;
            }
            if(temp >= ArrayUtils.SQLIST[i]) {
                break;
            }

            ArrayUtils.SQLIST[s] = ArrayUtils.SQLIST[i];
            s = i;
        }

        ArrayUtils.SQLIST[s] = temp;
    }

}
