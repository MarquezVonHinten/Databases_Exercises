package com.nils.databases.BWT;

import javafx.util.Pair;

import java.lang.reflect.Array;
import java.util.*;

public class BurrowsWheelerTransformHelper {

    public Pair<String, Integer> encode(String inputString) throws Exception{
        String bwtString = "";
        int endPosition = -1;
        List<String> allShifts = getAllShifts(inputString);
        Collections.sort(allShifts);
        for (int i = 0; i < inputString.length();i++) {
            String currentShift = allShifts.get(i);
            bwtString += currentShift.substring(inputString.length() - 1);
            if (currentShift.equals(inputString)) endPosition = i;
        }
        if (inputString.length() != bwtString.length()) throw new Exception("BWT String is wrong");
        if (endPosition == -1 || inputString.charAt(inputString.length() - 1) != bwtString.charAt(endPosition)) throw new Exception("Index of the End Position is wrong");
        return new Pair<>(bwtString, endPosition);
    }

    public String decode(Pair<String, Integer> bwtPair){
        return "misissiisis";
    }


    private List<String> getAllShifts(String inputString){
        List<String> shifts = new ArrayList<>(inputString.length());
        for (int i = 0; i < inputString.length(); i++){
            shifts.add(inputString);
            inputString = inputString.charAt(inputString.length() - 1) + inputString.substring(0, inputString.length() - 1);
        }
        return shifts;
    }




    // 1.
    public String transform(String inputString) {
        String bwtString = "";
        List<String> allShifts = getAllShifts(inputString);
        Collections.sort(allShifts);
        for (String shift : allShifts) {
            bwtString += shift.substring(inputString.length()-1);
        }
        return bwtString;
    }

    // 2.
    public int rank(char wantedChar, int index, String searchString){
        int count = 0;
        for (int i = 0; i <= index; i++) {
            char currentChar = searchString.charAt(i);
            if (wantedChar == currentChar) count++;
        }
        return count;
    }

    public int rank(String wantedChar, int index, String searchString){
        if (wantedChar.length() != 1) "".charAt(1);
        return rank(wantedChar.charAt(0), index, searchString);
    }


    public int count(String givenString, char givenChar){
        char charList[] = givenString.toCharArray();
        Arrays.sort(charList);
        String sortedString = new String(charList);
        return sortedString.indexOf(givenChar);
    }

    public int count(String givenString, String givenChar){
        if (givenChar.length() != 1) "".charAt(1);
        return count(givenString, givenChar.charAt(0));
    }

    public String retransform(String bwtString){
        String returnString = "";
        char firstColumn[] = bwtString.toCharArray();
        Arrays.sort(firstColumn);
        String firstColumnString = new String(firstColumn);
        int currentPosition = bwtString.indexOf('$');
        for (int i = 0; i < bwtString.length(); i++){
            char currentChar = bwtString.charAt(currentPosition);
            currentPosition = count(bwtString, currentChar) + rank(currentChar, currentPosition, bwtString) - 1;
            returnString =  currentChar + returnString;
        }

        return returnString;
    }

    /* Limitations:
        The Text cannot contain a '$' if it contains multiple the retransform may be corrupted
        For example This will not work: "bla$$blub$"
            bwt.retransform(bwt.transform("bla$$blub$")); returns : "$blub$bla$"

        It is also limited on the maximal String length of java

        Not a limitation, but this program depends on the fact, that Arrays.sort and Collections.sort use the same sort algorithm

     */

}
