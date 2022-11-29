package view;

//import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.Choice;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JEditorPane;

import java.awt.Point;
import java.awt.Window.Type;
import java.awt.List;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Button;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.ScrollPane;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.TextArea;

import javax.swing.JPanel;

import java.awt.Dialog.ModalExclusionType;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;
import javax.swing.JInternalFrame;
import javax.swing.JTextArea;

import archives.*;
import view.JanelaDoCompilador.btnAbrirListener;
import view.JanelaDoCompilador.btnNovoListener;

import javax.swing.SwingConstants;
import javax.swing.KeyStroke;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JToolBar;
import javax.swing.ImageIcon;
import javax.swing.JScrollBar;

import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class JanelaDoCompilador  extends JFrame{
	
	//Variaveis da classe
	private JFrame frame;
	private JLabel lblArquivo;
	private JLabel lblMensagem;
	private JLabel lblConsole;
	private JButton btnNovo;
	private JButton btnAbrirArquivo;
	private JButton btnCompilador;
	private JButton btnNoturno;
	private JButton btnSalvar;
	private JPanel tela_Codigo;
	private JPanel panel_arvore;
	private JPanel panel_console;
	private JScrollPane scroll_console;
	private JScrollPane scroll_codigo;
	private JScrollPane scroll_arvore;
	private JTextArea txtCodigo;
	private JTextArea txtArvoreSintatica;
	private JTextArea textArea_1 ;
	private JTextArea textConsole;
	private File file;
	private String campoTexto = null;
	private JButton btnSalvarComo;
	private JScrollPane scroll_ContaLinha;
	private JEditorPane txtContaLinha;
	private btnNovoListener btnNovoL; //Listener para os botoes de novo
	private btnAbrirListener btnAbrirL; //Listener para os botoes de Abrir
	private boolean controleArquivo = false; //Variavel que controla o fluxo se pode ou nao compilar
	private int contEnter = 1; //Conta a quantidade de enter
	private boolean noturno=false;
	public Vector<Integer> erros = new Vector<>();

	/**
	 * Create the application.
	 */
	public JanelaDoCompilador() {
		
		//Layout da tela
		this.lookFeel();
		btnAbrirL = new btnAbrirListener();
		 this.getContentPane().setBackground(new Color(240,240,240));
		setBackground(Color.LIGHT_GRAY);
		setTitle("Compilador Churrasco");

		setBounds(0, 0, 1366, 728);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		getContentPane().setLayout(null);
		
		tela_Codigo = new JPanel();
		tela_Codigo.setBounds(54, 75, 890, 313);
		getContentPane().add(tela_Codigo);
		tela_Codigo.setLayout(null);
		
		txtCodigo = new JTextArea();
		txtCodigo.setFont(new Font("Consolas", Font.PLAIN, 15));
		txtCodigo.setToolTipText("<p></p>");
		
		txtCodigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				//Caso o usuario clique com o botao ENTER
				if(arg0.getKeyCode() == 10){
					sb.delete(0, sb.length());
					// Verifica nao esta vazio o txtCodigo
					if(txtCodigo.getText().trim().equals("") != true){
						//Incrementa o contador de linhas
						contEnter++;
						//Chama a funcao que conta as linhas do txtCodigo
						contaLinha(10);
					}
					//Caso esteja vazio
					else{
						txtContaLinha.setText(appendText(""));
						//Incrementa o contador de linhas
						contEnter++;
						//Coloca o numero de linhas
						for(int i =1 ; i < contEnter; i++){
							txtContaLinha.setText(appendText(i + "<br>"));
						}
						txtContaLinha.setText(appendText(contEnter+""));
					}
				}
				//Caso o usuario clique BACKSPACE
				if(arg0.getKeyCode() == 8){
					sb.delete(0, sb.length());
					// Verifica nao esta vazio o txtCodigo
					if(txtCodigo.getText().trim().equals("") != true){
						//Decrementa o contador de linhas
						contEnter--;
						//Chama a funcao que conta as linhas do txtCodigo
						contaLinha(8);
					}
					//Caso esteja vazio
					else{
						txtContaLinha.setText(appendText(""));
						//Incrementa o contador de linhas
						contEnter--;
						//Coloca o numero de linhas
						for(int i =1 ; i < contEnter; i++){
							txtContaLinha.setText(appendText(i + "<br>"));
						}
						txtContaLinha.setText(appendText(contEnter+""));	
						
						//Caso o contador seja < 1
						if(contEnter < 1){
							sb.delete(0, sb.length());
							contEnter =1;
							txtContaLinha.setText(appendText("1"));
						}
					}
				}
				//Caso o usuario clique para BAIXO ou para CIMA
				//A rola o scroll dos dois scrollPane, o do arquivo e o de linha
				if(arg0.getKeyCode() == 38 || arg0.getKeyCode() == 40){
					Point point = scroll_codigo.getViewport().getViewPosition();  
					scroll_ContaLinha.getViewport().setViewPosition(point);
				}
			}
		});
		
		scroll_codigo = new JScrollPane ();		
		scroll_codigo.setBounds(0, 0, 890, 313);
		scroll_codigo.setViewportView(txtCodigo);
		txtCodigo.setBounds(10, 55, 890, 285);
		tela_Codigo.add(scroll_codigo);
		
		panel_arvore = new JPanel();
		panel_arvore.setBounds(987, 75, 353, 313);
		getContentPane().add(panel_arvore);
		panel_arvore.setLayout(null);
		
		scroll_arvore = new JScrollPane();
		scroll_arvore.setBounds(0, 0, 353, 313);
		panel_arvore.add(scroll_arvore);
		
		txtArvoreSintatica = new JTextArea();
		txtArvoreSintatica.setForeground(new Color(255, 128, 0));
		txtArvoreSintatica.setFont(new Font("Arial", Font.BOLD, 15));
		txtArvoreSintatica.setEditable(false);
		scroll_arvore.setViewportView(txtArvoreSintatica);
		
		panel_console = new JPanel();
		panel_console.setBounds(10, 424, 1330, 250);
		getContentPane().add(panel_console);
		panel_console.setLayout(null);
		
		scroll_console = new JScrollPane();
		scroll_console.setBounds(0, 0, 1330, 250);
		panel_console.add(scroll_console);
		
		textConsole = new JTextArea();
		textConsole.setForeground(new Color(255, 0, 0));
		textConsole.setFont(new Font("Consolas", Font.BOLD, 16));
		scroll_console.setViewportView(textConsole);
		textConsole.setEditable(false);
		
		lblArquivo = new JLabel("Código fonte");
		lblArquivo.setBounds(54, 50, 300, 25);
		lblArquivo.setFont((new Font("lblArquivo", Font.BOLD, 18)));
		getContentPane().add(lblArquivo);
		
		lblMensagem = new JLabel("Arvore Sintática");
		lblMensagem.setFont((new Font("Mensagem", Font.BOLD, 18)));
		lblMensagem.setBounds(1000, 50, 300, 25);
		getContentPane().add(lblMensagem);
		
		lblConsole = new JLabel("Console");
		lblConsole.setFont((new Font("lblConsole", Font.BOLD, 18)));
		lblConsole.setBounds(20, 399, 300, 25);
		getContentPane().add(lblConsole);
		
		btnNovo = new JButton("");
		btnNovo.setText("Novo");
		btnNovo.setBounds(10, 11, 100, 30);
		getContentPane().add(btnNovo);
		btnNovo.addActionListener(btnNovoL);
		btnNovo.setBackground(SystemColor.activeCaptionBorder);
		
		btnAbrirArquivo = new JButton("");
		btnAbrirArquivo.setText("Abrir");
		btnAbrirArquivo.setBounds(110, 11, 100, 30);
		getContentPane().add(btnAbrirArquivo);
		btnAbrirArquivo.setBackground(Color.LIGHT_GRAY);
		
		btnSalvar = new JButton("");
		btnSalvar.setText("Salvar");
		btnSalvar.setBounds(310, 11, 100, 30);
		getContentPane().add(btnSalvar);
		
		//Acao do botao para salvar
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salvar();
			}		
		});
		btnSalvar.setBackground(SystemColor.activeCaptionBorder);
		btnCompilador = new JButton("");
		btnCompilador.setText("Compilar");
		btnCompilador.setBounds(410, 11, 100, 30);
		getContentPane().add(btnCompilador);
		btnCompilador.setBackground(Color.LIGHT_GRAY);
		
		btnSalvarComo = new JButton("");
		//Acao do botao para salvar como
		btnSalvarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salvarComo();
			}
		});
		btnSalvarComo.setText("Salva Como");
		btnSalvarComo.setBounds(210, 11, 100, 30);
		getContentPane().add(btnSalvarComo);
		
		scroll_ContaLinha = new JScrollPane();
		scroll_ContaLinha.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);  
		scroll_ContaLinha.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		scroll_ContaLinha.setBounds(10, 75, 34, 313);
		getContentPane().add(scroll_ContaLinha);
		
		txtContaLinha = new JEditorPane();
		txtContaLinha.setContentType("text/html"); 
        
		txtContaLinha.setFont(new Font("Consolas", Font.PLAIN, 15));
		txtContaLinha.setDisabledTextColor(Color.green);
		txtContaLinha.setEditable(false);
		txtContaLinha.setText(appendText("1"));
		scroll_ContaLinha.setViewportView(txtContaLinha);
		btnAbrirArquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Verifica se o arquivo esta vazio
				if(txtCodigo.getText().equals("") != true){
					int resp = JOptionPane.showConfirmDialog(null, "Salvar altera\u00e7\u00f5es? Caso nao salve o arquivo sera perdido!!");
					
					//Para salvar
					if(resp ==0){
						 //Salvar um novo arquivo se ele n existir
	              	    if(file == null)
	              	    {
	              	     	salvarComo();
	              	    }else //Se o arquivo ja existir salvar nele
	              	    {
	              	      	salvar();
	              	    }
					} 
				}
				JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(null);
				
		        if (returnVal == JFileChooser.APPROVE_OPTION) {
		            file = fc.getSelectedFile().getAbsoluteFile();
		            //Instancia a classe ReadFile que cuida de ler o arquivo
		            ReadFile read = new ReadFile();
		            //Abre o arquivo
		            read.openFile(file);
		            txtCodigo.setText("");
		            campoTexto = new String();
		            campoTexto = read.readRecords();	            
		    		txtCodigo.append(campoTexto);
		    		controleArquivo = true;
		    		
		    		contEnter = read.getContLinhaArquivo();
		    		contEnter++;
		    		sb.delete(0, sb.length());
		    		for(int i =1 ; i < contEnter; i++){
						txtContaLinha.setText(appendText(i + "<br>"));
					}
					txtContaLinha.setText(appendText(contEnter+""));
		    		read.closeFile();
		        } 
			}
		});
		
		scroll_codigo.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent arg0) {
				Point point = scroll_codigo.getViewport().getViewPosition();  
				scroll_ContaLinha.getViewport().setViewPosition(point); 
			}
		});		
	}

	public void MarcaLinhaErro(int linha) {
		sb.delete(0, sb.length());
		
		erros.add(linha);
		for(int i =1;i<contEnter+1;i++) {
			
				if(!erros.contains(i)) {
					txtContaLinha.setText(appendText(i+"<br>"));
				}else {
					txtContaLinha.setText(appendText("<span style=\"color:red\"><b>"+i+"</b></span><br>"));
				}
		}
	}
	
	public void lookFeel() {//Altera o tipo de interface que ira exibir
		  try {
			  for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				  if ("Nimbus".equals(info.getName())) {
					  UIManager.setLookAndFeel(info.getClassName());
				  }
			  }
		  }catch (Exception e) {
		   JOptionPane.showMessageDialog(null,
		     "Nao foi possivel executar o nimbus");
		  }
	}
	
	// retorna o botao de compilar
	public JButton getCompilar() {

		return btnCompilador;
	}

	public JTextArea getTextArquivo(){
		return txtCodigo;
	}
	
	// funcao que adiciona msg no console
	public void setConsole(String msg){
		textConsole.append(msg);
	}
	
	// funcao que adiciona mensagem no campo de sintatica
	public void setMsg(String msg){
		txtArvoreSintatica.append(msg);
	}
	
	// funcao que retorna o arquivo que esta sendo editado
	public File getFile(){
		return file;
	}
	
	public void setFile(File file){
		this.file = file;
	}
	
	public String getCampoTexto(){
		return campoTexto;
	}
	
	public void setCampoTexto(String campoTexto){
		this.campoTexto = campoTexto;
	}
	
	public boolean getControleArquivo(){return controleArquivo;}
	
	public void setControleArquivo(boolean controle){
		this.controleArquivo = controle;
	}
	
	public void setVazioConsoleMsg(){
		textConsole.setText("");
		txtArvoreSintatica.setText("");
	}
	
	//Salvar se o arquivo ja existe
	public void salvar(){
		campoTexto = new String();	            
		controleArquivo = true;
		
		if(file !=null){
			campoTexto = new String();	            
    		controleArquivo = true;
			CreateFile create = new CreateFile();
			
			create.openFile(file);
			create.addRecords(txtCodigo.getText());
			create.closeFile();
			
			campoTexto = txtCodigo.getText();
		}else{
			salvarComo();
		}	
	}
	
	//Salvar se o arquivo ainda nao existir
	public void salvarComo(){
		// Abre o negocio para selecionar
		JFileChooser jc = new JFileChooser();
		jc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int i= jc.showSaveDialog(null);
		
		//Se o retorno for == 1 quer dizer que o usuario apertou em cancelar 
		// Se nao, ele escreveu o nome do arquivo, ou selecionou o arquivo que queira salvar
		if(i!=1) {
			// Pega o arquivo selecionado ou novo
			file = jc.getSelectedFile();
			campoTexto = new String();	            
    		controleArquivo = true;
			CreateFile create = new CreateFile();
			
			create.openFile(file);
			create.addRecords(txtCodigo.getText());
			create.closeFile();
			//Fecha o arquivo
			
			campoTexto = txtCodigo.getText();
		}
	}
	
	//Funcao para contar linhas
	public void contaLinha(int key){
		String[] separa = txtCodigo.getText().split("\n");
		txtContaLinha.setText(appendText(""));
		
		//Esse if serve para caso tenha conteudo, mas o usuario deu muitos enter
		if(contEnter >= separa.length){
			for(int i =1 ; i < contEnter; i++){
				txtContaLinha.setText(appendText(i + "<br>"));
			}
			txtContaLinha.setText(appendText(contEnter+""));
		}else{
			for(int i =1 ; i < separa.length; i++){
				txtContaLinha.setText(appendText(i + "<br>"));
			}
			txtContaLinha.setText(appendText(separa.length+""));
			if(key ==10) txtContaLinha.setText(appendText((separa.length+1) + ""));
			contEnter = separa.length;
		}
		
	}
	
	class btnNovoListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if(txtCodigo.getText().equals("") != true){
				 //Salvar um novo arquivo se ele n existir
				int resp = JOptionPane.showConfirmDialog(null, "Salvar altera\u00e7\u00f5es? Caso nao salve o arquivo sera perdido!!");
				if(resp ==0){
					if(file == null)
	          	    {
	          	     	salvarComo();
						
	          	    }else //Se o arquivo ja existir salvar nele
	          	    {
	          	      	salvar();
	          	    }
					sb.delete(0, sb.length());
	          	    txtCodigo.setText("");
	          	  	txtContaLinha.setText(appendText("1"));
	          	  	contEnter = 1;
				}else{
					sb.delete(0, sb.length());
					txtCodigo.setText("");
					txtContaLinha.setText("1");
					contEnter = 1;
				}
	      	   
			}else{
				txtCodigo.setText("");
				txtContaLinha.setText(appendText("1"));
				contEnter = 1;
			}
		}
	}
	
	class btnAbrirListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if(txtCodigo.getText().equals("") != true){
				 //Salvar um novo arquivo se ele n existir
				sb.delete(0, sb.length());
          	    if(file == null)
          	    {
          	     	salvarComo();
					
          	    }else //Se o arquivo ja existir salvar nele
          	    {
          	      	salvar();
          	    }
          	    txtCodigo.setText("");
          	  	txtContaLinha.setText(appendText("1"));
          	  	contEnter = 1;
			}else{
				txtCodigo.setText("");
				txtContaLinha.setText(appendText("1"));
				contEnter = 1;
						
			}
			
		}
	}
	private StringBuilder sb = new StringBuilder();
	public String appendText(String text) {
		  return sb.append(text).toString();
		}
}

