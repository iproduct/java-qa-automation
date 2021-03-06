package course.qa.model;

import java.io.Serializable;
import java.util.Set;

public class Paper extends Publication implements Serializable {
    private String publishedAt;
    private String paperAbstract;
    private String pages;

    public Paper() {
    }

    public Paper(Long id) {
        super(id);
    }

    public Paper(String title, String subtitle, String authors, int year, String publisher, String publishedAt,
                 String paperAbstract, String pages) {
        super(title, subtitle, authors, year, publisher);
        this.publishedAt = publishedAt;
        this.paperAbstract = paperAbstract;
        this.pages = pages;
    }

    public Paper(String title, String subtitle, String authors, int year, String publisher, String isbn,
                 Set<String> keywords, String publishedAt, String paperAbstract, String pages) {
        super(title, subtitle, authors, year, publisher, isbn, keywords);
        this.publishedAt = publishedAt;
        this.paperAbstract = paperAbstract;
        this.pages = pages;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getPaperAbstract() {
        return paperAbstract;
    }

    public void setPaperAbstract(String paperAbstract) {
        this.paperAbstract = paperAbstract;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Paper{");
        sb.append(super.toString());
        sb.append(", publishedAt='").append(publishedAt).append('\'');
        sb.append(", paperAbstract='").append(paperAbstract).append('\'');
        sb.append(", pages='").append(pages).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public String format() {
        return String.format("| %3d | %-15.15s |  %-15.15s |  %-20.20s | %4d | %-15.15s |  %-10.10s |  %-15.15s | %-6.6s |",
                getId(), getTitle(), getSubtitle(), getAuthors(), getYear(), getPublisher(), getIsbn(),
                String.join(", ", getKeywords()), "PAPER");
    }
}
