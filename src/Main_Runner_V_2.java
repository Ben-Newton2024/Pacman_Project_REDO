import javax.swing.JFrame;

public class Main_Runner_V_2 {

    public static void main (String[] args)
    {
        // create new instance of Map/ this is the screen that will be displayed upon, AKA, the level maps and design
        // stored as .txt files
        Map_V_2 loading_screen = new Map_V_2();

        // calling Map method Load map to read from the text file.
        // TODO FIND FILE LOCATIONS, TO LOAD SPECIFIC FILES PER LEVEL AFTER LOADING SCREEN AND HOME SCREEN
        loading_screen.loadMap("C:\\Users\\bened\\IntelliJ-workspace\\Pacman_Project\\src\\Assets\\Maps\\LvL2.txt");


        // create the UI JFrame to display pacman.
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(loading_screen);
        window.setSize(500,610);
        window.setVisible(true);

    }
}