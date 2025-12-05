import java.beans.PropertyEditorSupport;
import java.util.*;
import java.util.Arrays;
import java.util.stream.Stream;

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

    public int addDigits(int num) {
        while (num > 9) {
            int ziffern = 0;
            while (num != 0) {
                ziffern += num % 10;
                num /= 10;
            }
            num = ziffern;
        }
        return num;
    }
    public String decodeMessage(String key, String message) {
        Map<Character, Character> alphabet = new HashMap<>();
        alphabet.put(' ', ' ');
        char[] output = new char[message.length()];
        char c = 'a';
        for (char buchstabe : key.toCharArray()) {
            if (!alphabet.containsKey(buchstabe) && buchstabe != ' ') {
                alphabet.put(buchstabe, c++);
            }
        }
        for (int i = 0; i < message.length(); i++) {
            output[i] = alphabet.get(message.charAt(i));
        }
        return new String(output);
    }
    public int smallestIndex(int[] nums) {
        int output = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sumdigits = 0;
            int n = nums[i];
            while (n > 0) {
                sumdigits += n % 10;
                n /= 10;
            }
            if (sumdigits == i & min > sumdigits) {
                output = sumdigits;
                min = sumdigits;
            }
        }
        return output;
    }
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int output = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        for (int i = 1; i <= min; i++) {
            int zwischen = 0;
            if (min % i == 0 && max % i == 0) {
                zwischen = i;
            }
            if (zwischen > output) {
                output = zwischen;
            }
        }
        return output;
    }
    public boolean halvesAreAlike(String s) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < (s.length() / 2); i++ ) {
            char zwischen = s.charAt(i);
            boolean isVowel = helper(zwischen);
            if (isVowel) {
                a++;
            }
        }
        for (int i = (s.length() / 2); i < s.length(); i++){
            char zwischen = s.charAt(i);
            boolean isVowel = helper(zwischen);
            if(isVowel) {
                b++;
            }
        }

        return a == b;
    }
    public boolean helper(char z) {
        String vowels = "AaEeOoIiUu";
        return vowels.contains(String.valueOf(z));
    }
    public boolean divideArray(int[] nums) {
        boolean output = true;
        Map<Integer, Integer> counter = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            counter.put(nums[i], counter.getOrDefault(nums[i], 0) + 1);
        }
        Set<Integer> jani = counter.keySet();
        for(int key : jani) {
            if (counter.get(key) % 2 != 0) {
                return false;
            }
        }
        return output;
    }
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public int vowelStrings(String[] words, int left, int right) {
        int output = 0;
        for (int i = left; i <= right; i++) {
            char buchstabe1 = words[i].charAt(0);
            char buchstabe2 = words[i].charAt(words[i].length() - 1);
            if (helper2(buchstabe1) && helper2(buchstabe2)) {
                output++;
            }
        }
        return output;
    }
    public boolean helper2(char z) {
        String vowels = "AaEeOoIiUu";
        return vowels.contains(String.valueOf(z));
    }
    public String reformatDate(String date) {
        String[] words = date.split(" ");
        String day = "", month = "", year = "";

        Map<String, String> months = new HashMap<>();
        months.put("Jan", "01");
        months.put("Feb", "02");
        months.put("Mar", "03");
        months.put("Apr", "04");
        months.put("May", "05");
        months.put("Jun", "06");
        months.put("Jul", "07");
        months.put("Aug", "08");
        months.put("Sep", "09");
        months.put("Oct", "10");
        months.put("Nov", "11");
        months.put("Dec", "12");

        // Tag (erste Komponente, z. B. "20th" oder "6th")
        day = words[0].replaceAll("\\D", "");     // nur Ziffern
        if (day.length() == 1) {
            day = "0" + day;                     // zweistellig machen
        }

        // Monat (zweite Komponente, z. B. "Oct")
        month = months.get(words[1]);

        // Jahr (dritte Komponente, z. B. "2052")
        year = words[2];

        return year + "-" + month + "-" + day;
    }

    public int findCenter(int[][] edges) {
        Map<Integer, Integer> ordner = new HashMap<>();
        for (int[] edge : edges) {
            ordner.put(edge[0], ordner.getOrDefault(edge[0], 0) + 1);
            ordner.put(edge[1], ordner.getOrDefault(edge[1], 0) + 1);
        }
        Set<Integer> janNichtSoTief = ordner.keySet();
        for (int key : janNichtSoTief) {
            if (ordner.get(key) > 1) {
                return key;
            }
        }
        return -1;
    }

    public int findCenterEasier(int[][] edges) {
        boolean[] found = new boolean[edges.length + 1];
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (found[u - 1]) return u;
            if (found[v - 1]) return v;
            found[u - 1] = true;
            found[v - 1] = true;
        }
        return -1;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public boolean evaluateTree(TreeNode root) {
        if (root.val == 0 || root.val == 1) { // Basisfall: Ende der Rekursion, muss einen Wert returnen
            return root.val == 1;
        }
        if (root.val == 2) {
            return evaluateTree(root.left) || evaluateTree(root.right);
        }
        if (root.val == 3) {
            return evaluateTree(root.left) && evaluateTree(root.right);
        }
        return false;
    }

    public TreeNode searchBST(TreeNode root, int val) {
        LinkedList<TreeNode> zahlen = new LinkedList<>();
        zahlen.add(root);
        while (!zahlen.isEmpty()) {
            TreeNode current = zahlen.pop(); // gib mir erstes Element und lösche es aus Liste
            if (current.val == val) {
                return current;
            }
            if (current.left != null) {
               zahlen.add(current.left);
            }
            if (current.right != null) {
                zahlen.add(current.right);
            }
        }
        return null;
    }
    public boolean isMonotonic(int[] nums) {
        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                decreasing = false;
            }
            if (nums[i] < nums[i - 1]) {
                increasing = false;
            }
        }

        return increasing || decreasing;
    }
    public int furthestDistanceFromOrigin(String moves) {
        int countL = 0;
        int countR = 0;
        int count_ = 0;
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'L') {
                countL++;
            } else if (moves.charAt(i) == 'R') {
                countR++;
            } else {
                count_++;
            }

        }
        if (countL > countR) {
            return Math.abs(countR - (countL + count_));
        } else {
            return -countL + countR + count_;
        }
    }
    public int returnToBoundaryCount(int[] nums) {
        int output = 0;
        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            current = current + nums[i];
            if (current == 0) {
                output++;
            }
        }
        return output;
    }
    public int totalMoney(int n) {
        int output = 0;
        int monday = 0;
        int current = monday;
        for (int i = 0; i < n; i++) {
            if (i % 7 == 0) {
                monday++;
                output += monday;
                current = monday + 1;
            } else {
                output += current;
                current++;
            }
        }

        return output;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; } // Konstruktor, mit dem man ListNode erstellt
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode start = head;
        while (start != null && start.next != null) {
            ListNode folgeknoten = start.next;
            ListNode neuerknoten = new ListNode(hilfsfunktion(start.val, folgeknoten.val), folgeknoten);
            start.next = neuerknoten;
            start = folgeknoten; // start aktualisieren für neue Iteration mit neuen Werten
        }
        return head;
    }
    private int hilfsfunktion(int a, int b) {
        if (b==0) {
            return a;
        }
        return hilfsfunktion(b, a % b);
    }
    public List<String> commonChars(String[] words) {
        Map<Character, Integer> ordner = new HashMap<>();
        String tmp = words[0];
        for (int i = 0; i < tmp.length(); i++) {
            char c = tmp.charAt(i);
            ordner.put(c, ordner.getOrDefault(c, 0) + 1);
        }
        for (int i = 1; i < words.length; i++) {
            String s = words[i];
            Map<Character, Integer> compareMap = new HashMap<>();
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                compareMap.put(c, compareMap.getOrDefault(c, 0) + 1);
            }

            Map<Character, Integer> resultMap = new HashMap<>();
            for (char c : ordner.keySet()) {
                if (!compareMap.containsKey(c)) {
                    continue; // überspringt diese Iteration
                }
                int min = Math.min(ordner.get(c), compareMap.get(c));
                resultMap.put(c, min);
            }
            ordner = resultMap;
        }

        List<String> output = new ArrayList<>();
        for (Character c : ordner.keySet()) {
            for (int i = 0; i < ordner.get(c); i++) {
                output.add(String.valueOf(c));
            }
        }
        return output;
    }
    public int[] recoverOrder(int[] order, int[] friends) {
        int [] output = new int[friends.length];
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < friends.length; i++) {
            set.add(friends[i]);
        }
        int index = 0;
        for(int i = 0; i < order.length; i++) {
            if (set.contains(order[i])) {
                output[index++] = order[i];
            }
        }
        return output;
    }
    public int prefixCount(String[] words, String pref) {
        int output = 0;
        for (String word : words) {
            if (word.startsWith(pref)) {
                output++;
            }
        }
        return output;
    }
    public void reverseString(char[] s) { //void returnt nichts, da pass by reference d.h. der speicherplatz wird verändert und bei Testaufruf in Leetcode wird dann der "neue" char Array aufgerufen
        for (int i = 0; i < s.length / 2; i++) {
            char begin = s[i];
            char end = s[s.length - 1 - i];
            s[i] = end;
            s[s.length - 1 - i] = begin;
        }
    }

    public void reverseString2(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;
            j--;
        }
    }
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int [] ans  = new int [2];
        Map <Integer, Integer> ordner = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                ordner.put(grid[i][j], ordner.getOrDefault(grid[i][j], 0) + 1 );
            }
        }
        Set<Integer> jani = ordner.keySet();
        for (int key : jani) {
            if (ordner.get(key) == 2) {
                ans[0] = key;
            }
        }
        for (int i = 1; i <= grid.length * grid.length; i++) {
            if (!ordner.containsKey(i)) {
                ans[1] = i;
            }
        }
        return ans;
    }
    public int minimumSum(int num) {
        int[] digits = new int[4];
        for (int i = 0; i < 4; i++) {
            digits[i] = num % 10;
            num /= 10;
        }
        Arrays.sort(digits);

        int new1 = digits[0] * 10 + digits[2];
        int new2 = digits[1] * 10 + digits[3];

        return new1 + new2;
    }
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            StringBuilder sb = new StringBuilder();
            boolean beforeAt = true;
            boolean plusFound = false;
            for (int j = 0; j < email.length(); j++) {
                char buchstabe = email.charAt(j);

                if (buchstabe == '+') {
                    plusFound = true;
                }
                if (buchstabe == '@') {
                    beforeAt = false;
                }
                if (plusFound && beforeAt) {
                    continue;
                }
                if (beforeAt && buchstabe == '.') {
                    continue;
                }

                sb.append(buchstabe);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
    public boolean checkRecord(String s) {
        int absent = 0;
        int late = 0;
        for(int i = 0; i < s.length(); i++) {
            char buchstabe = s.charAt(i);
            if (late >= 3 || absent >= 2) {
                return false;
            }
            if (buchstabe == 'L') {
                late++;
                continue;
            } else if (buchstabe == 'A') {
                absent++;
            }
            late = 0;

        }
        return late < 3 && absent < 2;
    }

    public boolean checkRecordEasy(String s) {
        if (s.contains("LLL") || s.indexOf("A") != s.lastIndexOf("A")) {
            return false;
        }
        return true;
        // return !s.contains("LLL") && s.indexOf("A") == s.lastIndexOf("A");
    }
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat.length * mat[0].length != c * r) {
            return mat;
        }
        int[][] reshapeM = new int[r][c];
        int row = 0;
        int col = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                reshapeM[row][col] = mat[i][j];
                col++;
                if (col >= c) {
                    col = 0;
                    row++;
                }
            }
        }
        return reshapeM;
    }
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> zahlordner = new HashMap<>();
        for (int i = 0;  i < arr.length; i++) {
            zahlordner.put(arr[i], zahlordner.getOrDefault(arr[i], 0) +1);
        }
        Set<Integer> jani = zahlordner.keySet();
        List<Integer> seen = new ArrayList<>();
        for (int key : jani) {
            int freq = zahlordner.get(key);
            if (seen.contains(freq)){
                return false;
            }
            seen.add(freq);
        }
        return true;
    }
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < moves.length(); i++) {
            char buchstabe = moves.charAt(i);
            if (buchstabe == 'R') {
                x++;
            }
            if (buchstabe == 'U') {
                y++;
            }
            if (buchstabe == 'L') {
                x--;
            }
            if (buchstabe == 'D') {
                y--;
            }
        }
        return x == 0 && y == 0;
    }
    public boolean satisfiesConditions(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i < grid.length - 1 && grid[i][j] != grid[i + 1][j]) {
                    return false;
                }
                if (j < grid[i].length - 1 && grid[i][j] == grid[i][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
    public String clearDigits(String s) { // z.B. "cb34"
        boolean digitFound = true;
        while (digitFound) {
            digitFound = false;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if ('0' <= c && c <= '9') {
                    // 1. s == "cb34", c == 3, i = 2
                    //      => s = s.substring(0, 1) + s.substring(3)
                    //      => s = "c" + "4"
                    //      => s = "c4"
                    // 2. s = "c4", c == "4", i = 1
                    //      => s = s.substring(0, 0) + s.substring(2)
                    //      => s = "" + ""
                    //      => s = ""
                    if (i - 1 >= 0) {
                        // "abc" -> "abc".substring(0, 1) -> "a"
                        // "abc" -> "abc".substring(0, 2) => "ab"
                        // "abc" -> "abc".substring(1) => "bc"
                        s = s.substring(0, i - 1) + s.substring(i + 1);
                        digitFound = true;
                        break;
                    }
                }
            }
        }
        return s;
    }
    public int alternatingSum(int[] nums) {
        int output = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                output += nums[i];
            } else {
                output -= nums[i];
            }
        }
        return output;
    }
    public boolean checkString(String s) {
        int a = -1;
        int b = -1;
        for (int i = 0; i < s.length(); i++) {
            char buchstabe = s.charAt(i);
            if (buchstabe == 'a') {
                a = i;
            } else if (b == -1) {
                b = i;
            }
        }
        return a < b || b == -1; // return true wenn a < b
    }

    public boolean checkStringFast(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == 'b' && s.charAt(i + 1) == 'a') { // oder contains Methode nehmen
                return false;
            }
        }
        return true;
    }
    public int majorityElement(int[] nums) {
        int output = 0;
        Map<Integer, Integer> zahlordner = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            zahlordner.put(nums[i], zahlordner.getOrDefault(nums[i], 0) + 1);
        }
        Set<Integer> jani = zahlordner.keySet();
        int max = Integer.MIN_VALUE;
        for (int key : jani) {
            if (zahlordner.get(key) > max && zahlordner.get(key) > (nums.length / 2)) {
                max = zahlordner.get(key);
                output = key;
            }
        }
        return output;
    }
    public int maxNumberOfBalloons(String text) {
        int b = 0, a = 0, l = 0, o = 0, n = 0;

        for (int i = 0; i < text.length(); i++) {
            char buchstabe = text.charAt(i);
            if (buchstabe == 'b') b++;
            else if (buchstabe == 'a') a++;
            else if (buchstabe == 'l') l++;
            else if (buchstabe == 'o') o++;
            else if (buchstabe == 'n') n++;
        }
        l /= 2;
        o /= 2;
        return Math.min(Math.min(Math.min(Math.min(b, a), l), o), n);
    }
    public int findMaxConsecutiveOnes(int[] nums) {
        int output = 0;
        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                current++;
                output = Math.max(output, current);
            } else {
                current = 0;
            }
        }
        return output;
    }
    public int countPrefixes(String[] words, String s) {
        int output = 0;
        for (String w : words) {
            if (s.startsWith(w)) {
                output++;
            }
        }
        return output;
    }
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            boolean left = false;
            boolean right = false;
            if (i == 0 || flowerbed[i - 1] == 0) {
                left = true;
            }
            if (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) {
                right = true;
            }
            if (left && right && flowerbed[i] == 0) {
                flowerbed[i] = 1;
                count++;
            }
        }
        return count >= n;
    }
    public String generateTheString(int n) {
        String output = "";
        for (int i = 0; i < n; i++) {
            char a = 'a';
            char b = 'b';
            if ( i != n - 1 && n % 2 == 0) {
                output += a;
            } else {
                output += b;
            }
        }
        return output;
    }
    public int earliestTime(int[][] tasks) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < tasks.length; i++) {
            int current = 0;
            for (int j = 0; j < tasks[i].length; j++) {
               current += tasks[i][j];
            }
            if (current < min) {
                min = current;
            }
        }
        return min;
    }
    public int gcdOfOddEvenSums(int n) {
        int output = 0;
        int even = 0;
        int odd = 0;
        for (int i = 1; i <= (n * 2); i++) {
            if (i % 2 == 0) {
                even += i;
            } else {
                odd += i;
            }
        }
        for (int i = 1; i <= Math.max(even, odd); i++) {
            if (even % i == 0 && odd % i == 0 && output < i) {
                output = i;
            }
        }
        return output;
    }
    public boolean isArraySpecial(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] % 2 == nums[i +1] % 2) {
                return false;
            }
        }
        return true;
    }

    public int sumOddLengthSubarrays(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            ans += current;
            for (int j = i + 1; j < arr.length; j++) {
                current += arr[j];
                if ((j - i) % 2 == 0) {
                    ans += current;
                }
            }
        }
        return ans;
    }
    public int[] decode(int[] encoded, int first) {
        int [] arr = new int [encoded.length + 1];
        arr[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            arr[i + 1] = encoded[i] ^ arr[i];
        }
        return arr;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> output = new ArrayList<>();
        output.add(List.of(1));
        if (numRows == 1) {
            return output;
        }
        output.add(List.of(1, 1));
        if (numRows == 2) {
            return output;
        }

        for (int i = 2; i < numRows; i++) {
            List<Integer> zwischen = new ArrayList<>();
            zwischen.add(1);
            List<Integer> prev = output.get(i - 1);
            for (int j = 1; j < i; j++) { // exklusiv!!!
                int a = prev.get(j - 1);
                int b = prev.get(j);
                zwischen.add(a + b);
            }
            zwischen.add(1);
            output.add(zwischen);
        }
        return output;
    }
    public int garbageCollection(String[] garbage, int[] travel) {
        int m = 0, g = 0, p = 0, collected = 0;
        int mLast = -1, gLast = -1, pLast = -1;
        for (int i = 0; i < garbage.length; i++) {
            String stop = garbage[i];
            collected += stop.length();
            if (stop.contains("M")) {
                mLast = i - 1;
            }
            if (stop.contains("G")) {
                gLast = i - 1;
            }
            if (stop.contains("P")) {
                pLast = i - 1;
            }
        }
        for (int i = 0; i < travel.length; i++) {
            int path = travel[i];
            if (mLast >= i) {
                m += path;
            }
            if (gLast >= i) {
                g += path;
            }
            if (pLast >= i) {
                p += path;
            }
        }
        return m + g + p + collected;
    }
    public static int simpleArraySum(List<Integer> ar) {
        // Write your code here
        int output = 0;
        for (Integer integer : ar) {
            output += integer;
        }
        return output;
    }
    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> output = new ArrayList<>();
        output.add(0);
        output.add(0);
        for (int i = 0; i < a.size(); i++) {
            int scoreAlice = a.get(i);
            int scoreBob = b.get(i);
            if (scoreAlice > scoreBob) {
                output.set(0, output.get(0) + 1);
            } else if (scoreAlice < scoreBob) {
                output.set(1, output.get(1) + 1);
            }
        }
        return output;
    }
    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int firstdiagonal = 0;
        int seconddiagonal = 0;
        for (int i = 0; i < arr.size(); i++) {
            firstdiagonal += arr.get(i).get(i);
            seconddiagonal += arr.get(i).get(arr.size() - 1 - i);
        }
        return Math.abs(firstdiagonal - seconddiagonal);
    }
    public static int birthdayCakeCandles(List<Integer> candles) {
        int max = Integer.MIN_VALUE;
        Map<Integer, Integer> ordner = new HashMap<>();
        for (int i = 0; i < candles.size(); i++) {
            ordner.put(candles.get(i), ordner.getOrDefault(ordner.get(candles.get(i)), 0) + 1);
        }
        Set<Integer> jani = ordner.keySet();
        for (int key : jani) {
            if (key > max) {
                max = key;
            }
        }
        return ordner.get(max);

    }
    public static long aVeryBigSum(List<Long> ar) {
        long output = 0L;
        for (int i = 0; i < ar.size(); i++) {
            output += ar.get(i);
        }
        return output;
    }
    public static void plusMinus(List<Integer> arr) {
        double positiv = 0;
        double negativ = 0;
        double zero = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == 0) {
                zero++;
            }else if (arr.get(i) < 0) {
                negativ++;
            }else {
                positiv++;
            }
        }
        System.out.println(positiv/arr.size());
        System.out.println(negativ/arr.size());
        System.out.println(zero/arr.size());
    }
    public static void staircase(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("#");
            }
            System.out.println();
        }

    }
    public static void miniMaxSum(List<Integer> arr) {
        Collections.sort(arr);
        long sum_min = 0;
        long sum_max = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (i > 0) {
                sum_max += arr.get(i);
            }
            if (i < arr.size() - 1) {
                sum_min += arr.get(i);
            }
        }
        System.out.println(sum_min + " " + sum_max);
    }
    public static String timeConversion(String s) {
        String meridian = s.substring(s.length() - 2);
        String timePart = s.substring(0, s.length() - 2);

        String[] parts = timePart.split(":");
        int hour = Integer.parseInt(parts[0]);
        String minute = parts[1];
        String second = parts[2];
        if (meridian.equals("AM")) {
            if (hour == 12) {
                hour = 0;
            }
        } else {
            if (hour != 12) {
                hour += 12;
            }
        }
        String hourString = String.format("%02d", hour);
        return hourString + ":" + minute + ":" + second;
    }
    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> output = new ArrayList<>();
        for (int zwischen : grades) {
            if (zwischen < 38) {
                output.add(zwischen);
            } else if (5 - (zwischen % 5) < 3) {
                output.add(zwischen + (5 - (zwischen % 5)));
            } else {
                output.add(zwischen);
            }
        }
        return output;
    }
    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        List <Integer> apples_position = new ArrayList<>();
        List <Integer> oranges_position = new ArrayList<>();
        int count_apples = 0;
        int count_orange = 0;
        for (Integer apple : apples) {
            apples_position.add(a + apple);
        }
        for  (Integer orange : oranges) {
            oranges_position.add(b + orange);
        }
        for (Integer house_apple : apples_position){
            if (s <= house_apple && house_apple<=t) {
                count_apples++;
            }
        }
        for (int house_orange : oranges_position) {
            if (s <= house_orange && house_orange <=t) {
                count_orange++;
            }
        }
        System.out.println(count_apples);
        System.out.println(count_orange);
    }
    public static String kangaroo(int x1, int v1, int x2, int v2) {
        String ja = "YES";
        String nein = "NO";
        if (v1 <= v2) {
            return nein;
        }
        while (x1 < x2) {
            x1 += v1;
            x2 += v2;

            if (x1 == x2) {
                return ja;
            }
        }

        return nein;
    }
    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
        int output = 0;
        for (int i = 0; i < ar.size(); i++) {
            for (int j = 0; j < ar.size(); j++) {
                if (i < j && (ar.get(i) + ar.get(j)) % k == 0) {
                    output++;
                }
            }
        }
        return output;

    }
    public static int migratoryBirds(List<Integer> arr) {
        Map <Integer,Integer> sort = new HashMap<>();
        for (int i = 0; i < arr.size(); i++) {
            sort.put(arr.get(i), sort.getOrDefault(arr.get(i), 0) + 1);
        }
        Set<Integer> jani = sort.keySet();
        int max = Integer.MIN_VALUE;
        int id = -1;
        for (int key : jani) {
            if (sort.get(key) > max) {
                max = sort.get(key);
                id = key;
            } else if (sort.get(key) == max) {
                id = Math.min(key, id);
            }
        }
        return id;

    }
    public static void bonAppetit(List<Integer> bill, int k, int b) {
        int b_actual = 0;
        for (int i = 0; i < bill.size();i++) {
            if (i != k) {
                b_actual += bill.get(i);
            }
        }
        b_actual = b_actual / 2;
        if (b_actual == b) {
            System.out.println("Bon Appetit");
        }else {
            System.out.println(b - b_actual);
        }
    }
    public static int pageCount(int n, int p) {
        int front = 0;
        int behind = 0;
        for (int i = 1; i <= p; i += 2) {
            if (i != p) {
                front++;
            }
        }
        for (int i = n; i >= p; i -= 2) {
            if (n % 2 != 0 && p == i - 1) {
                break;
            }
            if (i != p) {
                behind++;
            }
        }
        return Math.min(front, behind);
    }
    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        List <Integer> costs = new ArrayList<>();
        for (int keyboard : keyboards) {
            for (int drive : drives) {
                if (keyboard + drive <= b){
                    costs.add(keyboard + drive);
                }
            }
        }
        int max = -1;
        for (int cost : costs) {
            if (cost > max) {
                max = cost;
            }
        }
        return max;
    }
    public static int sockMerchant(int n, List<Integer> ar) {
        Map<Integer,Integer> pair = new HashMap<>();
        int output = 0;
        for (int i = 0; i < ar.size(); i++) {
            pair.put(ar.get(i), pair.getOrDefault(ar.get(i), 0) + 1);
        }
        Set <Integer> jani = pair.keySet();
        for (int key : jani) {
            if (pair.get(key) > 1) {
                output += (pair.get(key) / 2);
            }
        }
        return output;
    }
    static String catAndMouse(int x, int y, int z) {
        String catA = "Cat A";
        String catB = "Cat B";
        String mouse = "Mouse C";
        if (Math.abs(x-z) < Math.abs(y-z)) {
            return catA;
        } else if (Math.abs(x-z) > Math.abs(y-z)) {
            return catB;
        } else {
            return mouse;
        }

    }
    public static int hurdleRace(int k, List<Integer> height) {
        int output = 0;
        for (int hurdle : height) {
            if (hurdle > output) {
                output = hurdle;
            }
        }
        if (k > output) {
            return 0;
        }
        return output - k;
    }
    public static int designerPdfViewer(List<Integer> h, String word) {
        List<Integer> heights = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            char buchstabe = word.charAt(i);
            int index = buchstabe - 'a';
            heights.add(h.get(index));
        }
        int max = Integer.MIN_VALUE;
        for (int i : heights) {
            if (i > max) {
                max = i;
            }
        }
        return max * word.length();
    }
    public static String angryProfessor(int k, List<Integer> a) {
        int count = 0;
        for (int time: a) {
            if (time <= 0){
                count++;
            }
        }
        if (count >= k) {
            return "NO";
        }
        return "YES";
    }
    public static int beautifulDays(int i, int j, int k) {
        int output = 0;
        for (int r = i; r <= j; r++) {
            String zwischen = String.valueOf(r);
            StringBuilder res = new StringBuilder();
            res.append(zwischen);
            res.reverse();
            if (Math.abs(r - Integer.parseInt(res.toString())) % k == 0) {
                output++;
            }
        }
        return output;

    }
    public static int viralAdvertising(int n) {
        int output = 2;
        int start = 2;
        for (int i = 2; i <= n; i++) {
            int zwischen = start * 3;
            output += zwischen / 2;
            start = zwischen / 2;
        }
        return output;

    }

    public static int saveThePrisoner(int n, int m, int s) {
        return ((s - 1 + m - 1) % n) + 1;
    }
    public static int findDigits(int n) {
        String zahl = String.valueOf(n);
        int count = 0;
        for (int i = 0; i < zahl.length(); i++) {
            char separat_number = zahl.charAt(i);
            int translate = Character.getNumericValue(separat_number);
            if (translate != 0 && n % translate == 0) {
                count++;
            }
        }
        return count;
    }
}
