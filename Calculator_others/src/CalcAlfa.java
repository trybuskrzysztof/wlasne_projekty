

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.awt.Insets;

	public class CalcAlfa {

		private JFrame frame;
		private JTextField textField;

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						CalcAlfa window = new CalcAlfa();
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
		public CalcAlfa() {
			initialize();
		}

		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			frame = new JFrame();
			frame.setBounds(100, 100, 500, 500);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			GridBagLayout gridBagLayout = new GridBagLayout();
			gridBagLayout.columnWidths = new int[]{0, 0};
			gridBagLayout.rowHeights = new int[]{50, 50, 50, 50, 50};
			gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			frame.getContentPane().setLayout(gridBagLayout);

			textField = new JTextField();
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.insets = new Insets(0, 0, 5, 5);
			gbc_textField.fill = GridBagConstraints.BOTH;
			gbc_textField.gridwidth = 4;
			gbc_textField.gridx = 0;
			gbc_textField.gridy = 0;

			frame.getContentPane().add(textField, gbc_textField);
			textField.setColumns(10);

			JButton b1 = new JButton("C");
			GridBagConstraints gbc_b1 = new GridBagConstraints();
			gbc_b1.insets = new Insets(0, 0, 5, 5);
			gbc_b1.fill = GridBagConstraints.BOTH;
			gbc_b1.gridx = 4;
			gbc_b1.gridy = 0;
			gbc_b1.weightx = 1;
			gbc_b1.weighty = 1;
			frame.getContentPane().add(b1, gbc_b1);

			JButton b2 = new JButton("7");
			GridBagConstraints gbc_b2 = new GridBagConstraints();
			gbc_b2.insets = new Insets(0, 0, 5, 5);
			gbc_b2.fill = GridBagConstraints.BOTH;
			gbc_b2.gridx = 0;
			gbc_b2.gridy = 1;
			gbc_b2.weightx = 1;
			gbc_b2.weighty = 1;
			frame.getContentPane().add(b2, gbc_b2);

			JButton b3 = new JButton("8");
			GridBagConstraints gbc_b3 = new GridBagConstraints();
			gbc_b3.insets = new Insets(0, 0, 5, 5);
			gbc_b3.fill = GridBagConstraints.BOTH;
			gbc_b3.gridx = 1;
			gbc_b3.gridy = 1;
			gbc_b3.weightx = 1;
			gbc_b3.weighty = 1;
			frame.getContentPane().add(b3, gbc_b3);

			JButton b4 = new JButton("9");
			GridBagConstraints gbc_b4 = new GridBagConstraints();
			gbc_b4.insets = new Insets(0, 0, 5, 5);
			gbc_b4.fill = GridBagConstraints.BOTH;
			gbc_b4.gridx = 2;
			gbc_b4.gridy = 1;
			gbc_b4.weightx = 1;
			gbc_b4.weighty = 1;
			frame.getContentPane().add(b4, gbc_b4);

			JButton b5 = new JButton("/");
			GridBagConstraints gbc_b5 = new GridBagConstraints();
			gbc_b5.insets = new Insets(0, 0, 5, 5);
			gbc_b5.fill = GridBagConstraints.BOTH;
			gbc_b5.gridx = 3;
			gbc_b5.gridy = 1;
			gbc_b5.weightx = 1;
			gbc_b5.weighty = 1;
			frame.getContentPane().add(b5, gbc_b5);
				
			JButton b6 = new JButton("sqrt");
			GridBagConstraints gbc_b6 = new GridBagConstraints();
			gbc_b6.insets = new Insets(0, 0, 5, 5);
			gbc_b6.fill = GridBagConstraints.BOTH;
			gbc_b6.gridx = 4;
			gbc_b6.gridy = 1;
			gbc_b6.weightx = 1;
			gbc_b6.weighty = 1;
			frame.getContentPane().add(b6, gbc_b6);

			JButton b7 = new JButton("4");
			GridBagConstraints gbc_b7 = new GridBagConstraints();
			gbc_b7.insets = new Insets(0, 0, 5, 5);
			gbc_b7.fill = GridBagConstraints.BOTH;
			gbc_b7.gridx = 0;
			gbc_b7.gridy = 2;
			gbc_b7.weightx = 1;
			gbc_b7.weighty = 1;
			frame.getContentPane().add(b7, gbc_b7);

			JButton b8 = new JButton("5");
			GridBagConstraints gbc_b8 = new GridBagConstraints();
			gbc_b8.insets = new Insets(0, 0, 5, 5);
			gbc_b8.fill = GridBagConstraints.BOTH;
			gbc_b8.gridx = 1;
			gbc_b8.gridy = 2;
			gbc_b8.weightx = 1;
			gbc_b8.weighty = 1;
			frame.getContentPane().add(b8, gbc_b8);

			JButton b9 = new JButton("6");
			GridBagConstraints gbc_b9 = new GridBagConstraints();
			gbc_b9.insets = new Insets(0, 0, 5, 5);
			gbc_b9.fill = GridBagConstraints.BOTH;
			gbc_b9.gridx = 2;
			gbc_b9.gridy = 2;
			gbc_b9.weightx = 1;
			gbc_b9.weighty = 1;
			frame.getContentPane().add(b9, gbc_b9);

			JButton b10 = new JButton("*");
			GridBagConstraints gbc_b10 = new GridBagConstraints();
			gbc_b10.insets = new Insets(0, 0, 5, 5);
			gbc_b10.fill = GridBagConstraints.BOTH;
			gbc_b10.gridx = 3;
			gbc_b10.gridy = 2;
			gbc_b10.weightx = 1;
			gbc_b10.weighty = 1;
			frame.getContentPane().add(b10, gbc_b10);

			JButton b11 = new JButton("%");
			GridBagConstraints gbc_b11 = new GridBagConstraints();
			gbc_b11.insets = new Insets(0, 0, 5, 5);
			gbc_b11.fill = GridBagConstraints.BOTH;
			gbc_b11.gridx = 4;
			gbc_b11.gridy = 2;
			gbc_b11.weightx = 1;
			gbc_b11.weighty = 1;
			frame.getContentPane().add(b11, gbc_b11);

			JButton b12 = new JButton("1");
			GridBagConstraints gbc_b12 = new GridBagConstraints();
			gbc_b12.insets = new Insets(0, 0, 5, 5);
			gbc_b12.fill = GridBagConstraints.BOTH;
			gbc_b12.gridx = 0;
			gbc_b12.gridy = 3;
			gbc_b12.weightx = 1;
			gbc_b12.weighty = 1;
			frame.getContentPane().add(b12, gbc_b12);

			JButton b13 = new JButton("2");
			GridBagConstraints gbc_b13 = new GridBagConstraints();
			gbc_b13.insets = new Insets(0, 0, 5, 5);
			gbc_b13.fill = GridBagConstraints.BOTH;
			gbc_b13.gridx = 1;
			gbc_b13.gridy = 3;
			gbc_b13.weightx = 1;
			gbc_b13.weighty = 1;
			frame.getContentPane().add(b13, gbc_b13);

			JButton b14 = new JButton("3");
			GridBagConstraints gbc_b14 = new GridBagConstraints();
			gbc_b14.insets = new Insets(0, 0, 5, 5);
			gbc_b14.fill = GridBagConstraints.BOTH;
			gbc_b14.gridx = 2;
			gbc_b14.gridy = 3;
			gbc_b14.weightx = 1;
			gbc_b14.weighty = 1;
			frame.getContentPane().add(b14, gbc_b14);

			JButton b15 = new JButton("-");
			GridBagConstraints gbc_b15 = new GridBagConstraints();
			gbc_b15.insets = new Insets(0, 0, 5, 5);
			gbc_b15.fill = GridBagConstraints.BOTH;
			gbc_b15.gridx = 3;
			gbc_b15.gridy = 3;
			gbc_b15.weightx = 1;
			gbc_b15.weighty = 1;
			frame.getContentPane().add(b15, gbc_b15);

			JButton b17 = new JButton("0");
			GridBagConstraints gbc_b17 = new GridBagConstraints();
			gbc_b17.insets = new Insets(0, 0, 5, 5);
			gbc_b17.fill = GridBagConstraints.BOTH;
			gbc_b17.gridx = 0;
			gbc_b17.gridy = 4;
			gbc_b17.weightx = 1;
			gbc_b17.weighty = 1;
			frame.getContentPane().add(b17, gbc_b17);

			JButton b18 = new JButton(".");
			GridBagConstraints gbc_b18 = new GridBagConstraints();
			gbc_b18.insets = new Insets(0, 0, 5, 5);
			gbc_b18.fill = GridBagConstraints.BOTH;
			gbc_b18.gridx = 1;
			gbc_b18.gridy = 4;
			gbc_b18.weightx = 1;
			gbc_b18.weighty = 1;
			frame.getContentPane().add(b18, gbc_b18);

			JButton b19 = new JButton("+/-");
			GridBagConstraints gbc_b19 = new GridBagConstraints();
			gbc_b19.insets = new Insets(0, 0, 5, 5);
			gbc_b19.fill = GridBagConstraints.BOTH;
			gbc_b19.gridx = 2;
			gbc_b19.gridy = 4;
			gbc_b19.weightx = 1;
			gbc_b19.weighty = 1;
			frame.getContentPane().add(b19, gbc_b19);

			JButton b20 = new JButton("+");
			GridBagConstraints gbc_b20 = new GridBagConstraints();
			gbc_b20.insets = new Insets(0, 0, 5, 5);
			gbc_b20.fill = GridBagConstraints.BOTH;
			gbc_b20.gridx = 3;
			gbc_b20.gridy = 4;
			gbc_b20.weightx = 1;
			gbc_b20.weighty = 1;
			frame.getContentPane().add(b20, gbc_b20);

			JButton b21 = new JButton("=");
			GridBagConstraints gbc_b21 = new GridBagConstraints();
			gbc_b21.insets = new Insets(0, 0, 5, 5);
			gbc_b21.fill = GridBagConstraints.BOTH;
			gbc_b21.gridx = 4;
			gbc_b21.gridy = 3;
			gbc_b21.gridheight = 2;
			frame.getContentPane().add(b21, gbc_b21);

		}
}