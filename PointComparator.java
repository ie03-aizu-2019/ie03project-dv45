package ex1;

import java.util.Comparator;

public class PointComparator implements Comparator<Point> {


	public int compare(Point a, Point b) {
		if( a.getPointX() > b.getPointX()) {
			return 1;
		}else if(a.getPointX() == b.getPointX()) {
			if(a.getPointY() > b.getPointY()) {
				return 1;
			}else {
				return -1;
			}
		}else {
			return -1;
		}
	}
}
