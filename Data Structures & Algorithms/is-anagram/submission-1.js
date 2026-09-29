class Solution {
    /**
     * @param {string} s
     * @param {string} t
     * @return {boolean}
     */
    isAnagram(s, t) {
        if(s.length !== t.length) return false;
        let arrS = s.split('').sort();
        let arrT = t.split('').sort();
        for(var i = 0; i<arrS.length; i++){
            if(arrS[i] !== arrT[i]) return false;
        }
        return true;
    }
}
