/*
 * Given on call rotation schedule for multiple people by their unique name, start time ( timestamp 0-max int64) and end time ( timestamp 0-max int64) of the rotation
Example input
Name | start | end
———|——|——-
Abby  |  10    |  100
Ben     |  50   |  70
Carla  |  60   |  120
David |  150 |  300
Your goal is to return a rotation table without overlapping periods representing who is on call during that time.
Return start time, end time and list of in call people.
Don’t include time periods that don’t have on call people. Specifically in the given example, this means excluding the period between 120-150.
Example output
start | end |  names
——|——|——-    
10     |  50    |  abby
50    |  60   |  abby, Ben
60    |  70   |  abby, Ben, carla
70    |  100 |  abby, Carla
100  |  120 |  Carla
150  |  300 |  David


------------------------------------------------------
10               100
+Abby             -Abby
50 + Ben, 70 -ben 


10  Abby +
50 + Ben 
70 -ben
100 -Abby 


O(N) --> scan the available slots -- populate the TREE MAP 
Space : O(2 * N) Map 

treversing over map, creating response

 */




import java.io.*;
import java.util.*;

import org.checkerframework.checker.units.qual.Length;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class WordCompare implements Comparator<String> {
  public int compare(String a, String b) {
    return b.length() - a.length();
  }
}

static class OnCallSchedule {
  int start;
  int end;
  List<String> names;

  public OnCallSchedule(int start, int end, List<String> names) {
    start = start;
    end = end;
    names = names;
  }

}

class Schedule {
  int start;
  int end;
  String name;
}


static class Event {
  String name;
  Boolean start;

  public Event(String name, Boolean start){
    this.name = name;
    this.start = start;
  }
}

class Solution {
  private static List<OnCallSchedule> getSchedule(List<Schedule> schedules) {

    TreeMap<Integer, Event> eventMap = new TreeMap<>();
    for (Schedule schedule: schedules) {
      eventMap.put(schedule.start, new Event(schedule.name, true));
      eventMap.put(schedule.end, new Event(schedule.name, false));
    }

    List<OnCallSchedule> result = new ArrayList<>();
    int prevStart = -1;
    List<String> names = new ArrayList<>();
    for(Map.Entry<Integer, Event> entry : eventMap.entrySet()) {
      if (prevStart != 1) {
        prevStart = entry.getKey();
        continue;
      }


      result.add(new OnCallSchedule(prevStart, entry.getKey(), new ArrayList(names)));

      if (entry.getValue().start == false) {
        names.remove(entry.getValue().name);
      }

    }

    return result;
  }
  public static void main(String[] args) {
    
    
  }

}

