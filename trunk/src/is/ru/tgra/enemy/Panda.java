package is.ru.tgra.enemy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL11;
import com.badlogic.gdx.utils.BufferUtils;
import is.ru.tgra.view.Point3D;

import java.nio.FloatBuffer;

public class Panda {
	protected Point3D position;
	float rotation;
	float maxHeight;
	boolean goingDown;
	
	public Panda(Point3D position) {
		this.position  = new Point3D(position.x, position.y, position.z);
		this.rotation  = 0;
		this.maxHeight = position.y;
		this.goingDown = true;
		this.init();
	}
	
	public Panda(Point3D position, float rotation) {
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
		Gdx.gl11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		Gdx.gl11.glTranslatef(position.x, position.y, 0);
		Gdx.gl11.glScalef(0.3f, 0.3f, 1.0f);
		Gdx.gl11.glDrawArrays(GL11.GL_TRIANGLE_STRIP, 0, 4);
		Gdx.gl11.glPopMatrix();	
	}

	public void randomize() {
		if(maxHeight - position.y > 20) {
			goingDown = false;
		}
		else if(maxHeight - position.y == 0) {
			goingDown = true;
		}
		
		if(goingDown) {
			position.y -= 0.1f;
		}
		else {
			position.y += 0.1f;
		}
	}
}
