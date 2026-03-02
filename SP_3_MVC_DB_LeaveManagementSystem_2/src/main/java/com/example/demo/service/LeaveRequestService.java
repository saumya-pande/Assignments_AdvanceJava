package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.temporal.ChronoUnit;
import java.util.List;

import com.example.demo.model.LeaveRequest;
import com.example.demo.model.LeaveType;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.LeaveRequestRepository;
import com.example.demo.repository.LeaveTypeRepository;

@Service
public class LeaveRequestService {

    @Autowired
    private LeaveRequestRepository leaveRequestRepository;

    @Autowired
    private LeaveTypeRepository leaveTypeRepository;

    // Apply Leave
    public LeaveRequest applyLeave(LeaveRequest leaveRequest) {

        LeaveType leaveType = leaveTypeRepository
                .findById(leaveRequest.getLeaveType().getLeaveTypeId())
                .orElseThrow(() -> new RuntimeException("Leave Type not found"));

        long days = ChronoUnit.DAYS.between(
                leaveRequest.getStartDate(),
                leaveRequest.getEndDate()) + 1;

        if (days > leaveType.getMaxDaysAllowed()) {
            throw new RuntimeException("Leave exceeds maximum allowed days");
        }

        leaveRequest.setStatus("Pending");

        return leaveRequestRepository.save(leaveRequest);
    }

    // Approve or Reject Leave
    public LeaveRequest updateLeaveStatus(Long id, String status) {

        LeaveRequest leaveRequest = leaveRequestRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Leave Request not found"));

        leaveRequest.setStatus(status);

        return leaveRequestRepository.save(leaveRequest);
    }

    // Get Leave Requests By Employee
    public List<LeaveRequest> getLeaveRequestsByEmployee(Long employeeId) {
        return leaveRequestRepository.findByEmployeeEmployeeId(employeeId);
    }

    // Get Leave Request By Id
    public LeaveRequest getLeaveRequestById(Long id) {
        return leaveRequestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Leave Request not found"));
    }
    
    public List<LeaveRequest> getAllRequests() {
        return leaveRequestRepository.findAll();
    }
}