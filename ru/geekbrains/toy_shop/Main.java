package ru.geekbrains.toy_shop;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        ToyShop toyShop = new ToyShop(new ArrayList<Toy>());
        System.out.print("Введите количество игрушек. ");
        int toysNum = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i < toysNum; i++) {
            System.out.printf("Введите числовой идентификатор %d игрушки. ",
                              i + 1);
            int identifier = Integer.parseInt(scanner.nextLine());
            System.out.printf("Введите название %d игрушки. ", i + 1);
            String name = scanner.nextLine();
            System.out.printf("Введите вероятность выпадения %d игрушки. ", 
                              i + 1);
            int dropChance = Integer.parseInt(scanner.nextLine());
            toyShop.add(new Toy(identifier, name, dropChance));
        }

        if (!toyShop.isRafflePossible()) {
            System.out.println("Сумма вероятностей выпадения игрушек не равна " +
                               "100 %.");
            return;
        }

        System.out.print("Введите количество игрушек для розыгрыша. ");
        toysNum = Integer.parseInt(scanner.nextLine());
        System.out.print("Введите путь к файлу. ");
        String file = scanner.nextLine();

        for (int i = 0; i < toysNum; i++) {
            toyShop.rafflePrize(file);
        }

    }

}
