package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Apple[] apple = new Apple[100];
        Random random = new Random();
        for (int i = 0; i < apple.length; i++) {
            apple[i] = new Apple();
            apple[i].setWeight((random.nextInt(6) + 1) * 0.1);
            int tmpForSort = random.nextInt(3);
            if (tmpForSort == 0) {
                apple[i].setSort(Sort.FIRST_SORT);
            } else if (tmpForSort == 1) {
                apple[i].setSort(Sort.SECOND_SORT);
            } else if (tmpForSort == 2) {
                apple[i].setSort(Sort.THIRD_SORT);
            }
        }
        System.out.println(Apple.cost(apple));
        smallApples(apple);
        sortByWeight(apple);
        sortByCost(apple);
        sortBySort(apple);
    }

    public static ArrayList<Apple> smallApples(Apple[] apple) {
        ArrayList<Apple> appllesSmallerThan200G = new ArrayList<Apple>();
        for (int i = 0; i < apple.length; i++) {
            if (apple[i].getWeight() < 0.2) {
                appllesSmallerThan200G.add(apple[i]);
            }
        }
        return appllesSmallerThan200G;
    }

    // Method sortByWeight use Selection sort
    public static Apple[] sortByWeight(Apple[] apple) {
        for (int i = 0; i < apple.length; i++) {
            Apple min = apple[i];
            int minIndex = i;
            for (int j = i + 1; j < apple.length; j++) {
                if (apple[j].getWeight() < min.getWeight()) {
                    min = apple[j];
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                Apple tmp = apple[i];
                apple[i] = apple[minIndex];
                apple[minIndex] = tmp;
            }
        }
        return apple;
    }

    public static Apple[] sortByCost(Apple[] apple) {
        for (int i = 0; i < apple.length; i++) {
            Apple min = apple[i];
            int minIndex = i;
            for (int j = i + 1; j < apple.length; j++) {
                if (apple[j].costPerUnit(apple[j]) < min.costPerUnit(min)) {
                    min = apple[j];
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                Apple tmp = apple[i];
                apple[i] = apple[minIndex];
                apple[minIndex] = tmp;
            }
        }
        return apple;
    }

    public static ArrayList<ArrayList<Apple>> sortBySort(Apple[] apple) {
        ArrayList<Apple> applesOfTheFirstSort = new ArrayList<Apple>();
        ArrayList<Apple> applesOfTheSecondSort = new ArrayList<Apple>();
        ArrayList<Apple> applesOfTheThirdSort = new ArrayList<Apple>();
        for (int i = 0; i < apple.length; i++) {
            if (apple[i].getSort() == Sort.FIRST_SORT) {
                applesOfTheFirstSort.add(apple[i]);
            } else if (apple[i].getSort() == Sort.SECOND_SORT) {
                applesOfTheSecondSort.add(apple[i]);
            } else if (apple[i].getSort() == Sort.THIRD_SORT) {
                applesOfTheThirdSort.add(apple[i]);
            }
        }
        ArrayList<ArrayList<Apple>> applesBySort = new ArrayList<ArrayList<Apple>>();
        applesBySort.add(applesOfTheFirstSort);
        applesBySort.add(applesOfTheSecondSort);
        applesBySort.add(applesOfTheThirdSort);
        return applesBySort;
    }
}