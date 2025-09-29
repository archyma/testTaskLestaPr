import java.util.Random;
import java.util.Scanner;

public class Battle {         //класс боя
    public PlayerHero hero;        //герой
    public AbsMonster monster;        //монстр
    public Entity winner = null;       //победитель

    public Battle(PlayerHero hero, AbsMonster monster) throws CloneNotSupportedException {
        this.hero = hero.clone();    //чтоб после боя вернутся к дефолтным статам
        this.monster = monster;
    }

    public void start(){
        int turn = 1;
        Entity firstT;        //для определения порядка ходов
        Entity secondT;

        System.out.println("-----------------------------------------------");
        hero.beReady(monster);                  //использовать бонусы, которые влияют на статы и посчитать здоровье


        System.out.println("-----------------------------------------------");
        System.out.println("Противники");  //инфа
        System.out.println(hero.getName());
        System.out.println(hero.atrs);
        System.out.println(monster.getName());
        System.out.println(monster.atrs);
        System.out.println("-----------------------------------------------");

        if(hero.atrs.agility >= monster.atrs.agility) {        //определяем первых ход
            firstT = hero;
            secondT = monster;
        }
        else {
            secondT = hero;
            firstT = monster;
        }

        System.out.println("Первый ход: " + firstT.getName());

        int buf = monster.health;         //чтоб вернуть после боя

        while(hero.health > 0 && monster.health > 0){
            System.out.println(hero.getName() + " - " + hero.health);
            System.out.println(monster.getName() + " - " + monster.health);

            System.out.println("-----------------------------------------------");
            System.out.println("Ход " + turn);
            System.out.println("-----------------------------------------------");
            attacking(firstT, secondT, turn);                            //атака поочередно
            if(secondT.getHealth() <= 0){                                   //если здоровье 0 - заканчиваем
                winner = firstT;
                System.out.println(winner.getName() + " - ПОБЕДИЛ!");
                monster.health = buf;
                System.out.println("-----------------------------------------------");
                break;
            }

            System.out.println("-----------------------------------------------");
            System.out.println(hero.getName() + " - " + hero.health);
            System.out.println(monster.getName() + " - " + monster.health);
            attacking(secondT, firstT, turn);
            if(firstT.getHealth() <= 0){
                winner = secondT;
                System.out.println(winner.getName() + " - ПОБЕДИЛ!");
                monster.health = buf;
                System.out.println("-----------------------------------------------");
                break;
            }

            turn++;
            System.out.println("-----------------------------------------------");
        }
    }

    private void attacking(Entity att,Entity target, int turn){             //процесс атаки
        System.out.println(att.getName() + ": атака");

        Random random = new Random();

        int sum = hero.atrs.agility + monster.atrs.agility; //сумма ловкости

        int r = random.nextInt(sum) + 1;                                 //попала атака или нет?
        System.out.println(r + " :: " + target.getAtrs().agility);
        System.out.println("___________________________________________\n");

        if(r > target.getAtrs().agility)
            target.getDamage(att.attack(att, target, turn), att, turn);           //получили урон и передали его цели
        else System.out.println(att.getName() + ": Атака промахнулась");
    }
}
