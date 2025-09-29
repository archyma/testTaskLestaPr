class GoblinMonster extends AbsMonster { //гоблин
    public GoblinMonster() {
        super(5, 2, 1, 1, 1, Weapon.DAGGER);
    }



    public String getName(){
        return "Гоблин";
    }



    public int attack(Entity att, Entity target, int turn){
        System.out.println("Гоблин: Финальный урон: " + (attDam + atrs.strength));
        return attDam + atrs.strength;
    }

    public void getDamage(int damage, Entity att, int turn){
        if(damage > 0){
            System.out.println("Гоблин: Полученный урон: " + damage);
            health -= damage;
            if(health >= 0) System.out.println("Гоблин: Здоровье: " + health);
            else System.out.println("Гоблин: Здоровье: 0");
        } else System.out.println("Гоблин: Урон не получен");
    }
}
