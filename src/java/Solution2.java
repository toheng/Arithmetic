package java;

/**
 * 二维数组中的查找
 * 题目描述：在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 *
 * @author: Hengo
 * @date: 2018/7/19 23:32
 */
public class Solution2 {
    public static boolean Find(int target, int[][] array) {
        int i = 0;
        int len = array.length - 1;
        while (len >= 0 && i < array[0].length) {
            if (array[len][i] > target) {
                len--;
            } else if (array[len][i] < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }
}
