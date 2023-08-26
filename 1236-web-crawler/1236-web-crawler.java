/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */

class Solution {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        Set<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        String hostName = getHostName(startUrl);
        queue.offer(startUrl);
        set.add(startUrl);
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            for (String url : htmlParser.getUrls(curr)) {
                if (url.contains(hostName) && !set.contains(url)) {
                    queue.offer(url);
                    set.add(url);
                }
            }
        }
        return new ArrayList<>(set);
    }
    
    private String getHostName(String url) {
        String[] str = url.split("/");
        return str[2];
    }
}