	package com.example.demo.model;


	import jakarta.persistence.*;
	import java.util.List;

	@Entity
	public class LeaveType {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long leaveTypeId;

	    private String leaveName;
	    private int maxDaysAllowed;

	    @OneToMany(mappedBy = "leaveType")
	    private List<LeaveRequest> leaveRequests;

	    // getters and setters
	}
