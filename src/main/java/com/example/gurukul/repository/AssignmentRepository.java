package com.example.gurukul.repository;

import com.example.gurukul.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository extends JpaRepository<Assignment,Integer> {

    Assignment findAssignmentByAnnouncementAndStudent(int id, long sId);
    Assignment findAssignmentById(int id);
}
