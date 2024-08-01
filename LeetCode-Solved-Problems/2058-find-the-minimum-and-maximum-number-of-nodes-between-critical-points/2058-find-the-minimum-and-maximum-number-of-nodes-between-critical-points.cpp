/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    int i = 0;
    vector<int>indxs;
    vector<int> nodesBetweenCriticalPoints(ListNode* head) {
        traverse(head);
        int n = indxs.size();
        if(n <= 1)return {-1,-1};
        
        int mn = INT_MAX;
        int mx = indxs[n-1] - indxs[0];
        
        for(int j=0; j<n-1; j++)
            mn = min(mn, indxs[j+1]-indxs[j]);
        
        return {mn, mx};
    }
    
private:
    void traverse(ListNode* node){
        if(node->next == NULL)return;
        if(node->next->next == NULL)return;
        i++;
        
        int prev = node->val;
        int me = node->next->val;
        int nxt = node->next->next->val;
        
        if(me < prev and me < nxt)
            indxs.push_back(i);
        
        if(me > prev and me > nxt)
            indxs.push_back(i);
        
        traverse(node->next);
    }
};