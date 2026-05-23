package hust.soict.hedspi.aims.media;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public abstract class Media {
    // classifier methods
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    // instance properties
    private final int id;
    private String title;
    private String category;
    private double cost;

    // constructors
    public Media(int id, String title, String category, double cost) {
        this.id = id;
        this.title = sanitise(title);
        this.category = sanitise(category);
        this.cost = cost;
    }

    // getters, setters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = sanitise(title);
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = sanitise(category);
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    // instance methods
    protected String sanitise(String input) {
        return input == null || input.isBlank() ? null : input;
    }

    public String formatTitle() {
        return title == null ? "unnamed" : title;
    }

    public String formatCategory() {
        return category == null ? "uncategorised" : category;
    }

    public String formatCost() {
        return cost < 0 ? "unavailable" : cost + "$";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Media) {
            String titleA = this.getTitle(), titleB = ((Media) o).getTitle();
            if (titleA == null || titleB == null) return false;
            return titleA.equals(titleB);
        }
        return false;
    }

    protected Map<String, Object> getDetails() {
        Map<String, Object> details = new HashMap<>();
        details.put("id", id);
        details.put("title", formatTitle());
        details.put("category", formatCategory());
        details.put("cost", formatCost());
        return details;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + getDetails().toString();
    }
}