import java.util.ArrayList;
import java.util.List;

/**
 * 生成括号
 * 题目描述: 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 例如，给出 n = 3，生成结果为：
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * 凡是这种生成全排列，满足条件的排列，大部分情况下都要用递归。
 * 首先左右括号必须相等。先确定前缀，然后递归，递归条件就是剩下的左括号数目，和剩下的右括号数目。
 * 比如：
 * ( ,  leftCount = 1, rightCount = 0;
 * 就可以把题目转化为：在左括号数目为3 - 1 = 2，右括号数目是3 - 0 = 3的解。
 *
 * @author: Hengo
 * @date: 2018/8/28 22:25
 */
public class Solution27 {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<String>();
        String s = "";
        parenthesis(list, s, n, n);
        return list;
    }

    public void parenthesis(ArrayList<String> list, String s, Integer left, Integer right) {
        if (left == 0 && right == 0) {
            list.add(s);
        }
        if (left > 0) {
            parenthesis(list, s + '(', left - 1, right);
        }
        if (right > 0 && left < right) {
            parenthesis(list, s + ')', left, right - 1);
        }
    }
}
