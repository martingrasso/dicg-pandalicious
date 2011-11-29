package is.ru.tgra.runner;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL11;
import is.ru.tgra.background.Background;
import is.ru.tgra.background.Scoreboard;

public class AppClass implements ApplicationListener {
    Background background;

    @Override
    public void create() {
        Gdx.gl11.glEnableClientState(GL11.GL_VERTEX_ARRAY);

        Gdx.gl11.glClearColor(0.4f, 0.6f, 1.0f, 1.0f);

        Gdx.gl11.glLoadIdentity();
        Gdx.glu.gluPerspective(Gdx.gl11, 90, 1.0f, 0.2f, 30.0f);


        background = new Background();
    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub
    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub

    }

    private void update() {

    }

    private void display() {
        Gdx.gl11.glClear(GL11.GL_COLOR_BUFFER_BIT);

        Gdx.gl11.glMatrixMode(GL11.GL_MODELVIEW);
        Gdx.gl11.glLoadIdentity();
        Gdx.glu.gluOrtho2D(Gdx.gl11, 0, 640, 0, 480);

        background.render();
    }

    @Override
    public void render() {
        update();
        display();
    }

    @Override
    public void resize(int arg0, int arg1) {
        // TODO Auto-generated method stub

    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub

    }

}