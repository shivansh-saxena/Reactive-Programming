package org.shiv;

import reactor.core.publisher.Flux;

import java.io.IOException;

public class Exercise2 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()

        // Print all numbers in the ReactiveSources.intNumbersFlux stream
        // TODO: Write code here
        System.out.println("Print all numbers in the ReactiveSources.intNumbersFlux stream");
        Flux<Integer> source = ReactiveSources.intNumbersFlux();
        source.subscribe(element -> System.out.print(element+" , "));
        source.subscribe(element -> System.out.print(element+" ,reprint "));

        // Print all users in the ReactiveSources.userFlux stream
        // TODO: Write code here
        System.out.println("Print all users in the ReactiveSources.userFlux stream");
        ReactiveSources.userFlux()
                        .subscribe(user -> System.out.print(user+" , "));

        System.out.println("Press a key to end");
        System.in.read();
    }

}
