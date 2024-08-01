class Solution:
    def addBinary(self, a: str, b: str) -> str:
        res=""
        la,lb,c = len(a)-1 , len(b)-1 ,0
        while la>=0 or lb>=0:
            s = c
            if la>=0:s+=ord(a[la])-ord('0') # ord is use to get value of ASCII character
            if lb>=0:s+=ord(b[lb])-ord('0')
            la,lb=la-1,lb-1
            c=1 if s>1 else 0
            res+= str(s%2)
            
        if c != 0:res+=str(c)
        return res[::-1]