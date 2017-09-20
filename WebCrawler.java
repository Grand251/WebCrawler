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

/**
 *
 * @author Owner
 */
public class WebCrawler {

    public static void main(String[] args) {
        int pageNum = 0;
        int maxDepth;
        String startURL;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Starting URL: ");
        startURL = scanner.nextLine();
        System.out.println("Depth: ");
        maxDepth = Integer.parseInt(scanner.nextLine());

        for (int depth = 1; depth <= maxDepth; depth++) {
            pageNum = crawl(startURL, depth, pageNum);
        }

    }

    public static int crawl(String URL, int depth, int pageNum) {

        try {
            String HTML = getPage(URL); // Get HTML code. Throws Exception if URL not valid

            pageNum++; //Increment pageNum if exception not thrown
            processPage(HTML, pageNum); //Create Unigram and Store HTML

            if (depth > 0) {
                String[] links = getLinks(HTML);
                String link;
                for (int i = 0; i < links.length; i++) {
                    link = links[i];
                    crawl(link, --depth, pageNum);
                }
            }
        } catch (MalformedURLException e) {
            System.out.println("Malformed URL.");
        } catch (IOException e) {
            System.out.println("HTML could not be retrieved.");
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

        try {
            File file = new File("./pages/" + pageNum + ".txt");
            FileWriter writer = new FileWriter(file);
            writer.write(HTML);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("File could not be written.");
        }

    }

    //Returns String array of all links found in HTML
    public static String[] getLinks(String HTML) {
        String[] links = {"href=\"auburn.edu\""};
        Pattern p = Pattern.compile("href=\"([^\"]*)\"");
        Matcher m = p.matcher(HTML);
        int magnitude = 0;
        while (m.find()) {
            m.group(1);
            links[magnitude] = m.group(1);
            magnitude++;
        }
        return links;
    }

}
