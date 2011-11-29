package is.ru.tgra.background;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL11;
import com.badlogic.gdx.utils.BufferUtils;
import is.ru.tgra.view.Point3D;

import java.nio.FloatBuffer;

public class TreeTop {
	protected Point3D position;
	
	float rotation;
	
	public TreeTop(Point3D position) {
		this.position = new Point3D(position.x, position.y, position.z);
		this.rotation = 0;
		this.init();
	}
	
	public TreeTop(Point3D position, float rotation) {
		this.position = new Point3D(position.x, position.y + 150, position.z);
		this.rotation = rotation;
		this.init();
	}
	
	private void init() {
	}
	
	public Point3D getPosition() {
		return this.position;
	}
	
	public void rotate(float rotation) {
		this.rotation = rotation;
	}
	
	public void setPosition(Point3D newPos) {
		position.x = newPos.x;
		position.y = newPos.y;
	}

	public void draw() {
		FloatBuffer vertexBuffer = BufferUtils.newFloatBuffer(8);
		vertexBuffer.put(new float[] {-50,-50, -50,50, 50,-50, 50,50});
		vertexBuffer.rewind();
		
		Gdx.gl11.glPushMatrix();
		Gdx.gl11.glVertexPointer(2, GL11.GL_FLOAT, 0, vertexBuffer);
		Gdx.gl11.glColor4f(0.0f, 1.0f, 0, 1.0f);
		Gdx.gl11.glTranslatef(position.x, position.y, 0);
		
		Gdx.gl11.glDrawArrays(GL11.GL_TRIANGLE_STRIP, 0, 4);
		Gdx.gl11.glPopMatrix();	
	}
}