package ru.geekbrains.toy_shop;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Random;

/**
 * Магазин, содержащий игрушки. Игрушки могут быть разыграны.
 */
public class ToyShop implements Raffable {

    /**
     * Игрушки в магазине.
     */
    private ArrayList<Toy> toys;
    
    public ToyShop(ArrayList<Toy> toys) {
        this.toys = toys;
    }

    /**
     * Добавляет игрушку в магазин.
     */
    public void add(Toy toy) {
        toys.add(toy);
    }

    /**
     * Убирает игрушку из магазина и возвращает true, а если игрушки не было в
     * магазине, возвращает false.
     */
    public boolean remove(Toy toy) {
        return toys.remove(toy);
    }

    /**
     * Возвращает true, если сумма вероятностей выпадения игрушек равна 100 %,
     * и false, если не равна.
     */
    public boolean isRafflePossible() {
        int summary = 0;

        for (Toy toy: toys) {
            summary += toy.getDropChance();
        }

        return summary == 100;
    }

    /**
     * Разыгрывает и записывает в файл игрушку путём формирования ArrayList из
     * 100 игрушек в пропорции, соответствующей соотношению вероятностей их
     * выпадения, и выбора случайного элемента этого ArrayList в качестве приза.
     * Если происходит ошибка при работе с файлами, выводит информационное
     * сообщение.
     */
    public void rafflePrize(String file) {
        ArrayList<Toy> raffledToys = new ArrayList<>(100);
        Random randomNum = new Random();

        try {
            OutputStream outputStream = new FileOutputStream(file, true);
            Writer writer = new OutputStreamWriter(outputStream,
                                                   StandardCharsets.UTF_8);

            for (Toy toy: toys) {
                for (int i = 0; i < toy.getDropChance(); i++) {
                    raffledToys.add(toy);
                }
            }

            Toy raffledToy = raffledToys.get(randomNum.nextInt(0, 99));
            writer.write(String.format("%s\n", raffledToy.toString()));
            writer.close();
        } catch (Exception exception) {
            System.out.println("Произошла ошибка при работе с файлами.");
        }
    }
}
