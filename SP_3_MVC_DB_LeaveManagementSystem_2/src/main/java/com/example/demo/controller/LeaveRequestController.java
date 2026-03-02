package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.LeaveRequest;
import com.example.demo.model.LeaveType;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.LeaveRequestService;
import com.example.demo.service.LeaveTypeService;

@Controller
@RequestMapping("/leave-requests")
public class LeaveRequestController {

    @Autowired
    private LeaveRequestService leaveRequestService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private LeaveTypeService leaveTypeService;

    // DASHBOARD (Main Page)
    @GetMapping
    public String dashboard(Model model) {

        model.addAttribute("leaveType", new LeaveType());
        model.addAttribute("leaveRequest", new LeaveRequest());
        model.addAttribute("employees", employeeService.getAllEmployees());
        model.addAttribute("leaveTypes", leaveTypeService.getAllLeaveTypes());
        model.addAttribute("leaveRequests", leaveRequestService.getAllRequests());

        return "dashboard";
    }

    @PostMapping("/save")
    public String applyLeave(@ModelAttribute LeaveRequest leaveRequest) {
        leaveRequestService.applyLeave(leaveRequest);
        return "redirect:/leave-requests";
    }

    @GetMapping("/approve/{id}")
    public String approve(@PathVariable Long id) {
        leaveRequestService.updateLeaveStatus(id, "Approved");
        return "redirect:/leave-requests";
    }

//    @GetMapping("/delete/{id}")
//    public String delete(@PathVariable Long id) {
//        leaveRequestService.de(id);
//        return "redirect:/leave-requests";
//    }
}