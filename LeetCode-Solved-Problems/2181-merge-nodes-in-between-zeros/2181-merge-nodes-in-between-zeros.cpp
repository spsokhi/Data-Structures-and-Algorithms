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
    ListNode* mergeNodes(ListNode* head) {
        traverse(head->next);
        return newhead->next;
    }
private:
    long long sum = 0;
    ListNode* newhead = new ListNode(0,NULL);
    ListNode* tmp = newhead;
    void traverse(ListNode* node){
        if(node == NULL)return;
        sum += node->val;
        if(node->val==0){
            ListNode* newNode = new ListNode(sum, NULL);
            sum = 0;
            tmp->next = newNode;
            tmp = tmp->next;
        }
        
        traverse(node->next);
        return;
    }
};