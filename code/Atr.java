import java.util.Random;

public class Atr implements Cloneable{                       //Статы или атрибуты
    int strength;   //сила
    int agility;   //ловкость
    int endurance;    //выносливость

    public Atr(){             //определяем рандомно для героя
        Random rand = new Random();
        strength = rand.nextInt(3) + 1;
        agility = rand.nextInt(3) + 1;
        endurance = rand.nextInt(3) + 1;
    }

    public Atr(int strength, int agility, int endurance){       //задам осознанно для монстра
        this.strength = strength;
        this.agility = agility;
        this.endurance = endurance;
    }


    public String toString(){
        return "СИЛ: " + strength + ", ЛОВ: " + agility + ", ВЫН: " + endurance;
    }


    public Atr clone(){
        return new Atr(strength, agility, endurance);
    }
}