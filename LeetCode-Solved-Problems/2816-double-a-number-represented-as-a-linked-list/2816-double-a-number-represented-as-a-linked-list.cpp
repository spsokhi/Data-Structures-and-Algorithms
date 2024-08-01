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
    ListNode* doubleIt(ListNode* head) {
        head = reverse(head);
        
        ListNode* new_head = new ListNode(-1, head);
        ListNode* cur = new_head;
        int carry = 0;
        
        while(cur->next != NULL){
            cur->next->val *= 2;
            cur->next->val += carry;
            carry = cur->next->val/10;
            cur->next->val %= 10;
            
            cur = cur->next;
        }
        
        if(carry>0){
            cur->next = new ListNode(carry);
            cur = cur->next;
        }
        
        return reverse(new_head->next);
    }
    
private:
    ListNode* reverse(ListNode* head){
        ListNode* prev = NULL;
        ListNode* cur = head;
        while(cur != NULL){
            ListNode* tmp = cur->next;
            cur->next = prev;
            prev = cur;
            cur = tmp;
        }
        
        return prev;
    }
};