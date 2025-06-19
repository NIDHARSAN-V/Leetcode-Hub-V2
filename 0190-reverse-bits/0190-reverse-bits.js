/**
 * @param {number} n - a positive integer
 * @return {number} - reversed bits as a number
 */
var reverseBits = function(n) {
    let res = "";

    for (let i = 0; i < 32; i++) {
        res += (n & 1);
        n >>= 1;
    }

    return parseInt(res, 2);
};
