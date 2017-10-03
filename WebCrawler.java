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
import java.net.URL;
import java.net.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Owner
 */
public class WebCrawler {
    
    private static ArrayList<String> pastURLs;
    
    public static void main(String[] args) {
        pastURLs = new ArrayList();
        
        int pageNum = 0;
        int maxDepth;
        File dir = new File("pages");
        if(dir.mkdir()) {
            System.out.println("Pages directory created.");
        }
            
        for (File childFile : dir.listFiles()) {
            childFile.delete();
        
        }
        String startURL;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Starting URL: ");
        startURL = scanner.nextLine();
        pastURLs.add(startURL);
        System.out.println("Depth: ");
        maxDepth = Integer.parseInt(scanner.nextLine());
        
        long startTime = System.currentTimeMillis();
        pageNum = crawl(startURL, maxDepth, pageNum);
        long endTime = System.currentTimeMillis();
        System.out.println("Time took: " + (endTime - startTime) + " milliseconds");
        

    }

    public static int crawl(String URL, int depth, int pageNum) {
        String HTML;
        
        try {
            HTML = getPage(URL); // Get HTML code. Throws Exception if URL not valid

            pageNum++; //Increment pageNum if exception not thrown
            processPage(HTML, pageNum); //Create Unigram and Store HTML

            if (depth > 0) {
                ArrayList<String> links = (ArrayList<String>) getLinks(HTML);
                for (String link : links) {
                    pageNum = crawl(link, depth - 1, pageNum);
                }
            }
        } catch (MalformedURLException e) {
            System.out.println("Malformed URL:\n" + URL);
        } catch (IOException e) {
            System.out.println("HTML could not be retrieved:\n" + URL);
        }

        return pageNum;
    }

    //Returns HTML string of page
    public static String getPage(String URL_link) throws MalformedURLException, IOException {
        String HTML = "";

        java.net.URL url = new URL(URL_link); //args[0]
        URLConnection connection = url.openConnection();
        DataInputStream in = new DataInputStream(connection.getInputStream());
        String text;
        while ((text = in.readLine()) != null) {
            HTML += "  " + text + "\n";
        }

        return HTML;
    }

    //Creates UNI-Gram and store page
    public static void processPage(String HTML, int pageNum) {
        char myChar;
        int indexOf;

        int[] uniGram = new int[95];
        for (int pos = 0; pos < HTML.length(); ++pos) {
            myChar = HTML.charAt(pos);
            indexOf = (int) myChar;
            if (indexOf >= 32 && indexOf < 127) {
                uniGram[indexOf - 32]++;
            }
        }

        String path = ""; //Test
        try {
            
            File file = new File("pages/" + pageNum + ".txt");
            path = file.getAbsolutePath();
            FileWriter writer = new FileWriter(file);
            writer.write(HTML);
            writer.flush();
            writer.close();
            System.out.print("Page: " + pageNum + "  ");
            for ( int i = 0; i < uniGram.length; i ++) {
                System.out.print(" '" + (char)(i + 32) + "'-" + uniGram[i] + " ");
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("File could not be written:\n" + path);
        }

    }

    //Returns String arraylist of all links found in HTML
    private static ArrayList<String> getLinks(String HTML) {
        ArrayList<String> links = new ArrayList();
        Pattern p = Pattern.compile("href=\"([^\"]*)\"");
        Matcher m = p.matcher(HTML);
        String link = "";
        while (m.find() && links.size() < 13) { //Improvement #1
            //System.out.println(m.group());
            
            String href = m.group();
            int firstQuote = href.indexOf("\"");
            href = href.substring(firstQuote + 1);
            href = href.substring(0, href.length() - 1);
            //link = m.group().substring(m.group().indexOf("\"") + 1, m.group().indexOf("\"", m.group().indexOf("\"")) + 1);
            links.add(href);
            
        }
        return links;
    }

}
