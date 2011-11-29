package is.ru.tgra.background;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Scoreboard {

    BitmapFont font;
    OrthographicCamera orthoCamera;
    SpriteBatch sBatch;
    int score;

    public Scoreboard() {

        this.font = new BitmapFont(Gdx.files.internal("assets/textures/font.fnt"), Gdx.files.internal("assets/textures/font.png"), false);
        this.orthoCamera = new OrthographicCamera(640, 480);
        this.sBatch = new SpriteBatch();

    }

public void drawScoreboard() {

        GL10 gl = Gdx.graphics.getGL10();
        Gdx.gl11.glPushMatrix();
        orthoCamera.update();
        orthoCamera.apply(gl);

        CharSequence score = "Score: " + Integer.toString(this.score);

        sBatch.begin();
        font.draw(sBatch, score, 500, 440);
        sBatch.end();
    }

}
