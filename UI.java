package contact;
/**
 * @author Andrew-Lloyd Small
 */
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class UI extends JFrame implements ActionListener{
	
	/**
	 * temporary contact storage variable
	 */
	static Contact currentContact;
	
	//various buttons on panels
	static JButton log;
	static JButton submit;
	static JButton searchEntry;
	static JButton entryBack;
	static JButton entryMore;
	static JButton searchMail;
	static JButton entryBackk;
	static JButton entryMoree;
	static JButton sben;
	static JButton sbn;
	static JButton dbn;
	static JButton dbm;
	static JButton del;
	static JButton send;
	
	//menu items
	static JMenuItem create;
	static JMenuItem display;
	static JMenuItem sbe;
	static JMenuItem sbm;
	static JMenuItem change;
	static JMenuItem homeButton;
	
	//radio buttons
	static JRadioButton mm;
	static JRadioButton  ff;
	
	//main panels
	static JPanel loginScreen;
	static JPanel mainMenu;
	static JPanel createNewContact;
	static JPanel entryNumSearch;
	static JPanel mailSearch;
	static JPanel displayContacts;
	static JPanel deleteScreen;
	static JPanel changeScreen;
	
	// menu bar
	static JMenuBar menuBar;
	
	//panel buttons and fields
	static JTextField uname;
	static JPasswordField pass;
	//
	static JTextField fn;
	static JTextField ln;
	static JTextField a;
	static JTextField ad;
	static JTextField dob;
	//
	static JTextArea area;
	//
	static JTextField searchbar;
	static JTextArea info1;
	//
	static JTextField searchbarr;
	static JTextArea info2;
	//
	static JTextField tf;
	static JTextArea ta;
	//
	static JTextField cn;
	static JTextField ca;
	static JTextField cadd;
	static JTextField addp;
	static JTextField delp;
	static JTextField addMail;
	static JTextField delMail;
	
	
	
	public UI () {	
		/**
		 * frame
		 */
		this.setPreferredSize(new Dimension(900,550));
		this.setTitle("Address Book");
		
		/**
		 * panel holding login screen
		 */
		loginScreen = new JPanel();
		loginScreen.setPreferredSize(new Dimension(900,550));
		loginScreen.setLayout(new BorderLayout());
		JLabel instruction = new JLabel("Enter username and password");
		loginScreen.add(instruction, BorderLayout.PAGE_START);
		instruction.setAlignmentX(CENTER_ALIGNMENT);
		
		uname = new JTextField(15);
		JLabel username = new JLabel("Username");
		
		pass = new JPasswordField(15);
		JLabel password = new JLabel("Password");
		log = new JButton("Login");
		
		JPanel u = new JPanel();
		u.add(uname);
		u.add(username);
		JPanel p = new JPanel();
		p.add(pass);
		p.add(password);
		
		JPanel list = new JPanel();
		list.setLayout(new BoxLayout(list,BoxLayout.Y_AXIS));
		list.add(Box.createRigidArea(new Dimension(0,210)));
		list.add(u);
		list.add(p);
		list.add(log);
		list.add(Box.createRigidArea(new Dimension(0,250)));
		
		loginScreen.add(list, BorderLayout.CENTER);
		
		
		loginScreen.setVisible(true);
		
		
		/**
		 * panel displayed after valid username and password are entered
		 */
		mainMenu = new JPanel();
		mainMenu.setLayout(new BorderLayout());
		
		BufferedImage image;
		try {
			image = ImageIO.read(new File("src/contact/Menuicon.png"));
			JLabel imageLabel = new JLabel(new ImageIcon(image));
			mainMenu.add(imageLabel, BorderLayout.CENTER);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		
		
		/**
		 * menu bar and menu
		 */
		menuBar = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		create = new JMenuItem("Create new contact");
		display = new JMenuItem("Display contacts");
		sbe = new JMenuItem("Search contacts by entry number");
		sbm = new JMenuItem("Search contacts by email address");
		change = new JMenuItem("Edit contact information");
		homeButton = new JMenuItem ("Home Screen");
		
		menu.add(create);
		menu.addSeparator();
		menu.add(display);
		menu.addSeparator();
		menu.add(sbe);
		menu.add(sbm);
		menu.addSeparator();
		menu.add(change);
		menu.addSeparator();
		menu.add(homeButton);
		menuBar.add(menu);
		

		
		/**
		 * panel displayed if the new contact button is clicked
		 */
		createNewContact = new JPanel();
		createNewContact.setLayout(new BoxLayout(createNewContact, BoxLayout.PAGE_AXIS));
		createNewContact.setPreferredSize(new Dimension(900,550));
		
		JPanel v = new JPanel();
		fn = new JTextField(15);
		JLabel fname = new JLabel("Firstname");
		v.add(fname);
		v.add(fn);
		//
		ln = new JTextField(15);
		JLabel lname = new JLabel("Lastname");
		v.add(lname);
		v.add(ln);
		//
		JPanel w = new JPanel();
		JLabel male = new JLabel("Male");
		JLabel female = new JLabel("Female");
		mm = new JRadioButton();
		ff = new JRadioButton();
		JLabel gender = new JLabel("Gender");
		ButtonGroup buttons = new ButtonGroup();
		buttons.add(mm);
		buttons.add(ff);
		
		w.add(gender);
		w.add(Box.createRigidArea(new Dimension(120,0)));
		w.add(mm);
		w.add(male);
		w.add(ff);
		w.add(female);
		//
		JPanel x = new JPanel();
		a = new JTextField(30);
		JLabel alias = new JLabel("Alias");
		x.add(alias);
		x.add(a);
		//
		JPanel y = new JPanel();
		ad = new JTextField(30);
		JLabel address = new JLabel("Address (street number; street name; city; parish; country)");
		
		y.add(address);
		y.add(ad);
		//
		JPanel z = new JPanel();
		dob = new JTextField("YYYYMMDD",30);
		dob.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				dob.setText("");
			}
			public void focusLost(FocusEvent e) {
				if (dob.getText().length() <1) 
				dob.setText("YYYYMMDD");
			}
		});
		dob.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) { 
		        if (dob.getText().length() >= 8 ) // limit textfield to 8 characters
		            e.consume(); 
		    }  
		});
		//
		JLabel date = new JLabel("Date of Birth");
		z.add(date);
		z.add(dob);
		
		//
		submit = new JButton("Submit");
		//
		createNewContact.add(Box.createRigidArea(new Dimension(0,90)));
		createNewContact.add(v);
		createNewContact.add(w);
		createNewContact.add(x);
		createNewContact.add(y);
		createNewContact.add(z);
		createNewContact.add(Box.createRigidArea(new Dimension(0,45)));
		createNewContact.add(submit);
		createNewContact.add(Box.createRigidArea(new Dimension(0,45)));
		
		
		
		/**
		 * panel displayed if 'searchByEntry' (search contact by entry number) is clicked
		 */
		entryNumSearch = new JPanel();
		entryNumSearch.setLayout(new BoxLayout(entryNumSearch, BoxLayout.PAGE_AXIS));
		entryNumSearch.setPreferredSize(new Dimension(900,550));
		//
		JPanel searchPanel = new JPanel();
		searchbar = new JTextField(50);
		searchEntry = new JButton("Search");
		searchPanel.add(searchbar);
		searchPanel.add(searchEntry);
		//
		info1 = new JTextArea(500,350);
		info1.setEditable(false);
		//
		JPanel bottom = new JPanel();
		entryBack = new JButton("Back");
		entryMore = new JButton("Clear search");
		bottom.add(entryBack);
		bottom.add(entryMore);
		//
		entryNumSearch.add(Box.createRigidArea(new Dimension(0,10)));
		entryNumSearch.add(new JLabel("Search By Entry Number"));
		entryNumSearch.add(Box.createRigidArea(new Dimension(0,10)));
		entryNumSearch.add(searchPanel);
		entryNumSearch.add(Box.createRigidArea(new Dimension(0,25)));
		entryNumSearch.add(info1);
		entryNumSearch.add(Box.createRigidArea(new Dimension(0,25)));
		entryNumSearch.add(bottom);
		entryNumSearch.add(Box.createRigidArea(new Dimension(0,10)));
		
		
		
		/**
		 * panel displayed if 'searchByMail' (search contact by email address) is clicked
		 */
		mailSearch = new JPanel();
		mailSearch.setLayout(new BoxLayout(mailSearch, BoxLayout.PAGE_AXIS));
		mailSearch.setPreferredSize(new Dimension(900,550));
		//
		JPanel searchPanell = new JPanel();
		searchbarr = new JTextField(50);
		searchMail = new JButton("Search");
		searchPanell.add(searchbarr);
		searchPanell.add(searchMail);
		//
		info2 = new JTextArea(500,350);
		info2.setEditable(false);
		//
		JPanel bottomm = new JPanel();
		entryBackk = new JButton("Back");
		entryMoree = new JButton("Clear search");
		bottomm.add(entryBackk);
		bottomm.add(entryMoree);
		//
		mailSearch.add(Box.createRigidArea(new Dimension(0,10)));
		mailSearch.add(new JLabel("Search By Email"));
		mailSearch.add(searchPanell);
		mailSearch.add(Box.createRigidArea(new Dimension(0,25)));
		mailSearch.add(info2);
		mailSearch.add(Box.createRigidArea(new Dimension(0,25)));
		mailSearch.add(bottomm);
		mailSearch.add(Box.createRigidArea(new Dimension(0,10)));
		
		
		
		/**
		 * panel on which full list on contacts can be viewed
		 */
		displayContacts = new JPanel();
		displayContacts.setLayout(new BoxLayout(displayContacts, BoxLayout.PAGE_AXIS));
		//
		JLabel label = new JLabel("Contacts");
		JPanel buttonspanel = new JPanel();
		sben = new JButton("Sort by entry number");
		sbn = new JButton("Sort by name");
		buttonspanel.add(sben);
		buttonspanel.add(sbn);
		//
		area = new JTextArea();
		area.setSize(500, 300);
		
		//
		displayContacts.add(Box.createRigidArea(new Dimension(0,10)));
		displayContacts.add(label);
		displayContacts.add(Box.createRigidArea(new Dimension(0,18)));
		displayContacts.add(buttonspanel);
		displayContacts.add(Box.createRigidArea(new Dimension(0,25)));
		displayContacts.add(area);
		displayContacts.add(Box.createRigidArea(new Dimension(0,30)));
		
		
		
		/**
		 * panel from which contacts may be deleted
		 */
		deleteScreen = new JPanel();
		deleteScreen.setLayout(new BoxLayout(deleteScreen,BoxLayout.PAGE_AXIS));
		JPanel top = new JPanel();
		JPanel mid = new JPanel();
		tf = new JTextField(40);
		dbn = new JButton("Find by entry number");
		dbm = new JButton("Find by email address");
		top.add(dbn);
		top.add(dbm);
		top.add(Box.createRigidArea(new Dimension(5,0)));
		top.add(tf);
		del = new JButton("Delete");
		mid.add(del);
		deleteScreen.add(Box.createRigidArea(new Dimension(0,5)));
		deleteScreen.add(top);
		deleteScreen.add(mid);
		mid.setAlignmentX(LEFT_ALIGNMENT);
		deleteScreen.add(Box.createRigidArea(new Dimension(0,5)));
		ta = new JTextArea();
		ta.setEditable(false);
		deleteScreen.add(ta);
		deleteScreen.add(Box.createRigidArea(new Dimension(0,25)));
		
		
		
		/**
		 * panel on which changes are made
		 */
		changeScreen = new JPanel();
		changeScreen.setLayout(new BoxLayout(changeScreen,BoxLayout.PAGE_AXIS));
		//
		JLabel instruct = new JLabel("Enter attributes you would like to change");
		JLabel changeLName = new JLabel("Change last name");
		cn = new JTextField(20);
		JPanel namechange = new JPanel();
		namechange.add(cn);
		cn.setAlignmentX(LEFT_ALIGNMENT);
		namechange.add(changeLName);
		
		JLabel changeAlias = new JLabel ("Change alias");
		ca = new JTextField(20);
		JPanel aliaschange = new JPanel();
		aliaschange.add(ca);
		aliaschange.add(changeAlias);
		
		JLabel changeAddress = new JLabel("Change address");
		cadd = new JTextField(20);
		JPanel addresschange = new JPanel();
		addresschange.add(cadd);
		addresschange.add(changeAddress);
		
		JLabel addPhone = new JLabel("Add phone number");
		addp = new JTextField(20);
		JPanel phone = new JPanel();
		phone.add(addp);
		phone.add(addPhone);
		
		JLabel delPhone = new JLabel("Delete phone number");
		delp = new JTextField(20);
		JPanel dphone = new JPanel();
		dphone.add(delp);
		dphone.add(delPhone);
		
		JLabel addEmail = new JLabel("Add Email address");
		addMail = new JTextField(20);
		JPanel mail = new JPanel();
		mail.add(addMail);
		mail.add(addEmail);
		
		JLabel dmail = new JLabel("Delete Email");
		delMail = new JTextField(20);
		JPanel ddmail = new JPanel();
		ddmail.add(delMail);
		ddmail.add(dmail);
		
		send = new JButton("Submit");
		
		changeScreen.add(Box.createRigidArea(new Dimension(0,15)));
		changeScreen.add(instruct);
		instruct.setAlignmentX(CENTER_ALIGNMENT);
		changeScreen.add(Box.createRigidArea(new Dimension(0,30)));
		changeScreen.add(namechange);
		changeScreen.add(aliaschange);
		changeScreen.add(addresschange);
		changeScreen.add(phone);
		changeScreen.add(dphone);
		changeScreen.add(mail);
		changeScreen.add(ddmail);
		changeScreen.add(Box.createRigidArea(new Dimension(0,20)));
		changeScreen.add(send);
		changeScreen.add(Box.createRigidArea(new Dimension(0,30)));
		
		
		
		this.getContentPane().add(loginScreen);
		
		//buttons on all panels
		log.addActionListener(this);
		submit.addActionListener(this);
		searchEntry.addActionListener(this);
		entryBack.addActionListener(this);
		entryMore.addActionListener(this);
		searchMail.addActionListener(this);
		entryBackk.addActionListener(this);
		entryMoree.addActionListener(this);
		sben.addActionListener(this);
		sbn.addActionListener(this);
		dbn.addActionListener(this);
		dbm.addActionListener(this);
		del.addActionListener(this);
		send.addActionListener(this);
		
		//
		//menu buttons
		create.addActionListener(this);
		display.addActionListener(this);
		sbe.addActionListener(this);
		sbm.addActionListener(this);
		change.addActionListener(this);
	}
	
	
	public static void createAndShowGUI() {
		JFrame frame = new UI();
		
		frame.pack();
		frame.setVisible(true);	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == log){
			if (uname.getText().equals("") || pass.getText().equals("")){
				JOptionPane.showMessageDialog(loginScreen, "Please fill both fields");
			}else{
			if ((!(uname.getText()).equals(DataManager.getLogin(0))) ||
					(!(pass.getText().equals(DataManager.getLogin(1))))){
				JOptionPane.showMessageDialog(loginScreen, "Incorrect username or password");
			}else{
				loginScreen.setVisible(false);
				this.getContentPane().add(mainMenu);
				this.setJMenuBar(menuBar);
			}
		}}
		
		if (e.getSource() == create){
			mainMenu.setVisible(false);
			entryNumSearch.setVisible(false);
			mailSearch.setVisible(false);
			displayContacts.setVisible(false);
			deleteScreen.setVisible(false);
			changeScreen.setVisible(false);
			this.getContentPane().add(createNewContact);
			createNewContact.setVisible(true);
		}
		
		if (e.getSource() == display){
			createNewContact.setVisible(false);
			mainMenu.setVisible(false);
			entryNumSearch.setVisible(false);
			mailSearch.setVisible(false);
			deleteScreen.setVisible(false);
			changeScreen.setVisible(false);
			this.getContentPane().add(displayContacts);
			displayContacts.setVisible(true);
			area.setEditable(true);
			area.setText(DataManager.showContacts());
			area.setEditable(false);
			
		}
		
		if (e.getSource() == sbe){
			mainMenu.setVisible(false);
			createNewContact.setVisible(false);
			displayContacts.setVisible(false);
			mailSearch.setVisible(false);
			deleteScreen.setVisible(false);
			changeScreen.setVisible(false);
			this.getContentPane().add(entryNumSearch);
			entryNumSearch.setVisible(true);
		}
		
		if (e.getSource() == sbm){
			mainMenu.setVisible(false);
			createNewContact.setVisible(false);
			displayContacts.setVisible(false);
			entryNumSearch.setVisible(false);
			deleteScreen.setVisible(false);
			changeScreen.setVisible(false);
			this.getContentPane().add(mailSearch);
			mailSearch.setVisible(true);
		}
		
		if (e.getSource() == change){
			mainMenu.setVisible(false);
			createNewContact.setVisible(false);
			displayContacts.setVisible(false);
			entryNumSearch.setVisible(false);
			deleteScreen.setVisible(false);
			mailSearch.setVisible(false);
			this.getContentPane().add(changeScreen);
			changeScreen.setVisible(true);
		}
		
		if (e.getSource() == submit){
			if ((!(fn.equals("")) && !(ln.equals("")) && !(a.equals("")) && !(ad.equals("")) && !(dob.equals("YYYYMMDD"))
					&& dob.getText().length() == 8) &&(mm.isSelected() || ff.isSelected())){
					//create and add new contact to list
				if (ff.isSelected()){
					currentContact = new Contact(fn.getText(),ln.getText(),Gender.FEMALE,Integer.parseInt((dob.getText())));
					DataManager.contactsLiteral.add(currentContact);
				}else{
					if (mm.isSelected())
					currentContact = new Contact(fn.getText(),ln.getText(),Gender.MALE,Integer.parseInt((dob.getText()))); 
					DataManager.contactsLiteral.add(currentContact);
				}
				DataManager.writeToFile(currentContact.toString());
				JOptionPane.showMessageDialog(createNewContact, "Contact has been added");
				fn.setText("");
				ln.setText("");
				a.setText("");
				ad.setText("");
				//
				//
				ff.setSelected(false);
				mm.setSelected(false);
				//
				//
				dob.setText("YYYYMMDD");
			}else{
				JOptionPane.showMessageDialog(createNewContact, "Please fill all fields");
			}
		}
		
		if (e.getSource() == searchEntry){
			if (searchbar.equals("")){
				JOptionPane.showMessageDialog(entryNumSearch, "Please enter an entry number");
			}else{
			//	if (searchbar.getText() == );
			}
		}
		
		
	}
	
		
}
