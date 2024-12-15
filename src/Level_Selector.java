import javax.swing.*;
import java.awt.*;

public class Level_Selector extends JPanel{

    public final JButton level_1 = new JButton("Level 1");
    public final JButton level_2 = new JButton("Level 2");
    public final JButton level_3 = new JButton("Level 3");
    public final JButton level_4 = new JButton("Level 4");
    public final JButton level_5 = new JButton("Level 5");


    public Level_Selector() {

        this.setFocusable(true);

        this.setLayout(new GridLayout(5, 1));
        this.add(level_1);
        this.add(level_2);
        this.add(level_3);
        this.add(level_4);
        this.add(level_5);
    }

}
