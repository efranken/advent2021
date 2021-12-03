package com.example.binarydiagnostic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class binarydiagnosticFirstTry {
        public static void main(String[] args) {

        int bit0 = 0;
        int bit1 = 0;
        int bit2 = 0;
        int bit3 = 0;
        int bit4 = 0;

        int zeros0 = 0;
        int zeros1 = 0;
        int zeros2 = 0;
        int zeros3 = 0;
        int zeros4 = 0;

        int bit0c = 0;
        int bit1c = 0;
        int bit2c = 0;
        int bit3c = 0;
        int bit4c = 0;

        int bitVal1 = 0;
        int bitVal2 = 0;

        int gamma = 0;
        int epsilon = 0;

        int dataInt = 0;

        String splitBinary;
        String bitGamma;
        String bitEpsilon;

        int splitBinaryInt = 0;

        //int arrayCount = 0;

        List<String> scan = new ArrayList<String>();


        try {
        File myObj = new File("binary.txt");
        Scanner getLines = new Scanner(myObj);
        Scanner arrayBuild = new Scanner(myObj);

        while (getLines.hasNextLine()) {
            String data = getLines.nextLine();
            scan.add(data);
            //System.out.println(data);
        }
        getLines.close();
        } catch (
        FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        for(int i = 0; i < scan.size(); i++) {
            splitBinary = String.valueOf(scan.get(i));
            //splitBinaryInt =
            bit0 = Character.getNumericValue(splitBinary.charAt(0));
            if (bit0 == 0) {
                zeros0++;
            }

            bit1 = Character.getNumericValue(splitBinary.charAt(1));
            if (bit1 == 0) {
                zeros1++;
            }

            bit2 = Character.getNumericValue(splitBinary.charAt(2));
            if (bit2 == 0) {
                zeros2++;
            }

            bit3 = Character.getNumericValue(splitBinary.charAt(3));
            if (bit3 == 0) {
                zeros3++;
            }

            bit4 = Character.getNumericValue(splitBinary.charAt(4));
            if (bit4 == 0) {
                zeros4++;
            }

            //System.out.println("val " + i + " split " + splitBinary + " length " + splitBinary.length());
            System.out.println("split " + splitBinary + " bits " + bit0 + bit1 + bit2 + bit3 + bit4 + " zeros " + zeros0 + zeros1 + zeros2 + zeros3 + zeros4);
        }

        if (zeros0 > (scan.size()/2)) {
            bit0c = 0;
        } else {
            bit0c = 1;
        }

        if (zeros1 > (scan.size()/2)) {
            bit1c = 0;
        } else {
            bit1c = 1;
        }

        if (zeros2 > (scan.size()/2)) {
            bit2c = 0;
        } else {
            bit2c = 1;
        }

        if (zeros3 > (scan.size()/2)) {
            bit3c = 0;
        } else {
            bit3c = 1;
        }

        if (zeros4 > (scan.size()/2)) {
            bit4c = 0;
        } else {
            bit4c = 1;
        }

        bitGamma = (bit0c + "" + bit1c + "" + bit2c + "" + bit3c + "" + bit4c);
        System.out.println(bitGamma);
        gamma = Integer.parseInt(bitGamma,2);
        System.out.println("Gamma rate: " + gamma);

        if (zeros0 > (scan.size()/2)) {
            bit0c = 1;
        } else {
            bit0c = 0;
        }

        if (zeros1 > (scan.size()/2)) {
            bit1c = 1;
        } else {
            bit1c = 0;
        }

        if (zeros2 > (scan.size()/2)) {
            bit2c = 1;
        } else {
            bit2c = 0;
        }

        if (zeros3 > (scan.size()/2)) {
            bit3c = 1;
        } else {
            bit3c = 0;
        }

        if (zeros4 > (scan.size()/2)) {
            bit4c = 1;
        } else {
            bit4c = 0;
        }

        bitEpsilon = (bit0c + "" + bit1c + "" + bit2c + "" + bit3c + "" + bit4c);
        System.out.println(bitEpsilon);
        epsilon = Integer.parseInt(bitEpsilon,2);
        System.out.println("Epsilon rate: " + epsilon);

        System.out.println("Power consumption = " + (epsilon*gamma));
    }
}
