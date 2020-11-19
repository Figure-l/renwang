package com.rw.oru.controller;

import com.rw.oru.dao.DepartmentDao;
import com.rw.oru.dao.EmployeeDao;
import com.rw.oru.entities.Department;
import com.rw.oru.entities.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Collections;

@Controller
public class EmployeeController {
    @Resource
    EmployeeDao employeeDao;
    @Resource
    DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String toEmployeeManager(Model model){

        Collection<Employee> coll = employeeDao.getAll();
        model.addAttribute("emps",coll);
        return "emp/list";
    }
    @GetMapping("/emp")
    public String toAddPage(Model model){
        Collection<Department> coll = departmentDao.getDepartments();
        model.addAttribute("depts",coll);
        return "emp/add";
    }
    @PostMapping("/emp")
    //SpringMvc自动将表单中name对应的属性封装到Employee对象中
    //即SpringMvc回将请求参数和入参对象进行一一绑定
    public String addEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,
                               Model model){
        Employee employee = employeeDao.get(id);
        Collection<Department> coll = departmentDao.getDepartments();
        model.addAttribute("emp",employee);
        model.addAttribute("depts",coll);
        return "emp/edit";
    }
    @PutMapping("/emp")
    public String update(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }

}
