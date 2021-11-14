/*   Created by IntelliJ IDEA.
 *   Author: Devvrat Sharma (devrats)
 *   Date: 13-Nov-21
 *   Time: 8:24 PM
 *   File: Teacher.java
 */

package com.example.gurukul.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;

@Entity
public class Teacher {

    @Id
    private long id;
    private String name;
    private String email;
    @OneToMany(mappedBy = "teacher")
    private List<Classes> classes;
    @OneToMany(mappedBy = "teacher")
    private List<Comment> comments;

    public Teacher(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", classes=" + classes +
                ", comments=" + comments +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher)) return false;
        Teacher teacher = (Teacher) o;
        return getId() == teacher.getId() && Objects.equals(getName(), teacher.getName()) && Objects.equals(getEmail(), teacher.getEmail()) && Objects.equals(getClasses(), teacher.getClasses()) && Objects.equals(getComments(), teacher.getComments());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getEmail(), getClasses(), getComments());
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

    public Teacher(String name, String email, List<Classes> classes, List<Comment> comments) {
        this.name = name;
        this.email = email;
        this.classes = classes;
        this.comments = comments;
    }

    public Teacher() {
    }
}