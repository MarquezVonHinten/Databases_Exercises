package com.nils.databases.BWT;

import javafx.util.Pair;

public class Main {
    public static BurrowsWheelerTransformHelper bwt;


    public static void main(String[] args)  throws Exception {
        bwt = new BurrowsWheelerTransformHelper();
        printCycle("abracadabra$");
        printCycle("abracadabra");
        printCycle("Rindfleischetikettierungsueberwachungsaufgabenuebertragungsgesetz$");
        printCycle("Rindfleischetikettierungsueberwachungsaufgabenuebertragungsgesetz");


    }


    public static void printCycle(String base) throws Exception {
        String transformed = "";
        String retransformed = "";
        if (base.contains("$")) {
            transformed = bwt.transform(base);
            retransformed = bwt.retransform(transformed);
        }else {
            Pair<String, Integer> encoded = bwt.encode(base);
            transformed = encoded.getKey();
            retransformed = bwt.decode(encoded);
        }
        System.out.println("Base word:     " + base);
        System.out.println("Transformed:   " + transformed);
        System.out.println("Retransformed: " + retransformed);
        System.out.println("Successive chars base word:        " + getFollowing(base));
        System.out.println("Successive chars transformed word: " + getFollowing(transformed));

        if (!base.equals(retransformed)) System.out.println("Something went wrong! The Base word does not equal the retransformed one");
    }

    public static int getFollowing(String string){
        char currentChar = string.charAt(0);
        int counter = 0;
        for (int i = 1; i< string.length(); i++) {
            if(currentChar == string.charAt(i)) counter++;
            currentChar = string.charAt(i);
        }

        return counter;
    }
}
