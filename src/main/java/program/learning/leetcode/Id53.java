package program.learning.leetcode;

public class Id53 {

    //dp
    private static int maxSubArray(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int max = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

    //分治
    public int maxSubArray2(int[] nums) {
        return getSum(nums, 0, nums.length - 1).getMaxSum();
    }

    public ArraySum getSum(int[] nums, int l, int r) {
        if (l == r) {
            return new ArraySum(nums[l], nums[l], nums[l], nums[l]);
        }

        int middle = (l + r) / 2;
        ArraySum left = getSum(nums, l, middle);
        ArraySum right = getSum(nums, middle + 1, r);

        int lSum = Math.max(left.getlSum(), left.getSum() + right.getlSum());
        int rSum = Math.max(right.getrSum(), right.getSum() + left.getrSum());
        int mSum = Math.max(Math.max(left.getMaxSum(), right.getMaxSum()), left.getrSum() + right.getlSum());
        int sum = left.getSum() + right.getSum();

        return new ArraySum(lSum, rSum, mSum, sum);
    }

    public static void main(String[] args) {
        int[] array = new int[]{-1,0,-2};
        System.out.println(maxSubArray(array));

        Id53 id53 = new Id53();
        System.out.println(id53.maxSubArray2(array));
    }

    class ArraySum {

        private Integer lSum;
        private Integer rSum;
        private Integer maxSum;
        private Integer sum;

        public ArraySum(Integer lSum, Integer rSum, Integer maxSum, Integer sum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.maxSum = maxSum;
            this.sum = sum;
        }

        public Integer getlSum() {
            return lSum;
        }

        public void setlSum(Integer lSum) {
            this.lSum = lSum;
        }

        public Integer getrSum() {
            return rSum;
        }

        public void setrSum(Integer rSum) {
            this.rSum = rSum;
        }

        public void setMaxSum(Integer maxSum) {
            this.maxSum = maxSum;
        }

        public Integer getSum() {
            return sum;
        }

        public void setSum(Integer sum) {
            this.sum = sum;
        }

        public Integer getMaxSum() {
            return maxSum;
        }
    }
}
