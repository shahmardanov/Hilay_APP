package com.example.hilay_app.response.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentProfileUpdateResponse {
    private String name;
    private String surname;
    private Long fkImageId;
    private String bio;
    private Long fkGroupId;
}