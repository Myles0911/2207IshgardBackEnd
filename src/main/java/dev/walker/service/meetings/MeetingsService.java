package dev.walker.service.meetings;

import dev.walker.entities.Meetings;

import java.util.List;

public interface MeetingsService {
Meetings registerMeeting (Meetings meetings);


List<Meetings> getAllMeetings();
}
