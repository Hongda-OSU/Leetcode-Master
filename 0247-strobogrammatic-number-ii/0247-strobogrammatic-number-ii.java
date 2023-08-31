class Solution {
    private List<String> result;
    
    public List<String> findStrobogrammatic(int n) {
        result = new ArrayList<>();
        findStrobogrammaticHelper(new char[n], 0, n - 1);
        return result;
    }
    
    private void findStrobogrammaticHelper(char[] arr, int left, int right) {
        if (left > right) {
            result.add(new String(arr));
            return;
        }
        if (left == right) {
            arr[left] = '0';
            result.add(new String(arr));
            arr[left] = '1';
            result.add(new String(arr));
            arr[left] = '8';
            result.add(new String(arr));
            return;
        }
        if (left != 0) {
            arr[left] = '0';
            arr[right] = '0';
            findStrobogrammaticHelper(arr, left + 1, right - 1);
        }
        arr[left] = '1';
        arr[right] = '1';
        findStrobogrammaticHelper(arr, left + 1, right - 1);
        arr[left] = '8';
        arr[right] = '8';
        findStrobogrammaticHelper(arr, left + 1, right - 1);
        arr[left] = '6';
        arr[right] = '9';
        findStrobogrammaticHelper(arr, left + 1, right - 1);
        arr[left] = '9';
        arr[right] = '6';
        findStrobogrammaticHelper(arr, left + 1, right - 1);
    }
}