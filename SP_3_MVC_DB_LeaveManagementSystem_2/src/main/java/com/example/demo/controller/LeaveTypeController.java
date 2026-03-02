package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.LeaveType;
import com.example.demo.service.LeaveTypeService;

@Controller
@RequestMapping("/leave-types")
public class LeaveTypeController {

    @Autowired
    private LeaveTypeService leaveTypeService;

    @GetMapping
    public String viewLeaveTypes(Model model) {
    	model.addAttribute("leaveTypes", leaveTypeService.getAllLeaveTypes());
    	model.addAttribute("pageTitle", "Leave Types");
        return "dashboard";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("leaveType", new LeaveType());
        return "dashboard";
    }

    @PostMapping("/save")
    public String saveLeaveType(@ModelAttribute LeaveType leaveType) {
        leaveTypeService.addLeaveType(leaveType);
        return "redirect:/dashboard";
    }
}