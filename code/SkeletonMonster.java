import org.w3c.dom.ls.LSOutput;

public class SkeletonMonster extends AbsMonster{  //скелет
    public SkeletonMonster() {
        super(10, 2, 2, 2, 1, Weapon.CLUB);
    }

    public String getName(){
        return "Скелет";
    }




    public int attack(Entity att, Entity target, int turn){
        System.out.println("Скелет: Финальный урон: " + (attDam + atrs.strength));
        return attDam + atrs.strength;
    }

    public void getDamage(int damage, Entity att, int turn){
        if(att.getWeapon().getDamType() == DamType.BLUNT){
            damage *= 2;
            System.out.println("Скелет: Особенность: Получает вдвое больше урона от дробящего оружия");
        }

        if(damage > 0){
            System.out.println("Скелет: Полученный урон: " + damage);
            health -= damage;
            if(health >= 0) System.out.println("Скелет: Здоровье: " + health);
            else System.out.println("Скелет: Здоровье: 0");
        } else System.out.println("Скелет: Урон не получен");
    }
}
