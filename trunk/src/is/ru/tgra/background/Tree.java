package is.ru.tgra.background;

import is.ru.tgra.view.Point3D;

public class  Tree {
	TreeTop tt;
	TreeBottom tb;
	Point3D position;
	
	public Tree(Point3D position) {
		this.position = position;
		tb = new TreeBottom(new Point3D(position.x, position.y, 0));
		tt = new TreeTop(new Point3D(tb.getPosition().x, tb.getPosition().y + 150, 0));
	}
	
	public void draw() {
		tb.draw();
		tt.draw();		
	}
	
	public void setPosition(Point3D newPos) {
		position = newPos;
		tt.setPosition(new Point3D(newPos.x, newPos.y + 150.0f, newPos.z));
		tb.setPosition(newPos);
	}
	
	public Point3D getPosition() {
		return new Point3D(position.x, position.y, position.z);
	}
}
