public abstract class AbsHero {   //абстракция героя
    protected int healthPerLevel; //здоровье за уровень
    protected Weapon startWeapon; //начальное оружие
    protected int level;

    public AbsHero(int healthPerLevel, Weapon startWeapon) {
        this.healthPerLevel = healthPerLevel;
        this.startWeapon = startWeapon;
        this.level = 0;
    }

    //информмация
    abstract String allInfo();

    abstract String getName();


    //действия в бою
    abstract int attack(Entity att, Entity target, int turn);          //определяем, сколько урона наносим при атаке

    abstract int saveDamage(Entity att, Entity target, int turn);         //определяем, сколько урона мы защитили при обороне

    abstract void skill(PlayerHero myHero, AbsMonster target);             //изменяем статы в зависимости от уровня и соперника


    //поднять уровень
    public void levelUp(){ level++; }


}


