/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author nshut
 */
public class Issue {
    private Integer book_id;
    private String book_name;
    private Integer teacher_id;
    private String teacher_name;
    private Date issue_date;
    private Date due_date;
    private String status;

    public Issue() {
    }

    public Issue(Integer book_id, String book_name, Integer teacher_id, String teacher_name, Date issue_date, Date due_date, String status) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.teacher_id = teacher_id;
        this.teacher_name = teacher_name;
        this.issue_date = issue_date;
        this.due_date = due_date;
        this.status = status;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public Integer getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Integer teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public Date getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(Date issue_date) {
        this.issue_date = issue_date;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

   
}
