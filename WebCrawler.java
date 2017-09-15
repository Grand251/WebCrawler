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
        String page = getPage(URL); // Get HTML code
        processPage(page); //Create and store the Unigram    
        
        if (depth > 0) {
            String[] links; //= getLinks(page);
            String link;
            for (int i = 0; i < links.length; i++) {
                link = links[i];
                crawl(link, --depth);
            }
        }
    }
    //Returns HTML string of page
    private static String getPage(String URL) {
        String page = "";
        return page;
    }
    
    //Creates and stores UNI-Gram
    private static void processPage(String page) {
        
    }
    //Returns String array of all links found in HTML
    private static String[] getLinks(String page) {
        String[] links;        
        return links;
    }
    
}
