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
    
    treeFromSeed mainTree = new treeFromSeed;
    
    private static void crawl(String URL, int depth) {
        if (depth <=0 && !mainTree.contains(URL)){     // Check that the base recursive case is present and add leaves to tree with no metadata
            mainTree.intake(URL);
        }
        if (depth > 0) {
            String HTML = getPage(URL); // Get HTML code
            char[] thisUnigraham = processPage(HTML);
            mainTREE.intake(URL,HTML,thisUnigraham);
            String[] links = getLinks(HTML);
            String link;
            for (int i = 0; i < links.length; i++) {
                link = links[i];
                if (!treeFromSeed.Contains(URL)){       // if the tree already holds this URL somewhere, Don't expand it. 
                    crawl(link, --depth);
                }
            }
        }
    }
    //Returns HTML string of page
    private static String getPage(String URL) {
        String HTML = "";
        return HTML;
    }
    
    //Creates and stores UNI-Gram
    private static char[] processPage(String HTML) {
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
        return freqOfChar[];
    }
    
     //returns the index of the same char in the 95 chars we are looking at
    private static int whichChar(char theChar){
        int theIndex = -1;
        // Create table for comparison Loop over all possible ASCII codes up to max.
        int min = 0;
        int max =95;
        char[] compCharArr= new char[95];
        for (int i = min; i < max; i++) {
            char c = (char) i;
            compCharArr[i]=c;
        }
        for (int i = min; i < max; i++) {
            if (compCharArr[i]==theChar) {
                   return i;
             }
        }
        return theIndex;
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

public class treeFromSeed {
    
    TreeNode aTN = new TreeNode;
    //hash aHash = new hash;
    //Hashing is unnecessary since URL's are already unique.
    //Store in array and search array. 
    list<string> haveURL;
    
  
    public static void intake(string URL){
        if (!haveURL.contians(URL)){
            haveURL.add(0,URL);            
        }
        //add url to the tree; overload the paramerters so if HTML is given, add HTML and LINKS to tree element
        //also load all links into a hash to test for repeating links. test first.
    }
    public static void intake(string URL, string HTML, char[] unigraham){
        if (!haveURL.contians(URL)){
            haveURL.add(0,URL);            
        }
        //add url to the tree; overload the paramerters so if HTML is given, add HTML and LINKS to tree element
        //also load all links into a hash to test for repeating links. test first.
    }
    public static bool Contains(URL){
        if (!haveURL.contians(URL)){
            return True;            
        }
        return False;
    }
    
    public static bool printTree(){
        
    }
    public static bool saveTreeToFile(){
        
    }
    
}

public class TreeNode {

    string aURL;
    string HTML;
    char[] aUnigram;
    
    TreeNode parent;
    List<TreeNode> children;

    public TreeNode() {
        this.aURL = URL;
        this.HTML = HTML;
        this.aUnigram = aUnigram;
        this.children = new LinkedList<TreeNode>();
    }
    public TreeNode add(T child) {
        TreeNode childNode = new TreeNode();
        childNode.parent = this;
        this.children.add();
        return childNode;
    }
}
