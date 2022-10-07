import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.input.KeyStroke;
import javax.swing.*;
import java.io.IOException;

public class Game {
    private Screen screen;
    Hero hero = new Hero(10,10);
    public Game() throws IOException {
        TerminalSize terminalSize = new TerminalSize(40, 20);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        Terminal terminal = terminalFactory.createTerminal();
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
    }

    private void draw() throws IOException {
        screen.clear();
        screen.setCharacter(hero.get_x(), hero.get_y(), TextCharacter.fromCharacter('X')
                [0]);
        screen.refresh();
    }

    public void run() throws IOException {
        KeyStroke key;
        while(true) {
            draw();
            key = screen.readInput();
            if(key.getKeyType() == KeyType.EOF) break;
            processKey(key);
        }
    }

    private void processKey(KeyStroke key) throws IOException {
        System.out.println(key);
        if (key.getKeyType() == KeyType.ArrowUp) hero.moveUp();
        else if(key.getKeyType() == KeyType.ArrowDown) hero.moveDown();
        else if(key.getKeyType() == KeyType.ArrowLeft) hero.moveLeft();
        else if(key.getKeyType() == KeyType.ArrowRight) hero.moveRight();
        else if( key.getCharacter() == 'q') screen.close();

    }
}

