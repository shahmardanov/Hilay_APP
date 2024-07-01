package com.example.hilay_app.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentProfileResponse {

    private Long fkImageId;
    private String bio;
    private Long fkGroupId;
}
