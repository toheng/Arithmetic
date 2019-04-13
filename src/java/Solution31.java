package java;

import java.util.Stack;

/**
 * LeetCode 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 1. 左括号必须用相同类型的右括号闭合。
 * 2. 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * @author hengo
 * @date 2019/4/13
 **/
public class Solution31 {

    public static void main(String[] args) {
        System.out.println(isValid("([)"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (stack.size() == 0) {
                // 栈为空，就进栈
                stack.push(aChar);
            } else if (isMatch(stack.peek(), aChar)) {
                // 栈不为空，比较是否匹配
                stack.pop();
            } else {
                stack.push(aChar);
            }
        }
        return stack.size() == 0;
    }

    private static boolean isMatch(char c1, char c2) {
        return (c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}');
    }

}
