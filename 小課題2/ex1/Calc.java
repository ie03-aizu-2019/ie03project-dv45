package ex1;

public class Calc {


	public boolean calc(Line l1,Line l2,double[] ans) {

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
}
