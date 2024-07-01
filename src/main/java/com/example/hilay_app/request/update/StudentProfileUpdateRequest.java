package com.example.hilay_app.request.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentProfileUpdateRequest {
    private String name;
    private String surname;
    private Long fkImageId;
    private String bio;
    private Long fkGroupId;
}