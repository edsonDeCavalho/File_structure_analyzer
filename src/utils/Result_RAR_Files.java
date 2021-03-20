package utils;

import java.io.Serializable;
/**
 * Cette herite de la classe Result_Of_Analyze
 * ;cerre a stocker des informations de l' analyse
 * de un fichier type RAR.
 *
 * @author Edson De Carvalho Pedro
 * @version 2
 *
 */

public class Result_RAR_Files extends Result_Of_Analyse implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Its_Type_RAR;
	/**
	 * Constructeur
	 * 
	 */
	public Result_RAR_Files() {
		super();
		Its_Type_RAR="";
	}

	public String getIts_Type_RAR() {
		return Its_Type_RAR;
	}

	public void setIts_Type_RAR(String its_Type_RAR) {
		Its_Type_RAR = its_Type_RAR;
	}

	public String toString() {
		return "Le resultat Total du fichier : "+super.getName_Of_File()+" est :"+super.getResult_Total()+"\n"
				+ "\n Le type myme: "+super.getResult_mymeType()+" "
				+ "\n Est vide : " + super.getResult_itsEmpty()+
				"  \n La Signature: "+Its_Type_RAR ;
	}
}