package com.kodilla.hibernate.manytomany;

import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

@SpringBootTest
class EmployeeTest {

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void findByLastName() {
        Employee employee1 = new Employee("Jan", "Kowalski");
        Employee employee2 = new Employee("Maciej", "Nowak");
        Employee employee3 = new Employee("Andrzej", "Nowak");
        employeeDao.save(employee1);
        employeeDao.save(employee2);
        employeeDao.save(employee3);
        List<Employee> foundKowalski = employeeDao.findEmployeesByLastName("Kowalski");
        List<Employee> foundNowak = employeeDao.findEmployeesByLastName("Nowak");

        assertEquals(1, foundKowalski.size());
        assertNotEquals(1, foundNowak.size());
        employeeDao.deleteAll();
    }
}