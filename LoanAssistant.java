import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class LoanAssistant {
	static boolean computePayment=true;
	Color Lightyellow = new Color(225,225,128);
	private JFrame frame;
	private JTextField balanceTextField;
	private JTextField interestTextField;
	private JTextField monthsTextField;
	private JTextField paymentTextField;
	private JButton computeButton;
	private JButton newLoanButton;
	private JButton monthsButton;
	private JButton paymentButton;
	private JLabel analysisLabel;
	private JTextArea analysisTextArea;
	private JButton exitButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoanAssistant window = new LoanAssistant();
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
	public LoanAssistant() {
		initialize();
	}
	
	//here are my personal functions
	public boolean validateDecimalNumber(JTextField tf)
	{
		String s=tf.getText().trim();
		boolean hasdecimal=false;
		boolean valid = true;
		if(s.length()==0)
		{
			valid = false;
		}
		else
		{
			for(int i=0;i<s.length();i++)
			{
				char c=s.charAt(i);
				if(c>='0'&&c<='9')
				{
					continue;
				}
				else if(c=='.'&& !hasdecimal)
				{
					hasdecimal=true;
				}
				else
				{
					valid =false;
				}
			}
		}
		tf.setText(s);
		if(!valid)
		{
			tf.requestFocus();
		}
		return (valid);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setBounds(100, 100, 699, 306);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel balanceLabel = new JLabel("Loan Balance");
		balanceLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		GridBagConstraints gbc_balanceLabel = new GridBagConstraints();
		gbc_balanceLabel.anchor = GridBagConstraints.WEST;
		gbc_balanceLabel.insets = new Insets(10, 10, 5, 5);
		gbc_balanceLabel.fill = GridBagConstraints.VERTICAL;
		gbc_balanceLabel.gridx = 0;
		gbc_balanceLabel.gridy = 0;
		frame.getContentPane().add(balanceLabel, gbc_balanceLabel);
		
		balanceTextField = new JTextField();
		balanceTextField.setHorizontalAlignment(JTextField.RIGHT);
		balanceTextField.setFont(new Font("Arial", Font.PLAIN, 16));
		GridBagConstraints gbc_balanceTextField = new GridBagConstraints();
		gbc_balanceTextField.insets = new Insets(10, 10, 5, 10);
		gbc_balanceTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_balanceTextField.gridx = 1;
		gbc_balanceTextField.gridy = 0;
		frame.getContentPane().add(balanceTextField, gbc_balanceTextField);
		balanceTextField.setColumns(10);
		
		analysisLabel = new JLabel("Loan Analysis");
		analysisLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		GridBagConstraints gbc_analysisLabel = new GridBagConstraints();
		gbc_analysisLabel.anchor = GridBagConstraints.WEST;
		gbc_analysisLabel.insets = new Insets(0, 10, 5, 0);
		gbc_analysisLabel.gridx = 3;
		gbc_analysisLabel.gridy = 0;
		frame.getContentPane().add(analysisLabel, gbc_analysisLabel);
		
		JLabel intrestLabel = new JLabel("Intrest Rate");
		intrestLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		GridBagConstraints gbc_intrestLabel = new GridBagConstraints();
		gbc_intrestLabel.anchor = GridBagConstraints.WEST;
		gbc_intrestLabel.insets = new Insets(10, 10, 5, 5);
		gbc_intrestLabel.gridx = 0;
		gbc_intrestLabel.gridy = 1;
		frame.getContentPane().add(intrestLabel, gbc_intrestLabel);
		
		interestTextField = new JTextField();
		interestTextField.setHorizontalAlignment(JTextField.RIGHT);
		interestTextField.setFont(new Font("Arial", Font.PLAIN, 16));
		interestTextField.setColumns(10);
		GridBagConstraints gbc_interestTextField = new GridBagConstraints();
		gbc_interestTextField.insets = new Insets(10, 10, 5, 10);
		gbc_interestTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_interestTextField.gridx = 1;
		gbc_interestTextField.gridy = 1;
		frame.getContentPane().add(interestTextField, gbc_interestTextField);
		
		analysisTextArea = new JTextArea();
		analysisTextArea.setFocusable(false);
		analysisTextArea.setPreferredSize(new Dimension(250,150));
		analysisTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		analysisTextArea.setFont(new Font("Courier New", Font.PLAIN, 14));
		analysisTextArea.setEditable(false);
		GridBagConstraints gbc_analysisTextArea = new GridBagConstraints();
		gbc_analysisTextArea.gridheight = 4;
		gbc_analysisTextArea.insets = new Insets(0, 10, 5, 10);
		gbc_analysisTextArea.fill = GridBagConstraints.BOTH;
		gbc_analysisTextArea.gridx = 3;
		gbc_analysisTextArea.gridy = 1;
		frame.getContentPane().add(analysisTextArea, gbc_analysisTextArea);
		
		JLabel monthsLabel = new JLabel("Number of Payments");
		monthsLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		GridBagConstraints gbc_monthsLabel = new GridBagConstraints();
		gbc_monthsLabel.anchor = GridBagConstraints.WEST;
		gbc_monthsLabel.insets = new Insets(10, 10, 5, 5);
		gbc_monthsLabel.gridx = 0;
		gbc_monthsLabel.gridy = 2;
		frame.getContentPane().add(monthsLabel, gbc_monthsLabel);
		
		monthsTextField = new JTextField();
		monthsTextField.setHorizontalAlignment(JTextField.RIGHT);
		monthsTextField.setFont(new Font("Arial", Font.PLAIN, 16));
		monthsTextField.setColumns(10);
		GridBagConstraints gbc_monthsTextField = new GridBagConstraints();
		gbc_monthsTextField.insets = new Insets(10, 10, 5, 10);
		gbc_monthsTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_monthsTextField.gridx = 1;
		gbc_monthsTextField.gridy = 2;
		frame.getContentPane().add(monthsTextField, gbc_monthsTextField);
		
		monthsButton = new JButton("X");
		monthsButton.setFocusable(false);
		monthsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				computePayment = false;
				paymentButton.setVisible(true);
				monthsButton.setVisible(false);
				monthsTextField.setText("");
				monthsTextField.setEditable(false);
				monthsTextField.setBackground(Lightyellow);
				paymentTextField.setEditable(true);
				paymentTextField.setBackground(Color.WHITE);
				computeButton.setText("Compute Number of Payments");
				monthsTextField.setFocusable(false);
				paymentTextField.setFocusable(true);
				balanceTextField.requestFocus();
				
			}
		});
		monthsButton.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_monthsButton = new GridBagConstraints();
		gbc_monthsButton.anchor = GridBagConstraints.WEST;
		gbc_monthsButton.insets = new Insets(10, 0, 5, 5);
		gbc_monthsButton.gridx = 2;
		gbc_monthsButton.gridy = 2;
		frame.getContentPane().add(monthsButton, gbc_monthsButton);
		
		JLabel paymentLabel = new JLabel("Monthly Payment");
		paymentLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		GridBagConstraints gbc_paymentLabel = new GridBagConstraints();
		gbc_paymentLabel.insets = new Insets(10, 10, 5, 5);
		gbc_paymentLabel.anchor = GridBagConstraints.WEST;
		gbc_paymentLabel.gridx = 0;
		gbc_paymentLabel.gridy = 3;
		frame.getContentPane().add(paymentLabel, gbc_paymentLabel);
		
		paymentTextField = new JTextField();
		paymentTextField.setHorizontalAlignment(JTextField.RIGHT);
		paymentTextField.setBackground(Lightyellow);
		paymentTextField.setEditable(false);
		paymentTextField.setFont(new Font("Arial", Font.PLAIN, 16));
		paymentTextField.setColumns(10);
		GridBagConstraints gbc_paymentTextField = new GridBagConstraints();
		gbc_paymentTextField.insets = new Insets(10, 10, 5, 10);
		gbc_paymentTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_paymentTextField.gridx = 1;
		gbc_paymentTextField.gridy = 3;
		frame.getContentPane().add(paymentTextField, gbc_paymentTextField);
		
		
		paymentButton = new JButton("X");
		paymentButton.setFocusable(false);
		paymentButton.setVisible(false);
		paymentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				computePayment = true;
				paymentButton.setVisible(false);
				monthsButton.setVisible(true);
				monthsTextField.setEditable(true);
				monthsTextField.setBackground(Color.WHITE);
				paymentTextField.setText("");
				paymentTextField.setEditable(false);
				paymentTextField.setBackground(Lightyellow);
				computeButton.setText("Compute Monthly Payment");
				monthsTextField.setFocusable(true);
				paymentTextField.setFocusable(false);
				balanceTextField.requestFocus();
				
			}
		});
		paymentButton.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_paymentButton = new GridBagConstraints();
		gbc_paymentButton.anchor = GridBagConstraints.WEST;
		gbc_paymentButton.insets = new Insets(10, 0, 10, 5);
		gbc_paymentButton.gridx = 2;
		gbc_paymentButton.gridy = 3;
		frame.getContentPane().add(paymentButton, gbc_paymentButton);
		
		computeButton = new JButton("Compute Monthly payments");
		computeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double balance, interest, payment;
				int months;
				double monthlyInterest, multiplier;
				double loanBalance, finalPayment;
				if(validateDecimalNumber(balanceTextField))
				{
				balance =Double.valueOf(balanceTextField.getText()).doubleValue();
				}
				else
				{
					JOptionPane.showConfirmDialog(null, "Invalid or empty Loan Balance entry.\nPlease correct","Balance Input Error",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				if(validateDecimalNumber(interestTextField))
				{
				interest =Double.valueOf(interestTextField.getText()).doubleValue();
				}
				else
				{
					JOptionPane.showConfirmDialog(null, "Invalid or empty Interest Rate entry.\nPlease correct","Interest Input Error",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				monthlyInterest = interest / 1200;
				if (computePayment)
				{
				if(validateDecimalNumber(monthsTextField))
				{
				months =Integer.valueOf(monthsTextField.getText()).intValue();
				}
				else
				{
					JOptionPane.showConfirmDialog(null, "Invalid or empty No. of Payments entry.\nPlease correct","No. of Payments Error",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				if(interest==0)
					{
						payment=balance/months;
					}
					else
					{
					multiplier = Math.pow(1 + monthlyInterest, months);
					payment = balance * monthlyInterest * multiplier / (multiplier - 1);
					}
				paymentTextField.setText(new DecimalFormat("0.00").format(payment));
				}
				else
				{
					if(validateDecimalNumber(paymentTextField))
					{
				payment=Double.valueOf(paymentTextField.getText()).doubleValue();
				//temp starts here
				if(payment<=(balance*monthlyInterest+1.0))
				{
					if(JOptionPane.showConfirmDialog(null, "Minimum payment must be $"+new DecimalFormat("0.00").format((int)(balance*monthlyInterest+1))+"\n"+"Do ypu want to use the minimum payment?","Input Error",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)
					{
						paymentTextField.setText(new DecimalFormat("0.00").format((int)
								(balance * monthlyInterest + 1.0)));
						payment =
								Double.valueOf(paymentTextField.getText()).doubleValue();
					}
					else
					{
						paymentTextField.requestFocus();
						return;
					}
				}
				//temp ends here
					}
					else
					{
						JOptionPane.showConfirmDialog(null, "Invalid or empty Monthly Payments entry.\nPlease correct","Monthly Payments Error",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
						return;
					}
				if(interest==0)
					{
						months=(int)(balance/payment);
					}
					else
					{
					months = (int)((Math.log(payment) - Math.log(payment - balance * monthlyInterest)) / Math.log(1 + monthlyInterest));
					}
				monthsTextField.setText(String.valueOf(months));
				}
				
				payment=Double.valueOf(paymentTextField.getText()).doubleValue();
				analysisTextArea.setText("Loan Balance: $" + new DecimalFormat("0.00").format(balance));
				analysisTextArea.append("\n" + "Interest Rate: " + new DecimalFormat("0.00").format(interest) + "%");
				loanBalance = balance;
				for (int paymentNumber = 1; paymentNumber <= months - 1; paymentNumber++)
				{
				loanBalance += loanBalance * monthlyInterest - payment;
				}
						finalPayment = loanBalance;
				if (finalPayment > payment)
				{
				loanBalance += loanBalance * monthlyInterest - payment;
				finalPayment = loanBalance;
				months++;
				monthsTextField.setText(String.valueOf(months));
				}
				analysisTextArea.append("\n\n" + String.valueOf(months - 1) + " Payments of $" + new
				DecimalFormat("0.00").format(payment));
				analysisTextArea.append("\n" + "Final Payment of: $" + new
				DecimalFormat("0.00").format(finalPayment));
				analysisTextArea.append("\n" + "Total Payments: $" + new
				DecimalFormat("0.00").format((months - 1) * payment + finalPayment));
				analysisTextArea.append("\n" + "Interest Paid $" + new
				DecimalFormat("0.00").format((months - 1) * payment + finalPayment - balance));
				computeButton.setEnabled(false);
				newLoanButton.setEnabled(true);
				newLoanButton.requestFocus();
			}
		});
		computeButton.setFont(new Font("Arial", Font.PLAIN, 16));
		GridBagConstraints gbc_computeButton = new GridBagConstraints();
		gbc_computeButton.gridwidth = 2;
		gbc_computeButton.insets = new Insets(10, 0, 5, 5);
		gbc_computeButton.gridx = 0;
		gbc_computeButton.gridy = 4;
		frame.getContentPane().add(computeButton, gbc_computeButton);
		
		newLoanButton = new JButton("New Loan Analysis");
		newLoanButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (computePayment)
				{
				paymentTextField.setText("");
				}
				else
				{
				monthsTextField.setText("");
				}
				analysisTextArea.setText("");
				computeButton.setEnabled(true);
				newLoanButton.setEnabled(false);
				balanceTextField.requestFocus();
				
			}
		});
		newLoanButton.setEnabled(false);
		newLoanButton.setFont(new Font("Arial", Font.PLAIN, 16));
		GridBagConstraints gbc_newLoanButton = new GridBagConstraints();
		gbc_newLoanButton.gridwidth = 2;
		gbc_newLoanButton.insets = new Insets(10, 0, 10, 5);
		gbc_newLoanButton.gridx = 0;
		gbc_newLoanButton.gridy = 5;
		frame.getContentPane().add(newLoanButton, gbc_newLoanButton);
		
		exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButton.setFocusable(false);
		exitButton.setFont(new Font("Arial", Font.PLAIN, 16));
		GridBagConstraints gbc_exitButton = new GridBagConstraints();
		gbc_exitButton.gridx = 3;
		gbc_exitButton.gridy = 5;
		frame.getContentPane().add(exitButton, gbc_exitButton);
	}

}
