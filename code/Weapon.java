public enum Weapon {   //оружие
    SWORD("Меч", 3, DamType.SLASHING),
    CLUB("Дубина", 3, DamType.BLUNT),
    DAGGER("Кинжал", 2, DamType.PIERCING),
    AXE("Топор", 4, DamType.SLASHING),
    SPEAR("Копье", 3, DamType.PIERCING),
    LEG_SWORD("Легендарный меч", 5, DamType.SLASHING);

    private final String name;
    private final int damage;
    private final DamType damType;

    Weapon(String name, int damage, DamType type){
        this.name = name;
        this.damage = damage;
        this.damType = type;
    }

    public String getName() {
        return name;
    }
    public int getDamage() {
        return damage;
    }
    public DamType getDamType() {
        return damType;
    }

    public String toString(){
        return name + " - ТИП: " + damType + ", УР: " + damage;
    }
}
