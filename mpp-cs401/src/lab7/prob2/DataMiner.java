package lab7.prob2;

import java.util.ArrayList;
import java.util.List;

public class DataMiner {
    List<ClosedCurve> closedCurves = new ArrayList<>();

    public static void main(String[] args) {
        DataMiner dataMiner = new DataMiner();
        dataMiner.closedCurves.add(new Rectangle(5, 7));
        dataMiner.closedCurves.add(new EquilateralTriangle(7));
        dataMiner.closedCurves.add(new Rectangle(2, 9));
        dataMiner.closedCurves.add(new Ellipse(3, 3));
        dataMiner.closedCurves.add(new Circle(6));
        System.out.println(dataMiner.computeAveragePerimeter());
    }

    //OO (good) way of performing computation
    public double computeAveragePerimeter() {
        if (closedCurves == null || closedCurves.isEmpty()) return 0.0;
        double sum = 0.0;
        for (int i = 0; i < closedCurves.size(); ++i) {
            sum += closedCurves.get(i).computePerimeter();
        }
        return sum / closedCurves.size();
    }

}
