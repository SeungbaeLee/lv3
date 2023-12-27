package com.hh99.lv3.admin.dto;

import com.hh99.lv3.admin.entity.Admin;
import com.hh99.lv3.admin.entity.Department;
import com.hh99.lv3.admin.entity.Role;
import lombok.Builder;
import lombok.Getter;

@Getter
public class AdminResponseDto {
    private String email;
    private Department department;
    private Role role;

    @Builder
    public AdminResponseDto(String email, Department department, Role role) {
        this.email = email;
        this.department = department;
        this.role = role;
    }

    public static AdminResponseDto fromEntity(Admin admin) {
        return AdminResponseDto.builder()
                .email(admin.getEmail())
                .department(admin.getDepartment())
                .role(admin.getRole())
                .build();
    }
}
