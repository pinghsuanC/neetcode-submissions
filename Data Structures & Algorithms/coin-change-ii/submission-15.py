class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        """
        Python here we go...
        """

        coins.sort()
        tab = {}
    
        def helper(coins: List[int], target: int, i: int)->int:
            if target == 0:
                return 1
            if i >= len(coins):
                return 0;
            if (target, i) in tab:
                return tab[(target, i)]
            
            if target < coins[i]:
                return 0;
            
            take = helper(coins, target - coins[i], i)
            skip = helper(coins, target, i+1)
            tab[(target, i)] = take + skip

            return take + skip
        

        return helper(coins, amount, 0);
            
