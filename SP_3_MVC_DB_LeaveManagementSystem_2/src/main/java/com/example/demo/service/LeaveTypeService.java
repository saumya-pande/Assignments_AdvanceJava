package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.LeaveType;
import com.example.demo.repository.LeaveTypeRepository;

@Service
public class LeaveTypeService {

    @Autowired
    private LeaveTypeRepository leaveTypeRepository;

    // Add Leave Type
    public LeaveType addLeaveType(LeaveType leaveType) {
        return leaveTypeRepository.save(leaveType);
    }

    // View All Leave Types
    public List<LeaveType> getAllLeaveTypes() {
        return leaveTypeRepository.findAll();
    }

    // Delete Leave Type
    public void deleteLeaveType(Long id) {
        leaveTypeRepository.deleteById(id);
    }

    // Get Leave Type By Id
    public LeaveType getLeaveTypeById(Long id) {
        return leaveTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Leave Type not found"));
    }
}