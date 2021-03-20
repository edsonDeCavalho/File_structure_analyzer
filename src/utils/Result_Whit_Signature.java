package utils;

import java.io.Serializable;

public class Result_Whit_Signature extends Result_Of_Analyse implements Serializable{

	/**
	 * Cette herite de la classe Result_Of_Analyze
	 * ;cerre a stocker des informations de l' analyse
	 * de un fichier que a bezoin de un analyse de Signature.
	 * 
	 * @author Edson De Carvalho Pedro
	 * @version 2
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Result_Signature;
	/**
	 * Constructeur
	 */
	public Result_Whit_Signature() {
		super();
		Result_Signature="";
	}

	public String getResult_Signature() {
		return Result_Signature;
	}

	public void setResult_Signature(String result_Signature) {
		Result_Signature = result_Signature;
	}

	public String toString() {
		return "Le resultat Total du fichier : "+super.getName_Of_File()+" est :"+super.getResult_Total()+"\n"
				+ "\n Le type myme: "+super.getResult_mymeType()+" "
				+ "\n Est vide : " + super.getResult_itsEmpty()+
				"  \n La Signature: "+Result_Signature ;
	}
	
	
}