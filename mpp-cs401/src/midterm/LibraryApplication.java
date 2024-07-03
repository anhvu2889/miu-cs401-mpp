package midterm;

import midterm.data.DataAccess;
import midterm.data.DataAccessFacade;
import midterm.data.TestData;
import midterm.presentation.LibrarySystem;

import javax.swing.*;
import java.awt.*;

public class LibraryApplication {

    public static void main(String[] args) {
        TestData.main(new String[0]);
        EventQueue.invokeLater(() ->
        {
            LibrarySystem.INSTANCE.setTitle("Sample Library Application");
            LibrarySystem.INSTANCE.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            LibrarySystem.INSTANCE.init();
            centerFrameOnDesktop(LibrarySystem.INSTANCE);
            LibrarySystem.INSTANCE.setVisible(true);
        });
    }

    public static void centerFrameOnDesktop(Component f) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        int height = toolkit.getScreenSize().height;
        int width = toolkit.getScreenSize().width;
        int frameHeight = f.getSize().height;
        int frameWidth = f.getSize().width;
        f.setLocation(((width - frameWidth) / 2), (height - frameHeight) / 3);
    }

}
