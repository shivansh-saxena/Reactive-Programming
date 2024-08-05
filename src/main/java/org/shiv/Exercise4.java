package org.shiv;

import reactor.core.Disposable;

import java.io.IOException;
import java.util.Optional;

public class Exercise4 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
        // TODO: Write code here
        System.out.println("Print the value from intNumberMono when it emits");

        ReactiveSources.intNumberMono()
                .subscribe(number -> System.out.println(number));

        //Type one
        ReactiveSources.intNumberMono()
                .subscribe();

        //Type two
        ReactiveSources.intNumberMono()
                .subscribe(
                        number -> System.out.println(number),
                        error -> System.out.println(error.getMessage())
                );

        //Type three
        ReactiveSources.intNumberMono()
                .subscribe(
                        number -> System.out.println(number),
                        error -> System.out.println(error.getMessage()),
                        () -> System.out.println("Complete")//this executes at the end of first lambda
                );

//        Type four(deprecated)
//        Disposable disposable = ReactiveSources.intNumberMono()
//                .subscribe(
//                        number -> System.out.println(number),
//                        error -> System.out.println(error.getMessage()),
//                        () -> System.out.println("Complete"),//this executes at the end of first lambda
//                        subscription -> {
//
//                        }
//                );

        // Get the value from the Mono into an integer variable
        // TODO: Write code here
        System.out.println("Get the value from the Mono into an integer variable");

        Integer number = ReactiveSources.intNumberMono()
                        .block();
        System.out.println(number);

        Optional<Integer> numberOptional = ReactiveSources.intNumberMono()
                .blockOptional();
        System.out.println(numberOptional.orElse(-1));

        System.out.println("Press a key to end");
        System.in.read();
    }

}
