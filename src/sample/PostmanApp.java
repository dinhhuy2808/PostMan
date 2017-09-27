package sample;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dynacode.DynaCode;

public class PostmanApp extends JFrame implements ActionListener {
	JTextField jt1,jt2,jt3;
	JButton btn;
	public PostmanApp (){
		setTitle("CREATE SCREEN UTILITY VER 1.0");
		setSize(400, 120);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel jpnl = new JPanel(new GridLayout(4, 1));
		jt1 = new JTextField(30);
		this.add(jpnl);
		jpnl.add(jt1);
		
		jt2 = new JTextField(30);
		jpnl.add(jt2);
		
		jt3 = new JTextField(30);
		jpnl.add(jt3);
		
		btn = new JButton("Gen");
		jpnl.add(btn);
		
		btn.addActionListener(this);
	}
	public static void main(String[] args) throws Exception {
		
		/*String s = "";
		for(String line:Files.readAllLines(Paths.get("Template.txt"))){
			s+=line +"\n";
		}
		
		
		String detail = "output.println(\"[Postman] \" + msg +\"456789\");"+"\n";
		 detail += "output.println(\"[Postman] \" + msg +\"Huy dep trai\");";
		
		s =s.replace("TemplateOfDeliverMessage", detail);
		
		MakeFile("D:/Users/htran/PostMan/dynacode/sample", s, "PostmanImpl.java");
		BufferedReader sysin = new BufferedReader(new InputStreamReader(System.in));

		Postman postman = getPostman();

		while (true) {
			System.out.print("Enter a message: ");
			String msg = sysin.readLine();

			postman.deliverMessage(msg);
		}*/
		
		PostmanApp p = new PostmanApp();
		p.setVisible(true);
	}
	private static void MakeFile(String directproject, String detail, String fileName) {
		try {
			FileWriter fw = new FileWriter(directproject+"/"
					+ fileName);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw);
			
			out.println(detail);
			// define class FileName.java
			out.flush();
			out.close();

		} catch (FileNotFoundException fex) {
			
			JOptionPane.showInternalMessageDialog(null, fex.toString());
		} catch (IOException ioex) {
			JOptionPane.showInternalMessageDialog(null, ioex.toString());
		} catch (Exception ex) {
			JOptionPane.showInternalMessageDialog(null,
					"Error to export to Frame1 with HTML format");
		}

	}
	private static Postman getPostman() {
		DynaCode dynacode = new DynaCode();
		dynacode.addSourceDir(new File("dynacode"));
		return (Postman) dynacode.newProxyInstance(Postman.class,
				"sample.PostmanImpl");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btn)){
			String s = "";
			try {
				for(String line:Files.readAllLines(Paths.get("Template.txt"))){
					s+=line +"\n";
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		/*	String detail1 = "output.println(\"[Postman] \" + msg +\"456789\");"+"\n";
			String detail2 += "output.println(\"[Postman] \" + msg +\"Huy dep trai\");";*/
			String detail1 = jt1.getText()+"\n";
			String detail2 = jt2.getText();
			s =s.replace("TemplateOfDeliverMessage", detail1 + detail2);
			
			MakeFile("D:/Users/htran/PostMan/dynacode/sample", s, "PostmanImpl.java");
			BufferedReader sysin = new BufferedReader(new InputStreamReader(System.in));

			Postman postman = getPostman();

			

				postman.deliverMessage(jt3.getText());
			
		}
	}

}
