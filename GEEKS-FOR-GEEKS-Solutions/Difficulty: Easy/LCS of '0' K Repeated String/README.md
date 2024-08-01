<h2><a href="https://www.geeksforgeeks.org/problems/lcs-of-0-k-repeated-string5642/1?page=1&category=Dynamic%20Programming&difficulty=Easy&status=unsolved&sortBy=submissions">LCS of '0' K Repeated String</a></h2><h3>Difficulty Level : Difficulty: Easy</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">Given a Binary string <strong>st</strong> and a number <strong>k</strong>. You have to find the Longest continuous sequence of '0' after repeating Given string K time.</span></p>

<p><strong><span style="font-size:18px">Example 1:</span></strong></p>

<pre><span style="font-size:18px"><strong>Input:</strong> k = 3
st = 100001
<strong>Output:</strong> 4
<strong>Explaination:</strong> The string repeated k times 
become 100001100001100001. Here the longest 
continuous sequence of 0 is 4.</span></pre>

<p><strong><span style="font-size:18px">Example 2:</span></strong></p>

<pre><span style="font-size:18px"><strong>Input:</strong> k = 4
st = 000
<strong>Output:</strong> 12
<strong>Explaination:</strong> When st is repeated 4 times 
it become 000000000000. The longest sequence 
becomes of length 12.</span></pre>

<p><span style="font-size:18px"><strong>Your Task:</strong><br>
You do not need to read input or print anything. Your task is to complete the function <strong>lcsK()</strong> which takes k and st as input parameters and returns the length of the longest continuous sequence of 0's after repeating st k times.</span></p>

<p><span style="font-size:18px"><strong>Expected Time Complexity:</strong> O(|st|)<br>
<strong>Expected Auxiliary Space:</strong> O(1)</span></p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
1 ≤ |st| ≤ 10<sup>5</sup><br>
1 ≤ k ≤ 10<sup>5</sup>&nbsp;&nbsp;</span></p>
</div><br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Dynamic Programming</code>&nbsp;<code>Algorithms</code>&nbsp;