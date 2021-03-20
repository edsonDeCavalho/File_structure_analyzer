package analyse;
import utils.Result_Image;
import utils.Result_Of_Analyse;
import utils.Result_RAR_Files;
import utils.Result_Whit_Signature;

import java.net.FileNameMap;
import java.net.URISyntaxException;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.imageio.ImageIO;
import tools.CSV_file_extract;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/**
 * Cette classe extrait les informations 
 * sur les signatures de un fichier CSV
 * 
 * @author Edson De Carvalho
 * @version 1
 *
 */

public class File_Analyser {


	private ArrayList<ArrayList<String> > CSV;
	private CSV_file_extract ExtractCSV; 
	
	public File_Analyser() throws IOException, URISyntaxException {
		ExtractCSV=new CSV_file_extract();
		CSV=new ArrayList<ArrayList<String> >();
		CSV=ExtractCSV.Csv_Stractor();
		
	}
	/**
	 * Cette prend comme paramettre un fichier; elle
	 * fette appele a plusieurs methodes pour pouvoir
	 * analyser le fichier en fonction de ça extention
	 * 
	 * @param file
	 * @return R
	 */
	
	public Result_Of_Analyse Analyse(File file) {
		
		
		switch(getExtention(file)) {
		
			case".html" :
				Result_Whit_Signature RHTML=new Result_Whit_Signature();
	
				RHTML.setName_Of_File(file.getName());
				if(verificationMymeType(file)) {
	
					RHTML.setResult_mymeType(" MYME TYPE VALIDE ");
				}
				else {
					RHTML.setResult_mymeType(" MYME TYPE PAS VALIDE ");
				}
				if(verification2EstVideFile(file)) {
					RHTML.setResult_itsEmpty(" FICHIER PAS VIDE ");
				}
				else {
					RHTML.setResult_itsEmpty(" FICHIER VIDE  ");
				}
				if(verificationSignature(file)) {
					RHTML.setResult_Signature("SIGNATURE VALIDE");
				}
				else {
					RHTML.setResult_Signature("SIGNATURE PAS VALIDE");
				}
				if(verificationMymeType(file) && verification2EstVideFile(file) && verificationSignature(file)) {
					RHTML.setResult_Total("LA VERIFICATION DU FICHIER "+file.getName()+" EST VALIDE  ");
				}
				else {
					RHTML.setResult_Total("LA VERIFICATION DU FICHIER "+file.getName()+" NE EST PAS VALIDE  ");
				}
				return RHTML;
			
		   case".txt" :
				Result_Of_Analyse RTEXT=new Result_Of_Analyse();
				
				RTEXT.setName_Of_File(file.getName());	
				
				if(verificationMymeType(file)) {
					RTEXT.setResult_mymeType(" MYME TYPE VALIDE ");
				}
				else {
					RTEXT.setResult_mymeType(" MYME TYPE PAS VALIDE ");
				}
				if(verification2EstVideFile(file)) {
					RTEXT.setResult_itsEmpty(" FICHIER PAS VIDE ");
				}
				else {
					RTEXT.setResult_itsEmpty(" FICHIER VIDE  ");
				}
				if(verificationMymeType(file) && verification2EstVideFile(file)) {
					RTEXT.setResult_Total("LA VERIFICATION DU FICHIER "+file.getName()+" EST VALIDE  ");
				}
				else {
					RTEXT.setResult_Total("LA VERIFICATION DU FICHIER "+file.getName()+" NE EST PAS VALIDE  ");
				}
				return RTEXT;
			case".jpeg" :	
				Result_Image RJPGE=new Result_Image();
				
				if(verification2EstVideFile(file)) {
					RJPGE.setResult_itsEmpty(" FICHIER PAS VIDE");
				}
				else {
					RJPGE.setResult_itsEmpty(" FICHIER VIDE");
				}
				RJPGE.setName_Of_File(file.getName());
				
				if(verificationMymeType(file)) {
					RJPGE.setResult_mymeType("MYME TYPE VALIDE ");
				}
				else {
					RJPGE.setResult_mymeType("MYME TYPE PAS VALIDE");
				}
				if(verificationImage(file)) {
					RJPGE.setResilt_its_Image(" DIMENSIONS DE L'IMAGE VALIDE");
				}
				else {
						RJPGE.setResilt_its_Image(" DIMENSIONS DE L'IMAGE PAS VALIDE");
				}
				if(verificationMymeType(file) && verificationImage(file)) {
					RJPGE.setResult_Total("LA VERIFICATION DU FICHIER "+file.getName()+" EST VALIDE ");
				}
				else {
					RJPGE.setResult_Total("LA VERIFICATION DU FICHIER "+file.getName()+" NE EST PAS VALIDE ");
				}
				return RJPGE;
				
			case".png" :
				Result_Image RPNG=new Result_Image();
				
				RPNG.setName_Of_File(file.getName());
				if(verification2EstVideFile(file)) {
					RPNG.setResult_itsEmpty(" FICHIER PAS VIDE");
				}
				else {
					RPNG.setResult_itsEmpty(" FICHIER VIDE");
				}
				if(verificationMymeType(file)) {
					RPNG.setResult_mymeType(" MYME TYPE VALIDE ");
				}
				else {
					RPNG.setResult_mymeType(" MYME TYPE PAS VALIDE");
				}
				if(verificationImage(file)) {
					RPNG.setResilt_its_Image(" DIMENSIONS DE L'IMAGE VALIDE");
				}
				else {
					RPNG.setResilt_its_Image(" DIMENSIONS DE L'IMAGE PAS VALIDE");
				}
				if(verificationMymeType(file) && verificationImage(file)) {
					RPNG.setResult_Total("LA VERIFICATION DU FICHIER "+file.getName()+" EST VALIDE  ");
				}
				else {
					RPNG.setResult_Total("LA VERIFICATION DU FICHIER "+file.getName()+" NE EST PAS VALIDE ");
				}
				return RPNG;
			
			case".jpg" :
				Result_Image RJPG=new Result_Image();
				
				RJPG.setName_Of_File(file.getName());
				if(verification2EstVideFile(file)) {
					RJPG.setResult_itsEmpty(" FICHIER PAS VIDE");
				}
				else {
					RJPG.setResult_itsEmpty(" FICHIER VIDE");
				}
				if(verificationMymeType(file)) {
					RJPG.setResult_mymeType(" MYME TYPE VALIDE ");
				}
				else {
					RJPG.setResult_mymeType(" MYME TYPE PAS VALIDE");
				}
				if(verificationImage(file)) {
					RJPG.setResilt_its_Image(" DIMENSIONS DE L'IMAGE VALIDE");
				}
				else {
					RJPG.setResilt_its_Image(" DIMENSIONS DE L'IMAGE PAS VALIDE");
				}
				if(verificationMymeType(file) && verificationImage(file)) {
					RJPG.setResult_Total("LA VERIFICATION DU FICHIER "+file.getName()+" EST VALIDE ");
				}
				else {
					RJPG.setResult_Total("LA VERIFICATION DU FICHIER "+file.getName()+" NE EST PAS VALIDE ");
				}
				return RJPG;
				
			case".gif" :
				Result_Image RGIF=new Result_Image();
				
				RGIF.setName_Of_File(file.getName());
				
				if(verification2EstVideFile(file)) {
					RGIF.setResult_itsEmpty(" FICHIER PAS VIDE");
				}
				else {
					RGIF.setResult_itsEmpty(" FICHIER VIDE");
				}
				if(verificationMymeType(file)) {
					RGIF.setResult_mymeType(" MYME TYPE VALIDE ");
				}
				else {
					RGIF.setResult_mymeType(" MYME TYPE PAS VALIDE");
				}
				if(verificationImage(file)) {
					RGIF.setResilt_its_Image(" DIMENSIONS DE L'IMAGE VALIDE");
				}
				else {
					RGIF.setResilt_its_Image(" DIMENSIONS DE L'IMAGE PAS VALIDE");
				}
				if(verificationMymeType(file) && verificationImage(file)) {
					RGIF.setResult_Total("LA VERIFICATION DU FICHIER "+file.getName()+" EST VALIDE ");
				}
				else {
					RGIF.setResult_Total("LA VERIFICATION DU FICHIER "+file.getName()+" NE EST PAS VALIDE ");
				}
				return RGIF;
				
			case".pdf" :
				Result_Of_Analyse RPDF=new Result_Of_Analyse();
				RPDF.setName_Of_File(file.getName());	
				if(verificationMymeType(file)) {
					RPDF.setResult_mymeType(" MYME TYPE VALIDE ");
				}
				else {
					RPDF.setResult_mymeType(" MYME TYPE PAS VALIDE");
				}
				if(verification2EstVideFile(file)) {
					RPDF.setResult_itsEmpty(" FICHIER PAS VIDE");
				}
				else {
					RPDF.setResult_itsEmpty(" FICHIER VIDE");
				}
				if(verificationMymeType(file) && verification2EstVideFile(file)) {
					RPDF.setResult_Total("LA VERIFICATION DU FICHIER "+file.getName()+" EST VALIDE  ");
				}
				else {
					RPDF.setResult_Total("LA VERIFICATION DU FICHIER "+file.getName()+" NE EST PAS VALIDE  ");
				}
				return RPDF;
			
			case ".docx":
				Result_RAR_Files RDOCX=new Result_RAR_Files();
				RDOCX.setName_Of_File(file.getName());	
				
				if(verificationMymeType(file)) {
					RDOCX.setResult_mymeType(" MYME TYPE VALIDE ");
				}
				else {
					RDOCX.setResult_mymeType(" MYME TYPE PAS VALIDE");
				}
				if(verification2EstVideFile(file)) {
					RDOCX.setResult_itsEmpty(" FICHIER PAS VIDE");
				}
				else {
					RDOCX.setResult_itsEmpty(" FICHIER VIDE");
				}
				if(verificationZip(file)) {
					RDOCX.setIts_Type_RAR(" EST BIEN UN FICHIER ZIP");
				}
				else {
					RDOCX.setIts_Type_RAR(" NE EST BIEN UN FICHIER ZIP");
				}
				if(verificationMymeType(file) && verification2EstVideFile(file) && verificationZip(file)) {
					RDOCX.setResult_Total("LA VERIFICATION DU FICHIER "+file.getName()+" EST VALIDE  ");
				}
				else {
					RDOCX.setResult_Total("LA VERIFICATION DU FICHIER "+file.getName()+" NE EST PAS VALIDE ");
				}
				return RDOCX;
				
			case ".doc":
				Result_RAR_Files RDOC=new Result_RAR_Files();
				RDOC.setName_Of_File(file.getName());	
				
				if(verificationMymeType(file)) {
					RDOC.setResult_mymeType(" MYME TYPE VALIDE ");
				}
				else {
					RDOC.setResult_mymeType(" MYME TYPE PAS VALIDE");
				}
				if(verification2EstVideFile(file)) {
					RDOC.setResult_itsEmpty(" FICHIER PAS VIDE");
				}
				else {
					RDOC.setResult_itsEmpty(" FICHIER VIDE");
				}
				if(verificationZip(file)) {
					RDOC.setIts_Type_RAR(" EST BIEN UN FICHIER ZIP");
				}
				else {
					RDOC.setIts_Type_RAR(" NE EST BIEN UN FICHIER ZIP");
				}
				if(verificationMymeType(file) && verification2EstVideFile(file) && verificationZip(file)) {
					RDOC.setResult_Total("LA VERIFICATION DU FICHIER "+file.getName()+" EST VALIDE  ");
				}
				else {
					RDOC.setResult_Total("LA VERIFICATION DU FICHIER "+file.getName()+" NE EST PAS VALIDE  ");
				}
				return RDOC;
				
			case ".sh":
				Result_Whit_Signature RSH=new Result_Whit_Signature();
				RSH.setName_Of_File(file.getName());	
				
				if(verificationMymeType(file)) {
					RSH.setResult_mymeType(" MYME TYPE VALIDE ");
				}
				else {
					RSH.setResult_mymeType(" MYME TYPE PAS VALIDE");
				}
				if(verification2EstVideFile(file)) {
					RSH.setResult_itsEmpty(" FICHIER PAS VIDE");
				}
				else {
					RSH.setResult_itsEmpty(" FICHIER VIDE");
				}
				if(verificationSignature(file)) {
					RSH.setResult_Signature("ANALYSE SIGNATURE CORRENCTE");
				}
				else {
					RSH.setResult_Signature(" ANALYSE SIGNATURE PAS CORRECTE");
				}
				if(verificationMymeType(file) && verification2EstVideFile(file)) {
					RSH.setResult_Total("LA VERIFICATION DU FICHIER "+file.getName()+" EST VALIDE ");
				}
				else {
					RSH.setResult_Total("LA VERIFICATION DU FICHIER "+file.getName()+" NE EST PAS VALIDE ");
				}
				return RSH;
				
			case ".csv":
				Result_Whit_Signature RCSV=new Result_Whit_Signature();
				RCSV.setName_Of_File(file.getName());	
				
				if(verificationMymeType(file)) {
					RCSV.setResult_mymeType(" MYME TYPE VALIDE ");
				}
				else {
					RCSV.setResult_mymeType(" MYME TYPE PAS VALIDE");
				}
				if(verification2EstVideFile(file)) {
					RCSV.setResult_itsEmpty(" FICHIER PAS VIDE");
				}
				else {
					RCSV.setResult_itsEmpty(" FICHIER VIDE");
				}
				if(verificationMymeType(file) && verification2EstVideFile(file)) {
					RCSV.setResult_Total("LA VERIFICATION DU FICHIER "+file.getName()+" EST VALIDE ");
				}
				else {
					RCSV.setResult_Total("LA VERIFICATION DU FICHIER "+file.getName()+" NE EST PAS VALIDE ");
				}
				return RCSV;
			case ".c":
				Result_Whit_Signature RC=new Result_Whit_Signature();
				RC.setName_Of_File(file.getName());	
				
				if(verificationMymeType(file)) {
					RC.setResult_mymeType(" MYME TYPE VALIDE ");
				}
				else {
					RC.setResult_mymeType(" MYME TYPE PAS VALIDE");
				}
				if(verification2EstVideFile(file)) {
					RC.setResult_itsEmpty(" FICHIER PAS VIDE");
				}
				else {
					RC.setResult_itsEmpty(" FICHIER VIDE");
				}
				if(verificationSignature(file)) {
					RC.setResult_Signature("ANALYSE SIGNATURE CORRENCTE");
				}
				else {
					RC.setResult_Signature(" ANALYSE SIGNATURE PAS CORRECTE");
				}
				if(verificationMymeType(file) && verification2EstVideFile(file)) {
					RC.setResult_Total("LA VERIFICATION DU FICHIER "+file.getName()+" EST VALIDE ");
				}
				else {
					RC.setResult_Total("LA VERIFICATION DU FICHIER "+file.getName()+" NE EST PAS VALIDE ");
				}
				return RC;
			
			default:
				Result_Of_Analyse DEFAUT=new Result_Of_Analyse();
				DEFAUT.setName_Of_File(file.getName());
				DEFAUT.setResult_itsEmpty("null");
				DEFAUT.setResult_mymeType("null");
				DEFAUT.setResult_Total("LE FICHIER "+file.getName()+" NE EST PAS REPERTOIRIE");
				return DEFAUT;
				
		}
	}

