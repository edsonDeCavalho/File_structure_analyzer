package utils;

import java.io.Serializable;

/**
 * Cette  classe Result_Of_Analyze
 * ;cerre a stocker des informations de l' analyse
 * de un fichier.
 *
 * @author Edson De Carvalho Pedro
 * @version 2
 *
 */

	
	public class Result_Of_Analyse implements Serializable {
	
		private static final long serialVersionUID = 1L;
		private String Name_Of_File;
		private String Result_mymeType;
		private String Result_itsEmpty;
		private String Result_Total;
		/**
		 * Constructeur
		 * 
		 */
	
		public Result_Of_Analyse() {
			Result_mymeType="";
			Result_itsEmpty="";
			Result_Total="";
			Name_Of_File="";
		}
		
		public String getName_Of_File() {
			return Name_Of_File;
		}
	
		public void setName_Of_File(String name_Of_File) {
			Name_Of_File = name_Of_File;
		}
		public String getResult_mymeType() {
			return Result_mymeType;
		}
	
		public void setResult_mymeType(String result_mymeType) {
			Result_mymeType = result_mymeType;
		}
	
		public String getResult_itsEmpty() {
			return Result_itsEmpty;
		}
	
		public void setResult_itsEmpty(String result_itsEmpty) {
			Result_itsEmpty = result_itsEmpty;
		}
	
		public String getResult_Total() {
			return Result_Total;
		}
	
		public void setResult_Total(String result_Total) {
			Result_Total = result_Total;
		}
	
		public String toString() {
			return "Le resultat Total du fichier : "+Name_Of_File+" est :"+Result_Total+"\n"
					+ "\n Le type myme: "+Result_mymeType+" \n Est vide : " + Result_itsEmpty ;
		}

	
	
	
	
}