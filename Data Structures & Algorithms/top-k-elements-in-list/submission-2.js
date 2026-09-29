class Solution {
    /**
     * @param {number[]} nums
     * @param {number} k
     * @return {number[]}
     */
    topKFrequent(nums, k) {
        let counter = {};
        // create counter
        for(let n of nums){
            if(!counter[n]) counter[n] = 0;
            counter[n]++;
        }

        return Object.entries(counter)
        .sort((a,b) => b[1] - a[1])
        .slice(0, k)
        .map(([num])=>Number(num))
        //.map(entry => Number(entry[0]))
    }
}
