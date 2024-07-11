package org.shiv;

import java.io.IOException;
import java.util.List;

public class Exercise3 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Get all numbers in the ReactiveSources.intNumbersFlux stream
        // into a List and print the list and its size
        // TODO: Write code here
        System.out.println("Get all numbers in the ReactiveSources.intNumbersFlux stream");
        System.out.println("into a List and print the list and its size");

        List<Integer> integerList = ReactiveSources.intNumbersFlux()
                        .toStream()
                                .toList();
        System.out.println(integerList+" of size "+integerList.size());

        System.out.println("Press a key to end");
        System.in.read();
    }

}
