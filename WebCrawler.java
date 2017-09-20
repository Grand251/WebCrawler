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
    
    //Creates and stores UNI-Gram
    private static void processPage(String HTML) {
        
    }
    //Returns String array of all links found in HTML
    private static String[] getLinks(String HTML) {
        String[] links;        
        return links;
    }
    
}
