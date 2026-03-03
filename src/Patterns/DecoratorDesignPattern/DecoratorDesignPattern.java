package Patterns.DecoratorDesignPattern;



interface ICharacter {
    String getAbilities();
}

abstract class CharacterDecorator implements  ICharacter{
    ICharacter character;

    CharacterDecorator(ICharacter _ch) {
        this.character = _ch;
    }
}


class HeightUp extends CharacterDecorator {
    HeightUp(ICharacter _ch) {
        super(_ch);
    }

    @Override
    public String getAbilities() {
        return this.character.getAbilities() + " Height UP";   
    }
}

class GunPower extends CharacterDecorator {
    GunPower(ICharacter _ch) {
        super(_ch);
    }

    @Override
    public String getAbilities() {
        return this.character.getAbilities() + " Gun Powder";   
    }
}


class StarPower extends CharacterDecorator {
    StarPower(ICharacter _ch) {
        super(_ch);
    }

    @Override
    public String getAbilities() {
        return this.character.getAbilities() + " Star Power";   
    }
}


class Mario implements ICharacter{
    @Override()
    public String getAbilities() {
        return "Mario";
    }
}


public class DecoratorDesignPattern {
    public static void main(String[] args) {
        // Create a basic Mario character
        ICharacter mario = new Mario(); 
        System.out.println("Basic character: " + mario.getAbilities());

        // Decorate Mario with a HightUp power-up
        mario = new HeightUp(mario);
        System.out.println("After Height up " + mario.getAbilities());

        // Decorate Mario with a Gun Power power-up
        mario = new GunPower(mario);
        System.out.println("After Gun Power " + mario.getAbilities());

        // Decorate Mario with a Star power-up
        mario = new StarPower(mario);
        System.out.println("After Star Power " + mario.getAbilities());
    }
}
