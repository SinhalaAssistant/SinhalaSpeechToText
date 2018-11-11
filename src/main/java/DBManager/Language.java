package DBManager;

import java.io.*;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Language {

    private static final String FILElan = "/home/hasini/Education/FYP/Code/src/main/resources/lan.txt";


        public static void main(String[] args) {

            String labels[][] = Labels.getLabels();
            BufferedWriter bw=null;

            try {

                bw = new BufferedWriter(new FileWriter(FILElan));

                for (int i=0;i<10000;i++){
//                    Collections.shuffle(labels);
                    for(int j=0;j<labels.length;j++){
                        shuffle(labels[j]);
                        for(int k=0;k<labels[j].length;k++){
                            bw.write(labels[j][k]+"\n");
                        }

                    }
                }

            } catch (IOException e) {

                e.printStackTrace();

            } finally {

                try {

                    if (bw != null)
                        bw.close();

                } catch (IOException ex) {

                    ex.printStackTrace();

                }

            }

        }

    private static void shuffle(String[] arr) {
        Random rgen = new Random();

        for (int i = 0; i < arr.length; i++) {
            int randPos = rgen.nextInt(arr.length);
            String tmp = arr[i];
            arr[i] = arr[randPos];
            arr[randPos] = tmp;
        }
    }


    }


