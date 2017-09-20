/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package webcrawler;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays.asList;

/**
 *
 * @author Owner
 */
public class WebCrawler {

    public static void main(String[] args) {
        int pageNum = 0;
        int maxDepth;
        String startURL;
        Scanner scanner = new Scanner(System. in); 
        System.out.println("Starting URL: ");
        startURL = scanner.nextLine();
        System.out.println("Depth: ");
        maxDepth = Integer.parseInt(scanner.nextLine());
       
        for (int depth = 1; depth <= maxDepth; depth++)
            pageNum = crawl(startURL, depth, pageNum);
        
    }
    

    

    private static int crawl(String URL, int depth, int pageNum) {
        pageNum++;
        String HTML = getPage(URL); // Get HTML code
        processPage(HTML, pageNum); //Create and store the Unigram    
        
        if (depth > 0) {
            String[] links = getLinks(HTML);
            String link;
            for (int i = 0; i < links.length; i++) {
                link = links[i];
                crawl(link, --depth, pageNum);
            }
        }
        return pageNum;
    }
    //Returns HTML string of page
       private static String getPage(String URL_link) throws MalformedURLException, IOException {
                String HTML = "";
            java.net.URL url = new URL(URL_link); //args[0]
            URLConnection connection = url.openConnection();

            try {
                  DataInputStream in = new DataInputStream(connection.getInputStream());
                    String text;
                    while ((text = in.readLine()) != null)
                    {
                       HTML += "  " + text + "\n");
                    }
                }
            catch (IOException e) {
                        System.out.println("Exception Occurred:");
                        e.printStackTrace();
                    }

        return HTML;
    }
    
    //Creates UNI-Gram and store page
    private static void processPage(String HTML, int pageNum) {
        char myChar;
        int indexOf;
        
        int[] uniGram = new int[95];
        for (int pos = 0; pos < HTML.length(); ++pos){
            myChar = HTML.charAt(pos);
            indexOf = (int) myChar;
            if (indexOf >= 32 && indexOf < 127) {
                uniGram[indexOf - 32]++;
            }
        }
       
        try {
            File file = new File("./pages/" + pageNum + ".txt");
            FileWriter writer = new FileWriter(file);
            writer.write(HTML);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            
        }
        
        
    }
    
    
    //Returns String arraylist of all links found in HTML
    private static List<string> getLinks(String HTML) {
        List<string> links = new ArrayList<string>;
        Pattern p = Pattern.compile("href=\"([^\"]*)\"");
        Matcher m = p.matcher(HTML);
        while (m.find()) {
            links.add(m.group(1).substring(m.group(1).indexOf("http://")+7, m.group(1).indexOf("\"", m.group(1).indexOf("http://"))));
        }
        return links;
    }

}
