public class Hero {
    private int x, y;
    public Hero(int x, int y){
        this.x = x;
        this.y = y;
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

    public void moveUp(){
        y += 1;
    }

    public void moveDown(){
        y -= 1;
    }

    public void moveLeft(){
        x -= 1;
    }

    public void moveRight(){
        x += 1;
    }
}
