var Car = /** @class */ (function () {
    function Car(engine) {
        this.engine = engine;
    }
    Car.prototype.display = function () {
        console.log(this.engine);
    };
    return Car;
}());
var car = new Car("diesel");
car.display();
