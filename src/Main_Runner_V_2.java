import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Main_Runner_V_2 extends JFrame implements ActionListener {

    private static final Level_Selector level_selector = new Level_Selector();
    private static final Map_V_2 main_screen_map = new Map_V_2();

    private static final Main_Runner_V_2 window = new Main_Runner_V_2();

    Main_Runner_V_2() {
        level_selector.level_1.addActionListener(this);
        level_selector.level_2.addActionListener(this);
        level_selector.level_3.addActionListener(this);
        level_selector.level_4.addActionListener(this);
        level_selector.level_5.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e);
        if (e.getSource() == level_selector.level_1) {
            File file_path = new File(".\\src\\Assets\\Maps\\LvL1.txt");
            main_screen_map.loadMap(file_path.getPath());
            window.remove(level_selector);
            window.setContentPane(main_screen_map);
            window.setFocusable(true);
            window.revalidate();
            window.repaint();

        }
    }

    public static void main (String[] args) {
        // create new instance of Map/ this is the screen that will be displayed upon, AKA, the level maps and design
        // stored as .txt files

        // create the UI JFrame to display pacman.
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(level_selector);
        window.setSize(495, 610);
        window.setVisible(true);

        // Run 2 threads one fo the above?
        /*
            one for the above and one to keep checking if a string value for the name has changed
            if so then it can kill the thread with all the level selectors,/ remove all the content from the frame
            then set a new content of the map?
         */

    }
}