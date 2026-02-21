package SOLID.ISP.Violated;


interface Shape {
    double area();
    double volume();
}


class Square implements Shape {
    double a;

    Square(double a) {
        this.a = a;
    }

    @Override
    public double area() {
        return this.a * this.a;
    }

    @Override
    public double volume() {
        try {
            throw new UnsupportedOperationException("Cannot perform volume operation in 2D Objects");
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }

        return 0;
    }
}

class Rectangle implements Shape {
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

    @Override
    public double volume() {
        try {
            throw new UnsupportedOperationException("Cannot perform volume operation in 2D Objects");
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }

        return 0;
    }
}

class Cube implements Shape {
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




public class ISPViolated {
    public static void main(String[] args) {
        Square square = new Square(4);
        Rectangle rectangle = new Rectangle(4, 6);
        Cube cube = new Cube(4);

        // CALCULATE AREA
        System.out.println(square.area());
        System.out.println(rectangle.area());
        System.out.println(cube.area());

        // CALCULATE VOLUME
        System.out.println(square.volume());
        System.out.println(rectangle.volume());
        System.out.println(cube.volume());
        
    }
}
