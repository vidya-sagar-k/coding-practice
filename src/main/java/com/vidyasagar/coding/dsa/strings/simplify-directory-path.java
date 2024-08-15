// https://leetcode.com/problems/simplify-path/description/
class Solution {
    public String simplifyPath(String path) {
        String[] names = path.split("/");
        Stack<String> st = new Stack<>();
        st.push("");

        for(String s : names) {
            if (s.equals(".") || s.isEmpty()) continue;
            if (s.equals("..")) {
                if (!st.empty()) st.pop();

            } 
            else
            st.push(s);
        }

        String result = "";
        while(!st.empty()) {
            String w = st.pop();
            if (w.length() == 0) continue;
            result = "/" + w + result;
        }

        if (result.length() == 0) result  = "/";

        return result;
    }
}
