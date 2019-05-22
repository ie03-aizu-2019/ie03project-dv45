package ex1;

import java.util.List;

public class Calc {

	public boolean cross(Line l1,Line l2,double[] ans) {

		double detA = (l1.getPointQ().getPointX() - l1.getPointP().getPointX()) * (l2.getPointP().getPointY() - l2.getPointQ().getPointY()) + (l2.getPointQ().getPointX() - l2.getPointP().getPointX()) * (l1.getPointQ().getPointY() - l1.getPointP().getPointY());
		double s,t,x,y;
		if(Math.pow(10,-8) <= detA && detA <= Math.pow(10,-7)){
			System.out.println("f1");
			return false;
		}else {
			s = (1 / detA) * ((l2.getPointP().getPointY() - l2.getPointQ().getPointY()) * (l2.getPointP().getPointX() - l1.getPointP().getPointX()) + (l2.getPointQ().getPointX() - l2.getPointP().getPointX()) * (l2.getPointP().getPointY() - l1.getPointP().getPointY()));

			t = (1 / detA) * ((l1.getPointP().getPointY() - l1.getPointQ().getPointY()) * (l2.getPointP().getPointY() - l1.getPointP().getPointY()) + (l1.getPointQ().getPointX() - l1.getPointP().getPointX()) * (l2.getPointP().getPointY() - l1.getPointP().getPointY()));

			if(0 <= s && s <= 1 && 0 <= t && t <= 1) {
			//	System.out.println(s + " " + t + " " + detA);

				x = l1.getPointP().getPointX() + (l1.getPointQ().getPointX() - l1.getPointP().getPointX()) * s;
				y = l1.getPointP().getPointY() + (l1.getPointQ().getPointY() - l1.getPointP().getPointY()) * s;

				if((x == l1.getPointP().getPointX() && y == l1.getPointP().getPointY()) || (x == l1.getPointQ().getPointX() && y == l1.getPointQ().getPointY()) || (x == l2.getPointP().getPointX() && y == l2.getPointP().getPointY()) || (x == l2.getPointQ().getPointX() && y == l2.getPointQ().getPointY())) {
					return false;
				}
				ans[0] = x;
				ans[1] = y;
			}else {
				return false;
			}
		}
		return true;
	}
//　道を探索し、その経路の長さを代入
	public boolean Route(List<NodeP> graph,Point[] rout,double cost) {
		
		Point s = rout[0];
		Point g = rout[1];
		NodeP node = new NodeP();
		NodeP process = new NodeP();
		while(true) {
			for(int i = 0;i < graph.size();i ++) {
				if(graph.get(i).getPointX() == s.getPointX() && graph.get(i).getPointY() == s.getPointY()) {
					cost = 0;
					node = graph.get(i);
					node.setCost();
					graph.get(i).tCheck();

				}
				if(node.getCheck() == 0 || node.getCost() == 0) {
					continue;
				}	
				if(process == null) {
					process = node;
					continue;
				}
				if(node.cost < )
			}
		}
	}


	public double FuncJudge(Point p,Point q,Point search) {
		return ((q.getPointY() -p.getPointY()) / q.getPointX() - p.getPointX());
	}

	//2点間の距離を計算
	double Dist(Point P,Point Q) {
		return Math.sqrt((Math.pow(Q.getPointX() - P.getPointX(),2)) + Math.pow(Q.getPointY() - P.getPointY(),2));
	}

	//点が直線に含まれているか探索する // いらないかも
	boolean JonLine(Point p,Line l) {
		if(p.getPointY() == (l.getPointQ().getPointY() - l.getPointP().getPointY()) / (l.getPointQ().getPointX() - l.getPointP().getPointX()) * (p.getPointX() - l.getPointP().getPointX()) + l.getPointP().getPointY()) {
			return true;
		}else {
			return false;
		}
	}
}
