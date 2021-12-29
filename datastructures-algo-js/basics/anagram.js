//Write a function to to determine if second string is an anagram of first.

//Input - two string- lower case
//Ouput - boolean
//s1, s2

//Examples
// arc , car -> true
// cat, act -> true
// this, that -> false
// 


function validAnagram(s1,s2){
    s1 = s1.toLowerCase();
    s2 = s2.toLowerCase();

       let count=[];

       for (let i = 0; i < s1.length; i++) {
           count[s1[i]]++;
       }

       for (let i = 0; i < s2.length; i++) {
           if (count[s2[i]] > 0) {
               count[s2[i]]--;
           }
       }


       for (let i = 0; i < count.length; i++) {
           if (count[i] != 0) {
               return false;
           }
       }

       return true;
}

console.log(validAnagram('car','act'));
console.log(validAnagram('car','arc'));
console.log(validAnagram('Mother in Law','Hitler Woman'));