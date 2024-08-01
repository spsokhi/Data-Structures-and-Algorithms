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
    bool isPalindrome(ListNode* head) {
        ListNode* fast = head, *slow = head;
        // finding middle (slow)
        while(fast and fast->next){
            fast = fast->next->next;
            slow = slow->next;
        }
        
        // reversing the second half
        ListNode* prev = NULL;
        while(slow){
            ListNode* tmp = slow->next;
            slow->next =  prev;
            prev = slow;
            slow = tmp;
        }
        
        // check palindrome
        ListNode* left = head, *right = prev;
        while(right){
            if(left->val != right->val)return false;
            left = left->next;
            right = right->next;
        }
        
        return true;
    }
};