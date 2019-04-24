package ex1;

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

		int xy[] = new int[M];
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

		int tie[] = new int[M];
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
		double ans[] = new double[N];
		boolean flag = false;

		for(int i=0; i<line.length; i++) {
			for(int j=i + 1; j<line.length; j++) {
				flag = c.calc(line[i], line[j], ans);
			}
			if(flag == true) {
				System.out.println(ans[0]+" "+ans[1]);
				System.exit(0);
			} else {

			}
		}

		if(flag == false) {
			System.out.println("NA");
		}

	}

}
