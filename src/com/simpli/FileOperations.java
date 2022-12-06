package com.simpli;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
public class FileOperations
{
	public static boolean CreateFile(String path)
	{
		File sampleFile=new File(path);
		boolean isCreated = false;
		try
		{
			isCreated= sampleFile.createNewFile();
		}
		catch (Exception e)
		{
				System.out.println("we could not find the path ");
		}
		return isCreated;
	}
	
	 public static ArrayList<String> readFileInList(String fileName) 
	  { 
	    ArrayList<String> lines =new ArrayList<String>(); 
	    //String file = "src/file.txt";
        //Path path = Paths.get(file);
        BufferedReader bufferedReader=null;
        try 
        {
        FileReader fr=new FileReader(new File(fileName));
       
        bufferedReader = new BufferedReader(fr);

        String curLine=null;
        //System.out.println(curLine);
        while ((curLine=bufferedReader.readLine()) !=null)
        {
        	//System.out.println("data exists");
        	lines.add(curLine);
            //System.out.println(curLine);
        }
        }
        catch (Exception e) 
        {
        	//bufferedReader.close();
		}
        
        return lines;
	  } 
	   
	

	
	  public static void appendStrToFile(String fileName,String str)
	  {
		  // Try block to check for exceptions
		  try {

			  // Open given file in append mode by creating an
			  // object of BufferedWriter class
			  BufferedWriter out = new BufferedWriter(new FileWriter(fileName, true));

			  // Writing on output stream
			  out.write(str);
			  // Closing the connection
			  out.close();
		  }

		  // Catch block to handle the exceptions
		  catch (IOException e) {

			  // Display message when exception occurs
			  System.out.println("exception occurred" + e);
		  }
	  }


    public static void main(String[] args) throws IOException 
    {
    	String filePath="src/";
    	String filename=null;
    	Scanner data=new Scanner(System.in);    	
    	boolean isCreated=false;
    	int choice=0;
    	ArrayList<String> fileLines=null;
    	System.out.println("Enter"+"\n"+"1 to CreateFile"+"\n"+"2 to WriteToFile"+"\n"+"3 to ReadFile"+"\n");
    	if(data.hasNextInt())
    	{
    		choice=data.nextInt();
    	}
    	else
    	{
    	System.out.println("This choice is not proper choice");    	
    	}
    	while(choice<=3)
    	{
    		switch (choice)
    		{
				case 1: 
				{
				   	System.out.println("Enter file name you want to create");
			    	filename=data.nextLine();
			    	if(!filename.contains(".txt"))
			    	filename=filename+".txt";
			    	//Path p=Paths.get(filePath, filename);
			    	System.out.println(filename);
			    	isCreated= FileOperations.CreateFile(filename);
			    	if(isCreated)
			    		System.out.println("file created");
			    	else
			    		System.out.println("file already exists");
			    	break;
					
				}
				case 2:
				{
					String newContent=null;
					System.out.println("Enter the file name");
			    	filename=data.next();
			    	
			    	filename=filename+".txt";
					System.out.println("Enter data you want to add to the file");
			    	if(data.hasNext())
					newContent=data.next();			    	
			    	
			    	FileOperations.appendStrToFile(filename, newContent+"\n");
			    	break;					
				}
				case 3:
				{
					System.out.println("Enter the file name");
			    	filename=data.next();
			    	if(!filename.contains(".txt"))
			    		filename=filename+".txt";
					fileLines= FileOperations.readFileInList(filename);
			    	if(!fileLines.isEmpty()) 
			    	{
						System.out.println("the file has :");
				    	for (String line : fileLines)
				    	{					
				    		System.out.println(line);
				    	}
			    	}
			    	else
			    		System.out.println("The file has no data");
			    	break;
				}
				default:
					System.out.println("This is not valid choice");
					
			}
    		System.out.println("Do you want perform another operation: press '1' to continue");
    		//String cont=data.next();
    		if(data.hasNextInt())
    		{
    			if(data.nextInt()==1)
    			{
    				System.out.println("Enter"+"\n"+"1 to CreateFile"+"\n"+"2 to WriteToFile"+"\n"+"3 to ReadFile"+"\n");
	    	    	if(data.hasNextInt())
	    	    	{
	    	    		choice=data.nextInt();
	    	    		continue;
	    	    	}
	    	    	else
	    	    	{
	    	    	System.out.println("This choice is not proper choice");    	
	    	    	}
	    				
    			}
    			else
    				System.out.println("Closing the app");
    				System.exit(0);
    			
    			    			
    		}
    		else
    		{
    			break;
    		}
    			
    	}
    	
    	
    	   }
}
