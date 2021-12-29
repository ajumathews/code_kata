
//Understanding the problem 

//Comparison of two arrays - where second array has the square value of the first array. Order doesnt matter.
//Inputs-two int array- unsorted.
//Output- boolean
//arr1, arr2, result


//Example
//same([1,2,3], [1,4,9]) - true
//same([1,2,3], [9,1,4]) - true
//same([1,2,3],[2,9]) - false
//same([1,2,1], [4,4,1]) - false -- the frequency of the values must be same.

function sameNaive(arr1, arr2) {

    for (let i = 0; i < arr1.length; i++) {
        for (let j = 0; j < arr2.length; j++) {
            if (arr2[j] == arr1[i] * arr1[i]) {
                arr2.splice(j, 1);
                break;
            } else if (j == arr2.length - 1) {
                return false;
            }
        }
    }
    return true;
}


function same(arr1, arr2) {
    if (arr1.length != arr2.length) {
        return false;
    }

    let frequencyCounter1 = {};
    let frequencyCounter2 = {};

    for (let value of arr1) {
        if (frequencyCounter1[value] > 0) {
            frequencyCounter1[value]++;
        } else {
            frequencyCounter1[value] = 1;
        }

    }

    for (let value of arr2) {
        if (frequencyCounter2[value] > 0) {
            frequencyCounter2[value]++;
        } else {
            frequencyCounter2[value] = 1;
        }

    }

    for (let key in frequencyCounter1) {
        if(! key*key in frequencyCounter2){
            return false;
        }
        if(frequencyCounter1[key]!=frequencyCounter2[key*key]){
            return false;
        }

    }

    return true;
}


console.log(same([1, 2, 3, 3], [9, 1, 4,9]));
