package ru.geekbrains.toy_shop;

/**
 * Игрушка, имеющая идентификатор, название, количество и вероятность
 * выпадения.
 */
public class Toy {
    
    /**
     * Числовой идентификатор игрушки.
     */
    private int identifier;

    /**
     * Название игрушки.
     */
    private String name;

    /**
     * Вероятность выпадения игрушки в процентах.
     */
    private int dropChance;

    public Toy(int identifier, String name, int dropChance) {
        if (identifier < 1) {
            throw new RuntimeException("Числовой идентификатор введён " +
                                       "некорректно.");
        } else if (name.isEmpty()) {
            throw new RuntimeException("Название введено некорректно.");
        } else if (dropChance < 0 || dropChance > 100) {
            throw new RuntimeException("Вероятность выпадения введена " +
                                       "некорректно.");
        } else {
            this.identifier = identifier;
            this.name = name;
            this.dropChance = dropChance;
        }
    }

    /**
     * Возвращает числовой идентификатор игрушки.
     */
    public int getIdentifier() {
        return identifier;
    }

    /**
     * Устанавливает числовой идентификатор игрушки.
     */
    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    /**
     * Возвращает название игрушки.
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает название игрушки.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Возвращает вероятность выпадения игрушки.
     */
    public int getDropChance() {
        return dropChance;
    }

    /**
     * Устанавливает вероятность выпадения игрушки.
     */
    public void setDropChance(int dropChance) {
        this.dropChance = dropChance;
    }

    @Override
    public String toString() {
        return String.format("%d, %s, %d %%", identifier, name, dropChance);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Toy toy = (Toy) object;
        return identifier == toy.identifier && name == toy.name &&
               dropChance == toy.dropChance;
    }

}
