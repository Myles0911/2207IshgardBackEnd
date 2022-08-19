package daos.complaints;

import entities.Complaints;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComplaintsDAOLocal implements ComplaintsDAO {

    private Map<Integer, Complaints> ish_table = new HashMap();
    private int idMaker = 1;

    @Override
    public Complaints createComplaints(Complaints complaints) {

        complaints.setComplain_id(idMaker);
        idMaker++;
        ish_table.put(complaints.getComplain_id(),complaints);
        System.out.println(ish_table.values());
        return complaints;
    }

    @Override
    public List<Complaints> getAllComplaints() {
        List<Complaints> complaints = new ArrayList<>(this.ish_table.values());
        return complaints;
    }

    @Override
    public Complaints getComplaintById(int complain_id) {
        Complaints complaints = this.ish_table.get(complain_id);
        return complaints;
    }
}
