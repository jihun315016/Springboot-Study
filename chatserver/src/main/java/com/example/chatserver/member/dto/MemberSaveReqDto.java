package com.example.chatserver.member.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 아래 세 개 어노테이션은 DTO 만들때 기본적으로 사용하는 어노테이션이라 생각하면 됌
// DTO가 아니라 Entity라면 Setter는 안 넣는 게 좋으므로 Data 말고 다른거 넣기
@Data // Getter, Setter, ToString 자동 구현
@AllArgsConstructor
@NoArgsConstructor
public class MemberSaveReqDto {
    private String name;

    private String email;

    private String password;
}
