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
public://neetcode
    void reorderList(ListNode* head) {
        // find the middle
        ListNode* slow=head, *fast=head;
        while(fast and fast->next){
            slow = slow->next;
            fast = fast->next->next;
        }
        // reverse the second half
        ListNode* prev = NULL, *second = slow->next;
        slow->next = NULL;
        while(second){
            ListNode* tmp = second->next;
            second->next = prev;
            prev = second;
            second = tmp;
        }
        // merge the two lists
        ListNode* firstptr = head, *secondptr = prev;
        while(secondptr){
            ListNode* tmp1 = firstptr->next, *tmp2 = secondptr->next;
            firstptr->next = secondptr;
            secondptr->next = tmp1;
            firstptr = tmp1;
            secondptr = tmp2;
        }
    }
};