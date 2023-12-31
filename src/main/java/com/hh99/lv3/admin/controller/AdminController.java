package com.hh99.lv3.admin.controller;

import com.hh99.lv3.admin.dto.AdminPostDto;
import com.hh99.lv3.admin.dto.AdminResponseDto;
import com.hh99.lv3.admin.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/admins")
@RestController
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/sign-up")
    public ResponseEntity createAdmin(@RequestBody AdminPostDto postDto) {
        AdminResponseDto createdAdmin = adminService.createAdmin(postDto);
        return new ResponseEntity<>(createdAdmin, HttpStatus.CREATED);
    }
}
