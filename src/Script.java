
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RK
 */
public class Script {
    public static void main(String[] argss){
       Sql s = new Sql();
       try{
            Statement st = s.fetchStatement();
            String q = "select moviename,movie_id from movies";
            ResultSet rs=  st.executeQuery(q);
            //System.out.println(rs);
            String movieid[] = new String[50];
            String movies[] = new String[50];
            int i = 0;
            while(rs.next()){
                try{
                        String movie_name = rs.getString(1);
                        String movie_id = rs.getString(2);
                        movieid[i] = movie_id;
                        movies[i] =movie_name+movie_id+".jpg";
                        System.out.println(movie_name);
                        i++;
                        ImageScraper is = new ImageScraper(movie_name);
                        URL url = is.Get();
                        InputStream in = new BufferedInputStream(url.openStream());
                        ByteArrayOutputStream out = new ByteArrayOutputStream();
                        byte[] buf = new byte[1024];
                        int n = 0;
                        while (-1!=(n=in.read(buf)))
                        {
                            out.write(buf, 0, n);
                        }
                        out.close();
                        in.close();
                        byte[] response = out.toByteArray();
                        FileOutputStream fos = new FileOutputStream("C:/Users/RK/Documents/NetBeansProjects/Movie ticket booking/src/downloads/"+movie_name+movie_id+".jpg");                
                        fos.write(response);
                        fos.close();

                
                    }
                    catch(Exception e){
                        System.out.println("err "+ e);
                    }               
            }
            i = 0;
            while(i < 50){
                try{
                        String dest = "/downloads/"+movies[i];
                        String Insert = "insert into images values('"+movieid[i]+"','"+dest+"');";
                        System.out.println(Insert);
                        int x = st.executeUpdate(Insert);
                        if(x == 1){
                            System.out.println(movieid[i]+" Inserted successfully!");
                        }
                        else{
                            System.out.println(movieid[i]+"not inserted successfully!");
                        } 
                        
                }
                catch(Exception e){
                    System.out.println(e);   
                        }
                i++;
            }
       }
       catch(Exception e){
           System.out.println(e);
       }
    }    
}
