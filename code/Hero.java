interface Hero extends Entity{             // герои
    String getName();

    int attack(Entity att, Entity target, int turn);
    void getDamage(int damage, Entity att, int turn);
    int getHealth();

    Weapon getWeapon();
}
