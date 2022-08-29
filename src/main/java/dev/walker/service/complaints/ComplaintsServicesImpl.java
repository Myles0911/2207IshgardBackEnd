package dev.walker.service.complaints;

import dev.walker.daos.complaints.ComplaintsDAO;
import dev.walker.entities.Complaints;
import dev.walker.entities.Status;

import java.util.List;
import java.util.stream.Collectors;

public class ComplaintsServicesImpl implements ComplaintsServices {
    private ComplaintsDAO complaintsDAO;

    public ComplaintsServicesImpl(ComplaintsDAO complaintsDAO) {
        this.complaintsDAO = complaintsDAO;
    }

    @Override
    public Complaints reportComplaint(Complaints complaints) {
        if (complaints.getDescription().length() == 0) {
            throw new RuntimeException("Sorry, to use this application you must register your Complaint");
        }

        Complaints myC = this.complaintsDAO.createComplaints(complaints);
        return myC;
    }

    @Override
    public Complaints getComplaintByID(int id) {
       return this.complaintsDAO.getComplaintById(id);
    }

    @Override
    public List<Complaints> getAllComplaints() {
       return this.complaintsDAO.getAllComplaints();
    }

    @Override
    public Complaints updateComplaintByMeetingID(Complaints complaints, int meeting_id) {
        return this.complaintsDAO.createComplaintByMeeting(complaints, meeting_id);
    }

    @Override
    public List<Complaints> getStatus(Status status) {
        List<Complaints> temp = complaintsDAO.getAllComplaints();

        List <Complaints> complaintByStatus = temp.stream().filter(complaint -> complaint.getStatus() == status).collect(Collectors.toList());
        return complaintByStatus;
    }
}


