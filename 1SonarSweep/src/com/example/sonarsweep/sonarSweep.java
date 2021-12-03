package com.example.sonarsweep;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;
import java.util.List;

class sonarSweep {
    public static void main(String[] args) {
        int dataInt = 0;
        int arrayCount = 0;
        int arrayCountPlus = arrayCount+1;
        int arrayCountMinus = 0;
        int pings = 0;
        List<Integer> scans = new ArrayList<Integer>();
        try {
            File myObj = new File("num.txt");
            Scanner getLines = new Scanner(myObj);
            Scanner arrayBuild = new Scanner(myObj);

            while (getLines.hasNextLine()) {
                String data = getLines.nextLine();
                dataInt = Integer.parseInt(data);
                scans.add(dataInt);
                System.out.println(data);
            }
            getLines.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        for(arrayCount = 0; arrayCount < scans.size(); arrayCount++) {
            if(arrayCount == 0){
                arrayCountMinus = 0;
            } else {
                arrayCountMinus = arrayCount-1;

                if (scans.get(arrayCount) > scans.get(arrayCountMinus)) {
                    pings++;
                }
            }
            System.out.println("Pings " + pings + " Array Count " + arrayCount + " Array Count -- " + arrayCountMinus + " scans size " + scans.size() + " current " + scans.get(arrayCount));
        }
    }
}