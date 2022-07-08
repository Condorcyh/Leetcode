package BinarySearch.Q1011;

/**
 * @Author 车一晗
 * @Date 2022/07/07
 **/
public class Ship {
    public int shipWithinDays(int[] weights, int days) {
        //载重可能得最小值为max(weights)，最大值为sum(weights)
        int left = 0;
        int right = 0;
        for (int weight: weights) {
            if (left < weight) {
                left = weight;
            }
            right += weight;
        }
        right++;

        while (left < right) {
            //载货量
            int mid = left + (right - left) / 2;
            if (canFinish(weights, days, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    //如果载重为cap，能否在days天内运完货物
    boolean canFinish(int[] weights, int days, int cap) {
        int i = 0;
        for (int day = 0; day < days; day++) {
            int max = cap;
            while ((max -= weights[i]) >= 0) {
                i++;
                if (i == weights.length) {
                    return true;
                }
            }
        }
        return false;
    }
}
