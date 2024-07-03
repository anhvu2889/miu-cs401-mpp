package midterm;

import midterm.data.TestData;
import midterm.presentation.MainLibrarySystem;

import java.awt.*;


public class LibrarySystemApplication {

    public static void main(String[] args) {
        TestData.main(null);
        EventQueue.invokeLater(MainLibrarySystem::getInstance);
    }
}
