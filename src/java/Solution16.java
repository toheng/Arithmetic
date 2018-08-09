package java;

/**
 * 左旋转字符串
 * 题目描述：对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 */
public class Solution16 {
    public String LeftRotateString(String str, int n) {
        //保证旋转的位数大于字符串的长度，否则返回空字符串
        if (n > str.length())
            return "";
        //把原字符串截取成俩字符串，然后拼接
        String s1 = str.substring(0, n);
        String s2 = str.substring(n, str.length());
        return s2 + s1;
    }
}