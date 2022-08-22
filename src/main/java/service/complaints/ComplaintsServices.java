package service.complaints;

import entities.Complaints;

import java.util.List;

public interface ComplaintsServices {
    Complaints reportComplaint (Complaints complaints);


    Complaints getComplaintByID(int id);

    List<Complaints> getAllComplaints();
}
