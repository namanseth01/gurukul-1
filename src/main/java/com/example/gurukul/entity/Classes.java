/*   Created by IntelliJ IDEA.
 *   Author: Devvrat Sharma (devrats)
 *   Date: 13-Nov-21
 *   Time: 8:24 PM
 *   File: Classes.java
 */

package com.example.gurukul.entity;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Classes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String topic;
    private String motto;
    private long secretCode;
    @OneToMany(mappedBy = "classes")
    private List<Announcement> announcement;
    @ManyToOne
    private Teacher teacher;
    @ManyToMany
    private List<Student> student;

    @Override
    public String toString() {
        return "Classes{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", topic='" + topic + '\'' +
                ", motto='" + motto + '\'' +
                ", secretCode=" + secretCode +
                ", announcement=" + announcement +
                ", teacher=" + teacher +
                ", student=" + student +
                '}';
    }


    public String stringTo() {
        return "Classes{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", topic='" + topic + '\'' +
                ", motto='" + motto + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Classes)) return false;
        Classes classes = (Classes) o;
        return getId() == classes.getId() && getSecretCode() == classes.getSecretCode() && Objects.equals(getTitle(), classes.getTitle()) && Objects.equals(getTopic(), classes.getTopic()) && Objects.equals(getMotto(), classes.getMotto()) && Objects.equals(getAnnouncement(), classes.getAnnouncement()) && Objects.equals(getTeacher(), classes.getTeacher()) && Objects.equals(getStudent(), classes.getStudent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getTopic(), getMotto(), getSecretCode(), getAnnouncement(), getTeacher(), getStudent());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public long getSecretCode() {
        return secretCode;
    }

    public void setSecretCode(long secretCode) {
        this.secretCode = secretCode;
    }

    public List<Announcement> getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(List<Announcement> announcement) {
        this.announcement = announcement;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    public Classes(String title, String topic, String motto, long secretCode, Teacher teacher) {
        this.title = title;
        this.topic = topic;
        this.motto = motto;
        this.secretCode = secretCode;
        this.teacher = teacher;
    }

    public Classes(String title, String topic, String motto, long secretCode, List<Announcement> announcement, Teacher teacher, List<Student> student) {
        this.title = title;
        this.topic = topic;
        this.motto = motto;
        this.secretCode = secretCode;
        this.announcement = announcement;
        this.teacher = teacher;
        this.student = student;
    }

    public Classes(int id, String title, String topic, String motto, long secretCode, List<Announcement> announcement, Teacher teacher, List<Student> student) {
        this.id = id;
        this.title = title;
        this.topic = topic;
        this.motto = motto;
        this.secretCode = secretCode;
        this.announcement = announcement;
        this.teacher = teacher;
        this.student = student;
    }

    public Classes() {
    }


}