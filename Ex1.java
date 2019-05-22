package ex1;

import java.util.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ex1 {

	public static void main(String args[]) {
		
		Input input = new Input();
		Calc c = new Calc();
		MakeNode manageN = new MakeNode();

		int N, M, P, Q;
		final int Rnum = 3;
		int x, y;
		int t1, t2;
		List<Point> list = new ArrayList<>();
		List<NodeP> graph = new ArrayList<>();

		int array[] = new int[4];
		input.isNum(array);
		N = array[0];
		M = array[1];
		P = array[2];
		Q = array[3];

//探索用にPointを入力するための配列
		int[] rank = new int[Q];
		Point[][] rout = new Point[Q][Rnum - 1];
		for(int i = 0;i < Q;i++) {
			for(int j = 0;j < Rnum - 1;j++) {
				rout[i][j] = new Point();
			}
		}
//点を設定するための入力配列
		Point point[] = new Point[N];
		for(int i = 0;i < N;i++) {
			point[i] = new Point();
		}
		
//点の入力
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
//点の番号から直線を作る
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
			//	System.out.println(line[i].getPointP().getPointX() + " " + line[i].getPointP().getPointY() + " " + line[i].getPointQ().getPointX() + " " + line[i].getPointQ().getPointY());
			} else {
				System.exit(0);
			}
		}

// 直線のGraphを作成
		manageN.makeN(line, graph);

		/*for(int i = 0;i < line.length; i ++) {
			System.out.println(line[i].getPointP().getPointX() + "    " + line[i].getPointP().getPointY());
			System.out.println(line[i].getPointQ().getPointX() + "    " + line[i].getPointQ().getPointY());
		}*/
	/*	System.out.println(point[0].getPointX() + "    " + point[0].getPointY());
		System.out.println(point[1].getPointX() + "    " + point[1].getPointY());
		System.out.println(point[2].getPointX() + "    " + point[2].getPointY());
		System.out.println(point[3].getPointX() + "    " + point[3].getPointY());
*/

//交点の検索と、もし交点があった場合のグラフの追加
		
		double ans[] = new double[2];
		boolean flag = false;
		int count = 0;

		
		for(int i=0; i<line.length; i++) {
			for(int j=i + 1; j<line.length; j++) {
				flag = c.cross(line[i], line[j], ans);

				if(flag == true) {
					Point set = new Point();
					set.setPoint(ans[0], ans[1]);
					list.add(new Point());
					list.set(count, set);
					manageN.addN(line[i], line[j], set, graph);
					count++;
				//	System.out.println(bdx.doubleValue() +" "+ bdy.doubleValue());
				} else {
				//	System.out.println("NA");
				}
			}
		}

		Point min = new Point();
		min.setPoint(list.get(0).getPointX(), list.get(0).getPointY());

		
		for(int i = 0;i < Q;i++) {
			 if(!(input.isP(Rnum, rout[i], point, list, rank[i]))) {
				 
			 }
		//この状態だと要素にnullが入っている可能性があるため経路検索時に確認するコードが必要
		}
		
		System.out.println();
		
		/*for(int i = 1;i < list.size();i++) {
				Collections.sort(list,new PointComparator());
		}*/

		for(Point p : list) {
			System.out.println(String.format("%.5f", p.getPointX()) + " " + String.format("%.5f", p.getPointY()));
		}
		
		
		System.out.println(graph.size());
		for(int i = 0;i < graph.size();i++) {
			graph.get(i).printNode();
			System.out.println();
		}
	}

}
