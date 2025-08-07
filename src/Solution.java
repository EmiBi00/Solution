import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

    public int[] sortedSquares(int[] nums) {
        int[] square = new int [nums.length];
        for (int i = 0; i < nums.length; i++) {
            square[i] = (int) Math.pow(nums[i], 2);
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (square[j] > square[j + 1]) {
                    int temp = square[j];
                    square[j] = square[j + 1];
                    square[j + 1] = temp;
                }
            }
        }
        return square;
    }

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int output = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && endTime[i] >= queryTime) {
                output++;
            }
        }
        return output;
    }

    static class Interval {

        private final int begin;
        private final int ende;

        public Interval(int begin, int ende) {
            this.begin = begin;
            this.ende = ende;
        }

        public int getBegin() {
            return begin;
        }

        public int getEnde() {
            return ende;
        }
    }

    public int busyStudent(Interval[] intervals, int queryTime) {
        int output = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i].getBegin() >= queryTime && intervals[i].getEnde() <= queryTime) {
                output++;
            }
        }
        return output;
    }

    public int busyStudent(List<int[]> times, int queryTime) {
        int output = 0;
        for (int[] time : times) {
            if (time[0] >= queryTime && time[1] <= queryTime) {
                output++;
            }
        }
        return output;
    }
    public int distributeCandies(int[] candyType) {
        Set<Integer> ordner = new HashSet<>();
        for (int type : candyType) {
            ordner.add(type);
        }
        return Math.min(ordner.size(), (candyType.length / 2));
    }
}
