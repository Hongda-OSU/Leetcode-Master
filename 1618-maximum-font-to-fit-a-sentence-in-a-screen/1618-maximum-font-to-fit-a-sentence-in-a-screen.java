/**
 * // This is the FontInfo's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface FontInfo {
 *     // Return the width of char ch when fontSize is used.
 *     public int getWidth(int fontSize, char ch) {}
 *     // Return Height of any char when fontSize is used.
 *     public int getHeight(int fontSize)
 * }
 */
class Solution {
    public int maxFont(String text, int w, int h, int[] fonts, FontInfo fontInfo) {
        int left = 0, right = fonts.length - 1, result = -1;
        while (left <= right) {
            int pivot = (left + right) >>> 1;
            if (findWidth(text, fonts[pivot], fontInfo) <= w && fontInfo.getHeight(fonts[pivot]) <= h) {
                result = fonts[pivot];
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return result;
    }
    
    public int findWidth(String text, int font, FontInfo fontInfo) {
        int width = 0;
        for (char ch : text.toCharArray())
            width += fontInfo.getWidth(font, ch);
        return width;
    }
}