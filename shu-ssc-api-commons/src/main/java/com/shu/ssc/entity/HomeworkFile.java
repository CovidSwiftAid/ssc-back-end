package com.shu.ssc.entity;


import lombok.Data;

@Data
public class HomeworkFile {
    private Integer homeworkFileId;

    private Integer homeworkId;

    private String fileUrl;

    private String fileName;

    public Integer getHomeworkFileId() {
        return homeworkFileId;
    }

    public void setHomeworkFileId(Integer homeworkFileId) {
        this.homeworkFileId = homeworkFileId;
    }

    public Integer getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(Integer homeworkId) {
        this.homeworkId = homeworkId;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}