<h2><a href="https://www.geeksforgeeks.org/problems/find-all-pairs-whose-sum-is-x5808/1?page=1&category=Arrays&difficulty=Easy&status=unsolved&sortBy=submissions">Find all pairs with a given sum</a></h2><h3>Difficulty Level : Difficulty: Easy</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size: 18px;">Given two unsorted arrays <strong>arr1[]</strong> &nbsp;and <strong>arr2[]</strong> of distinct elements, the task is to find all pairs whose sum equals <strong>x</strong> from both arrays.</span></p>
<p><span style="font-size: 18px;"><strong>Note:&nbsp;</strong>All pairs should be printed in <strong>increasing </strong>order of u. For eg. for two pairs (u<sub>1</sub>,v<sub>1</sub>) and (u<sub>2</sub>,v<sub>2</sub>), if u<sub>1&nbsp;</sub>&lt; u<sub>2</sub>&nbsp;then<br>(u<sub>1</sub>,v<sub>1</sub>) should be printed first else second.</span></p>
<p><span style="font-size: 18px;"><strong>Examples:</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input: arr1</strong>[] = [1, 2, 4, 5, 7], arr2[] = [5, 6, 3, 4, 8], x = 9 
<strong>Output: 
</strong>1 8
4 5 
5 4
<strong>Explanation: </strong>(1, 8), (4, 5), (5, 4) are the pairs which sum to 9.</span>
</pre>
<pre><span style="font-size: 18px;"><strong>Input: arr1</strong>[] = [-1, -2, 4, -6, 5, 7], arr2[] = [6, 3, 4, 0], x = 8
<strong>Output:</strong>
4 4 
5 3</span></pre>
<p><span style="font-size: 18px;"><strong>Expected Time Complexity:</strong> O(nLog(n))<br><strong>Expected Space&nbsp;</strong></span><strong style="font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif; font-size: 18px;">Complexity</strong><strong style="font-size: 18px; font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;">:</strong><span style="font-size: 18px; font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;"> O(n)</span></p>
<p><span style="font-size: 18px;"><strong>Constraints:</strong><br>1 ≤ arr1.size, arr2.size ≤ 10<sup>6</sup><br>-10<sup>6</sup> ≤ x, arr1[i], arr2[i] ≤ 10<sup>6</sup></span></p></div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Amazon</code>&nbsp;<code>MakeMyTrip</code>&nbsp;<code>Facebook</code>&nbsp;<code>United Health Group</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Arrays</code>&nbsp;<code>Hash</code>&nbsp;<code>Data Structures</code>&nbsp;