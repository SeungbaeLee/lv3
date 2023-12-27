package com.hh99.lv3.admin.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;
    private String email;
    private String password;
    @Enumerated(value = EnumType.STRING)
    private Department department;
    @Enumerated(value = EnumType.STRING)
    private Role role;
    private String refreshToken;

    @Builder
    public Admin(Long adminId, String email, String password, Department department, Role role) {
        this.adminId = adminId;
        this.email = email;
        this.password = password;
        this.department = department;
        this.role = role;
    }

    public void updateRefreshToken(String updateRefreshToken) {
        this.refreshToken = updateRefreshToken;
    }
}
