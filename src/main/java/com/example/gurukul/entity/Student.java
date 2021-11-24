/*   Created by IntelliJ IDEA.
 *   Author: Devvrat Sharma (devrats)
 *   Date: 13-Nov-21
 *   Time: 8:23 PM
 *   File: Student.java
 */

package com.example.gurukul.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;

    @Override
    public String toString() {
        return "Student{" +
                "uid=" + uid +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", classes=" + classes +
                ", comments=" + comments +
                ", assignments=" + assignments +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return uid == student.uid && Objects.equals(id, student.id) && Objects.equals(name, student.name) && Objects.equals(email, student.email) && Objects.equals(classes, student.classes) && Objects.equals(comments, student.comments) && Objects.equals(assignments, student.assignments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, id, name, email, classes, comments, assignments);
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Student(int uid, String id, String name, String email, List<Classes> classes, List<Comment> comments, List<Assignment> assignments) {
        this.uid = uid;
        this.id = id;
        this.name = name;
        this.email = email;
        this.classes = classes;
        this.comments = comments;
        this.assignments = assignments;
    }

    private String id;
    private String name;
    private String email;
    @ManyToMany(mappedBy = "student")
    @JsonManagedReference
    private List<Classes> classes;
    @OneToMany(mappedBy = "student")
    @JsonBackReference
    private List<Comment> comments;
    @OneToMany(mappedBy = "student")
    @JsonBackReference
    private List<Assignment> assignments;

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Classes> getClasses() {
        return classes;
    }

    public void setClasses(List<Classes> classes) {
        this.classes = classes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Student(String name, String email, List<Classes> classes, List<Comment> comments) {
        this.name = name;
        this.email = email;
        this.classes = classes;
        this.comments = comments;
    }

    public Student(String id, String name, String email, List<Classes> classes, List<Comment> comments) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.classes = classes;
        this.comments = comments;
    }

    public Student() {
    }
}