/**
 * Definition for polynomial singly-linked list.
 * class PolyNode {
 *     int coefficient, power;
 *     PolyNode next = null;
 
 *     PolyNode() {}
 *     PolyNode(int x, int y) { this.coefficient = x; this.power = y; }
 *     PolyNode(int x, int y, PolyNode next) { this.coefficient = x; this.power = y; this.next = next; }
 * }
 */

class Solution {
    public PolyNode addPoly(PolyNode poly1, PolyNode poly2) {
        if (poly1 == null)
            return poly2;
        if (poly2 == null)
            return poly1;
        PolyNode high = new PolyNode(), low = new PolyNode(), prev = null, start = new PolyNode();
        if (poly1.power < poly2.power) {
            high = poly2;
            low = poly1;
        } else {
            high = poly1;
            low = poly2;
        }
        start.next = high;
        prev = start;
        while (high != null && low != null) {
            if (high.power > low.power) {
                high = high.next;
                prev = prev.next;
            } else if (high.power == low.power) {
                high.coefficient += low.coefficient;
                if (high.coefficient == 0) {
                    high = high.next;
                    prev.next = high;
                } else {
                    high = high.next;
                    prev = prev.next;
                }
                low = low.next;
            } else {
                PolyNode tmp = low;
                low = low.next;
                prev.next = tmp;
                tmp.next = high;
                prev = prev.next;
            }
        }
        if (low != null)
            prev.next = low;
        return start.next;
    }
}