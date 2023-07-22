package ru.geekbrains.toy_shop;

/**
 * Розыгрыш призов с записью выигранных призов в файл.
 */
public interface Raffable {
    
    /**
     *  Разыгрывает и записывает в файл приз.
     */
    void rafflePrize(String file);

}
