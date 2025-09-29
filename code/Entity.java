public interface Entity {                 //Сущности
        String getName();
        int attack(Entity att,Entity target, int turn);
        void getDamage(int damage, Entity att, int turn);
        Atr getAtrs();
        int getHealth();
        Weapon getWeapon();
}
