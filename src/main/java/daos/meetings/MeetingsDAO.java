package daos.meetings;

import entities.Meetings;

import java.util.List;

public interface MeetingsDAO {

    Meetings createMeetings(Meetings meetings);
    List<Meetings> getAllComplaints();
}
