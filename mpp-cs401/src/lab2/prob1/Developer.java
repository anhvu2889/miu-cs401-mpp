package lab2.prob1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Developer {
    private final String id;
    private final List<Feature> assignedFeatures;

    public Developer(String id) {
        this.id = id;
        this.assignedFeatures = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public List<Feature> getAssignedFeatures() {
        return assignedFeatures;
    }

    public void addFeature(Feature feature) {
        assignedFeatures.add(feature);
    }

    public long getRemainingDays(Feature feature, LocalDate releaseDate) {
        return ChronoUnit.DAYS.between(LocalDate.now(), releaseDate);
    }
}
