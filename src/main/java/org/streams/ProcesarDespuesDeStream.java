package org.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
//import java.util.function.Predicate;


public class ProcesarDespuesDeStream {

    public static void main(String[] args) {
     
        List<Dish> menu = Arrays.asList( 
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH) );
            
        //Predicate<Dish> dishBajaCaloria = x -> x.getCalories() < 300;

        List<String> listcalories = menu.stream()
            .filter(d -> d.getCalories() < 400)//Despues de este metodo que sigue, solo hay plato con menos de 400 calorías
            .sorted(Comparator.comparing(d -> d.getCalories()))//Ordena los platos por calorias
            .map(d -> d.getName())//Extrae el nombre de los platos
            .toList();//Lo convierte en una lista

        System.out.println(listcalories);



    }


}