	/**
	 * Cette methode prende en parametre un fichier 
	 * et retourne son Myme Type.
	 * 
	 * @param file
	 * @return Boolean
	 */
	
	public Boolean verificationSignature(File file) {	
		for(int i=0;i<CSV.size();i++) {	
			if(CSV.get(i).get(2).equals(getSignature(file))) {
				return true;
			}
		}
		
	return false;
	}
	
	/**
	 * Cette methode prend comme parametre un fichier et compare
	 * ça signature(la premier ligne écrit dans le fichier), avec 
	 * la signature typique du type de fichier stocke dans le fi-
	 * chier CSV.
	 * 
	 * @param file
	 * @return Boolean
	 */
	public Boolean verificationMymeType(File file) {	
		for(int i=0;i<CSV.size();i++) {	
			if(CSV.get(i).get(1).equals(getMimetype(file))) {
				return true;
			}
		}
		
	return false;
	}
	/**
	 * Cette methode prende comme parametre un objet
	 * de type File, et esseye de executé une decompression
	 * du fichier en question, si reuci elle renvoit true et 
	 * false sinon.	 
	 * 
	 * @param file
	 * @return Boolean
	 */
	
	@SuppressWarnings("resource")
	public Boolean verificationZip(File file) {
		
		 String FILE_PATH = file.getAbsolutePath();
		 
	        ZipInputStream zipIs = null;
	        try {
	        	
	            zipIs = new ZipInputStream(new FileInputStream(FILE_PATH));
	 
	            ZipEntry entry = null;
	            entry = zipIs.getNextEntry();
	            if(entry != null) {
	            	return true;
	            }
	            else {
	            	return false;
	            }
	 
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	       try {
			zipIs.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return false;       
	}
	
	/**
	 * Cette methode prend comme parametre un fichier et 
	 * verifie ce celuici est une imge, en regardent en particulier
	 * la dimension de le image.
	 * 
	 * @param file
	 * @return boolean
	 */
	
	
	public Boolean verificationImage(File file) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int hauteur =img.getWidth();
		int longueur=img.getHeight();
		
		if((hauteur!=0)&&(longueur!=0)){
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * Cette methode effectue la deuxieme verification que 
	 * conciste a çavoir si un fichier donne est vide 
	 * ou non en ce bazant sur ça taille en bits.
	 * 
	 * @param file
	 * @return Boolean
	 */
	
	public Boolean verification2EstVideFile(File file) {
		if(file.length()!=0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Cette methode prend comme parametre un fichier et 
	 * retourne son exetention
	 *  
	 * @param file
	 * @return String
	 * 
	 */
	public String getExtention(File file) {
		String name = file.getName();
		int lastIndexOf = name.lastIndexOf(".");
		if (lastIndexOf == -1) {
			return ""; // empty extension
		}
	    return name.substring(lastIndexOf);
	}
	
	/**
	 * Cette methode prend comme parametre un fichier
	 * et retourne son Mymetype.
	 * 
	 * @param file
	 * @return String
	 * 
	 */
	
	public String getMimetype(File file) {
	
		FileNameMap fileNameMap = URLConnection.getFileNameMap();
		String mimeType = fileNameMap.getContentTypeFor(file.getName());
		return mimeType;
	}
	
	/**
	 * Cette methode compare la signature du fichie en 
	 * parametre, avec la signatures stockes dans le fichier
	 * csv.
	 *   
	 * @param file
	 * @return Boolean
	 */
	public String getSignature(File file) {
		String Signature = "pas repertoirie";
		
		switch (getExtention(file)) {
			
			case ".sh":
				BufferedReader bf2 = null;
				try {
					bf2 = new BufferedReader(new FileReader(file));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String tmp2 = null;
				try {
					tmp2 = bf2.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					bf2.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String [] words2 = tmp2.split("/");
				
				return words2[0];
			
			case ".c" :
				
				BufferedReader bf = null;
				try {
					bf = new BufferedReader(new FileReader(file));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String tmp = null;
				try {
					tmp = bf.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					bf.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				String [] words = tmp.split("<");
				return words[0];
				
			case ".html" :
				
				BufferedReader bf1 = null;
				try {
					bf1 = new BufferedReader(new FileReader(file));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String tmp1 = null;
				try {
					tmp1 = bf1.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					bf1.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String [] words1 = tmp1.split(">");
				return words1[0];
			
		}
			
		
		return Signature;
	}

	public ArrayList<ArrayList<String>> getCSV() {
		return CSV;
	}

	public void setCSV(ArrayList<ArrayList<String>> cSV) {
		CSV = cSV;
	}

	public CSV_file_extract getExtractCSV() {
		return ExtractCSV;
	}

	public void setExtractCSV(CSV_file_extract extractCSV) {
		ExtractCSV = extractCSV;
	}
	
}
