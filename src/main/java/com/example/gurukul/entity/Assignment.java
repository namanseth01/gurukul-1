/*   Created by IntelliJ IDEA.
 *   Author: Devvrat Sharma (devrats)
 *   Date: 16-Nov-21
 *   Time: 4:41 PM
 *   File: Assignment.java
 */

package com.example.gurukul.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JsonManagedReference
    private Announcement announcement;
    @ManyToOne
    @JsonManagedReference
    private Student student;
    private float marks;
    private String link;

    @Override
    public String toString() {
        return "Assignment{" +
                "id=" + id +
                ", announcement=" + announcement +
                ", student=" + student +
                ", marks=" + marks +
                ", link='" + link + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Assignment)) return false;
        Assignment that = (Assignment) o;
        return getId() == that.getId() && Float.compare(that.getMarks(), getMarks()) == 0 && Objects.equals(getAnnouncement(), that.getAnnouncement()) && Objects.equals(getStudent(), that.getStudent()) && Objects.equals(getLink(), that.getLink());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAnnouncement(), getStudent(), getMarks(), getLink());
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Assignment(int id, Announcement announcement, Student student, float marks, String link) {
        this.id = id;
        this.announcement = announcement;
        this.student = student;
        this.marks = marks;
        this.link = link;
    }

    public float getMarks() {
        return marks;
    }

    public void setMarks(float marks) {
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Announcement getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(Announcement announcement) {
        this.announcement = announcement;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Assignment(int id, Announcement announcement, Student student) {
        this.id = id;
        this.announcement = announcement;
        this.student = student;
    }

    public Assignment() {
    }
}