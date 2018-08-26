/**
 * single-number
 * Description: Given an array of integers, every element appears twice except for one. Find that single one.
 * 使用异或，相同返回0；0异或另一个数，为这个数本身
 *
 * @author: Hengo
 * @date: 2018/8/26 22:22
 */
public class Solution26 {
    public int singleNumber(int[] A) {
        int number = 0;
        for (int i = 0; i < A.length; i++) {
            number ^= A[i];
        }
        return number;
    }
}
