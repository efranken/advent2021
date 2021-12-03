package com.example.dive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class dive {
    public static void main(String[] args) {
        int x = 0;          //0 beginning point
        int y = 0;          //0 beginning point

                            //modified once per array iteration
        int xMod = 0;       //how much to move left/right
        int yMod = 0;       //how much to move up/down
        String direction;   //direction to move

        int linesCount = 0; //number of lines in array

        List<String> inputData = new ArrayList<String>();
        try {
            File myObj = new File("input.txt");
            Scanner getLines = new Scanner(myObj);

            while (getLines.hasNextLine()) {
                String lines = getLines.nextLine();
                inputData.add(lines);
                linesCount++;
            }
            getLines.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        for(int i=0; i < inputData.size(); i++) {
            if(inputData.get(i).contains("forward")){
                xMod = Integer.parseInt(inputData.get(i).replaceAll("\\D", ""));
                x+=xMod;
            }
            else if(inputData.get(i).contains("down")){
                yMod = Integer.parseInt(inputData.get(i).replaceAll("\\D", ""));
                y+=yMod;
            }
            else if(inputData.get(i).contains("up")){
                yMod = Integer.parseInt(inputData.get(i).replaceAll("\\D", ""));
                y-=yMod;
            }

            System.out.println(
                            "val " + i +
                            " data " + inputData.get(i) +
                            " parse x " + x +
                            " parse y " + y
            );
        }
        System.out.println("Horizontal " + x + " Vertical " + y + " Multiplied " + (x*y));
    }

}
