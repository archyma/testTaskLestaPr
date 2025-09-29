import java.util.*;

public class Game {             //класс игры
    PlayerHero player = null;                       //игрок
    ArrayList<AbsMonster> monsters = new ArrayList<AbsMonster>(Arrays.asList
            (new GoblinMonster(), new SkeletonMonster(), new SlimeMonster(),
                    new GhostMonster(), new GolemMonster(), new DragonMonster()));     //монстры

    void mainMenu(){    //меню запуска
        boolean mainMenu = true;

        while(mainMenu){
            switch (Main.takeIntNumber("1. Новая игра\n2. Выход")){
                case 1:
                    startGame();
                    break;
                case 2:
                    mainMenu = false;
                    break;
                default:
                    System.out.println("Неправильно выбран пункт!");
            }
        }
    }

    void startGame(){        //начать игру
        player = new PlayerHero(null);
        System.out.println("-----------------------------------------------");
        System.out.println("Новая игра. Создать персонажа");
        player.printAllClasses();
        boolean isC = false;
        int i = 1;
        while(!isC){
            System.out.println("-----------------------------------------------");
            i = Main.takeIntNumber("Выберите номер персонажа");
            if(i > 3 || i < 1) System.out.println("Неверный ввод");
            else isC = true;
        }
        System.out.println("-----------------------------------------------");
        player.heroClasses.get(i - 1).levelUp();
        player.weapon = player.heroClasses.get(i - 1).startWeapon;
        player.weapons.add(player.weapon);

        player.printInfo();

        System.out.println("-----------------------------------------------");

        fighting();
    }

    void fighting(){     //процесс боев
        int round = 1;
        while(round <= 3){
            System.out.println("Раунд " + round);

            Random rand = new Random();
            AbsMonster monster = monsters.get(rand.nextInt(monsters.size()));

            System.out.println("Монстр: " + monster.getName());
            System.out.println("-----------------------------------------------");

            if(round > 1){
                player.printWeapons();
                boolean isCor = false;

                while (!isCor){
                    try{
                        player.weapon = player.weapons.get(Main.takeIntNumber("Выберите оружие: ") - 1);
                        isCor = true;
                    } catch (IndexOutOfBoundsException e){
                        System.out.println("Неверный выбор");
                    }
                }
            }

            try {
                Battle battle = new Battle(player, monster);

                battle.start();

                if(Objects.equals(battle.winner.getName(), "Игрок")){          //если игрок выиграл, добавить ему оружие
                    if(!player.weapons.contains(monster.reward) && round < 3){   //проверяем что это оружие уместно добавлять
                        player.weapons.add(monster.reward);
                        System.out.println("Добавлено оружие: " + monster.reward);
                        System.out.println("-----------------------------------------------");
                    }

                    boolean isC = false;

                    while(!isC){      //улучшаем класс(собираем мультикласс)
                        if(round < 3){
                            player.printAllClasses();
                            int choice = Main.takeIntNumber("Выберите класс, который хотите улучшить: ");

                            try {
                                if(player.heroClasses.get(choice - 1).level < 3){             //проеряем можно ли улучшить
                                    player.heroClasses.get(choice - 1).levelUp();
                                    player.printAllClasses();
                                    isC = true;
                                } else {
                                    System.out.println(player.heroClasses.get(choice - 1).getName() + ": максимальный уровень достигнут");
                                }
                            } catch (IndexOutOfBoundsException e) {
                                System.out.println("Неверный выбор!");
                            }
                        } else {
                            isC = true;
                        }

                    }
                } else {
                    round = 4;
                    endMenu();
                }

                round++;

                if(round > 3){
                    System.out.println("Поздравляем! Игра пройдена!");
                    endMenu();
                }
            } catch (CloneNotSupportedException e){
                System.out.println("ОШИБКА!");
            }
        }
    }

    void endMenu(){   //конец игры
        System.out.println("Игра окончена! Спасибо за то, что выбрали нас:)");
    }

}
