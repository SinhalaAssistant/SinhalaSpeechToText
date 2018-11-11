import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.api.StreamSpeechRecognizer;

public class Demo {

    public static void main(String[] args) throws Exception {

        Configuration configuration = new Configuration();

        configuration.setAcousticModelPath("/home/hasini/Education/FYP/Code/model_parameters/sinhala_bank.ci_semi");
//        configuration.setDictionaryPath("/home/hasini/Education/FYP/Code/src/main/resources/sinhala.dict");
        configuration.setDictionaryPath("/home/hasini/Education/FYP/Code/db/etc/sinhala_bank.dic");
        configuration.setLanguageModelPath("/home/hasini/Education/FYP/Code/db/etc/sinhala_bank.lm");

        StreamSpeechRecognizer recognizer = new StreamSpeechRecognizer(configuration);
        InputStream stream = new FileInputStream(new File("test.wav"));

        recognizer.startRecognition(stream);
        SpeechResult result;
        while ((result = recognizer.getResult()) != null) {
            System.out.format("Hypothesis: %s\n", result.getHypothesis());
        }
        recognizer.stopRecognition();
    }
}
