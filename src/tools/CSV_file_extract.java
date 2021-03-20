package tools;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.ArrayList;



/**	
 *Cette classe permet de extraire des informations
 *de un fichier csv.
 *
 * @author EdsonDeCarvalho
 * @version 1.5
 *
 */

public class CSV_file_extract {	
	
	private ArrayList<ArrayList<String> > aList;
	/**
	 * Constructeur
	 * 
	 */
	public CSV_file_extract() {
		aList= new ArrayList<ArrayList<String> >();
		
	}
	/**
	 * Cette methode cert a extraire des informations 
	 * de un fichier csv et les retourneér dans une Array
	 * List de une Arraylist de String.
	 * 
	 * @return aList
	 * @throws IOException
	 * @throws URISyntaxException 
	 */
	public ArrayList<ArrayList<String> >Csv_Stractor( ) throws IOException, URISyntaxException {
		InputStream in = getClass().getClassLoader().getResourceAsStream("fichiercsv.csv"); 
		BufferedReader br = new BufferedReader(new InputStreamReader(in));; 
		String line=null;
		while ((line = br.readLine()) != null) {
			Input_Csv_Information(line);
		}	
        br.close();
        
       return aList;    
	}
	/**
	 * Cette methode est utilizer pour la methode 
	 * CSV_Stractor pour pouvoir mettre dans les informations
	 * recupereés du fichier CSV et les mettre dans la ArrayList
	 * ,elle prend comme paramettre un ligne de String du fichier CSV
	 * 
	 * @param line
	 */
	public void Input_Csv_Information(String line) {
		ArrayList<String> a1=new ArrayList<String>();
		String [] words = line.split(";");
		for(int i=0;i<words.length;i++) {
			a1.add(words[i]);
		}
		aList.add(a1);
	}
	
	public String toString() {
		return "File_analyse [aList=" + aList + "]";
	}
	
	public ArrayList<ArrayList<String>> getaList() {
		return aList;
	}
	public void setaList(ArrayList<ArrayList<String>> aList) {
		this.aList = aList;
	}
	
	   
}