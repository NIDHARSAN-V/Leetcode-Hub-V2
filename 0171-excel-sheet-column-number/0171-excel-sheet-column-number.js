/**
 * @param {string} columnTitle
 * @return {number}
 */
var titleToNumber = function(columnTitle) {
    let res = 0;
    const base = "A".codePointAt(0); 

    for (let i of columnTitle) {
        res = res * 26 + (i.codePointAt(0) - base + 1);
    }

    return res;
};
