package com.example.hilay_app.request.create;

import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentCreateRequest {



    private String name;
    private String surname;


    private String username;

    private String password;



}
