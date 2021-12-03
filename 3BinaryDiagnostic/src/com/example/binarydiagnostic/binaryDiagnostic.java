package com.example.binarydiagnostic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class binaryDiagnostic {
    public static void main(String[] args) {
        int binLength = 0;
        int zeros=0;

        String commonBitsGamma = "";
        String commonBitsEpsilon = "";

        List<String> scan = new ArrayList<String>();

        try {
            File myObj = new File("binary.txt");
            Scanner getLines = new Scanner(myObj);
            Scanner arrayBuild = new Scanner(myObj);

            while (getLines.hasNextLine()) {
                String data = getLines.nextLine();
                scan.add(data);
            }
            getLines.close();
        } catch (
                FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        binLength = scan.get(1).length();

        for(int charPos = 0; charPos < binLength; charPos++){
            for(int linePos = 0; linePos < scan.size(); linePos++) {
                String lineVal = scan.get(linePos);
                int charVal = Character.getNumericValue(lineVal.charAt(charPos));
                if (charVal == 0) {
                    zeros++;
                }
                System.out.println("charVal " + charVal + " charPos " + charPos + " linePos " + linePos);
            }

            if (zeros < scan.size()/2){
                commonBitsGamma = commonBitsGamma + 1;
                commonBitsEpsilon = commonBitsEpsilon + 0;
            } else {
                commonBitsGamma = commonBitsGamma + 0;
                commonBitsEpsilon = commonBitsEpsilon + 1;
            }

            zeros = 0;
        }
        System.out.println("Gamma " + commonBitsGamma + " Epsilon " + commonBitsEpsilon);

        int epsilon = Integer.parseInt(commonBitsEpsilon,2);
        int gamma = Integer.parseInt(commonBitsGamma,2);

        System.out.println("Gamma = " + gamma + " Epsilon " + epsilon + " Power Level = " + gamma * epsilon);
    }

}
