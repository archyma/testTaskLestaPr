interface Monster extends Entity {         //монстры
    Atr getAtrs();
    String getName();
    void getDamage(int damage, Entity att, int turn);
    int getHealth();
    int attack(Entity att,Entity target, int turn);
    Weapon getWeapon();
}
