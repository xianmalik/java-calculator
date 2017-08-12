import java.awt.EventQueue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calc {
	
	private int modifier = 0, tempMod = 0, frag = 0, fragInt = 1;
	float result = 0, temp;
	String prefix = "", suffix = "";

	private JFrame frame;
	private JTextField resultField;
	
	/**
	 * Custom Functions
	 */
	
	private void makeResult(){
		switch(modifier){
			case 0:
				result = temp;
				break;
			case 1:
				result += temp;
				break;
			case 2:
				result -= temp;
				break;
			case 3:
				result *= temp;
				break;
			case 4:
				result /= temp;
				break;
		}
		modifier = -1;
		frag = 0;
		fragInt = 1;
		temp = 0;
		result = (float)Math.round(result * 1000000) / 1000000;
	}
	
	private void operator(int x){
		switch(modifier){
			case -1:
				modifier = x;
				break;
			case 0:
				modifier = x;
			case 1:
				result += temp;
				modifier = x;
				break;
			case 2:
				result -= temp;
				modifier = x;
				break;
			case 3:
				result *= temp;
				modifier = x;
				break;
			case 4:
				result /= temp;
				modifier = x;
				break;
		}
		resultField.setText(Float.toString(result));
		temp = 0;
		frag = 0;
		prefix = "";
		suffix = "";
		fragInt = 1;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calc window = new Calc();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 307, 470);
		frame.setTitle("Scientific Calculator"); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		resultField = new JTextField();
		resultField.setBackground(new Color(255, 255, 255));
		resultField.setFont(new Font("Lucida Sans", Font.PLAIN, 17));
		resultField.setHorizontalAlignment(SwingConstants.RIGHT);
		resultField.setEditable(false);
		resultField.setBounds(0, 0, 291, 50);
		frame.getContentPane().add(resultField);
		resultField.setColumns(10);

		
		JButton btn0 = new JButton("0");
		btn0.setForeground(new Color(51, 51, 51));
		btn0.setBackground(new Color(204, 204, 204));
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (modifier == -1){
					modifier = 0;
					temp = 1;
				} else{
					if(frag==0){
						temp = temp*10;
					} else {
						temp = (float) (temp + 0/(Math.pow(10, fragInt++)));
					}	
				}
				resultField.setText(prefix + Float.toString(temp) + suffix);
			}
		});
		btn0.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btn0.setBounds(10, 371, 60, 50);
		frame.getContentPane().add(btn0);
		
		JButton btn1 = new JButton("1");
		btn1.setForeground(new Color(51, 51, 51));
		btn1.setBackground(new Color(204, 204, 204));
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (modifier == -1){
					modifier = 0;
					temp = 1;
				} else{
					if(frag==0){
						temp = temp*10 + 1;
					} else {
						temp = (float) (temp + 1/(Math.pow(10, fragInt++)));
					}	
				}
				resultField.setText(prefix + Float.toString(temp) + suffix);
			}
		});
		btn1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btn1.setBounds(10, 321, 60, 50);
		frame.getContentPane().add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.setForeground(new Color(51, 51, 51));
		btn2.setBackground(new Color(204, 204, 204));
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (modifier == -1){
					modifier = 0;
					temp = 2;
				} else{
					if(frag==0){
						temp = temp*10 + 2;
					} else {
						temp = (float) (temp + 2/(Math.pow(10, fragInt++)));
					}	
				}
				resultField.setText(prefix + Float.toString(temp) + suffix);
			}
		});
		btn2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btn2.setBounds(80, 321, 60, 50);
		frame.getContentPane().add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.setForeground(new Color(51, 51, 51));
		btn3.setBackground(new Color(204, 204, 204));
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (modifier == -1){
					modifier = 0;
					temp = 3;
				} else{
					if(frag==0){
						temp = temp*10 + 3;
					}
					else{
						temp = (float) (temp + 3/(Math.pow(10, fragInt++)));
					}	
				}
				resultField.setText(prefix + Float.toString(temp) + suffix);
			}
		});
		btn3.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btn3.setBounds(150, 321, 60, 50);
		frame.getContentPane().add(btn3);
		
		JButton btn4 = new JButton("4");
		btn4.setForeground(new Color(51, 51, 51));
		btn4.setBackground(new Color(204, 204, 204));
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (modifier == -1){
					modifier = 0;
					temp = 4;
				} else{
					if(frag==0){
						temp = temp*10 + 4;
					}
					else{
						temp = (float) (temp + 4/(Math.pow(10, fragInt++)));
					}	
				}
				resultField.setText(prefix + Float.toString(temp) + suffix);
			}
		});
		btn4.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btn4.setBounds(10, 271, 60, 50);
		frame.getContentPane().add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.setForeground(new Color(51, 51, 51));
		btn5.setBackground(new Color(204, 204, 204));
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (modifier == -1){
					modifier = 0;
					temp = 5;
				} else{
					if(frag==0){
						temp = temp*10 + 5;
					}
					else{
						temp = (float) (temp + 5/(Math.pow(10, fragInt++)));
					}	
				}
				resultField.setText(prefix + Float.toString(temp) + suffix);
			}
		});
		btn5.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btn5.setBounds(80, 271, 60, 50);
		frame.getContentPane().add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.setForeground(new Color(51, 51, 51));
		btn6.setBackground(new Color(204, 204, 204));
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (modifier == -1){
					modifier = 0;
					temp = 6;
				} else{
					if(frag==0){
						temp = temp*10 + 6;
					}
					else{
						temp = (float) (temp + 6/(Math.pow(10, fragInt++)));
					}	
				}
				resultField.setText(prefix + Float.toString(temp) + suffix);
			}
		});
		btn6.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btn6.setBounds(150, 271, 60, 50);
		frame.getContentPane().add(btn6);
		
		JButton btn7 = new JButton("7");
		btn7.setForeground(new Color(51, 51, 51));
		btn7.setBackground(new Color(204, 204, 204));
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (modifier == -1){
					modifier = 0;
					temp = 7;
				} else{
					if(frag==0){
						temp = temp*10 + 7;
					}
					else{
						temp = (float) (temp + 7/(Math.pow(10, fragInt++)));
					}	
				}
				resultField.setText(prefix + Float.toString(temp) + suffix);
			}
		});
		btn7.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btn7.setBounds(10, 221, 60, 50);
		frame.getContentPane().add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.setForeground(new Color(51, 51, 51));
		btn8.setBackground(new Color(204, 204, 204));
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (modifier == -1){
					modifier = 0;
					temp = 8;
				} else{
					if(frag==0){
						temp = temp*10 + 8;
					}
					else{
						temp = (float) (temp + 8/(Math.pow(10, fragInt++)));
					}	
				}
				resultField.setText(prefix + Float.toString(temp) + suffix);
			}
		});
		btn8.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btn8.setBounds(80, 221, 60, 50);
		frame.getContentPane().add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.setForeground(new Color(51, 51, 51));
		btn9.setBackground(new Color(204, 204, 204));
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (modifier == -1){
					modifier = 0;
					temp = 9;
				} else {
					if(frag==0){
						temp = temp*10 + 9;
					}
					else{
						temp = (float) (temp + 9/(Math.pow(10, fragInt++)));
					}	
				}
				resultField.setText(prefix + Float.toString(temp) + suffix);
			}
		});
		btn9.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btn9.setBounds(150, 221, 60, 50);
		frame.getContentPane().add(btn9);
		
		JButton btnDot = new JButton(".");
		btnDot.setForeground(new Color(51, 51, 51));
		btnDot.setBackground(new Color(204, 204, 204));
		btnDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frag = 1;
			}
		});
		btnDot.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnDot.setBounds(80, 371, 60, 50);
		frame.getContentPane().add(btnDot);
		
		JButton btnAdd = new JButton("+");
		btnAdd.setForeground(new Color(51, 51, 51));
		btnAdd.setBackground(new Color(204, 204, 204));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operator(1);
			}
		});
		btnAdd.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnAdd.setBounds(220, 221, 60, 50);
		frame.getContentPane().add(btnAdd);
		
		JButton btnSub = new JButton("-");
		btnSub.setForeground(new Color(51, 51, 51));
		btnSub.setBackground(new Color(204, 204, 204));
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operator(2);
			}
		});
		btnSub.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnSub.setBounds(220, 271, 60, 50);
		frame.getContentPane().add(btnSub);
		
		JButton btnMul = new JButton("*");
		btnMul.setForeground(new Color(51, 51, 51));
		btnMul.setBackground(new Color(204, 204, 204));
		btnMul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operator(3);
			}
		});
		btnMul.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnMul.setBounds(220, 321, 60, 50);
		frame.getContentPane().add(btnMul);
		
		JButton btnDiv = new JButton("/");
		btnDiv.setForeground(new Color(51, 51, 51));
		btnDiv.setBackground(new Color(204, 204, 204));
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operator(4);
			}
		});
		btnDiv.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnDiv.setBounds(220, 371, 60, 50);
		frame.getContentPane().add(btnDiv);
		
		JButton btnEq = new JButton("=");
		btnEq.setForeground(new Color(255, 255, 255));
		btnEq.setBackground(new Color(51, 153, 204));
		btnEq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(modifier==10){
					result = (float) Math.pow(result, temp);
				}else if(modifier==11){
					temp = (float) Math.log(temp);
					modifier = tempMod;
				}else if(modifier==21){
					temp = (float) (Math.log(temp)/Math.log(10));
					modifier = tempMod;
				}else if(modifier==12){
					temp = (float) Math.sin(Math.toRadians(temp));
					modifier = tempMod;
				}else if(modifier==13){
					temp = (float) Math.cos(Math.toRadians(temp));
					modifier = tempMod;
				}else if(modifier==14){
					temp = (float) Math.tan(Math.toRadians(temp));
					modifier = tempMod;
				}
				makeResult();
				resultField.setText(Float.toString(result));
			}
		});
		btnEq.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnEq.setBounds(150, 371, 60, 50);
		frame.getContentPane().add(btnEq);
		
		JButton btnClear = new JButton("C");
		btnClear.setForeground(new Color(51, 51, 51));
		btnClear.setBackground(new Color(204, 204, 204));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modifier = 0;
				temp = 0;
				result = 0;
				frag = 0;
				fragInt = 1;
				prefix = "";
				suffix = "";
				resultField.setText("");
			}
		});
		btnClear.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnClear.setBounds(220, 61, 60, 50);
		frame.getContentPane().add(btnClear);
		
		JButton btnInv = new JButton("inv");
		btnInv.setForeground(new Color(51, 51, 51));
		btnInv.setBackground(new Color(204, 204, 204));
		btnInv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				makeResult();
				result = 1/result;
				resultField.setText(prefix + Float.toString(result) + suffix);	
			}
		});
		btnInv.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnInv.setBounds(220, 161, 60, 50);
		frame.getContentPane().add(btnInv);
		
		JButton btnSqrt = new JButton("\u221A");
		btnSqrt.setForeground(new Color(51, 51, 51));
		btnSqrt.setBackground(new Color(204, 204, 204));
		btnSqrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				makeResult();
				result = (float) Math.sqrt(result);
				resultField.setText(prefix + Float.toString(result) + suffix);	
			}
		});
		btnSqrt.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnSqrt.setBounds(80, 161, 60, 50);
		frame.getContentPane().add(btnSqrt);
		
		JButton btnPow = new JButton("x\u02B8");
		btnPow.setForeground(new Color(51, 51, 51));
		btnPow.setBackground(new Color(204, 204, 204));
		btnPow.setToolTipText("Power");
		btnPow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				makeResult();
				modifier = 10;
			}
		});
		btnPow.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnPow.setBounds(150, 161, 60, 50);
		frame.getContentPane().add(btnPow);
		
		JButton btnSin = new JButton("sin");
		btnSin.setForeground(new Color(51, 51, 51));
		btnSin.setBackground(new Color(204, 204, 204));
		btnSin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tempMod = modifier;
				temp = 0;
				modifier = 12;
				prefix = "sin( ";
				suffix = " )";
				resultField.setText(prefix + suffix);	
			}
		});
		btnSin.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnSin.setBounds(10, 61, 60, 50);
		frame.getContentPane().add(btnSin);
		
		JButton btnCos = new JButton("cos");
		btnCos.setForeground(new Color(51, 51, 51));
		btnCos.setBackground(new Color(204, 204, 204));
		btnCos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tempMod = modifier;
				temp = 0;
				modifier = 13;
				prefix = "cos( ";
				suffix = " )";
				resultField.setText(prefix + suffix);	
			}
		});
		btnCos.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnCos.setBounds(80, 61, 60, 50);
		frame.getContentPane().add(btnCos);
		
		JButton btnTan = new JButton("tan");
		btnTan.setForeground(new Color(51, 51, 51));
		btnTan.setBackground(new Color(204, 204, 204));
		btnTan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tempMod = modifier;
				temp = 0;
				modifier = 14;
				prefix = "tan( ";
				suffix = " )";
				resultField.setText(prefix + suffix);
			}
		});
		btnTan.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnTan.setBounds(150, 61, 60, 50);
		frame.getContentPane().add(btnTan);
		
		JButton btnLog = new JButton("log");
		btnLog.setForeground(new Color(51, 51, 51));
		btnLog.setBackground(new Color(204, 204, 204));
		btnLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tempMod = modifier;
				temp = 0;
				modifier = 11;
				prefix = "log( ";
				suffix = " )";
				resultField.setText(prefix + suffix);
			}
		});
		btnLog.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnLog.setBounds(10, 111, 60, 50);
		frame.getContentPane().add(btnLog);

		JButton btnLn = new JButton("ln");
		btnLn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tempMod = modifier;
				temp = 0;
				modifier = 21;
				prefix = "ln( ";
				suffix = " )";
				resultField.setText(prefix + suffix);
			}
		});
		btnLn.setForeground(new Color(51, 51, 51));
		btnLn.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnLn.setBackground(new Color(204, 204, 204));
		btnLn.setBounds(80, 111, 60, 50);
		frame.getContentPane().add(btnLn);
		
		JButton btnFact = new JButton("x!");
		btnFact.setForeground(new Color(51, 51, 51));
		btnFact.setBackground(new Color(204, 204, 204));
		btnFact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				makeResult();
				int fact = 1;
				for (int i = 1; i <= result; i++) {
					fact *= i;
		        }
				result = fact;
				resultField.setText(prefix + Float.toString(result) + suffix);	
			}
		});
		btnFact.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnFact.setBounds(10, 161, 60, 50);
		frame.getContentPane().add(btnFact);
		

		JButton btnPer = new JButton("%");
		btnPer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				temp = temp/100;
				resultField.setText(Float.toString(temp));
			}
		});
		btnPer.setForeground(new Color(51, 51, 51));
		btnPer.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnPer.setBackground(new Color(204, 204, 204));
		btnPer.setBounds(150, 111, 60, 50);
		frame.getContentPane().add(btnPer);
		
		JButton btnPi = new JButton("\u03C0");
		btnPi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				temp = (float) 3.14159265358;
				resultField.setText(Float.toString(temp));
			}
		});
		btnPi.setForeground(new Color(51, 51, 51));
		btnPi.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnPi.setBackground(new Color(204, 204, 204));
		btnPi.setBounds(220, 111, 60, 50);
		frame.getContentPane().add(btnPi);
		
		/*
		 * Styling Buttons
		 */

		btn0.setBorderPainted(false);
		btn0.setFocusPainted(false);
		btn0.setContentAreaFilled(false);

		btn1.setBorderPainted(false);
		btn1.setFocusPainted(false);
		btn1.setContentAreaFilled(false);

		btn2.setBorderPainted(false);
		btn2.setFocusPainted(false);
		btn2.setContentAreaFilled(false);

		btn3.setBorderPainted(false);
		btn3.setFocusPainted(false);
		btn3.setContentAreaFilled(false);

		btn4.setBorderPainted(false);
		btn4.setFocusPainted(false);
		btn4.setContentAreaFilled(false);

		btn4.setBorderPainted(false);
		btn4.setFocusPainted(false);
		btn4.setContentAreaFilled(false);

		btn5.setBorderPainted(false);
		btn5.setFocusPainted(false);
		btn5.setContentAreaFilled(false);

		btn6.setBorderPainted(false);
		btn6.setFocusPainted(false);
		btn6.setContentAreaFilled(false);

		btn7.setBorderPainted(false);
		btn7.setFocusPainted(false);
		btn7.setContentAreaFilled(false);

		btn8.setBorderPainted(false);
		btn8.setFocusPainted(false);
		btn8.setContentAreaFilled(false);

		btn9.setBorderPainted(false);
		btn9.setFocusPainted(false);
		btn9.setContentAreaFilled(false);

		btnAdd.setBorderPainted(false);
		btnAdd.setFocusPainted(false);
		btnAdd.setContentAreaFilled(false);

		btnSub.setBorderPainted(false);
		btnSub.setFocusPainted(false);
		btnSub.setContentAreaFilled(false);

		btnMul.setBorderPainted(false);
		btnMul.setFocusPainted(false);
		btnMul.setContentAreaFilled(false);

		btnDiv.setBorderPainted(false);
		btnDiv.setFocusPainted(false);
		btnDiv.setContentAreaFilled(false);

		btnDot.setBorderPainted(false);
		btnDot.setFocusPainted(false);
		btnDot.setContentAreaFilled(false);

		btnEq.setBorderPainted(false);
		btnEq.setFocusPainted(false);

		btnInv.setBorderPainted(false);
		btnInv.setFocusPainted(false);
		btnInv.setContentAreaFilled(false);

		btnPow.setBorderPainted(false);
		btnPow.setFocusPainted(false);
		btnPow.setContentAreaFilled(false);

		btnSqrt.setBorderPainted(false);
		btnSqrt.setFocusPainted(false);
		btnSqrt.setContentAreaFilled(false);

		btnFact.setBorderPainted(false);
		btnFact.setFocusPainted(false);
		btnFact.setContentAreaFilled(false);

		btnLog.setBorderPainted(false);
		btnLog.setFocusPainted(false);
		btnLog.setContentAreaFilled(false);

		btnSin.setBorderPainted(false);
		btnSin.setFocusPainted(false);
		btnSin.setContentAreaFilled(false);

		btnCos.setBorderPainted(false);
		btnCos.setFocusPainted(false);
		btnCos.setContentAreaFilled(false);

		btnTan.setBorderPainted(false);
		btnTan.setFocusPainted(false);
		btnTan.setContentAreaFilled(false);

		btnClear.setBorderPainted(false);
		btnClear.setFocusPainted(false);
		
		btnLn.setFocusPainted(false);
		btnLn.setContentAreaFilled(false);
		btnLn.setBorderPainted(false);
		
		btnPer.setFocusPainted(false);
		btnPer.setContentAreaFilled(false);
		btnPer.setBorderPainted(false);

		btnPi.setFocusPainted(false);
		btnPi.setContentAreaFilled(false);
		btnPi.setBorderPainted(false);
		
	}
}
