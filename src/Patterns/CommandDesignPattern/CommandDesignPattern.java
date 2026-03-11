package Patterns.CommandDesignPattern;

class RemoteControl {
    Boolean[] commands;
    ICommand[] buttons;

    RemoteControl(int num) {
        this.buttons = new ICommand[num];
        this.commands = new Boolean[num];
    }

    void setCommand(int index, ICommand command) {
        this.buttons[index] = command;
        this.commands[index] = true;
    }

    void pressCommand(int index) {
        if (this.buttons[index] != null) {
            if(this.commands[index]) this.buttons[index].execute();
            else this.buttons[index].undo();
            this.commands[index] = !this.commands[index];
        } else {
            System.out.println("No command assigned to this button.");
        }
    }
}

interface ICommand {
    void execute();
    void undo();
}

class LightCommand implements ICommand {
    Light light = null;

    LightCommand(Light l) {
        this.light = l;
    }

    @Override()
    public void execute() {
        this.light.on();
    }

    @Override()
    public void undo() {
        this.light.off();
    }
}

class Light {
    String name;

    Light(String l) {
        this.name = l;
    }

    void on() {
        System.out.println(this.name + " LIGHT IS ONN!");
    }

    void off() {
        System.out.println(this.name + " LIGHT IS OFF!");
    }
}


public class CommandDesignPattern {
    public static void main(String[] args) {
        RemoteControl rc = new RemoteControl(10);

        Light livingRoomLight = new Light("Living Room");
        LightCommand lightCommand = new LightCommand(livingRoomLight);

        rc.setCommand(0,lightCommand);

        rc.pressCommand(0);
        rc.pressCommand(0);

    }    
}
