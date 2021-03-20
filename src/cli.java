
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map.Entry;
import brain.Tretement;
import gui.gui;
import utils.Result_Of_Analyse;
/**
 * Cette class est le CLI de notre projet
 * elle permet de lansé une analyse de un
 * fichier ou un dossier.
 * @author Edson De Carvalho Pedro
 * @version 2
 */




public class cli  {

	private static File filestorage;
	
	public cli() {
		
	}

	public static void textSave(HashMap<String,Result_Of_Analyse> t) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(filestorage.getAbsolutePath()));
			java.util.Iterator<Entry<String, Result_Of_Analyse>> itr = t.entrySet().iterator(); 
			while(itr.hasNext()) 
	        { 
	             Entry<String, Result_Of_Analyse> entry = itr.next(); 
	             String hola = "\n- - - - - - - - - - - \n Files Found\n"+"\n "+entry.getValue()+"+\n"; 
	             writer.write(hola);
				 writer.newLine();
	             
	        }		
			writer.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
	/**
	 * Cette methode permet de lancer la analyse de un 
	 * fichier et le engegistre dans un fichier 
	 * selectionneé.
	 * 
	 * @param file
	 * @throws URISyntaxException 
	 * @throws IOException
	 */
	public static void Operation_whith_Storage(File file) throws IOException, URISyntaxException {
		
		Tretement tn=new Tretement();
		HashMap<String,Result_Of_Analyse> ah=new HashMap<String,Result_Of_Analyse>();
		try {
			tn = new Tretement();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String hola="";
		ah=tn.Normal_Tretement(file);
		java.util.Iterator<Entry<String, Result_Of_Analyse>> itr = ah.entrySet().iterator(); 
      
        while(itr.hasNext()) 
        { 
             Entry<String, Result_Of_Analyse> entry = itr.next(); 
             hola+="\n- - - - - - - - - - - \n Files Found\n"+"\n "+entry.getValue()+"+\n"; 
        }
        
        System.out.println(hola);
        textSave(ah);
        
	
		
	}
	/**
	 * Cette methode permet de lancer la analyse de un 
	 * fichier et le engegistre sans un fichier 
	 * selectionneé.
	 * 
	 * @param file
	 * @throws URISyntaxException 
	 */
	
	public static void Operation_whithout_Storage(String file) throws URISyntaxException {
		
		File f2=new File(file);
		HashMap<String,Result_Of_Analyse> ah=new HashMap<String,Result_Of_Analyse>();
		Tretement tret = null;
		try {
			tret = new Tretement();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String hola="";
		ah=tret.Normal_Tretement(f2);
		java.util.Iterator<Entry<String, Result_Of_Analyse>> itr = ah.entrySet().iterator(); 
      
        while(itr.hasNext()) 
        { 
             Entry<String, Result_Of_Analyse> entry = itr.next(); 
             hola+="\n- - - - - - - - - - - \n Files Found\n"+"\n "+entry.getValue()+"+\n"; 
        }
	
	System.out.println(hola);	
	}
	public static void run() {
				try {
					gui window = new gui("GUI");
					window.frmFileAnalysateur.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	
	public static void main(String[] args) throws IOException, URISyntaxException {
		
		if(args[0].equals("-f")) {		
			
			if(args[2].equals("-s")){
				File f1=new File(args[1]);
				filestorage=new File(args[3]);
				Operation_whith_Storage(f1);
			}
			Operation_whithout_Storage(args[1]);
		}
		
		if(args[0].equals("-d")) {
			if(args[2].equals("-s")){
				File f2=new File(args[1]);
				filestorage=new File(args[3]);
				Operation_whith_Storage(f2);
			}
			Operation_whithout_Storage(args[1]);
		}
		
		if(args[0].equals("-h")) {
			
			System.out.println("--------------------------------------------------");
			System.out.println("\n help");
			System.out.println("\n -h to show the help menu");
			System.out.println("\n -f to analyse a single file");
			System.out.println("\n -d to analyse a foldier");
			System.out.println("\n -s to storege the analyse in a especific file \n");
			System.out.println(" -gui to open the GUI \n");
			System.out.println("--------------------------------------------------");
		}
		if(args[0].equals("-gui")) {
			
			run();

		}
			

	}
}