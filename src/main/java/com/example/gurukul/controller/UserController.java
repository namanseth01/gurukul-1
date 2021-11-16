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
    private AssignmentRepository assignmentRepository;

    @Autowired
    private AnnouncementRepository announcementRepository;

    @ResponseBody
    @RequestMapping(value = "/class", method = RequestMethod.POST)
    public ResponseEntity<?> getClasses(@RequestBody HashMap<String, Object> map){
        Long id = Long.parseLong((String) map.get("id"));
        Student student = this.studentRepository.getById(id);
        List<Classes> classesList = student.getClasses();
        ArrayList<String> list = new ArrayList<>();
        for (Classes classes: classesList) {
            list.add(classes.stringTo());
        }
        return ResponseEntity.ok(Map.of("list",list));

    }

    @ResponseBody
    @RequestMapping(value = "/announce", method = RequestMethod.POST)
    public ResponseEntity<?> createAnnouncements(@RequestBody HashMap<String, Object> map) throws ParseException {
        Announcement announcement = new Announcement();
        announcement.setMsg((String)map.get("msg"));
        announcement.setMessage((String)map.get("msg"));
        Date date=new SimpleDateFormat("dd/MM/yyyy").parse((String) map.get("date"));
        announcement.setDate(date);
        int classId = Integer.parseInt((String)((Map)map.get("classes")).get("secretCode"));
        Classes classes = this.classesRepository.findClassesBySecretCode(classId);
        announcement.setClasses(classes);
        if(map.get("dueDate")!=null){
            Date dueDate = new SimpleDateFormat("dd/MM/yyyy").parse((String) map.get("dueDate"));
            announcement.setDueDate(dueDate);
            List<Assignment> assignments = new ArrayList<>();
            announcement.setAssignments(assignments);
        }
        List<Announcement> list = classes.getAnnouncement();
        list.add(announcement);
        classes.setAnnouncement(list);
        classesRepository.save(classes);
        announcementRepository.save(announcement);
        return ResponseEntity.ok(Map.of("classes", classes));
    }

    @ResponseBody
    @RequestMapping(value = "/classes", method = RequestMethod.POST)
    public ResponseEntity<?> displayClasses(@RequestBody HashMap<String, Object> map){
        Long id = Long.parseLong((String) map.get("id"));
        List<Classes> listOfClasses = new ArrayList<Classes>();
        if(this.studentRepository.getById(id)!=null){
            Student student = this.studentRepository.getById(id);
            listOfClasses = student.getClasses();
        }if(this.teacherRepository.getById(id)!=null){
            Teacher teacher = this.teacherRepository.getById(id);
            listOfClasses = teacher.getClasses();
        }
        return ResponseEntity.ok(Map.of("listOfClasses", listOfClasses));
    }

    @ResponseBody
    @RequestMapping(value = "/comments", method = RequestMethod.POST)
    public ResponseEntity<?> createComments(@RequestBody HashMap<String, Object> map){
        int aId = Integer.parseInt((String) map.get("uId"));
        Announcement announcement = this.announcementRepository.getById(aId);
        List<Comment> commentsUnderAnnouncement = new ArrayList<Comment>();
        commentsUnderAnnouncement = announcement.getComment();
        Comment comment = new Comment();
        comment.setId(Integer.parseInt( (String)map.get("id")));
        comment.setMessage((String) map.get("message"));
        comment.setType((String) map.get("type"));
        comment.setTeacher((Teacher) map.get("Teacher"));
        comment.setStudent((Student) map.get("Student"));
        commentsUnderAnnouncement.add(comment);
        announcement.setComment(commentsUnderAnnouncement);
        return ResponseEntity.ok(Map.of("commentUnderAnnouncement", commentsUnderAnnouncement));
    }

    @ResponseBody
    @RequestMapping(value = "/displayComments", method = RequestMethod.POST)
    public ResponseEntity<?> displayComments(@RequestBody HashMap<String, Object> map){
        Integer.parseInt((String) map.get("id"));
        Announcement announcement = this.announcementRepository.getById(Integer.parseInt((String) map.get("id")));
        List<Comment> comments = new ArrayList<Comment>();
        comments = announcement.getComment();
        return ResponseEntity.ok(Map.of("Comments", comments));
    }


}
