package com.example.binarydiagnostic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class binaryDiagnostic2 {
    int charVal = 0;
    int ones = 0;
    int zeros = 0;

    String lineVal;

    List<String> scan = new ArrayList<String>();
    List<String> scanAirQuality = new ArrayList<String>();
    List<String> scanCO2Scrubber = new ArrayList<String>();;


    public static void main(String[] args) {
        binaryDiagnostic2 thisObj = new binaryDiagnostic2();
        binaryDiagnostic2 fileReader = new binaryDiagnostic2();

        thisObj.fileReader();
        thisObj.lifeSupportParse();
        thisObj.scrubberParse();
        thisObj.printAnswer();
    }

    public void fileReader() {
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
    }

    public void lifeSupportParse() {
        scanAirQuality = new ArrayList<String>(scan);
        int lifeDigits = String.valueOf(scanAirQuality.get(0)).length();
        int lifeLength = scanAirQuality.size();
        zeros = 0;
        ones = 0;
        int removed = 0;

        for (int digInc = 0; digInc < lifeDigits; digInc++) {
            for (int i = 0; i < lifeLength; i++) {
                lineVal = scanAirQuality.get(i);
                charVal = Character.getNumericValue(lineVal.charAt(digInc));
                if (charVal == 0) {
                    zeros++;
                }
                if (charVal == 1) {
                    ones++;
                }
            }
            if (ones > zeros || ones == zeros ) {
                for (int oneInc = 0; oneInc < scanAirQuality.size(); oneInc++) {
                    //System.out.println(oneInc);
                    lineVal = scanAirQuality.get(oneInc);   //get the value of the line at the point in the iteration
                    charVal = Character.getNumericValue(lineVal.charAt(digInc)); //get the character of the digit specified
                    if (charVal == 0) {
                        scanAirQuality.remove(oneInc); //if the value of the digit is 0, remove the line at the point in the iteration
                        removed++;
                        oneInc = -1;  //set it back to zero and bring it back around town
                    }

                }
            }
            if (ones < zeros) {
                for (int oneInca = 0; oneInca < scanAirQuality.size(); oneInca++) {
                    lineVal = scanAirQuality.get(oneInca);
                    charVal = Character.getNumericValue(lineVal.charAt(digInc));
                    if (charVal == 1) {
                        scanAirQuality.remove(oneInca);
                        oneInca = -1;
                        removed++;
                    }
                }
            }
            System.out.println(zeros + " zeros " + ones + " ones " + (zeros+ones) + " added " + removed + " removed");
            removed = 0;
            lifeLength = scanAirQuality.size();
            if(lifeLength == 1) {
                break;
            }
            zeros = 0;
            ones = 0;
        }
        System.out.println("air oxygen " + Integer.parseInt(scanAirQuality.get(0), 2) + " s " + scanAirQuality);
    }

    public void scrubberParse() {
        scanCO2Scrubber = new ArrayList<String>(scan);
        int scrubberDigits = String.valueOf(scanCO2Scrubber.get(0)).length();
        int scrubberLength = scanCO2Scrubber.size();
        zeros = 0;
        ones = 0;

        for (int digInc = 0; digInc < scrubberDigits; digInc++) {
            for (int i = 0; i < scrubberLength; i++) {
                lineVal = scanCO2Scrubber.get(i);
                charVal = Character.getNumericValue(lineVal.charAt(digInc));
                if (charVal == 0) {
                    zeros++;
                }
                if (charVal == 1) {
                    ones++;
                }
            }
            System.out.println(zeros + " zeros " + ones + " ones ");
            if (zeros < ones || ones == zeros) {
                for (int oneInc = 0; oneInc < scanCO2Scrubber.size(); oneInc++) {
                    lineVal = scanCO2Scrubber.get(oneInc);
                    charVal = Character.getNumericValue(lineVal.charAt(digInc));
                    if (charVal == 1) {
                        scanCO2Scrubber.remove(oneInc);
                        oneInc = -1;
                    }
                }
            }
            if (ones < zeros) {
                for (int oneInc = 0; oneInc < scanCO2Scrubber.size(); oneInc++) {
                    lineVal = scanCO2Scrubber.get(oneInc);
                    charVal = Character.getNumericValue(lineVal.charAt(digInc));
                    if (charVal == 0) {
                        scanCO2Scrubber.remove(oneInc);
                        oneInc = -1;
                    }
                }
            }

            scrubberLength = scanCO2Scrubber.size();

            if(scrubberLength == 1) {
                break;
            }

            zeros = 0;
            ones = 0;

        }
        System.out.println("co2 " + Integer.parseInt(scanCO2Scrubber.get(0), 2) + " s " + scanCO2Scrubber);
    }

    public void printAnswer() {
        int CO2 = Integer.parseInt(scanCO2Scrubber.get(0), 2);
        int air = Integer.parseInt(scanAirQuality.get(0), 2);
        int lifeSupport = CO2 * air;

        System.out.println("Life Support Rating = " + lifeSupport);
    }
}

