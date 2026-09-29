class Solution:
    def isPalindrome(self, s: str) -> bool:
        if len(s) <= 1: return True;

        li = list(filter(lambda x : x.isalnum(), list(s.lower())))
        print(li);
        l = 0
        r = len(li) - 1
        while l < r:
            if li[l] != li[r]: return False;
            l+=1
            r-=1

        return True