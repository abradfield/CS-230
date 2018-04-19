import java.util.Random;
import java.util.Scanner;

public class BST_Driver {

    public static void main(String[] args) {

        Random rand = new Random();
        Scanner keyboard = new Scanner( System.in);
        int value, treeHeight, treeNodeCount, treeLeafNodeCount;
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        int values [] = {36, 98, 66, 14, 43, 30, 55, 10, 47, 104, 94, 92, 58, 90, 17, 100, 81, 32, 31, 87};
        // int values [] = {10, 14, 17, 30, 31, 32, 36, 43, 47, 55, 58, 66, 81, 87, 90, 92, 94, 98, 100, 104};
        // int values [] = {104, 100, 98, 94, 92, 90, 87, 81, 66, 58, 55, 47, 43, 36, 32, 31, 30, 17, 14, 10};
		/*
		for( int count = 1 ; count <= 20 ; count++) {
				value = 10 + rand.nextInt( 100);
				System.out.print( value + "  ");
				tree.insert( value); */

        for( int count = 0 ; count < 20 ; count++) {
            tree.insert( values[count]);
        }

        System.out.println( "\n");
        System.out.println( "Testing tree traversals methods........................");
        System.out.println( "Preorder traversal:");
        tree.preOrderTraversal();
        System.out.println( "Inorder traversal:");
        tree.inOrderTraversal();
        System.out.println( "Postorder traversal:");
        tree.postOrderTraversal();

        System.out.println( "\n");
        System.out.println( "Testing tree information methods.........................");
        treeNodeCount = tree.getNodeCount();
        System.out.println( "Get node count: " + treeNodeCount);
        treeLeafNodeCount = tree.getLeafNodeCount();
        System.out.println( "Total leaf node count: " + treeLeafNodeCount);
        treeHeight = tree.getTreeHeight();
        System.out.println( "Tree height is: " + treeHeight);

        System.out.println( "\nTesting tree search method.............................");
        for( int i = 1 ; i <= 3 ; i++) {
            System.out.print( "Enter a value to search for: ");
            value = keyboard.nextInt();
            if( tree.searchFor( value))
                System.out.println( "Value " + value + " was located on the tree.");
            else
                System.out.println( "Value " + value + " was not found on the tree.");
        }

        System.out.println( "\nTesting node deletion method...........................");
        for( int i = 1 ; i <= 5 ; i++) {
            System.out.print( "Enter a value to delete: ");
            value = keyboard.nextInt();
            System.out.println( "Attempting to delete " + value + " from the tree.");
            if( tree.searchFor( value)) {
                System.out.println( "Value " + value + " was located on the tree and was deleted.");
                tree.delete( value);
            }
            else
                System.out.println( "Value " + value + " was not found on the tree. Thus, it was not deleted!");
            System.out.println( "Verifying the deletion of value " + value);
            tree.inOrderTraversal();
            tree.preOrderTraversal();
            tree.postOrderTraversal();
        }

        System.out.println( "\nDone.");
        keyboard.close();
        return;
    }
}
