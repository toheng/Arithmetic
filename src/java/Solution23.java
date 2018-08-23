import java.util.Scanner;

/**
 * 查找两个字符串a,b中的最长公共子串
 * 题目描述：查找两个字符串a,b中的最长公共子串。若有多个，输出在较短串中最先出现的那个。
 *
 * @author: Hengo
 * @date: 2018/8/23 23:49
 */
public class Solution23 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s1 = in.nextLine();
            String s2 = in.nextLine();
            String max = s1.length() >= s2.length() ? s1 : s2;
            String min = s1.length() >= s2.length() ? s2 : s1;
            int l = 0;
            String s = "";
            for (int i = 0; i < min.length(); i++) {
                for (int j = i + 1; j <= min.length(); j++) {
                    if (max.contains(min.substring(i, j)) && j - i > l) {
                        l = j - i;
                        s = min.substring(i, j);
                    }
                }
            }
            System.out.println(s);
        }
    }
}
