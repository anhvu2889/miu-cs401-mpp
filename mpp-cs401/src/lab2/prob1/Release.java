package lab2.prob1;

import java.time.LocalDate;
import java.util.List;

public class Release {
    private final String id;
    private final LocalDate releaseDate;
    private final List<Feature> features;

    private boolean isDelivered;

    public Release(String id, LocalDate releaseDate, List<Feature> features) {
        this.id = id;
        this.releaseDate = releaseDate;
        this.features = features;
        this.isDelivered = false;
    }

    public boolean isDelivered() {
        return isDelivered;
    }

    public void setDelivered(boolean delivered) {
        isDelivered = delivered;
    }
}
