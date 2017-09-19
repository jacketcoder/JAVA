package FrontEnd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class chooseEncryptionMethod {
	JPanel panel ;
	 String selectedAlgo;
	 ShowEncryptionWindow _ShowEncryptionWindow;
	Box verticalBox ;
	String[] encryptionsAlgoNames;
	JFrame frame;
	 ButtonGroup _buttonGroup=new ButtonGroup();
		JRadioButton [] encryptionsAlgoRButtons;
		JButton button,exit; 
		public chooseEncryptionMethod(JFrame frame,String []EncAlgoNames) {
			this.frame=frame;
			panel=new JPanel();
			 encryptionsAlgoNames= EncAlgoNames;
			encryptionsAlgoRButtons=new JRadioButton[EncAlgoNames.length];
			verticalBox = Box.createVerticalBox();
			for(int index=0;index<EncAlgoNames.length;index++) {
				encryptionsAlgoRButtons[index]=new JRadioButton(EncAlgoNames[index]);
				encryptionsAlgoRButtons[index].setActionCommand(String.valueOf(index));
				_buttonGroup.add(encryptionsAlgoRButtons[index]);
				verticalBox.add(encryptionsAlgoRButtons[index]);
				if(index==0) {
					encryptionsAlgoRButtons[index].setSelected(true);
				}
			}
			
			button=new JButton("Next");
			 button.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					selectedAlgo=_buttonGroup.getSelection().getActionCommand();
					_ShowEncryptionWindow=new ShowEncryptionWindow(Integer.valueOf(selectedAlgo));
					System.out.println("Sending message"+" "+selectedAlgo);		
				}
	          });
			 verticalBox.add(button);
			 exit=new JButton("Exit");
			 verticalBox.add(exit);
			 exit.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
				}
	          });
			 panel.add(verticalBox);
		}
		public JPanel returnPanel() {
			return panel;
		}
		public String returnSelectedAlgo() {
			return selectedAlgo;
		}
}
