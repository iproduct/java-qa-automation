package course.qa.model;

import course.qa.dao.Identifiable;

import java.util.Set;

public abstract class Publication implements Identifiable<Long>, Formatable {
    private Long id;
    private String title;
    private String subtitle;
    private String authors;
    private int year;
    private String publisher;
    private String isbn;
    private Set<String> keywords = Set.of();

    public Publication() {
    }

    public Publication(Long id) {
        this.id = id;
    }

    public Publication(String title, String subtitle, String authors, int year, String publisher) {
        this.title = title;
        this.subtitle = subtitle;
        this.authors = authors;
        this.year = year;
        this.publisher = publisher;
    }

    public Publication(String title, String subtitle, String authors, int year, String publisher,
                       String isbn, Set<String> keywords) {
        this.title = title;
        this.subtitle = subtitle;
        this.authors = authors;
        this.year = year;
        this.publisher = publisher;
        this.isbn = isbn;
        this.keywords = keywords;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Set<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(Set<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Publication)) return false;

        Publication that = (Publication) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", authors='" + authors + '\'' +
                ", year=" + year +
                ", publisher='" + publisher + '\'' +
                ", isbn='" + isbn + '\'' +
                ", keywords=" + keywords;
    }
}
