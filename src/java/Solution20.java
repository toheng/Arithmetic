import java.util.Scanner;

/**
 * 连续输入字符串(输入2次,每个字符串长度小于100)
 * 输出到长度为8的新字符串数组
 * 输入: abc
 * 123456789
 * 输出: abc00000
 * 12345678
 * 90000000
 *
 * @author: Hengo
 * @date: 2018/8/16 23:49
 */
public class Solution20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = new String(sc.nextLine());
            str += "00000000";
            while (str.length() > 8) {
                System.out.println(str.substring(0, 8));
                str = str.substring(8);
            }
        }
    }
}
