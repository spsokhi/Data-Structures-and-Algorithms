class Solution:
    def wonderfulSubstrings(self, word: str) -> int:
        
        n = len(word)
        
        total = 0
        
        is_odd = 0 # 0000000000
        
        f = collections.Counter()
        
        f[is_odd] += 1
        
        for c in word:
            d = ord(c) - ord('a')
            
            is_odd ^= (1<<d)
            
            total += f[is_odd] # getting all charachters with even number of apperances
            
            for i in range(10):
                is_odd ^= (1<<i)
                
                total += f[is_odd]
                
                is_odd ^= (1<<i)
                
            f[is_odd] += 1
                
                
        return total
                
                
                
                
                
                
                
                
                
            