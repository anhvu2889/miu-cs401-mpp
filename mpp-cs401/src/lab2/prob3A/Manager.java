package lab2.prob3A;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Position {

    private List<Position> directReports;

    public Manager(String id, String name) {
        super(id, name);
        directReports = new ArrayList<>();
    }

    public Manager(String id, String name, List<Position> directReports) {
        super(id, name);
        this.directReports = directReports;
    }

    public void addDirectReport(Position directReport) {
        directReports.add(directReport);
    }


}
