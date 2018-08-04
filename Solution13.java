import java.util.Scanner;

/**
 * 回文序列
 * 题目描述：如果一个数字序列逆置之后跟原序列是一样的就称这样的数字序列为回文序列。例如：
 * {1, 2, 1}, {15, 78, 78, 15} , {112} 是回文序列,
 * {1, 2, 2}, {15, 78, 87, 51} ,{112, 2, 11} 不是回文序列。
 * 现在给出一个数字序列，允许使用一种转换操作：
 * 选择任意两个相邻的数，然后从序列移除这两个数，并用这两个数字的和插入到这两个数之前的位置(只插入一个和)。
 * 现在对于所给序列要求出最少需要多少次操作可以将其变成回文序列。
 */

public class Solution13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int times = 0;
            int n = scanner.nextInt();
            int[] inputArr = new int[n];
            for (int i = 0; i < n; i++) {
                inputArr[i] = scanner.nextInt();
            }
            int head = 0;
            int tail = n - 1;
            while (head < tail) {
                if (inputArr[head] > inputArr[tail]) {
                    inputArr[--tail] += inputArr[tail + 1];
                    times++;
                } else if (inputArr[head] < inputArr[tail]) {
                    inputArr[++head] += inputArr[head - 1];
                    times++;
                } else {
                    head++;
                    tail--;
                }
            }
            System.out.println(times);
        }
        scanner.close();
    }
}