package PageObject;

import java.util.ArrayList;

/*
 * Description : A utility class to manage a dynamic ArrayList that supports
 *               multiple data types. Includes methods to add, display, search
 *               (case-insensitive for strings), and clear elements.
 */

public class test {
	
	private static ArrayList<Object> al = new ArrayList<>();
	
//	public void create_list()
//	{
//		 ArrayList<Object> al = new ArrayList<>();
//	}
	
	public static void addItems(Object[] itemsarr)
	{
		for(Object item:itemsarr)
		{
			al.add(item);
		}
	}
	
	public static void clearItems()
	{
		al.clear();
	}
	
	public static void displayList()
	{
		System.out.println("----------DISPLAYING ELEMENTS-----------");
//		for(Object elt:al)
//		{
//			System.out.println(elt);
//		}
		al.forEach(System.out::println);
		
		System.out.println("----------ALL ELEMENTS ARE DISPLAYED-----------");
		
	}
	
	public static boolean searchElt(Object elt)
	{
		boolean flag=false;
		for(Object element:al)
		{
			if (((String)element).equalsIgnoreCase((String)elt)) {
		    flag = true;
		}
		}
		
		return flag;
	}
	
	public static void checkElement(Object element)
	{
		boolean res = searchElt(element);
		if(res)
		{
			System.out.println(element+" is present in the list");
		}
		else
		{
			System.out.println(element+" is not present in the list");
		}
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		//test ref = new test();
		
		Object[] items = {"apple","Mango","bANANA"};
		addItems(items);
		displayList();
		checkElement("BANANA");
		String ab="abc";
		
		

		}

}
