package DBManager;

import java.io.*;
import java.io.FileReader;
import java.util.ArrayList;

public class Dictionary {
    private static final String FILENAME = "/home/hasini/Education/FYP/Code/db/etc/sinhala_bank.dic";
    private static final String FILEPhone = "/home/hasini/Education/FYP/Code/db/etc/sinhala_bank.phone";


    public static void main(String[] args) {

        BufferedReader br = null;
        FileReader fr = null;

        BufferedWriter bw=null;

        try {


            fr = new FileReader(FILENAME) ;
            br = new BufferedReader(fr);
            bw = new BufferedWriter(new FileWriter(FILEPhone));

            String sCurrentLine;

            ArrayList<String> phonemes = new ArrayList<String>();

            while ((sCurrentLine = br.readLine()) != null) {
//                System.out.println(sCurrentLine);
                String[] data = sCurrentLine.split(" ");
                for (int i =1; i<data.length; i++) {
                    if (!phonemes.contains(data[i])) {
                        phonemes.add(data[i]);
                        System.out.println(data[i]);
                        bw.write(data[i]+"\n");
                    }

                }

            }
            bw.write("SIL");



        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();
                if (bw != null)
                    bw.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }

    }

}
