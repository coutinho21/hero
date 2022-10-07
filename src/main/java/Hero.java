import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

public class Hero {
    private Position position = new Position(10,10);

    public Hero(int x, int y){
        position.set_x(x);
        position.set_y(y);
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

    public void draw(Screen screen){
        screen.setCharacter(position.get_x(), position.get_y(), TextCharacter.fromCharacter('X')
                [0]);
    }

    public void setPosition(Position position){
        this.position.set_x(position.get_x());
        this.position.set_y(position.get_y());
    }
}
