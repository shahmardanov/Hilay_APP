package com.example.hilay_app.response.create;

import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentCreateResponse {

    private String name;
    private String surname;
    private String username;
    private String password;
}
