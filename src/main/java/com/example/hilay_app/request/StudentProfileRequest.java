package com.example.hilay_app.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentProfileRequest {
    private String username;
    private Long fkImageId;
    private String bio;
    private Long fkGroupId;
}
