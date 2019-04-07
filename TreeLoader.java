/**
 * Load a tree from a text file.  Format is line based, with each line
 * consisting of a String for data, followed by two ints indicating if
 * the node has a left child or right child.  (1 is yes, 0 is no).
 * Ordering of nodes is postorder.
 *
 * @author John Donaldson
 * @author Benjamin Kuperman (Spring 2007)
 * @author Alexa Sharp (Fall 2012)
 */

import java.io.*;
import java.util.*;
//import java.nio.file.*;

public class TreeLoader {

    public BinaryTree<String> loadTreeFromFile(String fname) throws IOException
    {
        // TODO: See Part 2
            Stack<BinaryTree<String>> stringTrees = new Stack<BinaryTree<String>>();
            Scanner s = new Scanner(new File(fname));
            String data;
            String existsLeft;
            String existsRight;
            BinaryTree<String> left;
            BinaryTree<String> right;
            BinaryTree<String> tree;
            while(s.hasNext()) {
                data = s.next();
                existsLeft = s.next();
                existsRight = s.next();
                if(existsRight.equals("1")) {
                	right = stringTrees.pop();
                } else {
                	right = new EmptyTree<String>();
                }
                if(existsLeft.equals("1")) {
                	left = stringTrees.pop();
                } else {
                	left = new EmptyTree<String>();
                }
                tree = new ConsTree<String>(data, left, right);
                //tree = (BinaryTree<String>)h;
                stringTrees.push(tree);
                

            }
            //tree = new ConsTree(data, stringTrees.pop(), stringTrees.pop());
                return stringTrees.pop();
    }

    // So you can test your tree loader
    public static void main(String args[]) throws IOException {
        if(args.length!=1){
            System.out.println("Usage:  java TreeLoader filename");
        }
        else {
            TreeLoader tl = new TreeLoader();
            BinaryTree<String> t = tl.loadTreeFromFile(args[0]);
            System.out.println(t);
        }
    }
}