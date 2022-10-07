import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class Arena {
    private Screen screen;
    private int width, height;
    private List<Wall> walls;
    Hero hero = new Hero(10,10);
    public Arena(int width, int height){
        this.width = width;
        this.height = height;
        this.walls = createWalls();
    }

    public void processKey(KeyStroke key) throws IOException {
        System.out.println(key);
        if (key.getKeyType() == KeyType.ArrowUp) moveHero(hero.moveUp());
        else if(key.getKeyType() == KeyType.ArrowDown) moveHero(hero.moveDown());
        else if(key.getKeyType() == KeyType.ArrowLeft) moveHero(hero.moveLeft());
        else if(key.getKeyType() == KeyType.ArrowRight) moveHero(hero.moveRight());
    }

    private void moveHero(Position position){
        if(canHeroMove(position)) {
            hero.setPosition(position);
        }
    }

    private boolean canHeroMove(Position position){
        if(position.get_x() < 0 || position.get_x() > width || position.get_y() < 0 || position.get_y() > height) return false;
        for(Wall wall : walls){

        }
        return true;
    }

    public void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        hero.draw(graphics);
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width * 2, height * 2), ' ');
        graphics.putString(new TerminalPosition(hero.getPosition().get_x() * 2, hero.getPosition().get_y() * 2), "\\/");
        graphics.putString(new TerminalPosition(hero.getPosition().get_x() * 2, hero.getPosition().get_y() * 2 + 1), "/\\");
        for (Wall wall : walls)
            wall.draw(graphics);
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }
        return walls;
    }

}
