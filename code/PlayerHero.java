import java.util.ArrayList;
import java.util.Arrays;

public class PlayerHero implements Hero, Cloneable {        //игрок
    protected ArrayList<AbsHero> heroClasses = new ArrayList<AbsHero>(Arrays.asList(new RogueHero(), new WarriorHero(), new BarbarianHero()));  //все классы
    protected Atr atrs = new Atr();     //атрибуты
    protected int health;          //здоровье
    public ArrayList<Weapon> weapons = new ArrayList<>();          //оружия, которые есть у нас
    public Weapon weapon;        //оружие, которым бьемся

    public PlayerHero(Weapon weapon) {
        this.health = 0;
        this.weapon = weapon;
    }


    //инфа
    public void printWeapons() {
        for(int i = 0; i < weapons.size(); i++) {
            System.out.println((i+1) + ". " + weapons.get(i).toString());
        }
    }

    public void printInfo(){
        System.out.println(atrs);
        System.out.println("Оружие: " + weapon.getName() + " (" + weapon.getDamType() + "), Урон: " + weapon.getDamage());
        for(AbsHero hero : heroClasses){
            System.out.println(hero.getName());
        }
    }

    public Weapon getWeapon(){
        return weapon;
    }

    public Atr getAtrs(){
        return atrs;
    }

    public int getHealth(){
        return health;
    }

    public void printAllClasses(){
        for(int i = 0; i<heroClasses.size(); i++){
            System.out.println(i+1  + ". " + heroClasses.get(i).getName());
            System.out.println(heroClasses.get(i).allInfo());
        }
    }

    public void setWeapon(Weapon weapon){
        this.weapon = weapon;
    }

    public String getName(){
        return "Игрок";
    }



    //подготовка к бою
    private void skill(AbsMonster target){

        for(AbsHero hero : heroClasses){
            hero.skill(this, target);
        }
    }

    private void updateHealth(){
        health = 0;
        for(AbsHero hero : heroClasses){
            health += hero.healthPerLevel * hero.level;
            System.out.println(hero.getName() + ": " + hero.healthPerLevel + "*" + hero.level + " = " + hero.healthPerLevel * hero.level);
        }
        health += atrs.endurance;
        System.out.println("Игрок: Здоровье: " + health);
    }

    public void beReady(AbsMonster target){
        updateHealth();
        skill(target);
    }




    //действия в бою
    public int attack(Entity att, Entity target, int turn){
        int res = att.getAtrs().strength + att.getWeapon().getDamage();
        System.out.println("Герой: начальный атакующий урон: " + res);

        for(AbsHero hero : heroClasses){
            res += hero.attack(att, target, turn);
        }

        System.out.println("Герой: Финальный атакующий урон: " + res);
        return res;
    }

    public void getDamage(int damage, Entity att, int turn){
        for(AbsHero hero : heroClasses){
            damage -= hero.saveDamage(att, this, turn);
        }

        if(damage > 0){
            System.out.println("Герой: Полученный урон: " + damage);
            health -= damage;
            if(health >= 0) System.out.println("Герой: Здоровье: " + health);
            else System.out.println("Герой: Здоровье: 0");
        } else System.out.println("Герой: Урон не получен");
    }





    //клонирование
    public PlayerHero clone() throws CloneNotSupportedException{
        PlayerHero clone = (PlayerHero) super.clone();
        clone.weapons = (ArrayList<Weapon>) weapons.clone();
        clone.atrs = atrs.clone();
        return clone;
    }
}
