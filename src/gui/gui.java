package gui;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileSystemView;
import brain.Tretement;
import utils.Result_Of_Analyse;
import java.awt.TextArea;
import javax.swing.JLabel;


/**
 * Cette classe est le GUI de notre projet
 * @author Julien De Puertas
 *
 */
public class gui extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JFrame frmFileAnalysateur;
	private JButton btnNewButton;
	private JTextField textField_1;
	private File file;
	private JTextField textField;
	private File filestorage;
	private TextArea textArea;
	/**
	 * Lanceur de la applicatiion.
	 */
	public gui(String nom) {

		initialize(nom);
	}

	/**
	 * Initializateur des contens de la 
	 * interface graphique.
	 * 
	 * @param nom
	 */
	private void initialize(String nom) {
		
		setFrmFileAnalysateur(new JFrame());
		getFrmFileAnalysateur().setTitle(nom);
		getFrmFileAnalysateur().setBackground(Color.ORANGE);
		getFrmFileAnalysateur().setBounds(1000, 1000, 600, 450);
		getFrmFileAnalysateur().setLocationRelativeTo ( null );
		getFrmFileAnalysateur().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnNewButton = new JButton("Close");
		btnNewButton.setBounds(419, 383, 154, 25);
		btnNewButton.addActionListener(new ActionQuitter());
	
		getFrmFileAnalysateur().getContentPane().setLayout(null);
		getFrmFileAnalysateur().getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Normal Analyse");
		btnNewButton_1.setBounds(419, 288, 154, 25);
		btnNewButton_1.addActionListener(new ActionAnalyser());
		getFrmFileAnalysateur().getContentPane().add(btnNewButton_1);
		
		JButton btnChoose = new JButton("Choose");
		btnChoose.setBounds(222, 4, 128, 25);
		btnChoose.addActionListener(new ActionChooser());
		getFrmFileAnalysateur().getContentPane().add(btnChoose);
		
		textField_1 = new JTextField();
		textField_1.setBounds(145, 37, 128, 19);
		textField_1.setColumns(10);
		getFrmFileAnalysateur().getContentPane().add(textField_1);
		
		JButton btnNewButton_2 = new JButton("Choose");
		btnNewButton_2.setBounds(205, 288, 23, 25);
		getFrmFileAnalysateur().getContentPane().add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionChooser3());
		
		
		JTextPane txtpnChoiseAFile = new JTextPane();
		txtpnChoiseAFile.setText("Choose a file to storage \n de the analyse");
		txtpnChoiseAFile.setBounds(0, 197, 154, 36);
		getFrmFileAnalysateur().getContentPane().add(txtpnChoiseAFile);
		
		textField = new JTextField();
		
		textField.setColumns(10);
		textField.setBounds(134, 324, 101, 19);
		getFrmFileAnalysateur().getContentPane().add(textField);
		
		 textArea = new TextArea();
		textArea.setBounds(168, 73, 422, 209);
		getFrmFileAnalysateur().getContentPane().add(textArea);
		
		JButton btnFastAnalyse = new JButton("Fast Analyse");
		btnFastAnalyse.setBounds(419, 335, 154, 25);
		btnFastAnalyse.addActionListener(new ActionAnalyserFast());
		getFrmFileAnalysateur().getContentPane().add(btnFastAnalyse);
		
		JLabel lblChooseYourFile = new JLabel("Choose your file to analyse");
		lblChooseYourFile.setBounds(22, 9, 206, 15);
		frmFileAnalysateur.getContentPane().add(lblChooseYourFile);
		
		JLabel lblSelectedFile = new JLabel("Selected File :");
		lblSelectedFile.setBounds(25, 38, 141, 17);
		frmFileAnalysateur.getContentPane().add(lblSelectedFile);
		
		JLabel lblChooseAFile = new JLabel("Choose a file to storage  :");
		lblChooseAFile.setBounds(12, 292, 189, 15);
		frmFileAnalysateur.getContentPane().add(lblChooseAFile);
		
		JLabel lblSelectedFile_1 = new JLabel("Selected File :");
		lblSelectedFile_1.setBounds(22, 322, 132, 22);
		frmFileAnalysateur.getContentPane().add(lblSelectedFile_1);
		
		Refrechir();
		
				
	 }
	
	/**
	 * Cette prend comme parametre une HashMap de la analyse effectue 
	 * et ecri les informations de la analyse dans un fichier donne.
	 * 
	 * @param t
	 */
	
	public void textSave(HashMap<String,Result_Of_Analyse> t) {
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
	public JFrame getFrmFileAnalysateur() {
		return frmFileAnalysateur;
	}

	public void setFrmFileAnalysateur(JFrame frmFileAnalysateur) {
		this.frmFileAnalysateur = frmFileAnalysateur;
	}
	/**
	 * Cette SubClasse permet de quitter de
	 * GUI
	 * @author morous
	 *
	 */
		

	class ActionQuitter implements ActionListener{
		
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
			
		}
	}
	/**
	 * Cette methode permet de Analyser un fichier
	 * ou un dossier donne atravers le FileChooser.
	 * 
	 * @author Edson De Carvalho
	 *
	 */
	
	class ActionAnalyser implements ActionListener{
		
		public void actionPerformed(ActionEvent arg0) {
			HashMap<String,Result_Of_Analyse> ah1=new HashMap<String,Result_Of_Analyse>();
			Tretement tret1 = null;
			try {
				tret1 = new Tretement();
			} catch (IOException | URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String hola1="";
			ah1=tret1.Normal_Tretement(file);
			 java.util.Iterator<Entry<String, Result_Of_Analyse>> itr = ah1.entrySet().iterator(); 
	          
		        while(itr.hasNext()) 
		        { 
		             Entry<String, Result_Of_Analyse> entry = itr.next(); 
		             hola1+="\n- - - - - - - - - - - \n Files Found\n"+"\n "+entry.getValue()+"+\n"; 
		             
		        }
		        Refrechir();
		        textArea.setText(hola1);
		        textSave(ah1);
		        
		}
			
	}
	/**
	 * Cette methode permet de faire une analyse 
	 * rapide du fichier donne et la affiche.
	 * @author morous
	 *
	 */
	class ActionAnalyserFast implements ActionListener{
		
		public void actionPerformed(ActionEvent arg0) {
			HashMap<String,Result_Of_Analyse> ah=new HashMap<String,Result_Of_Analyse>();
			Tretement tret = null;
			try {
				tret = new Tretement();
			} catch (IOException | URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String hola="";
			try {
				ah=tret.Fast_Tretement(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 java.util.Iterator<Entry<String, Result_Of_Analyse>> itr = ah.entrySet().iterator(); 
	          
		        while(itr.hasNext()) 
		        { 
		             Entry<String, Result_Of_Analyse> entry = itr.next(); 
		             hola+="\n- - - - - - - - - - - \n Files Found\n"+"\n "+entry.getValue().toString()+"+\n"; 
		             
		        }
		        Refrechir();
		        textArea.setText(hola);
		      
		        
			}
		}
	/**
	 * Cette methode permet de choisir un fichier
	 * dans la machine.
	 * @author De Carvaho Pedro
	 *
	 */

	class ActionChooser implements ActionListener{
		
		public void actionPerformed(ActionEvent arg0) {
			
			JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			jfc.setDialogTitle("Multiple file and directory selection:");
			jfc.setMultiSelectionEnabled(true);
			jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			int returnValue = jfc.showOpenDialog(null);
			if (returnValue == JFileChooser.APPROVE_OPTION) {
			    File[]files = jfc.getSelectedFiles();
			    System.out.println("Directories found\n");
			    Arrays.asList(files).forEach(x -> {
			        
			    	file=x.getAbsoluteFile();
			    	if (x.isDirectory()) {
			    		textField_1.setText((x.getName()));
			        }
			 });
			    System.out.println("\n- - - - - - - - - - -  - - - - - - - -  - - - - - - - - \n");
			    System.out.println("Files Found\n");
			    Arrays.asList(files).forEach(x -> {
			        if (x.isFile()) {
			            System.out.println(x.getName());
			        }
			    });
			}
		
		}
	}
		/**
		 * Cette methode permet de choisir un fichier
		 * dans la machine.
		 * @author Edson De Carvalho Pedro
		 *
		 */

		class ActionChooser3 implements ActionListener{
			
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				jfc.setDialogTitle("Multiple file and directory selection:");
				jfc.setMultiSelectionEnabled(true);
				jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				int returnValue = jfc.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
				    File[]files = jfc.getSelectedFiles();
				    System.out.println("Directories found\n");
				    Arrays.asList(files).forEach(x -> {
				        
				    	filestorage=x.getAbsoluteFile();
				    	if (x.isDirectory()) {
				    		textField.setText((x.getName()));
				        }
				 });
				    System.out.println("\n- - - - - - - - - - -\n");
				    System.out.println("Files Found\n");
				    Arrays.asList(files).forEach(x -> {
				        if (x.isFile()) {
				        	textField.setText(x.getName());
				        }
				    });
				}
			}
	}
		public void Refrechir() {
			textArea.setText("");
		}
}