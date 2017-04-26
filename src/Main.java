import Application.LoginController;
import GUI.System.LoginGUI;
import GUI.System.SystemGUI;

/**
 * Created by LPNielsen on 26-Apr-17.
 */
public class Main {
    public static void main(String[] args) {
        LoginGUI gg = new LoginGUI(new LoginController(),new SystemGUI());
        gg.setVisible(true);
        System.out.println("hej");
    }
}
