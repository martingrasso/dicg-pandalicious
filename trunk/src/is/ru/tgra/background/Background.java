package is.ru.tgra.background;

import is.ru.tgra.enemy.Panda;
import is.ru.tgra.view.Point3D;

import java.util.ArrayList;

public class Background {
	private float speed;
	private float offsetY;
	ArrayList<Tree> trees;
	ArrayList<Panda> pandas;
    Scoreboard _sB;
	
	public Background() {
		speed  = 0.5f;
		offsetY = 200.0f;
		
		trees = new ArrayList<Tree>();
		trees.add(new Tree(new Point3D(50, 80, 0)));
		trees.add(new Tree(new Point3D(200, 150, 0)));
		trees.add(new Tree(new Point3D(350, 75, 0)));
		trees.add(new Tree(new Point3D(500, 95, 0)));
		trees.add(new Tree(new Point3D(650 ,150, 0)));

        _sB = new Scoreboard();
		
		// B�um til �vini og setjum � hvert tr�
		pandas = new ArrayList<Panda>();
		for(Tree tree : trees) {
			pandas.add(new Panda(new Point3D(tree.getPosition().x, tree.getPosition().y + offsetY, tree.getPosition().z)));
		}
	}
	
	private void animate() {
		for(Tree tree: trees) {
			tree.setPosition(new Point3D(tree.getPosition().x - speed, 
										 tree.getPosition().y,
										 tree.getPosition().z));
			
			
			if(tree.getPosition().x < -50) {
				tree.setPosition(new Point3D(700, tree.getPosition().y, 0));
			}
		}
		
		for(Panda panda: pandas) {
			panda.setPosition(new Point3D(panda.getPosition().x - speed, 
										 panda.getPosition().y,
										 panda.getPosition().z));
			
			
			if(panda.getPosition().x < -50) {
				panda.setPosition(new Point3D(700, panda.getPosition().y, 0));
			}
		}
	}
	
	public void render() {
		for(Panda panda : pandas) {
			panda.draw();
			panda.randomize();
		}
		for(Tree tree : trees) {
			tree.draw();
		}
       // _sB.drawScoreboard();
		animate();
	}
}