package src.ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.book;

import src.ru.yusdm.stud.lesson_8_collections_continue.homework.book.domain.BookGenre;

public class InputBook {

    private String name;
    private int publishYear;
    private int totalPages;

    private String paint;
    private String fontFamily;
    private BookGenre bookType;
    private String bookFamily;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public String getPaint() {
        return paint;
    }

    public void setPaint(String paint) {
        this.paint = paint;
    }

    public String getFontFamily() {
        return fontFamily;
    }

    public void setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
    }

    public BookGenre getBookGenre() {
        return bookType;
    }

    public void setBookGenre(BookGenre bookType) {
        this.bookType = bookType;
    }

    public String getBookFamily() {
        return bookFamily;
    }

    public void setBookFamily(String bookFamily) {
        this.bookFamily = bookFamily;
    }
}
