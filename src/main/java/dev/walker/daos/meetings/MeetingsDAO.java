package dev.walker.daos.meetings;

import dev.walker.entities.Meetings;

import java.util.List;

public interface MeetingsDAO {

    Meetings createMeetings(Meetings meetings);
    List<Meetings> getAllComplaints();
}
