package java;

import java.util.Stack;

/**
 * 栈的压入，弹出序列
 * 题目描述：输入两个整数序列，第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class Solution4 {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || popA == null || pushA.length == 0 || popA.length == 0 || pushA.length != popA.length) {
            return false;
        }

        Stack<Integer> s = new Stack<>();
        int popIndex = 0;
        for (int i = 0; i < pushA.length; i++) {
            s.push(pushA[i]);
            // 判断此时栈是否为空，并且比较栈顶值是否和出栈的值是否相等
            while (!s.empty() && s.peek() == popA[popIndex]) {
                // 弹出栈顶值
                s.pop();
                // 出栈序列自增
                popIndex++;
            }
        }
        return s.empty();
    }
}