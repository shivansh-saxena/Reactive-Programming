package org.shiv;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
        // TODO: Write code here
        ReactiveSources.intNumberMono().
                subscribe(
                        integer -> System.out.println(integer),
                        throwable -> System.out.println(throwable.getMessage()),
                        () -> System.out.println("end of integer mono")
                );

        ReactiveSources.userMono().
                subscribe(
                        user -> System.out.println(user.toString()),
                        throwable -> System.out.println(throwable.getMessage()),
                        () -> System.out.println("end of user mono")
                );

        // Subscribe to a flux using an implementation of BaseSubscriber
        // TODO: Write code here

        ReactiveSources.intNumbersFlux()
                        .subscribe(new MySubscriber<>());

        System.out.println("Press a key to end");
        System.in.read();
    }

}

class MySubscriber<T> extends BaseSubscriber<T>{
    public void hookOnSubscribe(Subscription subscription){
        System.out.println("Sub happened");
        //you will have to ask for items otherwise you won't receive any
        request(2);
    }
    public void hookOnNext(T value){
        System.out.println(value.toString()+" received");
        request(1);
    }
}