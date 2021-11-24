/*   Created by IntelliJ IDEA.
 *   Author: Devvrat Sharma (devrats)
 *   Date: 13-Nov-21
 *   Time: 8:24 PM
 *   File: Teacher.java
 */

package com.example.gurukul.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;
    private String id;
    private String name;
    private String email;
    @OneToMany(mappedBy = "teacher")
    @JsonManagedReference
    private List<Classes> classes;
    @OneToMany(mappedBy = "teacher")
    @JsonBackReference
    private List<Comment> comments;

    @Override
    public String toString() {
        return "Teacher{" +
                "uid=" + uid +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", classes=" + classes +
                ", comments=" + comments +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return uid == teacher.uid && Objects.equals(id, teacher.id) && Objects.equals(name, teacher.name) && Objects.equals(email, teacher.email) && Objects.equals(classes, teacher.classes) && Objects.equals(comments, teacher.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, id, name, email, classes, comments);
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Teacher(int uid, String id, String name, String email, List<Classes> classes, List<Comment> comments) {
        this.uid = uid;
        this.id = id;
        this.name = name;
        this.email = email;
        this.classes = classes;
        this.comments = comments;
    }

    public Teacher(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
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

    public Teacher(String name, String email, List<Classes> classes, List<Comment> comments) {
        this.name = name;
        this.email = email;
        this.classes = classes;
        this.comments = comments;
    }

    public Teacher() {
    }
}