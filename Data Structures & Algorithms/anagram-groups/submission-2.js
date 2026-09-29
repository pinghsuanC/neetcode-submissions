class Solution {
    /**
     * @param {string[]} strs
     * @return {string[][]}
     */
    groupAnagrams(strs) {
        let map = {};

        for(const str of strs){
            let freq = new Array(26).fill(0);
            let aCode = 'a'.charCodeAt(0);

            for(let c of str){
                freq[c.charCodeAt(0) - aCode]++;
            }
            let freqCode = freq.join("$$");
            if(!map[freqCode]) map[freqCode] = [];
            map[freqCode].push(str);
        }
        return Object.values(map);
    }

    isAnagram(s,t){
            if(s.length !== t.length) return false;
            let freq = new Array(26).fill(0);
            let aCode = 'a'.charCodeAt(0);

            for(let i =0; i<s.length; i++){
                freq[s.charCodeAt(i) - aCode]++;
            }

            for(let i =0; i<t.length; i++){
                freq[t.charCodeAt(i) - aCode]--;
            }
            
            for(var val of freq){
                if(val !== 0) return false;
            }
            return true;
        }
}
