package SOLID.ISP.Followed;


interface TwoDimensionalShape {
    double area();
}

interface ThreeDimensionalShape {
    double area();
    double volume();
}


class Square implements TwoDimensionalShape {
    double a;

    Square(double a) {
        this.a = a;
    }

    @Override
    public double area() {
        return this.a * this.a;
    }
}

class Rectangle implements TwoDimensionalShape {
    double a;
    double b;

    Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double area() {
        return this.a * this.b;
    }
}

class Cube implements ThreeDimensionalShape {
    double a;

    Cube(double a) {
        this.a = a;
    }

    @Override
    public double area() {
        return 6 * this.a * this.a;
    }

    @Override
    public double volume() {
        return this.a * this.a * this.a;
    }
}


public class ISPFollowed {
    public static void main(String[] args) {
        Square square = new Square(4);
        Rectangle rectangle = new Rectangle(4, 6);
        Cube cube = new Cube(4);

        // CALCULATE AREA
        System.out.println(square.area());
        System.out.println(rectangle.area());
        System.out.println(cube.area());

        // CALCULATE VOLUME
        System.out.println(cube.volume());
    }
}
