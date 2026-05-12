package hust.soict.hedspi.aims.media;

public abstract class Media {
    // instance properties
    private int id;
    private String title;
    private String category;
    private float cost;

    // constructors
    public Media() {
    }

    // getters, setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        if (title == null || title.isEmpty()) return "Unknown";
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        if (title == null) return "Unclassified";
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
}