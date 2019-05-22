package ex1;
import java.util.List;

// Nodeを登録していくためのクラス

public class MakeNode {

	Calc calc = new Calc();
	public void makeN(Line[] line,List<NodeP> graph) {

		for (int i = 0;i < line.length;i++) {
			int check = 0;
			NodeP set = new NodeP();
			set.setNode(line[i].getPointP());
			for(int j = 0;j <graph.size();j++) {
				if(set.getNow().getPointX() == graph.get(j).getPointX() && set.getNow().getPointY() == graph.get(j).getPointY()) {
					graph.get(j).addNode(line[i].getPointQ(),calc.Dist(line[i].getPointP(), line[i].getPointQ()));
					check = 1;
					break;
				}
			}
			if(check == 0) {
				set.addNode(line[i].getPointQ(),calc.Dist(line[i].getPointP(), line[i].getPointQ()));
				graph.add(set);
			}
			
			check = 0;
			
				set = new NodeP();
			//	System.out.println(set.getNow().getPointX() + "  " + set.getNow().getPointY() + " " + set.getNext().getPointX() + "  " + set.getNext().getPointY());
				set.setNode(line[i].getPointQ());
				for(int j = 0;j <graph.size();j++) {
					if(set.getNow().getPointX() == graph.get(j).getPointX() && set.getNow().getPointY() == graph.get(j).getPointY()) {
						graph.get(j).addNode(line[i].getPointP(),calc.Dist(line[i].getPointP(), line[i].getPointQ()));
						check = 1;
						break;
					}
				}
				if(check == 0) {
					set.addNode(line[i].getPointP(),calc.Dist(line[i].getPointP(), line[i].getPointQ()));
					graph.add(set);
				}
			//	System.out.println(set.getNow().getPointX() + "  " + set.getNow().getPointY() + " " + set.getNext().getPointX() + "  " + set.getNext().getPointY());
			}
	}


	public void addN(Line A,Line B,Point p,List<NodeP> graph) {
		int check = 0;
		NodeP set = new NodeP();
		set.setNode(A.getPointP());
		for(int i = 0;i < graph.size();i++) {
			if(set.getNow().getPointX() == graph.get(i).getPointX() && set.getNow().getPointY() == graph.get(i).getPointY()) {
				graph.get(i).addNode(p,calc.Dist(A.getPointP(), p));
				check = 1;
				break;
			}
		}
		if(check == 0) {
			set.addNode(p,calc.Dist(A.getPointP(), p));
			graph.add(set);
		}
		check = 0;
		
		set = new NodeP();
		set.setNode(p);
		for(int i = 0;i < graph.size();i++) {
			if(set.getNow().getPointX() == graph.get(i).getPointX() && set.getNow().getPointY() == graph.get(i).getPointY()) {
				graph.get(i).addNode(A.getPointP(), calc.Dist(A.getPointP(),p));
				check = 1;
				break;
			}
		}
		if(check == 0) {
			set.addNode(A.getPointP(), calc.Dist(A.getPointP(),p));
			graph.add(set);
		}
		
		check = 0;
		set = new NodeP();
		set.setNode(A.getPointQ());
		for(int i = 0;i < graph.size();i++) {
			if(set.getNow().getPointX() == graph.get(i).getPointX() && set.getNow().getPointY() == graph.get(i).getPointY()) {
				graph.get(i).addNode(p, calc.Dist(A.getPointQ(),p));
				check = 1;
				break;
			}
		}
		if(check == 0) {
			set.addNode(p, calc.Dist(A.getPointQ(),p));
			graph.add(set);
		}
		
		check = 0;
		
		set = new NodeP();
		set.setNode(p);
		for(int i = 0;i < graph.size();i++) {
			if(set.getNow().getPointX() == graph.get(i).getPointX() && set.getNow().getPointY() == graph.get(i).getPointY()) {
				graph.get(i).addNode(A.getPointQ(), calc.Dist(A.getPointQ(),p));
				check = 1;
				break;
			}
		}
		if(check == 0) {
			set.addNode(A.getPointQ(), calc.Dist(A.getPointQ(),p));
			graph.add(set);
		}
		
		check = 0;
		
		set = new NodeP();
		set.setNode(B.getPointP());
		for(int i = 0;i < graph.size();i++) {
			if(set.getNow().getPointX() == graph.get(i).getPointX() && set.getNow().getPointY() == graph.get(i).getPointY()) {
				graph.get(i).addNode(p, calc.Dist(B.getPointP(),p));
				check = 1;
				break;
			}
		}
		if(check == 0) {
			set.addNode(p, calc.Dist(B.getPointP(),p));
			graph.add(set);
		}
		
		check = 0;
		set = new NodeP();
		set.setNode(p);
		for(int i = 0;i < graph.size();i++) {
			if(set.getNow().getPointX() == graph.get(i).getPointX() && set.getNow().getPointY() == graph.get(i).getPointY()) {
				graph.get(i).addNode(B.getPointP(), calc.Dist(B.getPointP(),p));
				check = 1;
				break;
			}
		}
		if(check == 0) {
			set.addNode(B.getPointP(), calc.Dist(B.getPointP(),p));
			graph.add(set);
		}
		
		check = 0;
		set = new NodeP();
		set.setNode(B.getPointQ());
		for(int i = 0;i < graph.size();i++) {
			if(set.getNow().getPointX() == graph.get(i).getPointX() && set.getNow().getPointY() == graph.get(i).getPointY()) {
				graph.get(i).addNode(p, calc.Dist(B.getPointQ(),p));
				check = 1;
				break;
			}
		}
		if(check == 0) {
			set.addNode(p, calc.Dist(B.getPointQ(),p));
			graph.add(set);
		}
		
		check = 0;
		set = new NodeP();
		set.setNode(p);
		for(int i = 0;i < graph.size();i++) {
			if(set.getNow().getPointX() == graph.get(i).getPointX() && set.getNow().getPointY() == graph.get(i).getPointY()) {
				graph.get(i).addNode(B.getPointQ(), calc.Dist(B.getPointQ(),p));
				check = 1;
				break;
			}
		}
		if(check == 0) {
			set.addNode(B.getPointQ(), calc.Dist(B.getPointQ(),p));
			graph.add(set);
		}
	}
}


// Point配列と交点は別々に作る必要ありそう
// 交点を探すときに呼び出し、line２本と交点から作ったNodeをlistに追加する