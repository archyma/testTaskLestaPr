class RogueHero extends AbsHero {  //разбойник
    public RogueHero() {
        super(4, Weapon.DAGGER);
    }

    public String getName() {
        return "Разбойник: Уровень " + level;
    }

    public String allInfo(){
        return "Здоровье за ур.: 4, Нач. оружие: Кинжал(колющий)\n1 ур: Скрытая атака. 2 ур: +ЛОВКОСТЬ. 3 ур: Яд.\n";
    }

    public int attack(Entity att, Entity target, int turn){
        int res = 0;
        if(level > 0){
            if(att.getAtrs().agility > target.getAtrs().agility){
                res++;
                System.out.println("Разбойник: бонус за 1+ уровень: Урон +1");
            }
            if(level == 3){
                res += turn - 1;
                System.out.println("Разбойник: бонус за 3 уровень: Урон +" + (turn - 1));
            }

            System.out.println("Разбойник: Дополнительный урон: " + res);
        }

        return res;
    }

    public int saveDamage(Entity att, Entity target, int turn){
        return 0;
    }


    public void skill(PlayerHero myHero, AbsMonster target){
        if(level >= 2){
            System.out.println("Разбойник: бонус за 2+ ур.: Ловкость +1");
            myHero.getAtrs().agility++;
        }
    }
}
