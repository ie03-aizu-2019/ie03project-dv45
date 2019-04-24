package ex1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ex1 {

	public static void main(String args[]) {

		Input input = new Input();

		int N, M, P, Q;
		int x, y;
		int t1, t2;

		int array[] = new int[4];
		input.isNum(array);
		N = array[0];
		M = array[1];
		P = array[2];
		Q = array[3];

		Point point[] = new Point[N];
		for(int i = 0;i < N;i++) {
			point[i] = new Point();
		}

		int xy[] = new int[2];
		for(int i=0; i<N; i++) {
			if(input.isNum(xy) == true) {
				x = xy[0];
				y = xy[1];
				point[i].setPoint(x, y);
			} else {
				System.exit(0);
			}
		}
		/*
		for(int i=0; i<N; i++) {
			System.out.print(point[i].x);
			System.out.println(point[i].y);
		}*/

		Line line[] = new Line[M];
		for(int i = 0;i < M;i++) {
			line[i] = new Line();
		}

		int tie[] = new int[2];
		for(int i=0; i<M; i++) {
			if(input.isNum(tie) == true) {
				t1 = (int)tie[0];
				t2 = (int)tie[1];
				line[i].setLine(point[t1-1], point[t2-1]);
			} else {
				System.exit(0);
			}
		}
		/*for(int i = 0;i < line.length; i ++) {
			System.out.println(line[i].getPointP().getPointX() + "    " + line[i].getPointP().getPointY());
			System.out.println(line[i].getPointQ().getPointX() + "    " + line[i].getPointQ().getPointY());
		}*/
	/*	System.out.println(point[0].getPointX() + "    " + point[0].getPointY());
		System.out.println(point[1].getPointX() + "    " + point[1].getPointY());
		System.out.println(point[2].getPointX() + "    " + point[2].getPointY());
		System.out.println(point[3].getPointX() + "    " + point[3].getPointY());
*/

		Calc c = new Calc();
		double ans[] = new double[2];
		boolean flag = false;
		List<Point> list = new ArrayList<>();
		int count = 0;

		for(int i=0; i<line.length; i++) {
			for(int j=i + 1; j<line.length; j++) {
				flag = c.calc(line[i], line[j], ans);

				if(flag == true) {
					Point set = new Point();
					set.setPoint(ans[0], ans[1]);
					list.add(new Point());
					list.set(count++, set);
				//	System.out.println(bdx.doubleValue() +" "+ bdy.doubleValue());
				} else {
				//	System.out.println("NA");
				}
			}
		}

		Point min = new Point();
		min.setPoint(list.get(0).getPointX(), list.get(0).getPointY());

		/*for(int i = 1;i < list.size();i++) {
				Collections.sort(list,new PointComparator());
		}*/


		for(Iterator<Point>itr = list.iterator(); itr.hasNext();) {
			Point p = itr.next();
			BigDecimal bd1 = new BigDecimal(p.getPointX());
			BigDecimal bd2 = new BigDecimal(p.getPointY());
			BigDecimal bdx = bd1.setScale(5,BigDecimal.ROUND_UP);
			BigDecimal bdy = bd2.setScale(5,BigDecimal.ROUND_UP);
			System.out.println(bdx.doubleValue() + " " + bdy.doubleValue());
		}





	}

}
