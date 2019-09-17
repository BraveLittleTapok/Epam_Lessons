package ru.yusdm.stud.lesson_8_collections_continue.homework.common.domain;

public class BaseDomain<ID> {
    protected ID id;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }
}
