/*   Created by IntelliJ IDEA.
 *   Author: Devvrat Sharma (devrats)
 *   Date: 13-Nov-21
 *   Time: 8:37 PM
 *   File: HomeController.java
 */

package com.example.gurukul.controller;


import com.example.gurukul.entity.Student;
import com.example.gurukul.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RestController
public class HomeController {


    @Autowired
    private StudentRepository studentRepository;

    @ResponseBody
    @RequestMapping(value = "/enter", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody HashMap<String, Object> map) {
        Student student = new Student();
        student.setId(Long.parseLong((String) map.get("id")));
        studentRepository.save(student);
        return ResponseEntity.ok(Map.of("idea",1234565));
    }

}