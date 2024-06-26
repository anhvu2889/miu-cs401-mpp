package lab2.prob1;

import java.util.List;

public class Project {
    private final String id;
    private final List<Release> releases;

    public Project(String id, List<Release> releases) {
        this.id = id;
        this.releases = releases;
    }

    public boolean isCompleted() {
        for (Release release : releases) {
            if (!release.isDelivered())
                return false;
        }
        return true;
    }
}
