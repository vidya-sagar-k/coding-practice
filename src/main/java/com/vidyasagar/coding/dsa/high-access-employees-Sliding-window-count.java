// https://leetcode.com/problems/high-access-employees/

class EmpTime {
    int t;
    String name;
    public EmpTime(int t, String n) {
        this.t = t;
        this.name = n;
    }
}

class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        Set<String> result = new HashSet<>();
        List<EmpTime> empTimes = new ArrayList<>();

        for (List<String> empTime : access_times) {
            int t = Integer.parseInt(empTime.get(1).substring(0, 2)) * 60 + Integer.parseInt(empTime.get(1).substring(2));
            empTimes.add(new EmpTime(t, empTime.get(0)));
        }

        Collections.sort(empTimes, (a, b) -> {
            return a.t - b.t;
        });

        int i = 0, j = 0;
        int n = empTimes.size();
        HashMap<String, Integer> empCount = new HashMap<>();

        EmpTime emp = empTimes.get(0);
        empCount.put(emp.name, 1);
        while (i <= j && j<n-1) {

            if (empTimes.get(j+1).t - empTimes.get(i).t < 60) {
                // take next
                j++;
                emp = empTimes.get(j);
                empCount.put(emp.name, empCount.getOrDefault(emp.name, 0) + 1);
                if (empCount.get(emp.name) >= 3) {
                    result.add(emp.name);
                }

            } else {
                // first remove tail emp
                EmpTime oldEmp = empTimes.get(i);
                empCount.put(oldEmp.name, empCount.getOrDefault(oldEmp.name, 0) - 1);
                if (empCount.get(oldEmp.name) == 0) {
                    empCount.remove(oldEmp.name);
                }

                if (empCount.isEmpty()) {
                    j++;
                    i++;
                    empCount.put(empTimes.get(j).name, 1);
                } else {
                    i++;
                }
            }
        }

        return new ArrayList<String>(result);
    }
}
