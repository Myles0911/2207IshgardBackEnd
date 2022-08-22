package daos.complaints;

import entities.Complaints;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComplaintsDAOLocal implements ComplaintsDAO {

    private final Map<Integer, Complaints> ish_table = new HashMap();
    private int idMaker = 1;

    @Override
    public Complaints createComplaints(Complaints complaints) {

        complaints.setid(idMaker);
        idMaker++;
        ish_table.put(complaints.getid(), complaints);
        System.out.println(ish_table.values());
        return complaints;
    }

    @Override
    public List<Complaints> getAllComplaints() {
        List<Complaints> complaints = new ArrayList<>(this.ish_table.values());
        return complaints;
    }

    @Override
    public Complaints getComplaintById(int id) {
        Complaints complaints = this.ish_table.get(id);
        return complaints;
    }
}
