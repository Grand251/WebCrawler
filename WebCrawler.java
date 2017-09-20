/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package webcrawler;
import java.util.Scanner;

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
    private static String getPage(String URL) {
        String HTML = "";
        return HTML;
    }
    
    //Creates UNI-Gram and store page
    private static char[] processPage(String HTML, int pageNum) {
        char a_char;
        int indexOf;
        
        int[] freqOfChar95 = new int[95];
        for (int pos = 0; pos < HTML.length(); ++pos){
            a_char = HTML.charAt(pos);
            indexOf = (int) theChar;
            if (indeOf >= 32 && indexOf < 127) {
                freqOfChar[indexOf-32]++;
            }
        }
       
        File desktop = new File(System.getProperty("user.home"), "Desktop");
        File file = new File(desktop + "\\" + pagenum + ".txt");
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
        file.println(HTML);
        return freqOfChar[];
    }
    
    
    //Returns String array of all links found in HTML
    private static String[] getLinks(String HTML) {
        String[] links;
        Pattern p = Pattern.compile("href=\"(.*?)\"");
        Matcher m = p.matcher(HTML);
        magnitude = 0;
        while (m.find()) {
            links[magnitude] = m.group(1);
            magnitude++;
        }
        return links;
    }

}
