package lab2.prob3A;

import java.util.ArrayList;
import java.util.List;

public class Position {
    private final String id;
    private final String name;
    private final List<Position> directReports;

    public Position(String id, String name) {
        this.id = id;
        this.name = name;
        directReports = new ArrayList<>();
    }

    public void addDirectReport(Position position) {
        directReports.add(position);
    }

    public static void main(String[] args) {
        Position p1 = new Position("1", "A");
        Position p2 = new Position("2", "B");
        p1.addDirectReport(p2);
    }
}
