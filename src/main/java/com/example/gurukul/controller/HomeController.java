/*   Created by IntelliJ IDEA.
 *   Author: Devvrat Sharma (devrats)
 *   Date: 13-Nov-21
 *   Time: 8:37 PM
 *   File: HomeController.java
 */

package com.example.gurukul.controller;


import com.example.gurukul.entity.*;
import com.example.gurukul.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Controller
@RestController
public class HomeController {


    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private ClassesRepository classesRepository;
    @Autowired
    private AnnouncementRepository announcementRepository;
    @Autowired
    private AssignmentRepository assignmentRepository;

    @ResponseBody
    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public ResponseEntity<?> signUp(@RequestBody HashMap<String, Object> map) {
        if(map.get("role").equals("teacher")){
            Teacher teacher = new Teacher();
            teacher.setId(Long.parseLong((String) map.get("id")));
            teacher.setName((String) map.get("name"));
            teacher.setEmail((String) map.get("email"));
            teacherRepository.save(teacher);
        } else{
            Student student = new Student();
            student.setId(Long.parseLong((String) map.get("id")));
            student.setName((String) map.get("name"));
            student.setEmail((String) map.get("email"));
            studentRepository.save(student);
        }
        return ResponseEntity.ok(Map.of("Status","success"));
    }

    @ResponseBody
    @RequestMapping(value = "/createClass", method = RequestMethod.POST)
    public ResponseEntity<?> createClass(@RequestBody HashMap<String, Object> map) {
        Classes classes = new Classes();
        classes.setTitle((String) map.get("title"));
        classes.setTopic((String) map.get("topic"));
        classes.setMotto((String) map.get("motto"));
        Teacher teacher = teacherRepository.findById(Long.parseLong((String) map.get("id")));
        Random rnd = new Random();
        while (true){
            int number = rnd.nextInt(999999);
            String secretCode = String.format("%06d", number);
            Classes classes1 = classesRepository.findClassesBySecretCode(Long.parseLong(secretCode));
            if(classes1==null){
                classes.setSecretCode(Long.parseLong(secretCode));
                break;
            }
        }
        classes.setTeacher(teacher);
        List<Classes> classes1 = teacher.getClasses();
        classes1.add(classes);
        classesRepository.save(classes);
        teacherRepository.save(teacher);
        return ResponseEntity.ok(Map.of("SecretCode",classes.getSecretCode()));
    }

    @ResponseBody
    @RequestMapping(value = "/studentJoinClass", method = RequestMethod.POST)
    public ResponseEntity<?> studentJoinsClass(@RequestBody HashMap<String, Object> map){
        Classes classes = classesRepository.findClassesBySecretCode(Long.parseLong((String) map.get("secretCode")));
        Student student = studentRepository.findById(Long.parseLong((String) map.get("id")));
        List<Student> student1 = classes.getStudent();
        List<Classes> classes1 = student.getClasses();
        classes1.add(classes);
        student1.add(student);
        classesRepository.save(classes);
        studentRepository.save(student);
        return ResponseEntity.ok(Map.of("Status","success"));
    }

    @ResponseBody
    @RequestMapping(value = "/fetchAnnouncements", method = RequestMethod.POST)
    public ResponseEntity<?> fetchAnnouncements(@RequestBody HashMap<String, Object> map){
        Classes classesBySecretCode = classesRepository.findClassesBySecretCode(Long.parseLong((String)
                map.get("secretCode")));
        List<Announcement> announcement = classesBySecretCode.getAnnouncement();
        return ResponseEntity.ok(Map.of("announcement",announcement));
    }

    @ResponseBody
    @RequestMapping(value = "/fetchAnnouncementsDetails", method = RequestMethod.POST)
    public ResponseEntity<?> fetchAnnouncementDetails(@RequestBody HashMap<String, Object> map){
        Announcement announcement = announcementRepository.findAnnouncementById(Integer.parseInt((String)
                map.get("announcementId")));
        Teacher teacher = teacherRepository.findById(Long.parseLong((String) map.get("uId")));
        if(teacher!=null) {
            List<Assignment> assignments = announcement.getAssignments();
            return ResponseEntity.ok(Map.of("announcement",announcement,"assignment",assignments));
        } else {
            Assignment assignment = assignmentRepository.findAssignmentByAnnouncementAndStudent
                    (Integer.parseInt((String) map.get("announcementId")), Long.parseLong((String) map.get("uId")));
            return ResponseEntity.ok(Map.of("announcement",announcement,"assignment",assignment));
        }
    }

}