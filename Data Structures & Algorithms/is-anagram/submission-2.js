class Solution {
    /**
     * @param {string} s
     * @param {string} t
     * @return {boolean}
     */
    isAnagram2(s, t) {
        if(s.length !== t.length) return false;
        let arrS = s.split('').sort();
        let arrT = t.split('').sort();
        for(var i = 0; i<arrS.length; i++){
            if(arrS[i] !== arrT[i]) return false;
        }
        return true;
    }

    isAnagram(s,t){
        if(s.length !== t.length) return false;
        const freqTable = new Array(26).fill(0);
        const aCode = 'a'.charCodeAt(0);

        for(let i = 0; i<s.length; i++){
            freqTable[s.charCodeAt(i) - aCode]++;
        }

        for(let i = 0; i<t.length; i++){
            freqTable[t.charCodeAt(i) - aCode]--;
        }

        for(let count of freqTable){
            if(count !== 0) return false;
        }
        return true;
    }
}
