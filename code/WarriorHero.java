class WarriorHero extends AbsHero{   //воин
    public WarriorHero(){
        super(5, Weapon.SWORD);
    }

    public String getName() {
        return "Воин: Уровень: " + level;
    }

    public String allInfo(){
        return "Здоровье за ур.: 5, Нач. оружие: Меч(рубящий)\n1 ур: Порыв к действию. 2 ур: Щит. 3 ур: +СИЛА.\n";
    }




    public int attack(Entity att, Entity target, int turn){
        int res = 0;
        if(level > 0){
            if(turn == 1){
                res += att.getWeapon().getDamage();
                System.out.println("Воин: бонус за 1+ уровень: Двойной урон оружия на первом ходе");
            }

            System.out.println("Воин: Финальный урон: " + res);
        }

        return res;
    }

    public int saveDamage(Entity att, Entity target, int turn){
        int res = 0;
        if(level >= 2 && att.getAtrs().strength < target.getAtrs().strength){
            System.out.println("Воин: бонус за 2+ уровень: -3 от урона, если сила выше");
            res += 3;
        }
        return res;
    }

    public void skill(PlayerHero myHero, AbsMonster target){
        if(level == 3){
            System.out.println("Воин: бонус за 3 ур.: Сила +1");
            myHero.getAtrs().strength++;
        }
    }
}
