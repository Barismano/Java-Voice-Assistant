import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import java.net.URI;
import java.awt.Desktop;
public class App {
    public static void main(String[] args) throws Exception {
        

        Configuration config= new Configuration();
        config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        config.setDictionaryPath("src\\dic.dic");
        config.setLanguageModelPath("src\\lm.lm");
        try {
            LiveSpeechRecognizer rec = new LiveSpeechRecognizer(config);
            Desktop desk = Desktop.getDesktop();
            rec.startRecognition(true);
            
            
            while(rec.getResult() != null){
                String result = rec.getResult().getHypothesis();
                
                System.out.println(result);
                switch(result.toLowerCase()){
                    case "google":
                    System.out.println("Opening Google");
                    URI uri_google = new URI("http://google.com");
                    desk.browse(uri_google);
                    break;
                    case "youtube":
                    System.out.println("Opening Youtube");
                    URI uri_youtube = new URI("http://youtube.com");
                    desk.browse(uri_youtube);
                    break;
                    case "reddıt":
                    System.out.println("Opening Reddit");
                    URI uri_reddit = new URI("http://reddit.com");
                    desk.browse(uri_reddit);
                    break;
                    case "whatsapp":
                    System.out.println("Opening Whatsapp");
                    URI uri_whatsapp = new URI("https://web.whatsapp.com");
                    desk.browse(uri_whatsapp);
                    break;
                    case "maıl":
                    System.out.println("Opening Mail");
                    URI uri_mail = new URI("https://mail.google.com/mail/u/0/?tab=rm&ogbl#inbox");
                    desk.browse(uri_mail);
                    break;
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
