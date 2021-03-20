package utils;

import java.io.Serializable;

/**
 * Cette herite de la classe Result_Of_Analyze
 * ;cerre a stocker des informations de l' analyse
 * de un fichier type image.
 *
 * @author Edson De Carvalho Pedro
 * @version 2
 *
 */

public class Result_Image extends Result_Of_Analyse implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Result_its_Image;
	/**
	 * Constructeur
	 * 
	 */
	public Result_Image() {
		super();
		this.Result_its_Image="";
	}

	public String getResilt_its_Image() {
		return Result_its_Image;
	}

	public void setResilt_its_Image(String resilt_its_Image) {
		Result_its_Image = resilt_its_Image;
	}

	
	public String toString() {
		return "Le resultat Total du fichier : "+super.getName_Of_File()+" est :"+super.getResult_Total()+"\n"
				+ "\n Le type myme: "+ super.getResult_mymeType()+""
				+ " \n Dimensions de le image " + Result_its_Image 
				+"\n Est vide:"+ super.getResult_itsEmpty();
	}
}	

	
	