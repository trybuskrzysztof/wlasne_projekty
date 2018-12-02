package Miner;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Miner {
	int state[][];
	int tick;
	void run() {
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new JFrame("Pierwszy Przycisk");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			state = new int [15][15];
			Container pane = frame.getContentPane();
			pane.setLayout(new GridLayout(15,15));
			state[0][0]=1; state[1][1]=1;
			for (int y=0; y<15; y++)
				for (int x=0; x<15; x++) {
					JButton btn = new JButton(" ");
					int X = x;
					int Y = y;
					btn.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							if(SwingUtilities.isRightMouseButton(e))
								btn.setText(btn.getText().equals(" ")?"M":" ");
							else
								if(btn.getText().equals(" ")) {
									if(state[Y][X]==1)
										btn.setText("!");
									else {
									int count = 0;
									for (int i = -1; i<= 1; i++)
										for(int j=-1; j<=1; j++)
											if(i+Y >=0 && i+Y <15)
												if(j+X >=0 && j+X <15 )
													if(state[i+Y][j+X]==1)
														count += 1;
									btn.setText(" "+count);
									}
								}
						}
					});
						pane.add(btn);
					}
			frame.setSize(900, 900);
			frame.setVisible(true);
		});
		}
	public static void main(String[] args) {
			new Miner().run();
		}
				
	}
