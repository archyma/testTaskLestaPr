public class GolemMonster extends AbsMonster{
    public GolemMonster() {
        super(10, 1, 3, 1, 3, Weapon.AXE);
    }



    public String getName(){
        return "Голем";
    }



    public int attack(Entity att, Entity target, int turn){
        System.out.println("Голем: Финальный урон: " + (attDam + atrs.strength));
        return attDam + atrs.strength;
    }

    public void getDamage(int damage, Entity att, int turn){
        damage -= atrs.endurance;

        if(damage > 0){
            System.out.println("Голем: Полученный урон: " + damage);
            health -= damage;
            if(health >= 0) System.out.println("Голем: Здоровье: " + health);
            else System.out.println("Голем: Здоровье: 0");
        } else System.out.println("Голем: Урон не получен");
    }
}
