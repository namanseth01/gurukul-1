/*   Created by IntelliJ IDEA.
 *   Author: Devvrat Sharma (devrats)
 *   Date: 13-Nov-21
 *   Time: 8:24 PM
 *   File: Announcement.java
 */

package com.example.gurukul.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Announcement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String msg;
    private Date date;
    private String message;
    private Date dueDate;
    @ManyToOne
    @JsonBackReference
    private Classes classes;
    @OneToMany(mappedBy = "announcement")
    @JsonManagedReference
    private List<Comment> comment;
    @OneToMany(mappedBy = "announcement")
    @JsonBackReference
    private List<Assignment> assignments;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Announcement)) return false;
        Announcement that = (Announcement) o;
        return getId() == that.getId() && Objects.equals(getMsg(), that.getMsg()) && Objects.equals(getDate(), that.getDate()) && Objects.equals(getMessage(), that.getMessage()) && Objects.equals(getDueDate(), that.getDueDate()) && Objects.equals(getClasses(), that.getClasses()) && Objects.equals(getComment(), that.getComment()) && Objects.equals(getAssignments(), that.getAssignments());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMsg(), getDate(), getMessage(), getDueDate(), getClasses(), getComment(), getAssignments());
    }

    @Override
    public String toString() {
        return "Announcement{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + date +
                ", message='" + message + '\'' +
                ", dueDate=" + dueDate +
                ", classes=" + classes +
                ", comment=" + comment +
                ", assignments=" + assignments +
                '}';
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }

    public Announcement(String msg, Date date, String message, Date dueDate, List<Comment> comment) {
        this.msg = msg;
        this.date = date;
        this.message = message;
        this.dueDate = dueDate;
        this.comment = comment;
    }

    public Announcement(String msg, Date date, String message, Date dueDate, Classes classes, List<Comment> comment) {
        this.msg = msg;
        this.date = date;
        this.message = message;
        this.dueDate = dueDate;
        this.classes = classes;
        this.comment = comment;
    }

    public Announcement(int id, String msg, Date date, String message, Date dueDate, Classes classes, List<Comment> comment) {
        this.id = id;
        this.msg = msg;
        this.date = date;
        this.message = message;
        this.dueDate = dueDate;
        this.classes = classes;
        this.comment = comment;
    }

    public Announcement() {
    }
}