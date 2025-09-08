package com.kodilla.hibernate.taskList.dao;

import com.kodilla.hibernate.taskList.TaskList;
import net.bytebuddy.implementation.bytecode.StackSize;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;

    @Test
    void testFindByListName() {
        TaskList taskList = new TaskList("My task", "I will learn java every single day!");

        taskListDao.save(taskList);
        String listName = taskList.getListName();
        List<TaskList> readTasks = taskListDao.findByListName(listName);
        assertEquals(1, readTasks.size());
        taskListDao.deleteAll();
    }
}