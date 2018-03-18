package com.company;

public class Apple {

    private double weight;
    private Sort sort;
    private static final int pricePerKGFirstSort = 10;
    private static final int pricePerKGSecondSort = 15;
    private static final int pricePerKGThirdSort = 20;

    public double getWeight() {
        return weight;
    }

    public Sort getSort() {
        return sort;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    public static double costPerUnit(Apple apple) {
        double costPerUnit = 0;
        if(apple.getSort() == Sort.FIRST_SORT) {
            costPerUnit = apple.getWeight() * pricePerKGFirstSort;
        } else if(apple.getSort() == Sort.SECOND_SORT) {
            costPerUnit = apple.getWeight() * pricePerKGSecondSort;
        } else if(apple.getSort() == Sort.THIRD_SORT) {
            costPerUnit = apple.getWeight() * pricePerKGThirdSort;
        }
        return costPerUnit;
    }

    public static double cost(Apple[] apple){
        double result = 0;
        for (int i = 0; i < apple.length; i++) {
            result += apple[i].costPerUnit(apple[i]);
        }
        return result;
    }
}