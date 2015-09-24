package com.leolai.todolist;


import java.util.Date;

public class ToDoItem {

    private String task;
    private Date createDate;

    public ToDoItem(String task) {
        this(task, new Date(java.lang.System.currentTimeMillis()));
    }

    public ToDoItem(String task, Date createDate) {
        this.task = task;
        this.createDate = createDate;
    }

    public String getTastName() {
        return task;
    }

    public Date getCreateDate() {
        return createDate;
    }

    @Override
    public String toString() {
        return "ToDoItem{" +
                "task='" + task + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}