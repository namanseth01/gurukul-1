/*   Created by IntelliJ IDEA.
 *   Author: Devvrat Sharma (devrats)
 *   Date: 16-Nov-21
 *   Time: 4:41 PM
 *   File: Assignment.java
 */

package com.example.gurukul.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Arrays;
import java.util.Objects;

@Entity
public class Assignment {

    @Id
    private int id;
    private Byte[] assignmentFile;
    @ManyToOne
    @JsonManagedReference
    private Announcement announcement;
    @ManyToOne
    @JsonManagedReference
    private Student student;

    @Override
    public String toString() {
        return "Assignment{" +
                "id=" + id +
                ", assignmentFile=" + Arrays.toString(assignmentFile) +
                ", announcement=" + announcement +
                ", student=" + student +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Assignment)) return false;
        Assignment that = (Assignment) o;
        return getId() == that.getId() && Arrays.equals(getAssignmentFile(), that.getAssignmentFile()) && Objects.equals(getAnnouncement(), that.getAnnouncement()) && Objects.equals(getStudent(), that.getStudent());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getId(), getAnnouncement(), getStudent());
        result = 31 * result + Arrays.hashCode(getAssignmentFile());
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Byte[] getAssignmentFile() {
        return assignmentFile;
    }

    public void setAssignmentFile(Byte[] assignmentFile) {
        this.assignmentFile = assignmentFile;
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

    public Assignment(int id, Byte[] assignmentFile, Announcement announcement, Student student) {
        this.id = id;
        this.assignmentFile = assignmentFile;
        this.announcement = announcement;
        this.student = student;
    }

    public Assignment() {
    }
}