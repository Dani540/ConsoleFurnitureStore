package com.store.application.utils.generators;

import com.store.application.models.entity.Client;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class ClientGenerator {
    private static ClientGenerator clientGenerator;
    private final int MAX_AGE = 82;
    private List<String> names = List.of(
            "Dani",
            "Tiara",
            "Andres",
            "Antonella",
            "Omar",
            "Brian",
            "Pablo"
    ),
    lastnames = List.of(
            "Torres",
            "Palma",
            "Rodriguez",
            "Montes",
            "Sepulveda",
            "Mendez",
            "Inostroza"
    );

    public static ClientGenerator getInstance() {
        if (clientGenerator==null) clientGenerator = new ClientGenerator();
        return clientGenerator;
    }

    public Client generateClient() {
        return new Client(
                generateName(),
                generateLastName(),
                generateRut(),
                generateAge()
        );
    }

    private String generateName() {
        return names.get(new Random().nextInt(names.size()));
    }

    private String generateLastName() {
        return lastnames.get(new Random().nextInt(lastnames.size()));
    }

    private int generateRut() {
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(1, 9)
                .forEach(i ->{
                    int n = new Random().nextInt(1,9);
                    stringBuilder.append ( n );
                });
        return Integer.parseInt(stringBuilder.toString());
    }

    private int generateAge() {
        return new Random().nextInt(18,MAX_AGE);
    }
}
