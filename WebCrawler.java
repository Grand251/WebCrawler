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
        int maxDepth;
        String startURL;
        Scanner scanner = new Scanner(System. in); 
        System.out.println("Starting URL: ");
        startURL = scanner.nextLine();
        System.out.println("Depth: ");
        maxDepth = Integer.parseInt(scanner.nextLine());
        
        for (int depth = 1; depth <= maxDepth; depth++)
            crawl(startURL, depth);
        
    }
    
    
    private static void crawl(String URL, int depth) {
        String HTML = getPage(URL); // Get HTML code
        processPage(HTML); //Create and store the Unigram    
        
        if (depth > 0) {
            String[] links = getLinks(HTML);
            String link;
            for (int i = 0; i < links.length; i++) {
                link = links[i];
                crawl(link, --depth);
            }
        }
    }
    //Returns HTML string of page
    private static String getPage(String URL) {
        String HTML = "";
        return HTML;
    }
    
    //Creates and stores UNI-Gram
    private static void processPage(String HTML) {
        char a_char;
        
        int indexOf;
        int[] freqOfChar95 = new int[95];
        for (int pos = 0; pos < str.length(); ++pos){
            a_char = HTML.charAt(pos);
            indexOf = whichChar(a_char);
            if (indeOf != -1) {
                freqOfChar[indexOf]++;
            }
        }
        //DO WE RETURN THE ARRAY OR MAKE A GLOBAL CLASS?? AUTO SAVE?
    }
    //Returns String array of all links found in HTML
    private static String[] getLinks(String HTML) {
        String[] links;
        Pattern p = Pattern.compile("href=\"(.*?)\"");
        Matcher m = p.matcher(HTML);
        String url = null;
        magnitude = 0;
        while (m.find()) {
            links[magnitude] = m.group(1);
            magnitude++;
        }
        return links;
    }
    
    //returns the index of the same char in the 95 chars we are looking at
    private static int whichChar(char theChar){
        int theIndex = -1;
        
        return theIndex;
    }
    
}
