package com.example.hilay_app.response.create;

import lombok.*;
import lombok.experimental.FieldDefaults;


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
