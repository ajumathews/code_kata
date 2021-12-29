let hello = "Hello world from node js";
console.log(hello);

console.log(__dirname);
console.log(__filename);


const path = require("path");
console.log('The file name is '+path.basename(__filename));