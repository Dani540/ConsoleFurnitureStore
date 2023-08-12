package com.store.application.utils.generators;

import com.store.application.models.entity.Client;
import com.store.application.models.entity.PersonalizedFurniture;
import com.store.application.models.entity.TraditionalFurniture;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FurnitureGenerator {
    private static FurnitureGenerator furnitureGenerator;
    private final double
            MAX_WEIGHT = 159.5,
            MIN_WEIGHT = 29.99,
            MIN_PRICE = 12.99,
            MAX_PRICE = 199.90;
    private final List<String>
            nameList = List.of(
            "Sofa",
                    "Silla",
                    "Mesa",
                    "Escritorio",
                    "Comoda",
                    "Repisa",
                    "Silla de oficina",
                    "Archivador",
                    "Estanteria",
                    "Lampara de mesa",
                    "Armario"),
            loremList = List.of(
            "Lorem",
            "Ipsum",
            "dolor",
            "sit",
            "amet",
            "consectetur",
            "adipiscing",
            "elit",
            "sed" ,
            "do" ,
            "eiusmod",
            "tempor",
            "incididunt",
            "ut",
            "labore",
            "et" ,
            "dolore" ,
            "magna" ,
            "aliqua." ,
            "Ut",
            "enim",
            "ad",
            "minim" ,
            "veniam," ,
            "quis" ,
            "nostrud",
            "exercitation" ,
            "ullamco" ,
            "laboris",
            "nisi",
            "ut",
            "aliquip" ,
            "ex" ,
            "ea",
            "commodo",
            "consequat");


    public TraditionalFurniture generateTrad(){
        return new TraditionalFurniture(
                generateName(),
                generateDescription(),
                generateWeight(),
                generatePrice()
        );
    }

    public PersonalizedFurniture generatePers(){
        return new PersonalizedFurniture(
                generateName(),
                generateDescription(),
                generateWeight(),
                generatePrice(),
                new Random().nextBoolean(),
                generateClient()
        );
    }

    private String generateName() {
        return nameList.get(new Random().nextInt(nameList.size()));
    }

    private String generateDescription() {
        return IntStream
                .range(new Random().nextInt(loremList.size()/2), new Random().nextInt(0,loremList.size()))
                .mapToObj(loremList::get)
                .collect(Collectors.joining("_"));
    }

    private double generateWeight() {
        return new Random().nextDouble(MIN_WEIGHT, MAX_WEIGHT);
    }

    private double generatePrice() {
        return new Random().nextDouble(MIN_PRICE, MAX_PRICE);
    }

    private Client generateClient() {
        return ClientGenerator.getInstance().generateClient();
    }

    public static FurnitureGenerator getInstance() {
        if (furnitureGenerator==null) furnitureGenerator = new FurnitureGenerator();
        return furnitureGenerator;
    }
}
