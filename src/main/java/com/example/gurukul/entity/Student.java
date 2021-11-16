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
    private long id;
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

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
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
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getId() == student.getId() && Objects.equals(getName(), student.getName()) && Objects.equals(getEmail(), student.getEmail()) && Objects.equals(getClasses(), student.getClasses()) && Objects.equals(getComments(), student.getComments()) && Objects.equals(getAssignments(), student.getAssignments());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getEmail(), getClasses(), getComments(), getAssignments());
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Student(long id, String name, String email, List<Classes> classes, List<Comment> comments) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.classes = classes;
        this.comments = comments;
    }

    public Student() {
    }
}