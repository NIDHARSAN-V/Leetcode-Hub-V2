/**
 * @param {number} n
 * @return {boolean}
 */
var hasAlternatingBits = function(n) {
    let val = true;

    while(n!=0)
    {
       let curr = n&1;
       let nxt  = (n>>1)&1;

       if(curr == nxt)
       {
        return false;
       }

       n = n>>1;
    }
    return true;
};