/*   Created by IntelliJ IDEA.
 *   Author: Devvrat Sharma (devrats)
 *   Date: 13-Nov-21
 *   Time: 8:37 PM
 *   File: UserController.java
 */

package com.example.gurukul.controller;

import com.example.gurukul.entity.Classes;
import com.example.gurukul.entity.Student;
import com.example.gurukul.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RestController
public class UserController {

    @Autowired
    private StudentRepository studentRepository;

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
}
