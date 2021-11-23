/*   Created by IntelliJ IDEA.
 *   Author: Devvrat Sharma (devrats)
 *   Date: 13-Nov-21
 *   Time: 8:37 PM
 *   File: UserController.java
 */

package com.example.gurukul.controller;

import com.example.gurukul.entity.*;
import com.example.gurukul.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


@CrossOrigin
@Controller
@RestController
public class UserController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ClassesRepository classesRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private AnnouncementRepository announcementRepository;

    @Autowired
    private CommentRepository commentRepository;

    @ResponseBody
    @RequestMapping(value = "/announce", method = RequestMethod.POST)
    public ResponseEntity<?> createAnnouncements(@RequestBody HashMap<String, Object> map) throws ParseException {
        Announcement announcement = new Announcement();
        announcement.setMsg((String)map.get("title"));
        announcement.setMessage((String)map.get("msg"));
        Date date= new Date();
        announcement.setDate(date);
        int classId = (int) Long.parseLong((String)map.get("secretCode"));
        Classes classes = this.classesRepository.findClassesBySecretCode(classId);
        announcement.setClasses(classes);
        List<Announcement> list = classes.getAnnouncement();
        list.add(announcement);
        classes.setAnnouncement(list);
        if(map.get("dueDate")!=null){
            Date dueDate = new SimpleDateFormat("dd/MM/yyyy").parse((String) map.get("dueDate"));
            announcement.setDueDate(dueDate);
            List<Assignment> assignments = new ArrayList<>();
            announcement.setAssignments(assignments);
        }
        classesRepository.save(classes);
        announcementRepository.save(announcement);
        return ResponseEntity.ok(Map.of("classes", classes));
    }

    @ResponseBody
    @RequestMapping(value = "/classes", method = RequestMethod.POST)
    public ResponseEntity<?> displayClasses(@RequestBody HashMap<String, Object> map){
        String id = (String) map.get("id");
        List<Classes> listOfClasses = new ArrayList<>();
        if(this.studentRepository.findStudentById(id)!=null){
            Student student = this.studentRepository.findStudentById(id);
            listOfClasses = student.getClasses();
        }else{
            Teacher teacher = this.teacherRepository.findTeacherById(id);
            listOfClasses = teacher.getClasses();
        }
        return ResponseEntity.ok(Map.of("listOfClasses", listOfClasses));
    }

    @ResponseBody
    @RequestMapping(value = "/comments", method = RequestMethod.POST)
    public ResponseEntity<?> createComments(@RequestBody HashMap<String, Object> map){
        String aId = (String) map.get("uId");
        Announcement announcement = this.announcementRepository.getById(Integer.parseInt((String) map.get("announcementId")));
        List<Comment> commentsUnderAnnouncement = announcement.getComment();
        Comment comment = new Comment();
        comment.setAnnouncement(announcement);
        comment.setMessage((String) map.get("message"));
        Teacher teacher = null;
        Student student = null;
        if(studentRepository.findStudentById(aId)!=null){
            student = studentRepository.findStudentById(aId);
            comment.setStudent(student);
            List<Comment> comments = student.getComments();
            comments.add(comment);
        } else{
            comment.setTeacher(teacherRepository.findTeacherById(aId));
            teacher = teacherRepository.findTeacherById(aId);
            comment.setTeacher(teacher);
            List<Comment> comments = teacher.getComments();
            comments.add(comment);
        }
        commentsUnderAnnouncement.add(comment);
        announcement.setComment(commentsUnderAnnouncement);
        commentRepository.save(comment);
        announcementRepository.save(announcement);
        if(student!=null){
            studentRepository.save(student);
        } else {
            teacherRepository.save(teacher);
        }
        return ResponseEntity.ok(Map.of("commentUnderAnnouncement", commentsUnderAnnouncement));
    }
}
