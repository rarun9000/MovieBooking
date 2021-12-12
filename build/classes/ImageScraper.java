
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.imageio.ImageIO;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RK
 */
public class ImageScraper {
    String title="";
    ImageScraper(){
        
    }
    ImageScraper(String title){
        this.title = title + " imdb";
    }
    URL Get(){
        String img_name = title;
        URL res=null;
        try {
               String url = "https://www.google.com/search?q="+img_name+"&tbm=isch&ved=2ahUKEwiz-IW_oojwAhWJLSsKHepsC2EQ2-cCegQIABAA&oq=master+tamil+2021+image&gs_lcp=CgNpbWcQDFAAWABgixNoAHAAeACAAQCIAQCSAQCYAQCqAQtnd3Mtd2l6LWltZw&sclient=img&ei=xWV8YPOBAYnbrAHq2a2IBg&bih=721&biw=935";
                 // System.out.println(url);

//               Document doc = Jsoup.connect(url).get();
//              //Element x = doc.select("a.");//.absUrl("src");
//               //System.out.println(doc.select("a.VFACy").first().attr("href"));
//               String imdb_url = doc.select("a.VFACy").first().attr("href");
//               doc = Jsoup.connect(imdb_url).get();
               //System.out.println(doc.select("div.poster").select("img").attr("src"));
               System.out.println("Downloaded!");
              // url = doc.select("div.poster").select("img").attr("src");
               res = new URL(url);
               //               imdb part
           } catch (Exception ex) {
               System.out.println(ex);
           }
        return res;
    }
}
