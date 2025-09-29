public class DragonMonster extends AbsMonster{
    public DragonMonster() {
        super(20, 4, 3, 3, 3, Weapon.LEG_SWORD);
    }



    public String getName(){
        return "Дракон";
    }



    public int attack(Entity att, Entity target, int turn){
        int res = attDam + att.getAtrs().strength;
        System.out.println("Дракон: Начальный атакующий урон: " + res);

        if(turn % 3 == 0){
            System.out.println("Дракон: Дашит огнем");
            res += 3;
        }

        System.out.println("Дракон: Финальный урон: " + res);
        return res;
    }

    public void getDamage(int damage, Entity att, int turn){
        if(damage > 0){
            System.out.println("Дракон: Полученный урон: " + damage);
            health -= damage;
            if(health >= 0) System.out.println("Дракон: Здоровье: " + health);
            else System.out.println("Дракон: Здоровье: 0");
        } else System.out.println("Дракон: Урон не получен");
    }
}
