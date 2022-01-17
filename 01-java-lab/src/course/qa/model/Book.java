package course.qa.model;

import java.util.List;
import java.util.Set;

public class Book extends Publication {
    private CoverType cover;
    private int numberPages;
    private String description;

    public Book() {
    }

    public Book(Long id) {
        super(id);
    }

    public Book(String title, String subtitle, String authors, int year, String publisher, CoverType cover, int numberPages) {
        super(title, subtitle, authors, year, publisher);
        this.cover = cover;
        this.numberPages = numberPages;
    }

    public Book(String title, String subtitle, String authors, int year, String publisher, String isbn, Set<String> keywords, CoverType cover, int numberPages) {
        super(title, subtitle, authors, year, publisher, isbn, keywords);
        this.cover = cover;
        this.numberPages = numberPages;
    }

    public Book(String title, String subtitle, String authors, int year, String publisher,
                String isbn, Set<String> keywords, CoverType cover, int numberPages, String description) {
        super(title, subtitle, authors, year, publisher, isbn, keywords);
        this.cover = cover;
        this.numberPages = numberPages;
        this.description = description;
    }

    public CoverType getCover() {
        return cover;
    }

    public void setCover(CoverType cover) {
        this.cover = cover;
    }

    public int getNumberPages() {
        return numberPages;
    }

    public void setNumberPages(int numberPages) {
        this.numberPages = numberPages;
    }

    public String getChapters() {
        return description;
    }

    public void setChapters(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append(super.toString());
        sb.append(", cover=").append(cover);
        sb.append(", numberPages=").append(numberPages);
        sb.append(", chapters=").append(description);
        sb.append('}');
        return sb.toString();
    }
}
