package daos;

import entities.Complaints;

public interface ComplaintsDao {

    Complaints createComplaint (Complaints complaints);

    Complaints getComplaintID (int id );



}
