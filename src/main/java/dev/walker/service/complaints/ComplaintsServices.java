package dev.walker.service.complaints;

import dev.walker.entities.Complaints;
import dev.walker.entities.Status;

import java.util.List;

public interface ComplaintsServices {
    Complaints reportComplaint (Complaints complaints);

Complaints updateComplaintByMeetingID(Complaints complaints, int meeting_id);
    Complaints getComplaintByID(int id);

    List<Complaints> getAllComplaints();

    List<Complaints> getStatus (Status status);
}
