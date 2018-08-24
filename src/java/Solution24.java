import java.util.Scanner;

/**
 * 按字节截取字符串
 * 题目描述：编写一个截取字符串的函数，输入为一个字符串和字节数，输出为按字节截取的字符串。
 * 输入"我ABC汉DEF"6，应该输出为"我ABC"而不是"我ABC+汉的半个"。
 *
 * @author: Hengo
 * @date: 2018/8/24 23:40
 */
public class Solution24 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str;
        int num;
        while (in.hasNext()) {
            str = in.next();
            num = in.nextInt();
            char[] arr = str.toCharArray();
            int temp = 0;
            int i = 0;
            while (temp < num) {
                if (arr[i] > 128) {
                    temp += 2;
                    if (temp <= num)
                        i++;
                } else {
                    temp++;
                    if (temp <= num)
                        i++;
                }
            }
            System.out.println(str.substring(0, i));
        }
        in.close();
    }
}
