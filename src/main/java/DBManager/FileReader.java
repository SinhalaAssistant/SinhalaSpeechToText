package DBManager;

import java.io.*;

public class FileReader {

    private static final String TESTFileds = "/home/hasini/Education/FYP/Code/db/etc/sinhala_bank_test.fileids";
    private static final String TrainFields = "/home/hasini/Education/FYP/Code/db/etc/sinhala_bank_train.fileids";
    private static final String TestTrans = "/home/hasini/Education/FYP/Code/db/etc/sinhala_bank_test.transcription";
    private static final String TrainTrans = "/home/hasini/Education/FYP/Code/db/etc/sinhala_bank_train.transcription";

    public static void main(String a[]){

        String labels[][] = Labels.getLabels();

        BufferedWriter bw1=null;
        BufferedWriter bw2=null;
        BufferedWriter bw3=null;
        BufferedWriter bw4=null;

        try {

            bw1 = new BufferedWriter(new FileWriter(TESTFileds));
            bw2 = new BufferedWriter(new FileWriter(TrainFields));
            bw3 = new BufferedWriter(new FileWriter(TestTrans));
            bw4 = new BufferedWriter(new FileWriter(TrainTrans));

            int clips =0;
            for (int j=0; j<labels.length; j++) {

                for (int i=0; i<labels[j].length ; i++) {

                    File file = new File("/home/hasini/Education/FYP/Code/db/wav/"+(j+1)+"/"+(i+1)+"/sorted");
                    String[] fileList = file.list();
                    System.out.println(j+" "+i+" "+fileList.length);

                    int limit = fileList.length*80/100;
                    System.out.println("limit "+limit);
                    for (int k=0; k<fileList.length; k++) {
                        clips++;
//                        System.out.println(j+" "+i+" "+k);
                        String name = fileList[k];

                            String s = name.substring(0,name.length()-4);
                            if (k>limit){
//                                System.out.println("<s> "+labels[j][i]+" </s> ("+s+")");

                                bw1.write((j+1)+"/"+(i+1)+"/sorted/"+s+"\n");
                                bw3.write("<s> "+labels[j][i]+" </s> ("+s+")"+"\n");
                            } else {
//                                System.out.println(k+" train " +s);
                                bw2.write((j+1)+"/"+(i+1)+"/sorted/"+s+"\n");
                                bw4.write("<s> "+labels[j][i]+" </s> ("+s+")"+"\n");
                            }

                        }

                    }



            }


            System.out.println("clips "+clips);

            System.out.println("Done");

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (bw1 != null)
                    bw1.close();
                if (bw2 != null)
                    bw2.close();
                if (bw3 != null)
                    bw3.close();
                if (bw4 != null)
                    bw4.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }



    }




    }

