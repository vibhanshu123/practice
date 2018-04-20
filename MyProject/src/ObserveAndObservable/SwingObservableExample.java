package ObserveAndObservable;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingObservableExample {
	JFrame frame;
	
	public static void main(String[] args){
		SwingObservableExample ob=new SwingObservableExample();
		ob.go();
	}

	private void go() {
		frame=new JFrame();
		JButton but=new JButton("Should i do it?");
		but.addActionListener(new AngelListener());
		but.addActionListener(new DevilListener());
		frame.getContentPane().add(BorderLayout.CENTER,but);
	}
	
	class AngelListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("Dont do it, you might regret it");
			
		}
		
	}
	
	class DevilListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("comeon do it");
		}
		
	}

}
