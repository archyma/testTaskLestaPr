public class GhostMonster extends AbsMonster{
    public GhostMonster() {
        super(6, 3, 1, 3, 1, Weapon.SWORD);
    }



    public String getName(){
        return "Призрак";
    }



    public int attack(Entity att, Entity target, int turn){
        int res = attDam + atrs.strength;
        System.out.println("Призрак: Начальный атакующий урон" + res);
        if(att.getAtrs().agility > target.getAtrs().agility){
            res++;
            System.out.println("Призрак: бонус за 1+ уровень: Урон +1");
        }

        System.out.println("Призрак: Финальныйф атакующий урон" + res);
        return res;
    }

    public void getDamage(int damage, Entity att, int turn){
        if(damage > 0){
            System.out.println("Призрак: Полученный урон: " + damage);
            health -= damage;
            if(health >= 0) System.out.println("Призрак: Здоровье: " + health);
            else System.out.println("Призрак: Здоровье: 0");
        } else System.out.println("Призрак: Урон не получен");
    }
}
