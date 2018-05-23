package com.bridgelabz.datastructures.programs;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.plaf.synth.SynthSeparatorUI;

import com.bridgelabz.algorithm.impl.OrderedListImpl;
import com.bridgelabz.algorithm.interfaces.OrderedList;
import com.bridgelabz.functionalprogramming.util.Utility;

public class OrderedListMain {

    public static void main(String[] args) {
	// TAKES THE FILE DATA AND ADDS DATA AND STORES THEM BACK
	OrderedList list = new OrderedListImpl();
	String FILE_PATH = "/home/bridgeit/fileHolder/NumberList.txt";// GET FILE PATH

	File file = new File(FILE_PATH);
	FileReader read = null;
	if (!file.exists()) {
	    System.out.println("File resource could not be found Error :404");
	    return;

	}
	try {
	    read = new FileReader(file);
	    int c = -1;

	    StringBuffer sb = new StringBuffer();
	    try {
		while ((c = read.read()) != -1) {

		    sb.append((char) c);

		}
		System.out.println(sb.toString());
		String[] data = sb.toString().split(",");
		System.out.println("Size of the list is : " + list.size());
		Integer[] intData = new Integer[data.length];
		for(int i=0;i<intData.length;i++) {
		    System.out.println(data[i]);
		    intData[i]=Integer.parseInt(data[i].trim());
		    
		}
		

		for (Integer insertData : intData) {
		    Node n = new Node();

		    n.setInfo(insertData);
		    list.add(n);

		}

		System.out.println("Size of the list is after adding: " + list.size());
		System.out.println("Enter the number to be searched");

		String keyData = Utility.getUserStringValue();
		Node n = new Node();
		n.setInfo(keyData);
		System.out.println("File size before deleting is  " + list.size());
		if (list.search(n)) {

		    System.out.println("key found ");
		    System.out.println("deleting.....");

		    list.remove(n);

		    System.out.println("deletion completed .");
		    System.out.println("File size after  deleting is  " + list.size());

		} else {

		    list.add(n);
		    System.out.println("Element is added.");
		}

		file.delete();
		file.createNewFile();

		FileWriter fw = new FileWriter(file);
		StringBuffer listContents = new StringBuffer();
		System.out.println("--------------------");
		for (int i = 0; i < list.size(); i++) {
		    String dataListSingle = (String) list.pop(i).getInfo();
		    System.out.println("data  : " + dataListSingle);
		    listContents.append(dataListSingle + ",");
		    i--;
		}

		fw.write(listContents.reverse().toString().substring(1));
		fw.flush();

		System.out.println("Writing to file completed");

	    }

	    catch (Exception e) {
		System.out.println("cannot do the file read and write operations " + e.getMessage());

		e.printStackTrace();
	    }
	} catch (Exception e) {

	    System.out.println("cannot do the file read and write operations " + e.getMessage());
	    e.printStackTrace();
	}
    }

}

// code used for testing
//
// while (true) {
// System.out.println();
// System.out.println();
// System.out.println("---------------------------------");
// System.out.println();
// System.out.println("1.Create an empty list");
// System.out.println("2.Add element to list");
// System.out.println("3.Remove element from list");
// System.out.println("4.Search element from the list");
// System.out.println("5.Check if the list is empty");
// System.out.println("6.Check the number of elements present in the list");
// System.out.println("7.Add element in the end of the list");
// System.out.println("8.Insert element at the specified position(starts from
// 0)");
// System.out.println("9.Pop element from the list");
// System.out.println("10.Pop specified element from the list by position(starts
// from 0) ");
// System.out.println("11.Get the index of element from the list (Always will
// give the first match)");
// System.out.println("press anything ele to exit");
// int choice = Utility.getIntergerValue();
// Node item = null;
// Node n = null;
// int position = -1;
// switch (choice) {
// case 1:
// list = list.list();
// break;
// case 2:
// System.out.println("Enter the element");
// item = Utility.getNodeValue();
// list.add(item);
// break;
// case 3:
// System.out.println("Enter the element");
// item = Utility.getNodeValue();
// list.remove(item);
// break;
// case 4:
// System.out.println("Enter the element");
// item = Utility.getNodeValue();
// System.out.println("Element found : " + list.search(item));
// break;
// case 5:
// System.out.println("List is empty : " + list.isEmpty());
// break;
// case 6:
// System.out.println("Number of elements in the list : " + list.size());
// break;
// case 7:
// System.out.println("Enter the element");
// item = Utility.getNodeValue();
// // list.append(item);
// break;
// // case 8:
// // System.out.println("ente rthe element whose index is to be found..");
// // item = Utility.getNodeValue();
// // int myIndex = list.index(item);
// // System.out.println("Element forund at index " + myIndex);
//
// case 9:
// if ((n = list.pop()) != null) {
//
// System.out.println("Element is : " + n.getInfo());
//
// break;
// }
// System.out.println("List is empty");
// break;
// case 10:
// System.out.println("Enter the posiiton (0....n)");
// position = Utility.getIntergerValue();
// if ((n = list.pop(position)) != null) {
//
// System.out.println("Element is : " + n.getInfo());
//
// break;
// }
// break;
// case 11:
// System.out.println("Enter the element");
// item = Utility.getNodeValue();
// int index = list.index(item);
// String result = (index != -1) ? "The element is at : " + index : "Element not
// found";
// System.out.println(result);
// break;
// default:
//
// System.out.println("Exiting the menu.....");
// System.exit(1);
//
// }
//
// }
