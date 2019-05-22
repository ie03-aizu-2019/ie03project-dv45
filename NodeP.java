package ex1;

import java.util.*;

public class NodeP extends Point{
	List<Point> next = new ArrayList<>();
	Point now,pre;
	List<Double> dist = new ArrayList<>();
	int check,cost = -1;

	public void setNode(Point n) {
		this.now = n;
		this.check = 0;
		this.pre = null;
	}
	
	public void addNode(Point q,double d) {
		this.next.add(q);
		this.dist.add(d);
	}

	public void setCost() {
		this.cost = 0;
	}
	
	public Point getNow() {
		return this.now;
	}

	public Point getNext(int i) {
		return this.next.get(i);
	}

	public double getDist(int i) {
		return this.dist.get(i);
	}

	public int getCheck() {
		return this.check;
	}
	
	public void tCheck() {
		this.check = -1;
	}
	
	public int getCost() {
		return this.cost;
	}

	public void printNode() {
		for(int i = 0;i < this.next.size();i++) {
			System.out.print(String.format("%.5f",this.now.getPointX()) + " " + String.format("%.5f", this.now.getPointY()) + " ");
			System.out.print(String.format("%.5f",this.next.get(i).getPointX()) + " " + String.format("%.5f", this.next.get(i).getPointY()) + " ");
			System.out.print(String.format("%.5f", this.dist.get(i)) + " ");
		}
	}
}
