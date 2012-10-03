// Serial SMS Client for handling SMS communication with a mobile terminal
// (C) 2001 by Stefan Moscibroda

// class representing incoming SMS



import java.awt.*;
import java.awt.event.*;
import javax.comm.*;

/**
Informs the user that an other application has requested the port they
are using, and then asks if they are willing to give it up. If the user
answers "Yes" the port is closed and the dialog is closed, if the user
answers "No" the dialog closes and no other action is taken.
*/
public class PortRequestedDialog extends Dialog implements ActionListener {

    private Sms_GUI parent;
    private SmsTerminal term;

    /**
    Creates the a dialog with two buttons and a message asking the user if
    they are willing to give up the port they are using.

    @param parent The main SerialDemo object.
    */
    public PortRequestedDialog(Sms_GUI parent, SmsTerminal term) {
	super(parent, "Port Requested!", true);
	this.parent = parent;
        this.term = term;

	String lineOne = "Your port has been requested";
	String lineTwo = "by an other application.";
	String lineThree = "Do you want to give up your port?";
	Panel labelPanel = new Panel();
	labelPanel.setLayout(new GridLayout(3, 1));
	labelPanel.add(new Label(lineOne, Label.CENTER));
	labelPanel.add(new Label(lineTwo, Label.CENTER));
	labelPanel.add(new Label(lineThree, Label.CENTER));
	add(labelPanel, "Center");

	Panel buttonPanel = new Panel();
	Button yesButton = new Button("Yes");
	yesButton.addActionListener(this);
	buttonPanel.add(yesButton);
	Button noButton = new Button("No");
	noButton.addActionListener(this);
	buttonPanel.add(noButton);
	add(buttonPanel, "South");

	FontMetrics fm = getFontMetrics(getFont());
	int width = Math.max(fm.stringWidth(lineOne),
		 Math.max(fm.stringWidth(lineTwo), fm.stringWidth(lineThree)));

	setSize(width + 40, 150);
	setLocation(parent.getLocationOnScreen().x + 30,
		    parent.getLocationOnScreen().y + 30);
	setVisible(true);
    }

    /**
    Handles events generated by the buttons. If the yes button in pushed the
    port closing routine is called and the dialog is disposed of. If the "No"
    button is pushed the dialog is disposed of.
    */
    public void actionPerformed(ActionEvent e) {
	String cmd = e.getActionCommand();

	    if (cmd.equals("Yes")) {

               term.close();
	       parent.openButton.setEnabled(true);
	       parent.closeButton.setEnabled(false);
	    }

	    setVisible(false);
	    dispose();
    }
}
