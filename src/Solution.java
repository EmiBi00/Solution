import java.util.*;

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
    public int[][] transpose(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        // Eingabematrix ist eine n x m Matrix und wir wollen eine m x n Matrix
        int [][] transposeMatrix = new int[m][n];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                transposeMatrix[j][i] = matrix[i][j];
            }
        }
        return transposeMatrix;
    }
    public boolean digitCount(String num) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < num.length(); i++) {
            int zahl = num.charAt(i) - '0';
            if (map.containsKey(zahl)) {
                int wert = map.get(zahl);
                map.put(zahl, wert + 1);
            } else {
                map.put(zahl, 1);
            }
            // map.put(zahl, map.getOrDefault(zahl) + 1); Ist das Gleiche wie das If Else drüber
        }
        for (int i = 0; i < num.length(); i++) {
            int current = num.charAt(i) - '0';
            int wert = map.getOrDefault(i, 0);
            if (current != wert) return false;
        }
        return true;
    }

    public char findTheDifference(String s, String t) {
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();
        int i = 0, j = 0;
        while (i < s.length() || j < t.length()) {
            if (i < s.length()) {
                mapS.put(s.charAt(i), mapS.getOrDefault(s.charAt(i), 0) + 1);
            }
            if (j < t.length()) {
                mapT.put(t.charAt(j), mapT.getOrDefault(t.charAt(j), 0) + 1);
            }
            i++;
            j++;
        }
        for (Character c : mapT.keySet()) {
            if (!mapS.containsKey(c) || mapS.get(c) != mapT.get(c)) return c;
        }
        return ' ';
    }
}
