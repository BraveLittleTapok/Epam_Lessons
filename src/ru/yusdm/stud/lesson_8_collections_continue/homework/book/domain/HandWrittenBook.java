package src.ru.yusdm.stud.lesson_8_collections_continue.homework.book.domain;

public class HandWrittenBook extends Book {
    private String paint;

    public String getPaint() {
        return paint;
    }

    public void setPaint(String paint) {
        this.paint = paint;
    }

    @Override
    public String toString() {
        return "HandWrittenBook{" +
                "paint='" + paint +
                ", name='" + name + '\'' +
                ", publishYear=" + publishYear +
                ", totalPages=" + totalPages ;
    }
}
