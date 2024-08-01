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
    ListNode* removeNodes(ListNode* head) {
        if (head->next == NULL)
            return head;
        
        ListNode* new_head = reverse(head);
        ListNode* cur = new_head;
        int mx = cur->val;
        
        while(cur->next != NULL){
            if(cur->next->val < mx){
                cur->next = cur->next->next;
            }
            else{
                mx = cur->next->val;
                cur = cur->next;
            }
        }
        
        return reverse(new_head);
        
    }
private:
    ListNode* reverse(ListNode* node){
        ListNode* prev = NULL;
        ListNode* cur = node;
        while(cur != NULL){
            ListNode* tmp = cur->next;
            cur->next = prev;
            prev = cur;
            cur = tmp;
        }
        
        return prev;
    }
};
