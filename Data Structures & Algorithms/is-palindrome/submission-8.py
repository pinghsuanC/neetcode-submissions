class Solution:
    def isPalindrome(self, s: str) -> bool:
        if len(s) <= 1: return True;
        all = "".join(filter(lambda x: x.isalnum(), list(s.lower())))

        return all == all[::-1];