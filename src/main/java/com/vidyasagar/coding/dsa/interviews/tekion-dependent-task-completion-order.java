TEK : 

There are a total of N tasks, labeled from 0 to N-1. 
Some tasks may have prerequisites, for example to do task 0 you have to first complete task 1, which is expressed as a pair: [0, 1].
 Given the total number of tasks N and a list of prerequisite pairs P, find if it is possible to finish all tasks.
 
 
Input: N = 4, P = 3, prerequisites = 
{{1,0},{2,1},{3,2}}
Output: Yes
Explanation: To do task 1 you should have completed task 0, and to do task 2 you should have finished task 1, and to do task 3 you should have finished task 2. So it is possible.


0 --> 1 --> 2 --> 3 its possible


{{1,0},{2,1},{3,2}, {1, 3}}


dependents :[1, 2, 3]
independents : [0]



task_completed : [0, 3]

task_completed : [0, 3, 1]

no progress -- ==> no possible


next_task_completed : [0, 1]

task_completed.size = N --> possible


---> one pass : dependents, indenpenents -- o(n)

while (task_completed.size < N)
{
	n-1, n-2, n-3
	O(n)


}


// one scan: 
HashMap key --> set of parents

1 --> [0, 3]


and completed_tasks : [0]




Node {
	int key;
	List<Node> dependencies;
}



===

Q2 : Given a binary string, count number of substrings with K 1's in it.
Example s=1010 k =2 output=2

101
1010


001001001001010001
k = 3


001001001
 01001001
  1001001
   001001 --> not a candidate
   001001001




00100100100
3*3 + 


