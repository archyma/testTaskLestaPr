public class SlimeMonster extends AbsMonster{  //слайм
    public SlimeMonster() {
        super(8, 1, 3, 1, 2, Weapon.SPEAR);
    }

    public String getName() { return "Слайм"; }




    public int attack(Entity att, Entity target, int turn){
        System.out.println("Слайм: Финальный урон: " + (attDam + atrs.strength));
        return attDam + atrs.strength;
    }

    public void getDamage(int damage, Entity att, int turn){
        if(att.getWeapon().getDamType() == DamType.SLASHING){
            damage -= att.getWeapon().getDamage();
            System.out.println("Слайм: Особенность: Рубящее оружие не наносит урона");
        }

        if(damage > 0){
            System.out.println("Слайм: Полученный урон: " + damage);
            health -= damage;
            if(health >= 0) System.out.println("Слайм: Здоровье: " + health);
            else System.out.println("Слайм: Здоровье: 0");
        } else System.out.println("Слайм: Урон не получен");
    }
}
