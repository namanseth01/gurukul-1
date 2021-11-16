package com.example.gurukul.repository;

import com.example.gurukul.entity.Announcement;
import com.example.gurukul.entity.Assignment;
import com.example.gurukul.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository extends JpaRepository<Assignment,Integer> {

    Assignment findAssignmentByAnnouncementAndStudent(Announcement announcement, Student student);
    Assignment findAssignmentById(int id);
}
