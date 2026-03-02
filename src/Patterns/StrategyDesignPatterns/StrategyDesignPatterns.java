package Patterns.StrategyDesignPatterns;

interface Flyable {
    void fly();
}

class NormalFly implements Flyable {
    @Override
    public void fly() {
        System.out.println("Robot is flying normally!");
    }
}

class NoFlyable implements Flyable {
    @Override
    public void fly() {
        System.out.println("Robot is unable to fly!");
    }
}

interface Walkable {
    void walk();
}

class NormalWalk implements Walkable {
    @Override
    public void walk() {
        System.out.println("Robot is walking normally!");
    }
}

class NoWalk implements Walkable {
    @Override
    public void walk() {
        System.out.println("Robot is unable to walk!");
    }
}

interface Talkable {
    void talk();
}

class NormalTalk implements Talkable {
    @Override
    public void talk() {
        System.out.println("Robot is talking normally!");
    }
}

class NoTalk implements Talkable {
    @Override
    public void talk() {
        System.out.println("Robot is unable to talk!");
    }
}


interface Robot {
    void projection();
}

class CompanionRobot implements Robot {
    Talkable t;
    Walkable w;
    Flyable f;
    
    CompanionRobot(Talkable _t, Walkable _w, Flyable _f) {
        this.t = _t;
        this.w = _w;
        this.f = _f;
    }

    // Strategy usage
    public void performTalk() {
        t.talk();
    }

    public void performWalk() {
        w.walk();
    }

    public void performFly() {
        f.fly();
    }

    @Override
    public void projection() {
        System.out.println("Robot is projecting!");
    }
}



public class StrategyDesignPatterns {
    public static void main(String[] args) {
        CompanionRobot robot = new CompanionRobot(new NormalTalk(), new NormalWalk(), new NoFlyable());
        robot.projection();
        robot.performWalk();
        robot.performTalk();
        robot.performFly();
    }
}
