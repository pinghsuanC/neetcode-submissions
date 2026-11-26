class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        """
        Doing it in python... cause' why not 
        didn't know a tuple can be a key wtf python

        """
        dp = {}

        def helper(prices: List[int], i: int, canBuy: bool) -> int:
            if i >= len(prices):
                return 0
            if (i, canBuy) in dp:
                return dp[(i, canBuy)]
            
            # do nothing
            res = helper(prices, i+1, canBuy)

            if canBuy:
                # can buy today, so buy
                res = max(res, helper(prices, i+1, False) - prices[i])
                dp[(i, canBuy)] = res
            else:
                # can sell today, so sell
                res = max(res, helper(prices, i+2, True) + prices[i])
                dp[(i, canBuy)] = res
            
            

            return dp[(i, canBuy)];


        return helper(prices, 0, True)
