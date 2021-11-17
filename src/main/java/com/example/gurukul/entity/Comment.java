/*   Created by IntelliJ IDEA.
 *   Author: Devvrat Sharma (devrats)
 *   Date: 13-Nov-21
 *   Time: 8:24 PM
 *   File: Comment.java
 */

package com.example.gurukul.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String message;
    @ManyToOne
    @JsonManagedReference
    private Teacher teacher;
    @ManyToOne
    @JsonManagedReference
    private Student student;
    @ManyToOne
    @JsonBackReference
    private Announcement announcement;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", teacher=" + teacher +
                ", student=" + student +
                ", announcement=" + announcement +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment)) return false;
        Comment comment = (Comment) o;
        return getId() == comment.getId() && Objects.equals(getMessage(), comment.getMessage()) && Objects.equals(getTeacher(), comment.getTeacher()) && Objects.equals(getStudent(), comment.getStudent()) && Objects.equals(getAnnouncement(), comment.getAnnouncement());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMessage(), getTeacher(), getStudent(), getAnnouncement());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Announcement getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(Announcement announcement) {
        this.announcement = announcement;
    }

    public Comment(String message, Teacher teacher, Announcement announcement) {
        this.message = message;
        this.teacher = teacher;
        this.announcement = announcement;
    }

    public Comment(String message, Teacher teacher, Student student, Announcement announcement) {
        this.message = message;
        this.teacher = teacher;
        this.student = student;
        this.announcement = announcement;
    }

    public Comment(int id, String message, Teacher teacher, Student student, Announcement announcement) {
        this.id = id;
        this.message = message;
        this.teacher = teacher;
        this.student = student;
        this.announcement = announcement;
    }

    public Comment() {
    }
}