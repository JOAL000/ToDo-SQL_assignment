package org.example.Model;

import java.time.LocalDate;
import java.util.Objects;

public class TodoItem {

    private int id;
    private String title;
    private String taskDescription;
    private LocalDate deadLine;
    private boolean done;
    private int creator;

    public TodoItem(int id, String title,String taskDescription,LocalDate deadLine, boolean done, int creator) {
        this.taskDescription = taskDescription;
        this.creator = creator;
        this.done = done;
        this.deadLine = deadLine;
        this.title = title;
        this.id = id;
    }

    public TodoItem(String title, String taskDescription, LocalDate deadLine, boolean done, int creator) {
        this.title = title;
        this.taskDescription = taskDescription;
        this.deadLine = deadLine;
        this.done = done;
        this.creator = creator;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title!=null || title.isBlank()){
            this.title = title;
        }
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDate deadLine) {
        if (deadLine!=null){
            this.deadLine = deadLine;
        }

    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }

    public boolean isOverdue(){
       return deadLine.isBefore(LocalDate.now());
    }


    @Override
    public String toString() {
        return "TodoItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", deadLine=" + deadLine +
                ", done=" + done +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoItem todoItem = (TodoItem) o;
        return id == todoItem.id &&
                done == todoItem.done &&
                Objects.equals(title, todoItem.title) &&
                Objects.equals(taskDescription, todoItem.taskDescription) &&
                Objects.equals(deadLine, todoItem.deadLine);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, title, taskDescription, deadLine, done);
    }


}
