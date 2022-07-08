package BinarySearch.Q875;

/**
 * @Author 车一晗
 * @Date 2022/07/07
 **/
public class EatingSpeed {
    public int minEatingSpeed(int[] piles, int h) {
        //得到数组最大值
        int max = 0;
        for (int num : piles) {
            if (num > max) {
                max = num;
            }
        }

        int left = 1;
        int right = max + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int sum = 0;
            for (int i = 0; i < piles.length; i++) {
                //计算mid速度下需要多少时间吃掉香蕉
                int time = (piles[i] / mid) + (piles[i] % mid == 0 ? 0 : 1);
                sum += time;
            }
            if (sum <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
