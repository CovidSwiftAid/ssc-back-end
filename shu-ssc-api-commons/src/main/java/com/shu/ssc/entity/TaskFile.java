package com.shu.ssc.entity;


import lombok.Data;

@Data
public class TaskFile {
    private Integer taskFileId;

    private String fileUrl;

    private Integer taskId;

    private String fileName;

    public Integer getTaskFileId() {
        return taskFileId;
    }

    public void setTaskFileId(Integer taskFileId) {
        this.taskFileId = taskFileId;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}