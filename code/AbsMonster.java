public abstract class AbsMonster implements Monster, Cloneable {   //абстракция монстра
    protected int health;        //здоровье
    protected int attDam;        //урон от оружия
    protected Atr atrs;              //атрибуты
    protected Weapon reward;        //награда за победу

    public AbsMonster(int health, int attDam, int str, int agi, int end, Weapon reward) {
        this.health = health;
        this.attDam= attDam;
        this.reward = reward;
        this.atrs = new Atr(str, agi, end);
        this.health += atrs.endurance;         //здоровье складывается с выносливостью
    }

    //инфа
    public Weapon getWeapon() {
        return null;
    }

    public Atr getAtrs(){
        return atrs;
    }

    public int getHealth(){
        return health;
    }

    public abstract String getName();


    //действия в бою
    public abstract int attack(Entity att,Entity target, int turn);
    public abstract void getDamage(int damage, Entity att, int turn);



    //чтоб могли клонировать
    public AbsMonster clone() throws CloneNotSupportedException{
        return (AbsMonster) super.clone();
    }
}
