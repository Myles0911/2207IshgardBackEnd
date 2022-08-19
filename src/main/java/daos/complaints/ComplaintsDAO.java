package daos.complaints;

import entities.Complaints;

import java.util.List;


public interface ComplaintsDAO {
        //Create
       Complaints createComplaints(Complaints complaints);


       //Get all Complaints
        List<Complaints> getAllComplaints();

        //Get Individual Complaint
    Complaints getComplaintById(int complain_id);
}
