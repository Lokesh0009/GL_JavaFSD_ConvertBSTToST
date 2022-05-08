package com.gl.javafsd.convertbsttost;

public class Main {
	
	public Node node;
	static Node headNode = null;
	static Node prevNode = null;
	
	static void bstToSkewed(Node root)
	{
		if(root == null)
		{
			return;
		}
		
		else {
			bstToSkewed(root.left);
		}
		
		Node rightNode = root.right;
		
		if(headNode == null)
		{
			headNode = root;
			root.left = null;
			prevNode = root;
		}
		
		else
		{
			prevNode.right = root;
			root.left = null;
			prevNode = root;
		}
		bstToSkewed(rightNode);
	}
	
	static void traverseRightSkewed(Node root)
    {
        if(root == null)
        {
            return;
        }
        System.out.print(root.val + " ");
        traverseRightSkewed(root.right);   
    }
	
	public static void main(String args[])
	{
		Main tree = new Main();
		tree.node = new Node(50);
	    tree.node.left = new Node(30);
	    tree.node.right = new Node(60);
	    tree.node.left.left = new Node(10);
	    tree.node.right.left = new Node(55);
	    bstToSkewed(tree.node);
		traverseRightSkewed(headNode);
	}

}
