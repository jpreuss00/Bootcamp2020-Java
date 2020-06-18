package Bootcamp2020.Java;

import java.util.Random;
import java.util.Scanner;

public class HelloWorld {

    public static String getGreeting(int number) {

        switch(number){
            case 0:
                return "Hello World";
            case 1:
                return "H3ll0 W0rld";
            case 2:
                return "H3770 W0r7d";
            default:
                return "Hello world.";
        }

    }

    public static void random(){

        Random random = new Random();

        System.out.println(getGreeting(random.nextInt(3)));

    }

    public static void console(){

        System.out.println("Bitte entscheide dich für 0, 1 oder 2.");

        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.next());

        System.out.println(getGreeting(input));
    }

    public void hw(){

        System.out.println("Bitte entscheide dich für eine zufällige (0) oder ausgewählte (1) Begrüßung.");

        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.next());

        switch(input){
            case 0:
                random();
                break;
            case 1:
                console();
                break;
            default:
                break;
        }
    }
}