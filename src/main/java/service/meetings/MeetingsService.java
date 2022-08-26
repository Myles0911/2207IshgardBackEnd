package service.meetings;

import entities.Meetings;

import java.util.List;

public interface MeetingsService {
Meetings registerMeeting (Meetings meetings);


List<Meetings> getAllMeetings();
}
