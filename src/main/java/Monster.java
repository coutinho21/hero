import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import java.util.Random;

public class Monster extends Element{
    public Monster(int x, int y){
        super(x, y);
    }

    public Position move(){
        int pos = new Random().nextInt(4);
        return switch (pos) {
            case 0 -> new Position(position.get_x() + 1, position.get_y());
            case 1 -> new Position(position.get_x(), position.get_y() + 1);
            case 2 -> new Position(position.get_x() - 1, position.get_y());
            case 3 -> new Position(position.get_x(), position.get_y() - 1);
            default -> new Position(0, 0);
        };
    }

    public void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.get_x(), position.get_y()), "@");
    }
}
