class Solution {
    /**
     * @param {string[]} strs
     * @return {string[][]}
     */
    groupAnagrams(strs) {
        
        
        let listMap = {};
        let keys = [];

        for(const str of strs){
            let isAna = false;
            for(const k of keys){
                isAna = this.isAnagram(str, k);
                if(isAna){
                    // add to mapped value
                    listMap[k].push(str);
                    break;
                }
            }
            if(isAna == false){
                // add new key and add to kep
                keys.push(str);
                listMap[str] = new Array();
                listMap[str].push(str);
            }
        }
        
        

        return Object.values(listMap)
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
