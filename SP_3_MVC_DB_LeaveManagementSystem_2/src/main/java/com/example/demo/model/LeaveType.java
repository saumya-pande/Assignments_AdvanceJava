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

		public LeaveType() {
			super();
		}

		public LeaveType(Long leaveTypeId, String leaveName, int maxDaysAllowed, List<LeaveRequest> leaveRequests) {
			super();
			this.leaveTypeId = leaveTypeId;
			this.leaveName = leaveName;
			this.maxDaysAllowed = maxDaysAllowed;
			this.leaveRequests = leaveRequests;
		}

		public Long getLeaveTypeId() {
			return leaveTypeId;
		}

		public void setLeaveTypeId(Long leaveTypeId) {
			this.leaveTypeId = leaveTypeId;
		}

		public String getLeaveName() {
			return leaveName;
		}

		public void setLeaveName(String leaveName) {
			this.leaveName = leaveName;
		}

		public int getMaxDaysAllowed() {
			return maxDaysAllowed;
		}

		public void setMaxDaysAllowed(int maxDaysAllowed) {
			this.maxDaysAllowed = maxDaysAllowed;
		}

		public List<LeaveRequest> getLeaveRequests() {
			return leaveRequests;
		}

		public void setLeaveRequests(List<LeaveRequest> leaveRequests) {
			this.leaveRequests = leaveRequests;
		}

	    // getters and setters
	    
	}
