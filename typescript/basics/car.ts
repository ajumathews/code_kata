
class Car{
    engine: string;

    constructor(engine:string){
        this.engine = engine;
    }

    display():void {
        console.log(this.engine);
    }

}


var car = new Car("diesel");
car.display();





