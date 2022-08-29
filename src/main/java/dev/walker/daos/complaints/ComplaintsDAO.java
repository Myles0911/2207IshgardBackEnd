package dev.walker.daos.complaints;

import dev.walker.entities.Complaints;
import dev.walker.entities.Status;

import java.util.List;


public interface ComplaintsDAO {
        //Create
       Complaints createComplaints(Complaints complaints);

       Complaints createComplaintByMeeting(Complaints complaints, int meeting_id);

        List<Complaints> getStatus (Status status);


       //Get all Complaints
        List<Complaints> getAllComplaints();

        //Get Individual Complaint
    Complaints getComplaintById(int id);
}
