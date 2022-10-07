import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Arena {
    private Screen screen;
    private int width, height;

    Hero hero = new Hero(10,10);
    public Arena(int width, int height){
        this.width = width;
        this.height = height;
    }

    public void processKey(KeyStroke key) throws IOException {
        System.out.println(key);
        if (key.getKeyType() == KeyType.ArrowUp) moveHero(hero.moveUp());
        else if(key.getKeyType() == KeyType.ArrowDown) moveHero(hero.moveDown());
        else if(key.getKeyType() == KeyType.ArrowLeft) moveHero(hero.moveLeft());
        else if(key.getKeyType() == KeyType.ArrowRight) moveHero(hero.moveRight());
        else if( key.getCharacter() == 'q') screen.close();
    }

    private void moveHero(Position position){
        if(canHeroMove(position)) {
            hero.setPosition(position);
        }
    }

    private boolean canHeroMove(Position position){
        if(position.get_x() < 0 || position.get_x() > width || position.get_y() < 0 || position.get_y() > height) return false;
        return true;
    }

    public void draw(Screen screen){
        screen.setCharacter(hero.getPosition().get_x(), hero.getPosition().get_y(), TextCharacter.fromCharacter('X')[0]);
    }
}
