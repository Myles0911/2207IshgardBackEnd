package service.complaints;

import daos.complaints.ComplaintsDAO;
import entities.Complaints;
import service.complaints.ComplaintsServices;

import java.util.List;

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
}

