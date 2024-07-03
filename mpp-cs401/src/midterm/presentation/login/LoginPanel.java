package midterm.presentation.login;

import midterm.presentation.windows.LoginWindow;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {
    public static LoginPanel INSTANCE = new LoginPanel();
    private JSplitPane splitPane;

    private JPanel leftLoginSide;
    private JPanel rightLoginSide;

    private LoginPanel() {
        super(new CardLayout());
        initComponents();
    }

    private void setLeftLoginSidePanel() {
        leftLoginSide = new JPanel(new BorderLayout());
        leftLoginSide.setBackground(Color.WHITE);
        String currDirectory = System.getProperty("user.dir");
        String pathToImage = STR."\{currDirectory}/src/midterm/presentation/resource/library.jpg";
        ImageIcon image = new ImageIcon(pathToImage);

        JLabel icon = new JLabel(image);
        leftLoginSide.add(icon, BorderLayout.CENTER);
    }

    private void setRightLoginSidePanel() {
        rightLoginSide = new JPanel();
        rightLoginSide.setBackground(Color.LIGHT_GRAY);
        rightLoginSide.add(LoginWindow.INSTANCE);
    }

    private void initComponents() {
        setLeftLoginSidePanel();
        setRightLoginSidePanel();

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftLoginSide, rightLoginSide);
        splitPane.setDividerLocation(500);
        // Add the SplitPane to the Pane
        add(splitPane, BorderLayout.CENTER);
    }
}
