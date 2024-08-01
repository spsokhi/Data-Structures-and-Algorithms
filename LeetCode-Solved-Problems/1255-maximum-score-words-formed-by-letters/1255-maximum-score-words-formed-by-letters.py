class Solution:
    def maxScoreWords(self, words: List[str], letters: List[str], score: List[int]) -> int:
        # brute-force backtracking 
        
        def can_form_word(word, letter_cnt):
            word_cnt = Counter(word)
            for c in word_cnt:
                if word_cnt[c] > letter_cnt[c]:
                    return False
            return True
        
        def get_score(word):
            res = 0
            for c in word:
                res += score[ord(c)-ord('a')]
            return res
        
        letter_cnt = Counter(letters)
        def backtrack(i):
            if i >= len(words):
                return 0
            res = backtrack(i+1) # skip the word
            if can_form_word(words[i], letter_cnt): # include the word
                for c in words[i]:
                    letter_cnt[c] -= 1
                res = max(res, get_score(words[i]) + backtrack(i+1))
                for c in words[i]:
                    letter_cnt[c] += 1
                    
            return res
        
        return backtrack(0)
                    
                 
        