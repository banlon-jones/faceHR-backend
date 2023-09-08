package com.micro.faceHR.controllers;

import com.micro.faceHR.domain.models.User;
import com.micro.faceHR.domain.services.UserService;
import com.micro.faceHR.dto.EmployeeInfo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/protected/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateEmployee(@RequestBody @Valid EmployeeInfo employeeInfo, @PathVariable String userId) {
        return ResponseEntity.ok(userService.updateEmployeeInfo(employeeInfo, UUID.fromString(userId)));
    }
}
