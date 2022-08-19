package service;

import daos.complaints.ComplaintsDAO;
import entities.Complaints;

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
        if (complaints.getStatus().length() == 0) {
            throw new RuntimeException("Sorry, you must place a status on this complaint");
        }
        if(complaints.getMeeting_id() == 0) {
            throw new RuntimeException("This complaint must be matched with a meeting");
        }
        Complaints myC = this.complaintsDAO.createComplaints(complaints);
        return complaints;
    }
}

