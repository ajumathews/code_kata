interface Person{
     name:string,
    sayHello : ()=>string;    
}

var customer:Person = {
    name: "aju",
    sayHello:() => {return"hello"}
}

console.log(customer.name);
console.log(customer.sayHello())