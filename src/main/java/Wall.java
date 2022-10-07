import com.googlecode.lanterna.graphics.TextGraphics;

public class Wall extends Element{
    private int x,y;
    Position position = new Position(x,y);
    public Wall(int x, int y){
        super(x,y);
    }

    public void set_x(int x){
        this.x = x;
    }

    public void set_y(int y){
        this.y = y;
    }

    public int get_x(){
        return x;
    }

    public int get_y(){
        return y;
    }

    public Position getPosition(){
        return position;
    }

    public void draw(TextGraphics graphics){

    }

}
