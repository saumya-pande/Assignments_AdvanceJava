package com.example.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.*;
import com.example.demo.model.LeaveRequest;

@Controller
public class LeaveRequestController {

    private final LeaveRequestService leaveService;
    private final EmployeeService employeeService;
    private final LeaveTypeService leaveTypeService;

    public LeaveRequestController(LeaveRequestService leaveService,
                                  EmployeeService employeeService,
                                  LeaveTypeService leaveTypeService) {
        this.leaveService = leaveService;
        this.employeeService = employeeService;
        this.leaveTypeService = leaveTypeService;
    }

    @GetMapping("/applyLeave")
    public String form(Model model) {
        model.addAttribute("leaveRequest", new LeaveRequest());
        model.addAttribute("employees", employeeService.getAll());
        model.addAttribute("leaveTypes", leaveTypeService.getAll());
        return "apply-leave";
    }

    @PostMapping("/saveLeave")
    public String save(@ModelAttribute LeaveRequest request) {
        leaveService.applyLeave(request);
        return "redirect:/leaveRequests";
    }

    @GetMapping("/leaveRequests")
    public String list(Model model) {
        model.addAttribute("requests", leaveService.getAll());
        return "leave-list";
    }

    @GetMapping("/approve/{id}")
    public String approve(@PathVariable Long id) {
        leaveService.approve(id);
        return "redirect:/leaveRequests";
    }

    @GetMapping("/reject/{id}")
    public String reject(@PathVariable Long id) {
        leaveService.reject(id);
        return "redirect:/leaveRequests";
    }
}
