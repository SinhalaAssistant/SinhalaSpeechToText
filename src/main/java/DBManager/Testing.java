package DBManager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Testing {

    private static final String folder = "/home/hasini/Education/FYP/Test/";

    public static void main(String a[]){

        double[] precentage = {23.1, 16.8 ,19.9, 12.9,16.9,10.4};

        for (int b=1;b<8; b++) {
            System.out.println("*****************************************"+b*1000);
            String destination = folder+(b*1000);

            String labels[][] = Labels.getLabels();

            BufferedWriter bw1=null;
            BufferedWriter bw2=null;
            BufferedWriter bw3=null;
            BufferedWriter bw4=null;

            try {

                bw1 = new BufferedWriter(new FileWriter(destination+"/etc/sinhala_bank_test.fileids"));
                bw2 = new BufferedWriter(new FileWriter(destination+"/etc/sinhala_bank_train.fileids"));
                bw3 = new BufferedWriter(new FileWriter(destination+"/etc/sinhala_bank_test.transcription"));
                bw4 = new BufferedWriter(new FileWriter(destination+"/etc/sinhala_bank_train.transcription"));

                int clips =0;
                for (int j=0; j<labels.length; j++) {

                    int o = labels[j].length;

                    for (int i=0; i<labels[j].length ; i++) {

                        File file = new File("/home/hasini/Education/FYP/Code/db/wav/"+(j+1)+"/"+(i+1)+"/sorted");
                        String[] fileList = file.list();
                        System.out.println(j+" "+i+" "+fileList.length);

                        double newLength = precentage[j]/100*(b*1000)/o;

                        System.out.println(j+" "+i+" "+newLength);

                        int limit =(int) newLength*80/100;
                        System.out.println("limit "+limit);
                        for (int k=0; k<newLength; k++) {
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

}
