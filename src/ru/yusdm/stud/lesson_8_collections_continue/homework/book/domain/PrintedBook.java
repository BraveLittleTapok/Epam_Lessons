package ru.yusdm.stud.lesson_8_collections_continue.homework.book.domain;

public class PrintedBook extends Book {
    private String fontFamily;

    public String getFontFamily() {
        return fontFamily;
    }

    public void setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
    }

    @Override
    public String toString() {
        return "PrintedBook{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", publishYear=" + publishYear +
                ", totalPages=" + totalPages +
                " fontFamily='" + fontFamily + '\'' +
                '}';
    }
}
