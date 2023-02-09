import java.util.Scanner;

class Node
{
	int val;
	Node left;
	Node right;
	
	Node(int val)
	{
		this.val = val;
		this.left = null;
		this.right = null;
	}
	
	public Node copy()
	{
		return this;
	}
}

class PrintTree
{
	public static void main(String args[])
	{
		PrintTree pp = new PrintTree();
		
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int[] arr = new int[size];

		for(int i = 0 ; i < size ; i++) arr[i] = s.nextInt();
		s.close();
		
		Node node = pp.insertLevelOrder(arr, 0);
		
		pp.preOrder(node.copy());
		System.out.println();
		
		pp.inOrder(node.copy());
		System.out.println();
		
		pp.postOrder(node.copy());
	}
	
	public Node insertLevelOrder(int[] arr, int pos)
	{
		if(pos >= arr.length) return null;
		Node node = new Node(arr[pos]);
		node.left = insertLevelOrder(arr, 2 * pos + 1);
		node.right = insertLevelOrder(arr, 2 * pos + 2);

		return node;
	}
	
	public void preOrder(Node node)
	{
		if(node == null) return;
		
		System.out.print(node.val + " ");
		printPreOrder(node.left);
		printPreOrder(node.right);
	}
	
	public void inOrder(Node node)
	{
		if(node == null) return;
		
		printInOrder(node.left);
		System.out.print(node.val + " ");
		printInOrder(node.right);
	}
	
	public void postOrder(Node node)
	{
		if(node == null) return;
		
		printPostOrder(node.left);
		printPostOrder(node.right);
		System.out.print(node.val + " ");
	}
}