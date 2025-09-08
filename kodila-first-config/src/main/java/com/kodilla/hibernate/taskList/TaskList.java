package com.kodilla.hibernate.taskList;

import com.kodilla.hibernate.task.Task;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.*;

@Entity
@Table(name = "TASKLISTS")
public final class TaskList {
    private int id;
    private String listName;
    private String description;
    private List<Task> tasks = new ArrayList<>();

    public TaskList() {
    }

    public TaskList(String listName, String description) {
        this.listName = listName;
        this.description = description;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }

    @Column(name = "LISTNAME")
    public String getListName() {
        return listName;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    @OneToMany(
            targetEntity = Task.class,
            mappedBy = "taskList",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Task> getTasks() {
        return tasks;
    }

    // Settery
    public void setId(int id) {
        this.id = id;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    // Metody pomocnicze dla zarządzania relacją
    public void addTask(Task task) {
        tasks.add(task);
        task.setTaskList(this);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
        task.setTaskList(null);
    }
}