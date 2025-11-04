package com.example.chatserver.member.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor // Builder는 모든 멤버들이 모두 들어간 생성자가 필요한데 그 생성자를 만들어주는 어노테이션
@NoArgsConstructor // AllArgsConstructor로 인해 사라진 기본 생성자 추가
@Getter // private 멤버에 접근할 수 있는 public 메서드 자동 생성
@Entity // 정의된 멤버들이 DB에 만들어지도록 하는 어노테이션
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increment 기능
    private Long id;

    // 별다른 어노테이션이 없다면 DB에 varchar(255) 타입으로 생성된다.
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    private String password;

    // admin or 일반유저
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Role role = Role.USER;
}
