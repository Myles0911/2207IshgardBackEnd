package service.meetings;

import daos.meetings.MeetingsDAO;
import entities.Meetings;

import java.util.List;

public class MeetingsServiceImpl implements MeetingsService {
    private MeetingsDAO meetingsDAO;

    public MeetingsServiceImpl(MeetingsDAO meetingsDAO) {
        this.meetingsDAO = meetingsDAO;
    }

    @Override
    public Meetings registerMeeting(Meetings meetings) {
        if (meetings.getAddress().length() == 0) {
            throw new RuntimeException(("The meeting must have an address"));
        }
        if (meetings.getSummary().length() == 0) {
            throw new RuntimeException(("The meeting must have a summary"));

        }
        Meetings newMeeting = this.meetingsDAO.createMeetings(meetings);
        return newMeeting;
    }


    @Override
    public List<Meetings> getAllMeetings() {
        return  this.meetingsDAO.getAllComplaints();
    }
}
