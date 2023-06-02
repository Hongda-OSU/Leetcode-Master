class Solution {
    public int oddEvenJumps(int[] arr) {
        
        int[] count = new int[100001];
        boolean[][] res = new boolean[2][arr.length];
        res[0][arr.length - 1] = true;
        res[1][arr.length - 1] = true;
        count[arr[arr.length - 1]] = arr.length;
        int min = arr[arr.length - 1], max = arr[arr.length - 1];
        int result = 1;
        for(int i = arr.length - 2; i >= 0; i--) {
            int nextSmallIndex = findNextSmall(count, min, max, arr[i]);
            int nextLargeIndex = findNextLarge(count, min, max, arr[i]);
            if(nextSmallIndex == -1) {
                res[0][i] = false;
            } else {
                res[0][i] = res[1][nextSmallIndex];
            }

            if(nextLargeIndex == -1) {
                res[1][i] = false;
            } else {
                res[1][i] = res[0][nextLargeIndex];
            }

            count[arr[i]] = i + 1;
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            // System.out.println(arr[i] + " " + nextSmallIndex + " " + nextLargeIndex + " " + i + " " + res[0][i] + " " + res[1][i]);
            if(res[0][i]) {
                result++;
            }
        }

        return result;

    }

    int findNextSmall(int[] count, int min, int max, int val) {

        for(int i=val; i <= max; i++) {
            if(count[i] != 0) {
                return count[i]-1;
            }
        }
        return -1;
    }

    int findNextLarge(int[] count, int min, int max, int val) {

        for(int i=val; i >= min; i--) {
            if(count[i] != 0) {
                return count[i]-1;
            }
        }
        return -1;
    }
}