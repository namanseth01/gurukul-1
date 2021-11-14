/*   Created by IntelliJ IDEA.
 *   Author: Devvrat Sharma (devrats)
 *   Date: 13-Nov-21
 *   Time: 8:24 PM
 *   File: Teacher.java
 */

package com.example.gurukul.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Teacher {

    @Id
    private long id;

    public Teacher() {
    }
}