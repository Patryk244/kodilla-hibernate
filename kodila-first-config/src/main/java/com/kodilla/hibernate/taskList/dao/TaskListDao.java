package com.kodilla.hibernate.taskList.dao;

import com.kodilla.hibernate.taskList.TaskList;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Transactional
@Repository
public interface TaskListDao extends CrudRepository<TaskList, Integer> {
    List<TaskList> findByListName(String listName);
}