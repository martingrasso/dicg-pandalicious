package is.ru.tgra.runner;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

public class Runner {
	public static void main(String[] args) {
		new LwjglApplication((ApplicationListener)new AppClass(), "Pandalicious", 640, 480, false);
	}
}