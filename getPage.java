import java.net.*;
import java.io.*;
import java.util.*;

/**
 * Created by Daniel on 9/17/2017.
 */
public class getPage {

    private static void printWebPage(URLConnection u)
            throws IOException
    {
        DataInputStream in = new
                DataInputStream(u.getInputStream());

        try {
            File desktop = new File(System.getProperty("user.home"), "Desktop");

            File file = new File(desktop +"\\outputHtml.txt");
	            /*If file gets created then the createNewFile()
	             * method would return true or if the file is
	             * already present it would return false
	             */
            boolean fvar = file.createNewFile();
            if (fvar){
                System.out.println("File has been created successfully");
            }
            else{
                System.out.println("File already present at the specified location");
            }

            String text;
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            while ((text = in.readLine()) != null)
            {
                writer.write("  " + text + "\n");
            }
        }catch (IOException e) {
            System.out.println("Exception Occurred:");
            e.printStackTrace();
        }


    }
    // Create a URL from the specified address, open a
    // connection to it,
    // and then display information about the URL.

    public static void main(String args[])
            throws MalformedURLException, IOException
    {

        URL url = new URL("http://auburn.edu/"); //args[0]
        URLConnection connection = url.openConnection();
        printWebPage(connection);
    }
}



