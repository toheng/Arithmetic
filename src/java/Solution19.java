import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * 随机数去重排序
 * 题目描述：输入N个随机数，去掉重复的元素，组成元素从小到大的数组。
 *
 * @author: Hengo
 * @date: 2018/8/13 23:27
 */
public class Solution19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] inputArray = new int[n];
            for (int i = 0; i < n; i++) {
                inputArray[i] = scanner.nextInt();
            }
            // 排序
            Arrays.sort(inputArray);
            System.out.println(inputArray[0]);
            for (int i = 1; i < n; i++) {
                if (inputArray[i] != inputArray[i - 1]) {
                    System.out.println(inputArray[i]);
                }
            }
        }
    }
}
