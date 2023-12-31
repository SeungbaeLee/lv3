package com.hh99.lv3.domain.admin.dto;

import com.hh99.lv3.domain.admin.entity.Admin;
import com.hh99.lv3.domain.admin.entity.Department;
import com.hh99.lv3.domain.admin.entity.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AdminPostDto {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Pattern(
            regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,15}$",
            message = "비밀번호는 알파벳 대소문자, 숫자, 특수문자를 모두 포함해야 합니다."
    )
    private String password;

    @NotBlank
    private Department department;

    @NotBlank
    private Role role;

    @Builder
    public AdminPostDto(String email, String password, Department department, Role role) {
        this.email = email;
        this.password = password;
        this.department = department;
        this.role = role;
    }

    public Admin toEntity() {
        return Admin.builder()
                .email(this.email)
                .password(this.password)
                .department(this.department)
                .role(this.role)
                .build();
    }
}
