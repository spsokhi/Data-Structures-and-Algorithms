/**
 * @param {string} s
 * @return {string}
 */
var removeStars = function(s) {
    const stack=[];
    for(var i=0;i<s.length;i++){
        if(s[i]=='*' && stack.length){
            stack.pop();
        }
        else{
            stack.push(s[i]);
        }
    }
    
    return stack.join('');
};