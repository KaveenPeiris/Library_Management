package Model;

public class BookMangementController {
    private String id;
    private String title;
    private String author;
    private String category;
    private int qty;

    public BookMangementController(String id, String title, String author, String category, int qty) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.qty = qty;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public int getQty() { return qty; }
    public void setQty(int qty) { this.qty = qty; }
}