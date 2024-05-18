package com.vidyasagar.coding.dsa;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MinMeetingRoom {


  public int solve(ArrayList<ArrayList<Integer>> a) {
   PriorityQueue<Integer> minHeapMeetingEndTimes = new PriorityQueue<>();
    List<MeetingTiming> meetingTimings = new ArrayList<>();
    int n = a.size();

    for (int i = 0; i<n; i++) {
      meetingTimings.add(new MeetingTiming(a.get(i).get(0), a.get(i).get(1)));
    }

    Collections.sort(meetingTimings, new MeetingSorter());

    int minMeetingRooms = 0;

    for (MeetingTiming meetingTiming : meetingTimings) {
      if (minHeapMeetingEndTimes.isEmpty()) {
        minHeapMeetingEndTimes.add(meetingTiming.getEndTime());
      } else {
        if (minHeapMeetingEndTimes.peek() <= meetingTiming.getStartTime()) {
          minHeapMeetingEndTimes.remove();
        }
        minHeapMeetingEndTimes.add(meetingTiming.getEndTime());
      }

      minMeetingRooms = Math.max(minHeapMeetingEndTimes.size(), minMeetingRooms);
    }



//    TreeMap<Integer, Integer> meetingStartCount = new TreeMap<>();
//    for (int i = 0; i<n; i++) {
//      int startTime = a.get(i).get(0);
//      int endTime = a.get(i).get(1);
//
//      meetingStartCount.put(startTime, meetingStartCount.getOrDefault(startTime, 0) + 1);
//      meetingStartCount.put(endTime, meetingStartCount.getOrDefault(endTime, 0) - 1);
//    }
//
//    int ans = 0;
//    int c = 0;
//    for (Map.Entry<Integer, Integer> entry : meetingStartCount.entrySet()) {
//      c += entry.getValue();
//      ans = Math.max(ans, c);
//    }


    return minMeetingRooms;
  }
}

class MeetingTiming {
  private int startTime;
  private int endTime;
  public MeetingTiming(int startTime, int endTime) {
    this.startTime = startTime;
    this.endTime = endTime;
  }

  public int getStartTime() {
    return this.startTime;
  }

  public int getEndTime() {
    return this.endTime;
  }
}

class MeetingSorter implements Comparator<MeetingTiming> {
  public int compare(MeetingTiming a, MeetingTiming b) {
    return a.getStartTime() - b.getStartTime();
  }
}
