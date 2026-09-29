class Solution {
    /**
     * @param {number[]} nums
     * @param {number} target
     * @return {number[]}
     */
    twoSum(nums, target) {
        // create the index map
        let valueIndMap = {};
        for(const i in nums){
            valueIndMap[nums[i]] = i;
        }

        for(let i = 0; i<nums.length; i++){
            const valJ = target - nums[i];
            if(!valueIndMap[valJ]){ continue; }
            let indJ = parseInt(valueIndMap[valJ]);
            if(indJ != null && indJ!==i){
                return [i, parseInt(valueIndMap[valJ])];
            }
        }

    }
}
