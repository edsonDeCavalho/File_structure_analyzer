package brain;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map.Entry;
import analyse.File_Analyser;
import utils.Result_Of_Analyse;

/**
 * Cette methode permet de Traiter et lancer 
 *  une analyse de un fichier ou repertire.
 *  
 *  @author Edson De Carvalho
 *  @author Julien De Puertas
 *  @version 12.0
 */
public class Tretement {
	private HashMap<String,Result_Of_Analyse> Result_Normal;
	private HashMap<String,Result_Of_Analyse> Result_Fast;
	private HashMap<String,Result_Of_Analyse> stocke;
	private File_Analyser FA;	
	/**
	 * Constructeur
	 * 
	 * @throws IOException
	 * @throws URISyntaxException 
	 */
	
	public Tretement() throws IOException, URISyntaxException {
		Result_Normal=new HashMap<String,Result_Of_Analyse>();
		Result_Fast=new HashMap<String,Result_Of_Analyse>();
		FA=new File_Analyser();
		stocke=new HashMap<String,Result_Of_Analyse>();
	}
	
	/**
	 * Cette methode permet de lancer une analyse 
	 * rapide et retourne un HashMap avec des objets 
	 * Analyse
	 * 
	 * @param file
	 * @return Result_Fast
	 * @throws IOException
	 */
	
	public HashMap<String,Result_Of_Analyse> Fast_Tretement(File file) throws IOException{
		Sub_Fast_Tretement(file);
		return Result_Fast;
	}
	/**
	 * Cette methode permet de parcourir un 
	 * reprtoire et lacer des analyses simultainiement
	 * en les stockent sur une HashMap de objets Resultat.
	 * 
	 * @param file
	 * @throws IOException
	 */
	public void Sub_Fast_Tretement(File file) throws IOException {
		
		if(file.isDirectory()) {
			File[] listFiles=file.listFiles();
			for(int i=0;i<listFiles.length;i++) {
				Sub_Normal_Tretement(listFiles[i]);
			}
		}
		else {
			if(!Storage_Check(file)) {
				Result_Of_Analyse b=stocke.get(file.getName());
				Result_Fast.put(b.getName_Of_File(), b);
			}
			else {
				Result_Of_Analyse a=FA.Analyse(file);
				stocke.put(file.getName(), a);
				Result_Fast.put(a.getName_Of_File(), a);
			}
		}
	}
	
	/**
	 * Cette methode permet de lancer une analyse 
	 * rapide et retourne un HashMap avec des objets 
	 * Analyse
	 * 
	 * @param file
	 * @return Result_Fast
	 * @throws IOException
	 */
		
	public HashMap<String,Result_Of_Analyse> Normal_Tretement(File file){
		Sub_Normal_Tretement(file);
		return Result_Normal;
	}
	public void Sub_Normal_Tretement(File file){
		
		if(file.isDirectory()) {
			File[] listFiles=file.listFiles();
			for(int i=0;i<listFiles.length;i++) {
				Sub_Normal_Tretement(listFiles[i]);
			}
		}
		else {
			Result_Of_Analyse a=FA.Analyse(file);
			stocke.put(file.getName(), a);
			Result_Normal.put(a.getName_Of_File(), a);
			
		}
	}
	/**
	 * Cette methode permet de parcourir un 
	 * reprtoire et lacer des analyses simultainiement
	 * en les stockent sur une HashMap de objets Resultat.
	 * 
	 * @param file
	 * @throws IOException
	 */
	
	public Boolean Storage_Check(File file) {
		
		java.util.Iterator<Entry<String, Result_Of_Analyse>> itr = stocke.entrySet().iterator(); 
        
        while(itr.hasNext()) 
        { 
        	Notation notation =itr.next().getValue();
            if(itr.next().getValue(){
           	 return true;
            }
            else {
           	 return false;
            }
             
        }
		return null;
		
	}

	public HashMap<String, Result_Of_Analyse> getResult_Normal() {
		return Result_Normal;
	}

	public void setResult_Normal(HashMap<String, Result_Of_Analyse> result_Normal) {
		Result_Normal = result_Normal;
	}

	public HashMap<String, Result_Of_Analyse> getResult_Fast() {
		return Result_Fast;
	}

	public void setResult_Fast(HashMap<String, Result_Of_Analyse> result_Fast) {
		Result_Fast = result_Fast;
	}

	public File_Analyser getFA() {
		return FA;
	}

	public void setFA(File_Analyser fA) {
		FA = fA;
	}


	
}