class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        """
        
        Three sum but in python here we go...
        
        The key for 3-sum is after 2 determined values, the other value is determined too
        for a value @ i, start with L=i+1 and R = len - 1, use sum to find the target
        Sort array = better way to plurge
            - if it's greater than 0, means it's impossible to find 0
        
        And to remove duplicates, move the L pointer to a non-duplicated position
        
        """

        n = len(nums)
        
        nums.sort()
        res = []
        
        for i, a in enumerate(nums):
            if a > 0:
                break
            
            if i > 0 and a == nums[i-1]:
                continue
            
            l = i + 1
            r = n - 1
            while l < r:
                total = a + nums[l] + nums[r]
                if total > 0:
                    r-=1
                elif total < 0:
                    l+=1
                else:
                    res.append([a, nums[l], nums[r]])
                    l+=1
                    r-=1
                    while nums[l] == nums[l-1] and l < r:
                        l+=1

        return res