/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author nshut
 */
public class Teacher {
    
    private Integer id;
    private String teacher_names;
    private String book_name;
    private String classes;
    private Integer numberOfBooks;

    public Teacher() {
    }

    public Teacher(Integer id) {
        this.id = id;
    }

    public Teacher(Integer id, String teacher_names, String book_name, String classes, Integer numberOfBooks) {
        this.id = id;
        this.teacher_names = teacher_names;
        this.book_name = book_name;
        this.classes = classes;
        this.numberOfBooks = numberOfBooks;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeacher_names() {
        return teacher_names;
    }

    public void setTeacher_names(String teacher_names) {
        this.teacher_names = teacher_names;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public Integer getNumberOfBooks() {
        return numberOfBooks;
    }

    public void setNumberOfBooks(Integer numberOfBooks) {
        this.numberOfBooks = numberOfBooks;
    }

    
}
