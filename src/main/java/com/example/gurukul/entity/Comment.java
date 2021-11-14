/*   Created by IntelliJ IDEA.
 *   Author: Devvrat Sharma (devrats)
 *   Date: 13-Nov-21
 *   Time: 8:24 PM
 *   File: Comment.java
 */

package com.example.gurukul.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String message;
    @ManyToOne
    private Teacher teacher;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Announcement announcement;
    private String type;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", teacher=" + teacher +
                ", student=" + student +
                ", announcement=" + announcement +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment)) return false;
        Comment comment = (Comment) o;
        return getId() == comment.getId() && Objects.equals(getMessage(), comment.getMessage()) && Objects.equals(getTeacher(), comment.getTeacher()) && Objects.equals(getStudent(), comment.getStudent()) && Objects.equals(getAnnouncement(), comment.getAnnouncement()) && Objects.equals(getType(), comment.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMessage(), getTeacher(), getStudent(), getAnnouncement(), getType());
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Comment(String message, Teacher teacher, Announcement announcement, String type) {
        this.message = message;
        this.teacher = teacher;
        this.announcement = announcement;
        this.type = type;
    }

    public Comment(String message, Teacher teacher, Student student, Announcement announcement, String type) {
        this.message = message;
        this.teacher = teacher;
        this.student = student;
        this.announcement = announcement;
        this.type = type;
    }

    public Comment(int id, String message, Teacher teacher, Student student, Announcement announcement, String type) {
        this.id = id;
        this.message = message;
        this.teacher = teacher;
        this.student = student;
        this.announcement = announcement;
        this.type = type;
    }

    public Comment() {
    }
}