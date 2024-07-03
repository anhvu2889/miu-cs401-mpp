package midterm.controller;

import midterm.data.DataAccess;
import midterm.data.DataAccessFacade;

import java.util.ArrayList;
import java.util.List;

public class BookControllerImpl implements BookController {
    @Override
    public List<String> getAllBookIds() {
        DataAccess dataAccess = new DataAccessFacade();
        return new ArrayList<>(dataAccess.readBooksMap().keySet());
    }
}
