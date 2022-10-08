import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

public class Hero extends Element{
    public Hero(int x, int y){
        super(x,y);
    }

    public Position moveUp(){
        return new Position(position.get_x(),position.get_y()-1);
    }

    public Position moveDown(){
        return new Position(position.get_x(),position.get_y()+1);
    }

    public Position moveLeft(){
        return new Position(position.get_x() - 1,position.get_y());
    }

    public Position moveRight(){
        return new Position(position.get_x() + 1,position.get_y());
    }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#000000"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.get_x(), position.get_y()), "X");
    }
}
