// https://leetcode.com/problems/merge-intervals/
class Interval {
    int start;
    int end;
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart(){return this.start;}
    public int getEnd(){return this.end;}
    public int setEnd(int end){return this.end = end;}
}

class IntervalSorter implements Comparator<Interval> {
    public int compare(Interval a, Interval b) {
        return a.getStart() - b.getStart();
    }
}

class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n<=1) return intervals;
        List<Interval> intervalList = new ArrayList<>();
        for (int i = 0; i<n; i++) {
            intervalList.add(new Interval(intervals[i][0], intervals[i][1]));
        }

        Collections.sort(intervalList, new IntervalSorter());
        List<Interval> mergedIntervals = new ArrayList<>();
        Interval lastInterval = intervalList.get(0);
        mergedIntervals.add(lastInterval);
        for (int i = 1; i<n; i++) {
            if (intervalList.get(i).getStart() > lastInterval.getEnd()) {
                // no overlap, take this one
                lastInterval = intervalList.get(i);
                mergedIntervals.add(intervalList.get(i));
            } else {
                // overlap
                if (intervalList.get(i).getEnd() <= lastInterval.getEnd()) {
                    // child of last interval, ignore
                    continue;
                } else {
                    lastInterval.setEnd(intervalList.get(i).getEnd());
                }
            }
        }

        int m = mergedIntervals.size();
        int[][] result= new int[m][2];
        for (int i = 0; i<m; i++) {
            result[i][0] = mergedIntervals.get(i).getStart();
            result[i][1] = mergedIntervals.get(i).getEnd();
        } 

        return result;

    }
}
