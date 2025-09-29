class BarbarianHero extends AbsHero { //варвар
    public BarbarianHero(){
        super(6, Weapon.CLUB);
    }


    public String getName() {
        return "Варвар: Уровень: " + level;
    }

    public String allInfo(){
        return "Здоровье за ур.: 6, Нач. оружие: Дубина(дробящий)\n1 ур: Ярость. 2 ур: Каменная кожа. 3 ур: +ВЫНОСЛИВОСТЬ.\n";
    }




    public int attack(Entity att, Entity target, int turn){
        int res = 0;
        if(level > 0){
            if(turn <= 3){
                res += 2;
                System.out.println("Варвар: бонус за 1+ уровень: Урон +2");
            }

            System.out.println("Варвар: Дополнительный урон: " + res);
        }
        return res;
    }

    public int saveDamage(Entity att, Entity target, int turn){
        int res = 0;

        if(level > 0){
            if(turn > 3){
                System.out.println("Варвар: бонус за 1+ уровень: -1 от урона");
                res += 1;
            }
            if(level >= 2){
                System.out.println("Варвар: бонус за 2+ уровень: Урон -ВЫН: -" + target.getAtrs().endurance);
                res += target.getAtrs().endurance;
            }
        }
        return res;
    }

    public void skill(PlayerHero myHero, AbsMonster target){
        if (level == 3){
            myHero.getAtrs().endurance++;
            System.out.println("Варвар: бонус за 3 ур.: Выносливость +1");
        }
    }
}
