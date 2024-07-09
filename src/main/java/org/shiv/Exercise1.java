package org.shiv;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        // TODO: Write code here
        System.out.println("\nPrint all numbers in the intNumbersStream stream");
        StreamSources.intNumbersStream().forEach(i-> System.out.print(i+" , "));
        //alternative way
        //StreamSources.intNumbersStream().forEach(System.out::print);

        // Print numbers from intNumbersStream that are less than 5
        // TODO: Write code here
        System.out.println("\nPrint numbers from intNumbersStream that are less than 5");
        StreamSources.intNumbersStream().filter(i -> i < 5)
                .forEach(i-> System.out.print(i+" , "));

        // Print the second and third numbers in intNumbersStream that's greater than 5
        // TODO: Write code here
        System.out.println("\nPrint the second and third numbers in intNumbersStream that's greater than 5");
        StreamSources.intNumbersStream().filter(i -> i>5)
                .skip(1)
                        .limit(2)
                                .forEach(i-> System.out.print(i+" , "));

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        // TODO: Write code here
        System.out.println("\nPrint the first number in intNumbersStream that's greater than 5.");
        Integer val = StreamSources.intNumbersStream().filter(i -> i > 5)
                .findFirst()
                        .orElse(-1);
        System.out.println(val);
        //alternative way
        //(StreamSources.intNumbersStream().filter(i -> i > 5).findFirst()).ifPresent(System.out::println);

        // Print first names of all users in userStream
        // TODO: Write code here
        System.out.println("\nPrint first names of all users in userStream");
        //alternative
        //StreamSources.userStream().forEach(user -> System.out.print(user.getFirstName()+" , "));
        StreamSources.userStream()
                .map(user -> user.getFirstName())
                        .forEach(userName -> System.out.print(userName+" , "));

        // Print first names in userStream for users that have IDs from number stream
        // TODO: Write code here
        System.out.println("\nPrint first names in userStream for users that have IDs from number stream");
        StreamSources.intNumbersStream()
                .flatMap(id -> StreamSources.userStream().filter(user -> user.getId() == id))
                .map(user -> user.getFirstName())
                .forEach(userName -> System.out.print(userName+" , "));

        System.out.println();
        StreamSources.userStream()
                .filter(user -> StreamSources.intNumbersStream().anyMatch(i -> i==user.getId()))
                .forEach(user -> System.out.print(user.getFirstName()+" , "));

    }

}
