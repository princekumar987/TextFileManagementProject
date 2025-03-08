package FileIo;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class F13_TextFileManagementProject {

	public static void main(String[] args) throws IOException {
		
		
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			
			System.out.println("p1->CreateFile\np2->ShowAllFiles\np3->ShowFileByName\np4->OpenFileByName\n"
					+"p5->DeleteFileByName\np6->Restore\np7->DeleteAll\np8->Exit");
			
			System.out.println("Enter Choice:--");
			int choice=sc.nextInt();
			
			if(choice==8) {
				System.out.println("Thanks for using");
				break;
			}
			
			switch(choice) {
			    case 1:
			    	
			    	String result=createFile();
			    	
			    	System.out.println(result);
			    	
			    	
			    	break;
			    case 2:
			    	
			    	ArrayList<String>a=showAllFiles();
			    	System.out.println();
			    	int i=0;
			    	for(String s:a) {
			    		System.out.println(a.get(i));
			    		i++;
			    	}
			    	System.out.println();
			    	
			    	break;
			     case 3:
			    	
			    	String s=showFileByName();
			    	
			    	System.out.println(s);
			    	
			    	break;
			    case 4:
			    	
			    	openFileByName();
			    	
			    	break;
			    case 5:
			    	
			    	String dfg=deletFileByName();
			    	
			    	System.out.println(dfg);
			    	
			    	break;
			    case 6:
			    	
			    	 String restore=restoreFile();
			    	 
			    	 System.out.println(restore);
			    	break;
			    case 7:
			    	
			    	deleteAll();
			    	break;
			    default:
			    	break;
			}
			
			
		}
		
		

	}

	private static void deleteAll() {
		
		
		String path="C:\\Users\\princ\\OneDrive\\Desktop\\Demo\\ram";
		File file=new File(path);
		
		File[]listfilles=file.listFiles()
;
		
		for(File f:listfilles) {
			f.delete();
		}
		
		System.out.println("file deleetd successfully");
	}

	private static String  restoreFile() throws IOException {
		
		FileReader fr=null;
	    FileWriter fw=null;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter file name for restore");
		
		String filename=sc.next();
		
		String source="C:\\Users\\princ\\OneDrive\\Desktop\\Demo\\Prince"+File.separator+filename;
		String dest="C:\\Users\\princ\\OneDrive\\Desktop\\Demo\\ram"+File.separator+filename;
		
		File file=new File(source);
		
		boolean exists=file.exists();
		
		if(exists) {
			
			//restore logic
			
			fr=new FileReader(source);
			fw=new FileWriter(dest);
			
			int temp=0;
			
			while(true) {
				temp=fr.read();
				if(temp==-1) {
					break;
				}
				fw.write(temp);
			}
		}
		
		fr.close();
		fw.close();
		
		
      //delete code
		
		new File(source).delete();
		
		return "file restored";	
		
		
		
	}

	private static String deletFileByName() {
		
        try {
        	
        	String result =showFileByName();
        	
        	if(result.endsWith(".txt")) {
        		
        		String source="C:\\Users\\princ\\OneDrive\\Desktop\\Demo\\ram"+File.separator+result;
        		backup(result);
        		
        		
        		File file=new File(source);
        		boolean delete=file.delete();
        		
        		
        		if(delete) {
        			return "file deleted successfully";
        		}
        		else {
        			return "something went wrong";
        		}
        	}
        	else {
        		return result;
        	}
        	
        }
        catch(Exception e) {
        	e.printStackTrace();
        	return "something went wrong";
        }
		
		
	}
	
	private static void backup(String result)  {
		
		 FileReader fr=null;
		 FileWriter fw=null;
		 
		try {
			
			 String source ="C:\\Users\\princ\\OneDrive\\Desktop\\Demo\\ram"+File.separator+result;
			 String dest="C:\\Users\\princ\\OneDrive\\Desktop\\Demo\\Prince"+File.separator+result;
			 
			 fr=new FileReader(source);
			 fw=new FileWriter(dest);
			 
			 int temp=0;
			 
			 while(true) {
				 temp=fr.read();
				 if(temp==-1)break;
				 fw.write((char)temp);
			 }
			 
		}
		catch(Exception e) {
			 e.printStackTrace();
		}
		finally {
			if(fr!=null && fw!=null) {
				try {
				  fr.close();
				  fw.close();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static void openFileByName() {
		
		FileReader fr=null;
		
		try {
    		
    		String result1 =showFileByName();
    	
    		
    		if(result1.endsWith(".txt")) {
    			
    			 String path="C:\\Users\\princ\\OneDrive\\Desktop\\Demo\\ram"+File.separator+result1;
    			 
    			 fr=new FileReader(path);
    			 
    			 int temp=0;
    			 
    			 while(true) {
    				 temp=fr.read();
    				 if(temp==-1)break;
    				 System.out.print(temp);
    			 }
    			 
    			 System.out.println();
    			 
    		}
    		else {
    			System.out.println(result1);
    		}
    	}
    	catch(Exception e) {
    		System.out.println("something went wrong");
    		e.printStackTrace();
    	}
		finally {
			try {
				
				if(fr!=null) {
					fr.close();
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	private static String showFileByName() {
		
		
		try {
			
			Scanner sc=new Scanner(System.in);
			
			System.out.println("Enter file name");
			String filename=sc.next();
			
			ArrayList<String>a=showAllFiles();
			
			int index=a.indexOf(filename);
			
			if(index!=-1) {
				String getfile=a.get(index);
				return getfile;
			}
			else {
				return "file not found";
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			return "something went wrong";
		}
		
		
	}

	private static ArrayList<String> showAllFiles() {
    	   
    	   ArrayList<String>list=new ArrayList<>();
           
           String path="C:\\Users\\princ\\OneDrive\\Desktop\\Demo\\ram";
           
           File file=new File(path);
           
           File[]listfiles=file.listFiles();	
           
           for(File e:listfiles) {
           	list.add(e.getName());
           }
           
           return list;
    	   
        
	}

	private static String createFile() throws IOException {
		
		
		try {
			
			Scanner sc=new Scanner(System.in);
			System.out.println("*************(Create File)************");
			
			System.out.println("Enter file name");
			String filename=sc.next();
			
			String path="C:\\Users\\princ\\OneDrive\\Desktop\\Demo\\ram"+File.separator+filename;
			
			File file=new File(path);
			
			boolean df=file.createNewFile();
			
			if(df) {
				return "file successfully created";
			}
			else {
				return "file already exist";
			}
		}
		catch(Exception e) {
			
			e.printStackTrace();
			return "something wrong";
		}
		
		
		
	}

}
