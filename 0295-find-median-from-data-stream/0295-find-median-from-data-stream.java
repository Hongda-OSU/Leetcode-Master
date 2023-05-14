import java.io.*; 
import java.util.*; 
import java.lang.*;

class MyComparator implements Comparator<int[]>{
	public int compare(int[] a, int[] b) {
		if (a[0]!=b[0]) {
			return a[0] - b[0];
		}
		return a[1] - b[1];
	}
}


class MedianFinder {
	int time;
	MyComparator MyCom;

    /** initialize your data structure here. */
	TreeSet<int[]> set ;
	int[] point1;
	int[] point2;
	public MedianFinder() {
        time = 0;
        MyCom = new MyComparator();
        set = new TreeSet<>(MyCom);
    }
	
    public void addNum(int num) {
    	int[] item = new int[] {num, time++};
        set.add(item);
        if (time == 1) {
        	point1 = set.first();
        	point2 = set.first();
        	return;
        }
                
        if (point1 == point2) {
        	if (MyCom.compare(item, point1)<0) {
        		point2 = point1;
        		point1 = set.lower(point1);
        	}
        	else {
        		point1 = point2;
        		point2 = set.higher(point2);
        	}
        	return;
        }
        
        if (point1 != point2) {
        	if (MyCom.compare(item, point1) < 0) {
        		point2 = point1;
        	}
        	else if (MyCom.compare(item, point2) > 0) {
        		point1 = point2;
        	}
        	else {
        		point1 = item;
        		point2 = item;
        	}
        }
    }
    
    public double findMedian() {
        return ((double)point1[0] + (double)point2[0])/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */