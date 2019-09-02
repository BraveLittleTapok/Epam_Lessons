package ru.yusdm.stud.lesson_8_collections_continue.homework;

/**
 * Created by Dinara Shabanova on 02.09.2019.
 */
public abstract class Entity {
    protected Long id;
    public abstract Long getId();
    public abstract void setId(Long id);

  /*  protected <T extends Entity> Long add(T element, List<T> listToAdd){
        element.setId(IdGenerator.generateId());
        listToAdd.add(element);
        return element.getId();
    }*/
    /*
    protected <T> void delete(T element, ){
        {
            for (int i = 0; i < books.length; i++) {

                if (book.getId().equals(books[i].getId())) {
                    books[i] = null;
                    bookIndex--;
                    break;
                }

            }
            Book[] newBooks = new Book[books.length];
            int index = 0;
            for (Book b : books) {
                if (b != null) {
                    newBooks[index] = b;
                    index++;
                }
            }
            books = newBooks;
        }
    }
    protected <T> void print(List<T> list){

    }*/
}
