package com.shu.ssc.common.dto;

import lombok.Data;

@Data
public class StudentDto {
    String nickname;
    String sex;
    String school;
    Integer majorId;
    String grade;
    String picUrl;
}