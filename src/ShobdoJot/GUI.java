package ShobdoJot;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class GUI extends main_class implements ActionListener{
	
	Container c;
	char[] ch = {'\u09BE','\u09BF','\u09C0','\u09C1','\u09C2','\u09C3','\u09C7','\u09C8','\u09CB','\u09CC','\u0981'} ;
	String  x[]={"ক","খ","গ","ঘ","ঙ","চ","ছ","জ","ঝ","ঞ","ট","ঠ","ড","ঢ","ণ","ত","থ","দ","ধ",
			"ন","প","ফ","ব","ভ","ম","য","র","ল","শ","ষ","স","হ","ড়","ঢ়","য়","ং","ঃ","্‌",
			"অ","আ","ই","ঈ","উ","ঊ","ঋ","এ","ঐ","ও","ঔ","BackSpace","ৎ"};
	JButton[] karbutton = new JButton[11];
	JButton[] lbuttons = new JButton[51];
	JLabel[] labels = new JLabel[26];
	JButton[] hintlabel = new JButton[4];
	JButton ok = new JButton();
	JButton rest = new JButton();
	JTextField tf = new JTextField();
	
	private final static Color yellow = new Color(198, 180, 102);   
    private final static Color gray = new Color(121, 124, 126);   
    private final static Color green = new Color(121, 167, 107);   
    private final static Color lightGray = new Color(212, 214, 218); 
    
    Border border = BorderFactory.createLineBorder(lightGray, 4);
    Font f = new Font("kalpurush",Font.BOLD,17);
    
    ArrayList<String> list = new ArrayList<>();
    ArrayList<String> list2 = new ArrayList<>();
    BufferedReader b,dict;
    String w;
    
    JTextField tf1 = new JTextField();
	
    int isExist;
    int win = 0;
    int isremove = 0;
    String s1,s2 = "",s3= "",s4 = "";
    int ind0 = 0,ind1 = 1,ind2 = 2,ind3 = 3;
    int cnt = 0;
    int i,j;
    int karflag = 0;
    int flag = 0;
    int step = 0; 
    String me = "";
    int hint_checked = 0;
    
    
    GUI(){
		setTitle("শব্দজট by Rafi");
		setSize(600,850);
		setLocationRelativeTo(null);  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		setVisible(true);
		c = this.getContentPane();
		
		wordgen();
		boxes();
		buttons();
		hints();
		action_on_ok();
		restart();
		
		
		
	
	}
	
    void boxes() {
		
		int l=50,t=80,w = 50,h =50;
		

		for(int i = 0; i < 24; i++) {
			labels[i] = new JLabel();
			labels[i].setFont(f);
			labels[i].setBorder(border);
	        //setHorizontalAlignment(JLabel.CENTER);
	        //setVerticalAlignment(JLabel.CENTER);    
			labels[i].setOpaque(true);  
			labels[i].setForeground(Color.BLACK);
			labels[i].setBackground(Color.WHITE);
			
			if(i>=0 && i<=3) {
				l += 55;
				t = 80;
			}
			if(i>= 4 && i <= 7) {
				l += 55;
				t = 135;
			}
			if(i >= 8 && i<= 11) {
				l += 55;
				t = 190;
			}
			if(i >= 12 && i<= 15) {
				l += 55;
				t = 245;
			}
			if(i >= 16 && i<= 19) {
				l += 55;
				t = 300;
			}
			if(i == 0 || i == 4 || i == 8 || i == 12 || i == 16) l = 50;
			
			labels[i].setBounds(l,t,w,h);
	        c.add(labels[i]);
	        
	        
		}
		
		JLabel heading = new JLabel();
		
		heading.setBounds(220,18,150,60);
		heading.setText("শব্দজট");
		heading.setFont(new Font("kalpurush",Font.BOLD,50));
		heading.setForeground(green);
		heading.setOpaque(true);
		c.add(heading);
		
		
        
	}
    
    
    int is_word_in_dict() {
    	//C:\\Users\\Rafi\\Downloads\\BengaliWordList_48.txt
    	
    	try {
    		dict = new BufferedReader(new FileReader("BengaliWordList_48.txt"));
    		String temp2 = dict.readLine();
    		while(temp2 != null) {
    			list2.add(temp2);
    			temp2 = dict.readLine();
    		}
    		
    		String s = labels[ind0].getText() + labels[ind1].getText() + labels[ind2].getText() + labels[ind3].getText() ;

    		
    		
    		for(String word : list2) {
    			if(word.equals(s)) {
    				isExist = 1;
    			}
    		}
    		
    		
    	}
    	catch(Exception e) {
    		
    	}
    	return isExist;
    	
    }

    void wordgen() {
//		
		try {
			
			b = new BufferedReader(new FileReader("C:\\Users\\Rafi\\OneDrive\\Documents\\dict.txt"));
			String temp = b.readLine();
			while(temp != null) {
				list.add(temp);
				temp = b.readLine();
			}
		
			Random random = new Random();
			w = list.get(random.nextInt(list.size()));
			
			
			String line;
            while ((line = dict.readLine()) != null) {
                System.out.println(line);
            }
			
			
		}
		catch(Exception e) {
			
		}
	}
	
	
	void buttons() {
		
		int m = 10,n = 450,o = 50,p=50;
		
		for( j = 0;j<11;j++) {
			karbutton[j] = new JButton();
			karbutton[j].setFont(f);
			karbutton[j].setBackground(gray);
			karbutton[j].setText(Character.toString(ch[j]));
			if(j>=0 && j<=10) {
				m += 50;
			}
			if(j == 0) m =10;
			karbutton[j].setBounds(m,n,o,p);
			c.add(karbutton[j]);
			
			karbutton[j].addActionListener(this);
			
		}
		
		
		int left = 10 ,top = 500 ,width = 50, height =50;
		
		
		for( i = 0; i <= 50; i++) {
			lbuttons[i] = new JButton();
			lbuttons[i].setBackground(gray);
			if(i >= 1 && i<= 10) {
				left += 50;
				top = 500;
			}
			if(i >= 11 && i<=21) {
				left += 50;
				top = 550;
			}
			if(i >= 22 && i<=32) {
				left += 50;
				top = 600;
			}
			
			if(i >= 33 && i<=43) {
				left += 50;
				top = 650;
			}
			if(i >= 44 && i<= 50) {
				left += 50;
				top = 700;
			}
			
			if(i == 0 || i == 11 || i == 22 || i == 33 || i == 44) left = 10;
			if(i == 49) {width = 150;left = 310;}
			if(i == 50) {left = 260;width = 50;}
			lbuttons[i].setBounds(left,top,width,height);
			lbuttons[i].setText(x[i]);
			lbuttons[i].setFont(f);
			c.add(lbuttons[i]);
			
			lbuttons[i].addActionListener(this);
			
			
		}
		
		ok.setBounds(420,260,100,30);
		ok.setText("Enter");
		ok.setBackground(gray);
		c.add(ok);
		
		rest.setBounds(420,200,150,50);
		rest.setFont(new Font("kalpurush",Font.BOLD,15));
		rest.setText("পুনরায় শুরু");
		rest.setOpaque(true);  
		rest.setForeground(Color.BLACK);
		rest.setBackground(gray);
		
		c.add(rest);
		
	}

	
	
	void wordCheck() {
		
//		String ss = Character.toString(w.charAt(0));
//		
//		
//		for(int i = 1;i<w.length();i++) {
//			if(w.charAt(i) == ch[0]  || w.charAt(i) == ch[1] || w.charAt(i) == ch[2] || w.charAt(i) == ch[3] || w.charAt(i) == ch[4] || w.charAt(i) == ch[5] || w.charAt(i) == ch[6] || w.charAt(i) == ch[7] || w.charAt(i) == ch[8] || w.charAt(i) == ch[9]) {
//				continue;
//			}
//			if(w.charAt(i) == '\u09CD') {
//				i++;
//				continue;
//			}
//			else {
//				ss += Character.toString(w.charAt(i));
//			}
//		}
		
		//String s1,s2 = "",s3= "",s4 = "";
		
		s1 = Character.toString(w.charAt(0));
		int k = 0;
		for(int i = 1;i<w.length();) {
			if(k == 0) {
			if(w.charAt(i) == '\u09CD') {
				if(w.charAt(i+2) == '\u09BE' || w.charAt(i+2) == '\u09BF' || w.charAt(i+2) == '\u09C0' || w.charAt(i+2) == '\u09C1' || w.charAt(i+2) == '\u09C2' || w.charAt(i+2) == '\u09C3' || w.charAt(i+2) == '\u09C7' || w.charAt(i+2) == '\u09C8' || w.charAt(i+2) == '\u09CB' || w.charAt(i+2) == '\u09D7' || w.charAt(i+2) == '\u0981' || w.charAt(i+2) == '\u0982' || w.charAt(i+2) == '\u0983'  ) {
					s1 += Character.toString(w.charAt(i)) + Character.toString(w.charAt(i+1)) + Character.toString(w.charAt(i+2));
					i+= 3;
					//System.out.println("true of if 1");
				}
				else {
					s1 += Character.toString(w.charAt(i)) + Character.toString(w.charAt(i+1));
					i+=2;
					}
				
				}
			else if(w.charAt(i) == '\u09BE' || w.charAt(i) == '\u09BF' || w.charAt(i) == '\u09C0' || w.charAt(i) == '\u09C1' || w.charAt(i) == '\u09C2' || w.charAt(i) == '\u09C3' || w.charAt(i) == '\u09C7' || w.charAt(i) == '\u09C8' || w.charAt(i) == '\u09CB' || w.charAt(i) == '\u09D7'  ) {
					s1 += Character.toString(w.charAt(i));
					i++;
				}
			else {
				//continue;
				//i++;
			}
			k++;
			}
			//System.out.println(i + " " + k);
			if(k == 1) {
				s2 = Character.toString(w.charAt(i));
				if(w.charAt(i+1) == '\u09CD') {
					if(w.charAt(i+3) == '\u09BE' || w.charAt(i+3) == '\u09BF' || w.charAt(i+3) == '\u09C0' || w.charAt(i+3) == '\u09C1' || w.charAt(i+3) == '\u09C2' || w.charAt(i+3) == '\u09C3' || w.charAt(i+3) == '\u09C7' || w.charAt(i+3) == '\u09C8' || w.charAt(i+3) == '\u09CB' || w.charAt(i+3) == '\u09D7' || w.charAt(i+3) == '\u0981' || w.charAt(i+3) == '\u0982' || w.charAt(i+3) == '\u0983'  ) {
						s2 += Character.toString(w.charAt(i+1)) + Character.toString(w.charAt(i+2)) + Character.toString(w.charAt(i+3));
						i+= 4;
						//System.out.println("true of if 1");
					}
					else {
						s2 += Character.toString(w.charAt(i+1)) + Character.toString(w.charAt(i+2));
						i+=3;
						}
					
					}
				else if(w.charAt(i+1) == '\u09BE' || w.charAt(i+1) == '\u09BF' || w.charAt(i+1) == '\u09C0' || w.charAt(i+1) == '\u09C1' || w.charAt(i+1) == '\u09C2' || w.charAt(i+1) == '\u09C3' || w.charAt(i+1) == '\u09C7' || w.charAt(i+1) == '\u09C8' || w.charAt(i+1) == '\u09CB' || w.charAt(i+1) == '\u09D7'  ) {
						s2 += Character.toString(w.charAt(i+1));
						i += 2;
					}
				else {
					i++;//continue;
				}
				k++;
				}
			//System.out.println(i + " " + k);
			
			if(k == 2) {
				s3 = Character.toString(w.charAt(i));
				if(w.charAt(i+1) == '\u09CD') {
					if(w.charAt(i+3) == '\u09BE' || w.charAt(i+3) == '\u09BF' || w.charAt(i+3) == '\u09C0' || w.charAt(i+3) == '\u09C1' || w.charAt(i+3) == '\u09C2' || w.charAt(i+3) == '\u09C3' || w.charAt(i+3) == '\u09C7' || w.charAt(i+3) == '\u09C8' || w.charAt(i+3) == '\u09CB' || w.charAt(i+3) == '\u09D7' || w.charAt(i+3) == '\u0981' || w.charAt(i+3) == '\u0982' || w.charAt(i+3) == '\u0983'  ) {
						s3 += Character.toString(w.charAt(i+1)) + Character.toString(w.charAt(i+2)) + Character.toString(w.charAt(i+3));
						i+= 4;
						System.out.println("true of if 1");
					}
					else {
						s3 += Character.toString(w.charAt(i+1)) + Character.toString(w.charAt(i+2));
						i+=3;
						}
					
					}
				else if(w.charAt(i+1) == '\u09BE' || w.charAt(i+1) == '\u09BF' || w.charAt(i+1) == '\u09C0' || w.charAt(i+1) == '\u09C1' || w.charAt(i+1) == '\u09C2' || w.charAt(i+1) == '\u09C3' || w.charAt(i+1) == '\u09C7' || w.charAt(i+1) == '\u09C8' || w.charAt(i+1) == '\u09CB' || w.charAt(i+1) == '\u09D7'  ) {
						s3 += Character.toString(w.charAt(i+1));
						i+= 2;
					}
				else {
					i++;//continue;
				}
				k++;
				}
			//System.out.println(i + " " + k);
			if(k == 3) {
				s4 = Character.toString(w.charAt(i));
				if(i == w.length()-1) break;
				else if(w.charAt(i+1) == '\u09CD') {
					if(w.charAt(i+3) == '\u09BE' || w.charAt(i+3) == '\u09BF' || w.charAt(i+3) == '\u09C0' || w.charAt(i+3) == '\u09C1' || w.charAt(i+3) == '\u09C2' || w.charAt(i+3) == '\u09C3' || w.charAt(i+3) == '\u09C7' || w.charAt(i+3) == '\u09C8' || w.charAt(i+3) == '\u09CB' || w.charAt(i+3) == '\u09D7' || w.charAt(i+3) == '\u0981' || w.charAt(i+3) == '\u0982' || w.charAt(i+3) == '\u0983'  ) {
						s4 += Character.toString(w.charAt(i+1)) + Character.toString(w.charAt(i+2)) + Character.toString(w.charAt(i+3));
						i+= 4;
						//System.out.println("true of if 1");
					}
					else {
						s4 += Character.toString(w.charAt(i+1)) + Character.toString(w.charAt(i+2));
						i+=3;
						}
					
					}
				else if(w.charAt(i+1) == '\u09BE' || w.charAt(i+1) == '\u09BF' || w.charAt(i+1) == '\u09C0' || w.charAt(i+1) == '\u09C1' || w.charAt(i+1) == '\u09C2' || w.charAt(i+1) == '\u09C3' || w.charAt(i+1) == '\u09C7' || w.charAt(i+1) == '\u09C8' || w.charAt(i+1) == '\u09CB' || w.charAt(i+1) == '\u09D7'  ) {
						s4 += Character.toString(w.charAt(i+1));
						i += 2;
					}
				else {
					i++;
					//continue;
				}
				k++;
				}
			
		}
		
//		char s1,s2,s3,s4;
//		s1 = (ss.charAt(0));
//		s2 = (ss.charAt(1));
//		s3 = (ss.charAt(2));
//		s4 = (ss.charAt(3));
		
		//System.out.println(s1 + s2 + s3 + s4);
		//tf1.setText(s1 + " " + s2 + " " + s3 + " " + s4);
		
		//System.out.println(ind0 + " " + ind1 + " " + ind2);
		
		int koytahoiche = 0;
		
		tf1.setText(labels[0].getText() + labels[1].getText() + labels[2].getText());
		
		
		if(labels[ind0].getText().equals(s1)) {
			labels[ind0].setBackground(green);
			koytahoiche++;
		}
		else if(labels[ind0].getText().equals(s2)  || labels[ind0].getText().equals(s3) || labels[ind0].getText().equals(s4)) {
			labels[ind0].setBackground(yellow);
		}
		else {
			labels[ind0].setBackground(gray);
		}
		if(labels[ind1].getText().equals(s2)) {
			labels[ind1].setBackground(green);
			koytahoiche++;
		}
		else if(labels[ind1].getText().equals(s1) || labels[ind1].getText().equals(s3)  || labels[ind1].getText().equals(s4)) {
			labels[ind1].setBackground(yellow);
		}
		else {
			labels[ind1].setBackground(gray);
		}
		if(labels[ind2].getText().equals(s3) ) {
			labels[ind2].setBackground(green);
			koytahoiche++;
		}
		else if(labels[ind2].getText().equals(s1)  || labels[ind2].getText().equals(s2) || labels[ind2].getText().equals(s4)) {
			labels[ind2].setBackground(yellow);
		}
		else {
			labels[ind2].setBackground(gray);
		}
		
		if(labels[ind3].getText().equals(s4)) {
			labels[ind3].setBackground(green);
			koytahoiche++;
		}
		else if(labels[ind3].getText().equals(s1) || labels[ind3].getText().equals(s2) || labels[ind3].getText().equals(s3)) {
			labels[ind3].setBackground(yellow);
		}
		else {
			labels[ind3].setBackground(gray);
		}
		
		if(koytahoiche == 4) win = 1;
		
	}

	void restart() {
		
		
		rest.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				for(int i = 0;i<20;i++) {
					labels[i].setText("");
					labels[i].setBackground(Color.white);
					}
				
				 
				     win = 0;
				     isremove = 0;
				     s1 = "";s2 = "";s3= "";s4 = "";
				     ind0 = 0;ind1 = 1;ind2 = 2;ind3 = 3;
				     cnt = 0;

				     karflag = 0;
				     flag = 0;
				     step = 0; 
				     me = "";
				     wordgen();
				     is_word_in_dict();
				     tf.setText("");
				
				
				
				
				
			}
			
		});
	}

	public void actionPerformed(ActionEvent e) {
		
	if(cnt == 0) {	
		//karflag = 0;
		
		if(e.getSource() == karbutton[0]) cnt--;
		if(e.getSource() == karbutton[1]) cnt--;
		if(e.getSource() == karbutton[2]) cnt--;
		if(e.getSource() == karbutton[3]) cnt--;
		if(e.getSource() == karbutton[4]) cnt--;
		if(e.getSource() == karbutton[5]) cnt--;
		if(e.getSource() == karbutton[6]) cnt--;
		if(e.getSource() == karbutton[7]) cnt--;
		if(e.getSource() == karbutton[8]) cnt--;
		if(e.getSource() == karbutton[9]) cnt--;
		if(e.getSource() == karbutton[10])cnt--;
		
		
		if(e.getSource() == lbuttons[0]) labels[ind0].setText(x[0]);
		if(e.getSource() == lbuttons[1]) labels[ind0].setText(x[1]);
		if(e.getSource() == lbuttons[2]) labels[ind0].setText(x[2]);
		if(e.getSource() == lbuttons[3]) labels[ind0].setText(x[3]);
		if(e.getSource() == lbuttons[4]) cnt--;
		if(e.getSource() == lbuttons[5]) labels[ind0].setText(x[5]);
		if(e.getSource() == lbuttons[6]) labels[ind0].setText(x[6]);
		if(e.getSource() == lbuttons[7]) labels[ind0].setText(x[7]);
		if(e.getSource() == lbuttons[8]) labels[ind0].setText(x[8]);
		if(e.getSource() == lbuttons[9]) cnt--;
		if(e.getSource() == lbuttons[10])labels[ind0].setText(x[10]);
		if(e.getSource() == lbuttons[11])labels[ind0].setText(x[11]);
		if(e.getSource() == lbuttons[12])labels[ind0].setText(x[12]);
		if(e.getSource() == lbuttons[13])labels[ind0].setText(x[13]);
		if(e.getSource() == lbuttons[14])labels[ind0].setText(x[14]);
		if(e.getSource() == lbuttons[15])labels[ind0].setText(x[15]);
		if(e.getSource() == lbuttons[16])labels[ind0].setText(x[16]);
		if(e.getSource() == lbuttons[17])labels[ind0].setText(x[17]);
		if(e.getSource() == lbuttons[18])labels[ind0].setText(x[18]);
		if(e.getSource() == lbuttons[19])labels[ind0].setText(x[19]);
		if(e.getSource() == lbuttons[20])labels[ind0].setText(x[20]);
		if(e.getSource() == lbuttons[21])labels[ind0].setText(x[21]);
		if(e.getSource() == lbuttons[22])labels[ind0].setText(x[22]);
		if(e.getSource() == lbuttons[23])labels[ind0].setText(x[23]);
		if(e.getSource() == lbuttons[24])labels[ind0].setText(x[24]);
		if(e.getSource() == lbuttons[25])labels[ind0].setText(x[25]);
		if(e.getSource() == lbuttons[26])labels[ind0].setText(x[26]);
		if(e.getSource() == lbuttons[27])labels[ind0].setText(x[27]);
		if(e.getSource() == lbuttons[28])labels[ind0].setText(x[28]);
		if(e.getSource() == lbuttons[29])labels[ind0].setText(x[29]);
		if(e.getSource() == lbuttons[30])labels[ind0].setText(x[30]);
		if(e.getSource() == lbuttons[31])labels[ind0].setText(x[31]);
		if(e.getSource() == lbuttons[32])labels[ind0].setText(x[32]);
		if(e.getSource() == lbuttons[33])labels[ind0].setText(x[33]);
		if(e.getSource() == lbuttons[34])labels[ind0].setText(x[34]);
		if(e.getSource() == lbuttons[35]) cnt--;
		if(e.getSource() == lbuttons[36]) cnt--;
		if(e.getSource() == lbuttons[37]) cnt--;
		if(e.getSource() == lbuttons[38])labels[ind0].setText(x[38]);
		if(e.getSource() == lbuttons[39])labels[ind0].setText(x[39]);
		if(e.getSource() == lbuttons[40])labels[ind0].setText(x[40]);
		if(e.getSource() == lbuttons[41])labels[ind0].setText(x[41]);
		if(e.getSource() == lbuttons[42])labels[ind0].setText(x[42]);
		if(e.getSource() == lbuttons[43])labels[ind0].setText(x[43]);
		if(e.getSource() == lbuttons[44])labels[ind0].setText(x[44]);
		if(e.getSource() == lbuttons[45])labels[ind0].setText(x[45]);
		if(e.getSource() == lbuttons[46])labels[ind0].setText(x[46]);
		if(e.getSource() == lbuttons[47])labels[ind0].setText(x[47]);
		if(e.getSource() == lbuttons[48])labels[ind0].setText(x[48]);
		
		if(e.getSource() == lbuttons[49]) {
			labels[ind0].setText(" ");
			cnt--;
		}
		
	}
	if(cnt == 1) {
		//if(karflag == 0) {
		if(e.getSource() == karbutton[0]) {
			String s = labels[ind0].getText();labels[ind0].setText(s+Character.toString(ch[0])); cnt--; karflag = 1; 
		}
		
		if(e.getSource() == karbutton[1]) {
			String s = labels[ind0].getText();labels[ind0].setText(s+Character.toString(ch[1])); cnt--; karflag = 1;
		}
		if(e.getSource() == karbutton[2]) {
			String s = labels[ind0].getText();labels[ind0].setText(s+Character.toString(ch[2])); cnt--; karflag = 1;
		}
		if(e.getSource() == karbutton[3]) {
			String s = labels[ind0].getText();labels[ind0].setText(s+Character.toString(ch[3])); cnt--; karflag = 1;
		}
		if(e.getSource() == karbutton[4]) {
			String s = labels[ind0].getText();labels[ind0].setText(s+Character.toString(ch[4])); cnt--; karflag = 1;
		}
		if(e.getSource() == karbutton[5]) {
			String s = labels[ind0].getText();labels[ind0].setText(s+Character.toString(ch[5])); cnt--; karflag = 1;
		}
		if(e.getSource() == karbutton[6]) {
			String s = labels[ind0].getText();labels[ind0].setText(s+Character.toString(ch[6])); cnt--; karflag = 1;
		}
		if(e.getSource() == karbutton[7]) {
			String s = labels[ind0].getText();labels[ind0].setText(s+Character.toString(ch[7])); cnt--; karflag = 1;
		}
		if(e.getSource() == karbutton[8]) {
			String s = labels[ind0].getText();labels[ind0].setText(s+Character.toString(ch[8])); cnt--; karflag = 1;
		}
		if(e.getSource() == karbutton[9]) {
			String s = labels[ind0].getText();labels[ind0].setText(s+Character.toString(ch[9])); cnt--; karflag = 1;
		}
		
		//}
		if(e.getSource() == karbutton[10]) {
			String s = labels[ind0].getText();labels[ind0].setText(s+Character.toString(ch[10])); cnt--; karflag = 0;
		}
		
			if(e.getSource() == lbuttons[0]) {
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); 
					labels[ind0].setText(t.append(labels[ind0].getText().charAt(0)).append("্").append(x[0]).toString());
					flag = 0; cnt--;
					
				}
				else labels[ind1].setText(x[0]);
				}
			if(e.getSource() == lbuttons[1]) {
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); 
					labels[ind0].setText(t.append(labels[ind0].getText().charAt(0)).append("্").append(x[1]).toString());
					flag = 0; cnt--;		
				}
				
				else labels[ind1].setText(x[1]);
			}
				
			if(e.getSource() == lbuttons[2]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); 
					labels[ind0].setText(t.append(labels[ind0].getText().charAt(0)).append("্").append(x[2]).toString());
					flag = 0; cnt--;			
				}	
				else labels[ind1].setText(x[2]);
			}
			if(e.getSource() == lbuttons[3]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind0].setText(t.append(labels[ind0].getText().charAt(0)).append("্").append(x[3]).toString());
					flag = 0; cnt--;
				}
				else labels[ind1].setText(x[3]);
			}
			if(e.getSource() == lbuttons[4]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind0].setText(t.append(labels[ind0].getText().charAt(0)).append("্").append(x[4]).toString());
					flag = 0; cnt--;
					
				}
				
			else labels[ind1].setText(x[4]);
			}
			if(e.getSource() == lbuttons[5]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind0].setText(t.append(labels[ind0].getText().charAt(0)).append("্").append(x[5]).toString());
					flag = 0; cnt--;
					
				}
				
			else labels[ind1].setText(x[5]);
			}
			if(e.getSource() == lbuttons[6]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind0].setText(t.append(labels[ind0].getText().charAt(0)).append("্").append(x[6]).toString());
					flag = 0; cnt--;
					
				}
				
			else labels[ind1].setText(x[6]);
			}
			if(e.getSource() == lbuttons[7]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind0].setText(t.append(labels[ind0].getText().charAt(0)).append("্").append(x[7]).toString());
					flag = 0; cnt--;
					
				}
				
			else labels[ind1].setText(x[7]);
			}
			if(e.getSource() == lbuttons[8]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind0].setText(t.append(labels[ind0].getText().charAt(0)).append("্").append(x[8]).toString());
					flag = 0; cnt--;
					
				}
				
			else labels[ind1].setText(x[8]);
			}
			if(e.getSource() == lbuttons[9]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind0].setText(t.append(labels[ind0].getText().charAt(0)).append("্").append(x[9]).toString());
					flag = 0; cnt--;
					
				}
				
			else labels[ind1].setText(x[9]);
			}
			if(e.getSource() == lbuttons[10]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind0].setText(t.append(labels[ind0].getText().charAt(0)).append("্").append(x[10]).toString());
					flag = 0; cnt--;
					
				}
				
			else labels[ind1].setText(x[10]);
			}
			if(e.getSource() == lbuttons[11]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind0].setText(t.append(labels[ind0].getText().charAt(0)).append("্").append(x[11]).toString());
					flag = 0; cnt--;
					
				}
				
			else labels[ind1].setText(x[11]);
			}
			if(e.getSource() == lbuttons[12]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind0].setText(t.append(labels[ind0].getText().charAt(0)).append("্").append(x[12]).toString());
					flag = 0; cnt--;
					
				}
				
			else labels[ind1].setText(x[12]);
			}
			if(e.getSource() == lbuttons[13]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind0].setText(t.append(labels[ind0].getText().charAt(0)).append("্").append(x[13]).toString());
					flag = 0; cnt--;
					
				}
				
			else labels[ind1].setText(x[13]);
			}
			if(e.getSource() == lbuttons[14]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind0].setText(t.append(labels[ind0].getText().charAt(0)).append("্").append(x[14]).toString());
					flag = 0; cnt--;
					
				}
				
			else labels[ind1].setText(x[14]);
			}
			if(e.getSource() == lbuttons[15]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind0].setText(t.append(labels[ind0].getText().charAt(0)).append("্").append(x[15]).toString());
					flag = 0; cnt--;
					
				}
				
			else labels[ind1].setText(x[15]);
			}
			if(e.getSource() == lbuttons[16]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind0].setText(t.append(labels[ind0].getText().charAt(0)).append("্").append(x[16]).toString());
					flag = 0; cnt--;
					
				}
				
			else labels[ind1].setText(x[16]);
			}
			if(e.getSource() == lbuttons[17]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind0].setText(t.append(labels[ind0].getText().charAt(0)).append("্").append(x[17]).toString());
					flag = 0; cnt--;
					
				}
				
			else labels[ind1].setText(x[17]);
			}
			if(e.getSource() == lbuttons[18]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind0].setText(t.append(labels[ind0].getText().charAt(0)).append("্").append(x[18]).toString());
					flag = 0; cnt--;
					
				}
				
			else labels[ind1].setText(x[18]);
			}
			if(e.getSource() == lbuttons[19]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind0].setText(t.append(labels[ind0].getText().charAt(0)).append("্").append(x[19]).toString());
					flag = 0; cnt--;
					
				}
				
			else labels[ind1].setText(x[19]);
			}
			if(e.getSource() == lbuttons[20]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind0].setText(t.append(labels[ind0].getText().charAt(0)).append("্").append(x[20]).toString());
					flag = 0; cnt--;
					
				}
				
			else labels[ind1].setText(x[20]);
			}
			if(e.getSource() == lbuttons[21]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind0].setText(t.append(labels[ind0].getText().charAt(0)).append("্").append(x[21]).toString());
					flag = 0; cnt--;
					
				}
				
			else labels[ind1].setText(x[21]);
			}
			if(e.getSource() == lbuttons[22]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind0].setText(t.append(labels[ind0].getText().charAt(0)).append("্").append(x[22]).toString());
					flag = 0; cnt--;
					
				}
				
			else labels[ind1].setText(x[22]);
			}
			if(e.getSource() == lbuttons[23]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind0].setText(t.append(labels[ind0].getText().charAt(0)).append("্").append(x[23]).toString());
					flag = 0; cnt--;
					
				}
				
			else labels[ind1].setText(x[23]);
			}
			if(e.getSource() == lbuttons[24]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind0].setText(t.append(labels[ind0].getText().charAt(0)).append("্").append(x[24]).toString());
					flag = 0; cnt--;
					
				}
				
			else labels[ind1].setText(x[24]);
			}
			if(e.getSource() == lbuttons[25]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind0].setText(t.append(labels[ind0].getText().charAt(0)).append("্").append(x[25]).toString());
					flag = 0; cnt--;
					
				}
				
			else labels[ind1].setText(x[25]);
			}
			if(e.getSource() == lbuttons[26]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind0].setText(t.append(labels[ind0].getText().charAt(0)).append("্").append(x[26]).toString());
					flag = 0; cnt--;
					
				}
				
			else labels[ind1].setText(x[26]);
			}
			if(e.getSource() == lbuttons[27]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind0].setText(t.append(labels[ind0].getText().charAt(0)).append("্").append(x[27]).toString());
					flag = 0; cnt--;
					
				}
				
			else labels[ind1].setText(x[27]);
			}
			if(e.getSource() == lbuttons[28]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind0].setText(t.append(labels[ind0].getText().charAt(0)).append("্").append(x[28]).toString());
					flag = 0; cnt--;
					
				}
				
			else labels[ind1].setText(x[28]);
			}
			if(e.getSource() == lbuttons[29]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind0].setText(t.append(labels[ind0].getText().charAt(0)).append("্").append(x[29]).toString());
					flag = 0; cnt--;
					
				}
				
			else labels[ind1].setText(x[29]);
			}
			if(e.getSource() == lbuttons[30]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind0].setText(t.append(labels[ind0].getText().charAt(0)).append("্").append(x[30]).toString());
					flag = 0; cnt--;
					
				}
				
			else labels[ind1].setText(x[30]);
			}
			if(e.getSource() == lbuttons[31]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind0].setText(t.append(labels[ind0].getText().charAt(0)).append("্").append(x[31]).toString());
					flag = 0; cnt--;
					
				}
				
			else labels[ind1].setText(x[31]);
			}
			if(e.getSource() == lbuttons[32]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind0].setText(t.append(labels[ind0].getText().charAt(0)).append("্").append(x[32]).toString());
					flag = 0; cnt--;
					
				}
				else labels[ind1].setText(x[32]);
			}
			if(e.getSource() == lbuttons[33]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind0].setText(t.append(labels[ind0].getText().charAt(0)).append("্").append(x[33]).toString());
					flag = 0; cnt--;
					
				}
				
			else labels[ind1].setText(x[33]);
			}
			if(e.getSource() == lbuttons[34]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind0].setText(t.append(labels[ind0].getText().charAt(0)).append("্").append(x[34]).toString());
					flag = 0; cnt--;
					
				}
				
			else labels[ind1].setText(x[34]);
			}
			if(e.getSource() == lbuttons[35]) {labels[ind0].setText(labels[ind0].getText()+x[35]);cnt--;}
			if(e.getSource() == lbuttons[36]) {labels[ind0].setText(labels[ind0].getText()+x[36]);cnt--;}
			if(e.getSource() == lbuttons[37]) {   labels[ind0].setText(labels[ind0].getText() + x[37]); cnt--;flag = 1;}
			if(e.getSource() == lbuttons[38]) labels[ind1].setText(x[38]);
			if(e.getSource() == lbuttons[39]) labels[ind1].setText(x[39]);
			
			if(e.getSource() == lbuttons[40])labels[ind1].setText(x[40]);
			if(e.getSource() == lbuttons[41])labels[ind1].setText(x[41]);
			if(e.getSource() == lbuttons[42])labels[ind1].setText(x[42]);
			if(e.getSource() == lbuttons[43])labels[ind1].setText(x[43]);
			if(e.getSource() == lbuttons[44])labels[ind1].setText(x[44]);
			if(e.getSource() == lbuttons[45])labels[ind1].setText(x[45]);
			if(e.getSource() == lbuttons[46])labels[ind1].setText(x[46]);
			if(e.getSource() == lbuttons[47])labels[ind1].setText(x[47]);
			if(e.getSource() == lbuttons[48])labels[ind1].setText(x[48]);
			if(e.getSource() == lbuttons[49]) {
				labels[ind0].setText(" ");
				cnt--;
				cnt--;
			}
			if(e.getSource() == lbuttons[50]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind0].setText(t.append(labels[ind0].getText().charAt(0)).append("্").append(x[50]).toString());
					flag = 0; cnt--;
					
				}
				
			else labels[ind1].setText(x[50]);
			}
			
	}
	
	if(cnt == 2) {
		
		if(e.getSource() == karbutton[0]) {
			String s = labels[ind1].getText();labels[ind1].setText(s+Character.toString(ch[0])); cnt--;
		}
		if(e.getSource() == karbutton[1]) {
			String s = labels[ind1].getText();labels[ind1].setText(s+Character.toString(ch[1])); cnt--;
		}
		if(e.getSource() == karbutton[2]) {
			String s = labels[ind1].getText();labels[ind1].setText(s+Character.toString(ch[2])); cnt--;
		}
		if(e.getSource() == karbutton[3]) {
			String s = labels[ind1].getText();labels[ind1].setText(s+Character.toString(ch[3])); cnt--;
		}
		if(e.getSource() == karbutton[4]) {
			String s = labels[ind1].getText();labels[ind1].setText(s+Character.toString(ch[4])); cnt--;
		}
		if(e.getSource() == karbutton[5]) {
			String s = labels[ind1].getText();labels[ind1].setText(s+Character.toString(ch[5])); cnt--;
		}
		if(e.getSource() == karbutton[6]) {
			String s = labels[ind1].getText();labels[ind1].setText(s+Character.toString(ch[6])); cnt--;
		}
		if(e.getSource() == karbutton[7]) {
			String s = labels[ind1].getText();labels[ind1].setText(s+Character.toString(ch[7])); cnt--;
		}
		if(e.getSource() == karbutton[8]) {
			String s = labels[ind1].getText();labels[ind1].setText(s+Character.toString(ch[8])); cnt--;
		}
		if(e.getSource() == karbutton[9]) {
			String s = labels[ind1].getText();labels[ind1].setText(s+Character.toString(ch[9])); cnt--;
		}
		if(e.getSource() == karbutton[10]) {
			String s = labels[ind1].getText();labels[ind1].setText(s+Character.toString(ch[10])); cnt--;
		}
			if(e.getSource() == lbuttons[0]) {
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind1].setText(t.append(labels[ind1].getText().charAt(0)).append("্").append(x[0]).toString());
					flag = 0; cnt--;
					
				}
				else labels[ind2].setText(x[0]);
				}
			if(e.getSource() == lbuttons[1]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind1].setText(t.append(labels[ind1].getText().charAt(0)).append("্").append(x[1]).toString());
					flag = 0; cnt--;
					
				}
				else labels[ind2].setText(x[1]);
				}
			if(e.getSource() == lbuttons[2]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind1].setText(t.append(labels[ind1].getText().charAt(0)).append("্").append(x[2]).toString());
					flag = 0; cnt--;
					
				}
				else labels[ind2].setText(x[2]);
				}
			if(e.getSource() == lbuttons[3]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind1].setText(t.append(labels[ind1].getText().charAt(0)).append("্").append(x[3]).toString());
					flag = 0; cnt--;
					
				}
				else labels[ind2].setText(x[3]);
				}
			if(e.getSource() == lbuttons[4]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind1].setText(t.append(labels[ind1].getText().charAt(0)).append("্").append(x[4]).toString());
					flag = 0; cnt--;
					
				}
				else labels[ind2].setText(x[4]);
				}
			if(e.getSource() == lbuttons[5]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind1].setText(t.append(labels[ind1].getText().charAt(0)).append("্").append(x[5]).toString());
					flag = 0; cnt--;
					
				}
				else labels[ind2].setText(x[5]);
				}
			if(e.getSource() == lbuttons[6]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind1].setText(t.append(labels[ind1].getText().charAt(0)).append("্").append(x[6]).toString());
					flag = 0; cnt--;
					
				}
				else labels[ind2].setText(x[6]);
				}
			if(e.getSource() == lbuttons[7]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind1].setText(t.append(labels[ind1].getText().charAt(0)).append("্").append(x[7]).toString());
					flag = 0; cnt--;
					
				}
				else labels[ind2].setText(x[7]);
				}
			if(e.getSource() == lbuttons[8]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind1].setText(t.append(labels[ind1].getText().charAt(0)).append("্").append(x[8]).toString());
					flag = 0; cnt--;
					
				}
				else labels[ind2].setText(x[8]);
				}
			if(e.getSource() == lbuttons[9]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind1].setText(t.append(labels[ind1].getText().charAt(0)).append("্").append(x[9]).toString());
					flag = 0; cnt--;
					
				}
				else labels[ind2].setText(x[9]);
				}
			if(e.getSource() == lbuttons[10]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind1].setText(t.append(labels[ind1].getText().charAt(0)).append("্").append(x[10]).toString());
					flag = 0; cnt--;
					
				}
				else labels[ind2].setText(x[10]);
				}
			if(e.getSource() == lbuttons[11]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind1].setText(t.append(labels[ind1].getText().charAt(0)).append("্").append(x[11]).toString());
					flag = 0; cnt--;
					
				}
				else labels[ind2].setText(x[11]);
				}
			if(e.getSource() == lbuttons[12]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind1].setText(t.append(labels[ind1].getText().charAt(0)).append("্").append(x[12]).toString());
					flag = 0; cnt--;
					
				}
				else labels[ind2].setText(x[12]);
				}
			if(e.getSource() == lbuttons[13]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind1].setText(t.append(labels[ind1].getText().charAt(0)).append("্").append(x[13]).toString());
					flag = 0; cnt--;
					
				}
				else labels[ind2].setText(x[13]);
				}
			if(e.getSource() == lbuttons[14]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind1].setText(t.append(labels[ind1].getText().charAt(0)).append("্").append(x[14]).toString());
					flag = 0; cnt--;
					
				}
				else labels[ind2].setText(x[14]);
				}
			if(e.getSource() == lbuttons[15]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind1].setText(t.append(labels[ind1].getText().charAt(0)).append("্").append(x[15]).toString());
					flag = 0; cnt--;
					
				}
				else labels[ind2].setText(x[15]);
				}
			if(e.getSource() == lbuttons[16]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind1].setText(t.append(labels[ind1].getText().charAt(0)).append("্").append(x[16]).toString());
					flag = 0; cnt--;
					
				}
				else labels[ind2].setText(x[16]);
				}
			if(e.getSource() == lbuttons[17]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind1].setText(t.append(labels[ind1].getText().charAt(0)).append("্").append(x[17]).toString());
					flag = 0; cnt--;
					
				}
				else labels[ind2].setText(x[17]);
				}
			if(e.getSource() == lbuttons[18]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind1].setText(t.append(labels[ind1].getText().charAt(0)).append("্").append(x[18]).toString());
					flag = 0; cnt--;
					
				}
				else labels[ind2].setText(x[18]);
				}
			if(e.getSource() == lbuttons[19]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind1].setText(t.append(labels[ind1].getText().charAt(0)).append("্").append(x[19]).toString());
					flag = 0; cnt--;
					
				}
				else labels[ind2].setText(x[19]);
				}
			if(e.getSource() == lbuttons[20]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind1].setText(t.append(labels[ind1].getText().charAt(0)).append("্").append(x[20]).toString());
					flag = 0; cnt--;
					
				}
				else labels[ind2].setText(x[20]);
				}
			if(e.getSource() == lbuttons[21]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind1].setText(t.append(labels[ind1].getText().charAt(0)).append("্").append(x[21]).toString());
					flag = 0; cnt--;
					
				}
				else labels[ind2].setText(x[21]);
				}
			if(e.getSource() == lbuttons[22]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind1].setText(t.append(labels[ind1].getText().charAt(0)).append("্").append(x[22]).toString());
					flag = 0; cnt--;
					
				}
				else labels[ind2].setText(x[22]);
				}
			if(e.getSource() == lbuttons[23]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind1].setText(t.append(labels[ind1].getText().charAt(0)).append("্").append(x[23]).toString());
					flag = 0; cnt--;
					
				}
				else labels[ind2].setText(x[23]);
				}
			if(e.getSource() == lbuttons[24]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind1].setText(t.append(labels[ind1].getText().charAt(0)).append("্").append(x[24]).toString());
					flag = 0; cnt--;
					
				}
				else labels[ind2].setText(x[24]);
				}
			if(e.getSource() == lbuttons[25]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind1].setText(t.append(labels[ind1].getText().charAt(0)).append("্").append(x[25]).toString());
					flag = 0; cnt--;
					
				}
				else labels[ind2].setText(x[25]);
				}
			if(e.getSource() == lbuttons[26]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind1].setText(t.append(labels[ind1].getText().charAt(0)).append("্").append(x[26]).toString());
					flag = 0; cnt--;
					
				}
				else labels[ind2].setText(x[26]);
				}
			if(e.getSource() == lbuttons[27]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind1].setText(t.append(labels[ind1].getText().charAt(0)).append("্").append(x[27]).toString());
					flag = 0; cnt--;
					
				}
				else labels[ind2].setText(x[27]);
				}
			if(e.getSource() == lbuttons[28]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind1].setText(t.append(labels[ind1].getText().charAt(0)).append("্").append(x[28]).toString());
					flag = 0; cnt--;
					
				}
				else labels[ind2].setText(x[28]);
				}
			if(e.getSource() == lbuttons[29]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind1].setText(t.append(labels[ind1].getText().charAt(0)).append("্").append(x[29]).toString());
					flag = 0; cnt--;
					
				}
				else labels[ind2].setText(x[29]);
				}
			if(e.getSource() == lbuttons[30]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind1].setText(t.append(labels[ind1].getText().charAt(0)).append("্").append(x[30]).toString());
					flag = 0; cnt--;
					
				}
				else labels[ind2].setText(x[30]);
				}
			if(e.getSource() == lbuttons[31]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind1].setText(t.append(labels[ind1].getText().charAt(0)).append("্").append(x[31]).toString());
					flag = 0; cnt--;
					
				}
				else labels[ind2].setText(x[31]);
				}
			if(e.getSource() == lbuttons[32]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind1].setText(t.append(labels[ind1].getText().charAt(0)).append("্").append(x[32]).toString());
					flag = 0; cnt--;
					
				}
				else labels[ind2].setText(x[32]);
				}
			if(e.getSource() == lbuttons[33]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind1].setText(t.append(labels[ind1].getText().charAt(0)).append("্").append(x[33]).toString());
					flag = 0; cnt--;
					
				}
				else labels[ind2].setText(x[33]);
				}
			if(e.getSource() == lbuttons[34]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind1].setText(t.append(labels[ind1].getText().charAt(0)).append("্").append(x[34]).toString());
					flag = 0; cnt--;
					
				}
				else labels[ind2].setText(x[34]);
				}
//			if(e.getSource() == lbuttons[35]){
//				if(flag == 1) {
//					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
//					labels[1].setText(t.append(labels[1].getText().charAt(0)).append("্").append(x[35]).toString());
//					flag = 0; cnt--;
//					
//				}
//				else labels[2].setText(x[35]);
//				}
			//if(e.getSource() == lbuttons[36])labels[2].setText(x[36]);
			if(e.getSource() == lbuttons[35]) {labels[ind1].setText(labels[ind1].getText()+x[35]);cnt--;}
			if(e.getSource() == lbuttons[36]) {labels[ind1].setText(labels[ind1].getText()+x[36]);cnt--;}
			if(e.getSource() == lbuttons[37]){   labels[ind1].setText(labels[ind1].getText() + x[37]); cnt--;flag = 1;}
			if(e.getSource() == lbuttons[38])labels[ind2].setText(x[38]);
			if(e.getSource() == lbuttons[39])labels[ind2].setText(x[39]);
			if(e.getSource() == lbuttons[40])labels[ind2].setText(x[40]);
			if(e.getSource() == lbuttons[41])labels[ind2].setText(x[41]);
			if(e.getSource() == lbuttons[42])labels[ind2].setText(x[42]);
			if(e.getSource() == lbuttons[43])labels[ind2].setText(x[43]);
			if(e.getSource() == lbuttons[44])labels[ind2].setText(x[44]);
			if(e.getSource() == lbuttons[45])labels[ind2].setText(x[45]);
			if(e.getSource() == lbuttons[46])labels[ind2].setText(x[46]);
			if(e.getSource() == lbuttons[47])labels[ind2].setText(x[47]);
			if(e.getSource() == lbuttons[48])labels[ind2].setText(x[48]);
			if(e.getSource() == lbuttons[49]) {
				labels[ind1].setText(" ");
				cnt--;cnt--;
			}
			if(e.getSource() == lbuttons[50]){
				if(flag == 1) {
					StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
					labels[ind1].setText(t.append(labels[ind1].getText().charAt(0)).append("্").append(x[50]).toString());
					flag = 0; cnt--;
					
				}
				else labels[ind2].setText(x[50]);
				}
	}
	if(cnt == 3) {
		if(e.getSource() == karbutton[0]) {
			String s = labels[ind2].getText();labels[ind2].setText(s+Character.toString(ch[0])); cnt--;
		}
		if(e.getSource() == karbutton[1]) {
			String s = labels[ind2].getText();labels[ind2].setText(s+Character.toString(ch[1])); cnt--;
		}
		if(e.getSource() == karbutton[2]) {
			String s = labels[ind2].getText();labels[ind2].setText(s+Character.toString(ch[2])); cnt--;
		}
		if(e.getSource() == karbutton[3]) {
			String s = labels[ind2].getText();labels[ind2].setText(s+Character.toString(ch[3])); cnt--;
		}
		if(e.getSource() == karbutton[4]) {
			String s = labels[ind2].getText();labels[ind2].setText(s+Character.toString(ch[4])); cnt--;
		}
		if(e.getSource() == karbutton[5]) {
			String s = labels[ind2].getText();labels[ind2].setText(s+Character.toString(ch[5])); cnt--;
		}
		if(e.getSource() == karbutton[6]) {
			String s = labels[ind2].getText();labels[ind2].setText(s+Character.toString(ch[6])); cnt--;
		}
		if(e.getSource() == karbutton[7]) {
			String s = labels[ind2].getText();labels[ind2].setText(s+Character.toString(ch[7])); cnt--;
		}
		if(e.getSource() == karbutton[8]) {
			String s = labels[ind2].getText();labels[ind2].setText(s+Character.toString(ch[8])); cnt--;
		}
		if(e.getSource() == karbutton[9]) {
			String s = labels[ind2].getText();labels[ind2].setText(s+Character.toString(ch[9])); cnt--;
		}
		if(e.getSource() == karbutton[10]) {
			String s = labels[ind2].getText();labels[ind2].setText(s+Character.toString(ch[10])); cnt--;
		}
		if(e.getSource() == lbuttons[0]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind2].setText(t.append(labels[ind2].getText().charAt(0)).append("্").append(x[0]).toString());
				flag = 0; cnt--;
				
			}
			else labels[ind3].setText(x[0]);
			}
		if(e.getSource() == lbuttons[1]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind2].setText(t.append(labels[ind2].getText().charAt(0)).append("্").append(x[1]).toString());
				flag = 0; cnt--;
				
			}
			else labels[ind3].setText(x[1]);
			}
		if(e.getSource() == lbuttons[2]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind2].setText(t.append(labels[ind2].getText().charAt(0)).append("্").append(x[2]).toString());
				flag = 0; cnt--;
				
			}
			else labels[ind3].setText(x[2]);
			}
		if(e.getSource() == lbuttons[3]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind2].setText(t.append(labels[ind2].getText().charAt(0)).append("্").append(x[3]).toString());
				flag = 0; cnt--;
				
			}
			else labels[ind3].setText(x[3]);
			}
		if(e.getSource() == lbuttons[4]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind2].setText(t.append(labels[ind2].getText().charAt(0)).append("্").append(x[4]).toString());
				flag = 0; cnt--;
				
			}
			else labels[ind3].setText(x[4]);
			}
		if(e.getSource() == lbuttons[5]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind2].setText(t.append(labels[ind2].getText().charAt(0)).append("্").append(x[5]).toString());
				flag = 0; cnt--;
				
			}
			else labels[ind3].setText(x[5]);
			}
		if(e.getSource() == lbuttons[6]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind2].setText(t.append(labels[ind2].getText().charAt(0)).append("্").append(x[6]).toString());
				flag = 0; cnt--;
				
			}
			else labels[ind3].setText(x[6]);
			}
		if(e.getSource() == lbuttons[7]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind2].setText(t.append(labels[ind2].getText().charAt(0)).append("্").append(x[7]).toString());
				flag = 0; cnt--;
				
			}
			else labels[ind3].setText(x[7]);
			}
		if(e.getSource() == lbuttons[8]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind2].setText(t.append(labels[ind2].getText().charAt(0)).append("্").append(x[8]).toString());
				flag = 0; cnt--;
				
			}
			else labels[ind3].setText(x[8]);
			}
		if(e.getSource() == lbuttons[9]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind2].setText(t.append(labels[ind2].getText().charAt(0)).append("্").append(x[9]).toString());
				flag = 0; cnt--;
				
			}
			else labels[ind3].setText(x[9]);
			}
		if(e.getSource() == lbuttons[10]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind2].setText(t.append(labels[ind2].getText().charAt(0)).append("্").append(x[10]).toString());
				flag = 0; cnt--;
				
			}
			else labels[ind3].setText(x[10]);
			}
		if(e.getSource() == lbuttons[11]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind2].setText(t.append(labels[ind2].getText().charAt(0)).append("্").append(x[11]).toString());
				flag = 0; cnt--;
				
			}
			else labels[ind3].setText(x[11]);
			}
		if(e.getSource() == lbuttons[12]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind2].setText(t.append(labels[ind2].getText().charAt(0)).append("্").append(x[12]).toString());
				flag = 0; cnt--;
				
			}
			else labels[ind3].setText(x[12]);
			}
		if(e.getSource() == lbuttons[13]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind2].setText(t.append(labels[ind2].getText().charAt(0)).append("্").append(x[13]).toString());
				flag = 0; cnt--;
				
			}
			else labels[ind3].setText(x[13]);
			}
		if(e.getSource() == lbuttons[14]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind2].setText(t.append(labels[ind2].getText().charAt(0)).append("্").append(x[14]).toString());
				flag = 0; cnt--;
				
			}
			else labels[ind3].setText(x[14]);
			}
		if(e.getSource() == lbuttons[15]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind2].setText(t.append(labels[ind2].getText().charAt(0)).append("্").append(x[15]).toString());
				flag = 0; cnt--;
				
			}
			else labels[ind3].setText(x[15]);
			}
		if(e.getSource() == lbuttons[16]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind2].setText(t.append(labels[ind2].getText().charAt(0)).append("্").append(x[16]).toString());
				flag = 0; cnt--;
				
			}
			else labels[ind3].setText(x[16]);
			}
		if(e.getSource() == lbuttons[17]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind2].setText(t.append(labels[ind2].getText().charAt(0)).append("্").append(x[17]).toString());
				flag = 0; cnt--;
				
			}
			else labels[ind3].setText(x[17]);
			}
		if(e.getSource() == lbuttons[18]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind2].setText(t.append(labels[ind2].getText().charAt(0)).append("্").append(x[18]).toString());
				flag = 0; cnt--;
				
			}
			else labels[ind3].setText(x[18]);
			}
		if(e.getSource() == lbuttons[19]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind2].setText(t.append(labels[ind2].getText().charAt(0)).append("্").append(x[19]).toString());
				flag = 0; cnt--;
				
			}
			else labels[ind3].setText(x[19]);
			}
		if(e.getSource() == lbuttons[20]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind2].setText(t.append(labels[ind2].getText().charAt(0)).append("্").append(x[20]).toString());
				flag = 0; cnt--;
				
			}
			else labels[ind3].setText(x[20]);
			}
		if(e.getSource() == lbuttons[21]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind2].setText(t.append(labels[ind2].getText().charAt(0)).append("্").append(x[21]).toString());
				flag = 0; cnt--;
				
			}
			else labels[ind3].setText(x[21]);
			}
		if(e.getSource() == lbuttons[22]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind2].setText(t.append(labels[ind2].getText().charAt(0)).append("্").append(x[22]).toString());
				flag = 0; cnt--;
				
			}
			else labels[ind3].setText(x[22]);
			}
		if(e.getSource() == lbuttons[23]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind2].setText(t.append(labels[ind2].getText().charAt(0)).append("্").append(x[23]).toString());
				flag = 0; cnt--;
				
			}
			else labels[ind3].setText(x[23]);
			}
		if(e.getSource() == lbuttons[24]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind2].setText(t.append(labels[ind2].getText().charAt(0)).append("্").append(x[24]).toString());
				flag = 0; cnt--;
				
			}
			else labels[ind3].setText(x[24]);
			}
		if(e.getSource() == lbuttons[25]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind2].setText(t.append(labels[ind2].getText().charAt(0)).append("্").append(x[25]).toString());
				flag = 0; cnt--;
				
			}
			else labels[ind3].setText(x[25]);
			}
		if(e.getSource() == lbuttons[26]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind2].setText(t.append(labels[ind2].getText().charAt(0)).append("্").append(x[26]).toString());
				flag = 0; cnt--;
				
			}
			else labels[ind3].setText(x[26]);
			}
		if(e.getSource() == lbuttons[27]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind2].setText(t.append(labels[ind2].getText().charAt(0)).append("্").append(x[27]).toString());
				flag = 0; cnt--;
				
			}
			else labels[ind3].setText(x[27]);
			}
		if(e.getSource() == lbuttons[28]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind2].setText(t.append(labels[ind2].getText().charAt(0)).append("্").append(x[28]).toString());
				flag = 0; cnt--;
				
			}
			else labels[ind3].setText(x[28]);
			}
		if(e.getSource() == lbuttons[29]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind2].setText(t.append(labels[ind2].getText().charAt(0)).append("্").append(x[29]).toString());
				flag = 0; cnt--;
				
			}
			else labels[ind3].setText(x[29]);
			}
		if(e.getSource() == lbuttons[30]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind2].setText(t.append(labels[ind2].getText().charAt(0)).append("্").append(x[30]).toString());
				flag = 0; cnt--;
				
			}
			else labels[ind3].setText(x[30]);
			}
		if(e.getSource() == lbuttons[31]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind2].setText(t.append(labels[ind2].getText().charAt(0)).append("্").append(x[31]).toString());
				flag = 0; cnt--;
				
			}
			else labels[ind3].setText(x[31]);
			}
		if(e.getSource() == lbuttons[32]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind2].setText(t.append(labels[ind2].getText().charAt(0)).append("্").append(x[32]).toString());
				flag = 0; cnt--;
				
			}
			else labels[ind3].setText(x[32]);
			}
		if(e.getSource() == lbuttons[33]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind2].setText(t.append(labels[ind2].getText().charAt(0)).append("্").append(x[33]).toString());
				flag = 0; cnt--;
				
			}
			else labels[ind3].setText(x[33]);
			}
		if(e.getSource() == lbuttons[34]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind2].setText(t.append(labels[ind2].getText().charAt(0)).append("্").append(x[34]).toString());
				flag = 0; cnt--;
				
			}
			else labels[ind3].setText(x[34]);
			}
		if(e.getSource() == lbuttons[50]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind2].setText(t.append(labels[ind2].getText().charAt(0)).append("্").append(x[50]).toString());
				flag = 0; cnt--;
				
			}
			else labels[ind3].setText(x[50]);
			}

		if(e.getSource() == lbuttons[35]) {labels[ind2].setText(labels[ind2].getText()+x[35]);cnt--;}
		if(e.getSource() == lbuttons[36]) {labels[ind2].setText(labels[ind2].getText()+x[36]);cnt--;}
		if(e.getSource() == lbuttons[37]){   labels[ind2].setText(labels[ind2].getText() + x[37]); cnt--;flag = 1;}
		if(e.getSource() == lbuttons[38])labels[ind3].setText(x[38]);
		if(e.getSource() == lbuttons[39])labels[ind3].setText(x[39]);
		if(e.getSource() == lbuttons[40])labels[ind3].setText(x[40]);
		if(e.getSource() == lbuttons[41])labels[ind3].setText(x[41]);
		if(e.getSource() == lbuttons[42])labels[ind3].setText(x[42]);
		if(e.getSource() == lbuttons[43])labels[ind3].setText(x[43]);
		if(e.getSource() == lbuttons[44])labels[ind3].setText(x[44]);
		if(e.getSource() == lbuttons[45])labels[ind3].setText(x[45]);
		if(e.getSource() == lbuttons[46])labels[ind3].setText(x[46]);
		if(e.getSource() == lbuttons[47])labels[ind3].setText(x[47]);
		if(e.getSource() == lbuttons[48])labels[ind3].setText(x[48]);
		if(e.getSource() == lbuttons[49]) {
			labels[ind2].setText(" ");
			cnt--;cnt--;
		}
	}
	if(cnt == 4) {
		if(e.getSource() == karbutton[0]) {
			String s = labels[ind3].getText();labels[ind3].setText(s+Character.toString(ch[0])); cnt--;
		}
		if(e.getSource() == karbutton[1]) {
			String s = labels[ind3].getText();labels[ind3].setText(s+Character.toString(ch[1])); cnt--;
		}
		if(e.getSource() == karbutton[2]) {
			String s = labels[ind3].getText();labels[ind3].setText(s+Character.toString(ch[2])); cnt--;
		}
		if(e.getSource() == karbutton[3]) {
			String s = labels[ind3].getText();labels[ind3].setText(s+Character.toString(ch[3])); cnt--;
		}
		if(e.getSource() == karbutton[4]) {
			String s = labels[ind3].getText();labels[ind3].setText(s+Character.toString(ch[4])); cnt--;
		}
		if(e.getSource() == karbutton[5]) {
			String s = labels[ind3].getText();labels[ind3].setText(s+Character.toString(ch[5])); cnt--;
		}
		if(e.getSource() == karbutton[6]) {
			String s = labels[ind3].getText();labels[ind3].setText(s+Character.toString(ch[6])); cnt--;
		}
		if(e.getSource() == karbutton[7]) {
			String s = labels[ind3].getText();labels[ind3].setText(s+Character.toString(ch[7])); cnt--;
		}
		if(e.getSource() == karbutton[8]) {
			String s = labels[ind3].getText();labels[ind3].setText(s+Character.toString(ch[8])); cnt--;
		}
		if(e.getSource() == karbutton[9]) {
			String s = labels[ind3].getText();labels[ind3].setText(s+Character.toString(ch[9])); cnt--;
		}
		if(e.getSource() == karbutton[10]) {
			String s = labels[ind3].getText();labels[ind3].setText(s+Character.toString(ch[10])); cnt--;
		}
		if(e.getSource() == lbuttons[0]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind3].setText(t.append(labels[ind3].getText().charAt(0)).append("্").append(x[0]).toString());
				flag = 0; cnt--;
				
			}
			//else labels[3].setText(x[0]);
			}
		if(e.getSource() == lbuttons[1]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind3].setText(t.append(labels[ind3].getText().charAt(0)).append("্").append(x[1]).toString());
				flag = 0; cnt--;
				
			}
			//else labels[3].setText(x[1]);
			}
		if(e.getSource() == lbuttons[2]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind3].setText(t.append(labels[ind3].getText().charAt(0)).append("্").append(x[2]).toString());
				flag = 0; cnt--;
				
			}
			//else labels[3].setText(x[2]);
			}
		if(e.getSource() == lbuttons[3]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind3].setText(t.append(labels[ind3].getText().charAt(0)).append("্").append(x[3]).toString());
				flag = 0; cnt--;
				
			}
			else labels[3].setText(x[3]);
			}
		if(e.getSource() == lbuttons[4]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind3].setText(t.append(labels[ind3].getText().charAt(0)).append("্").append(x[4]).toString());
				flag = 0; cnt--;
				
			}
			//else labels[3].setText(x[4]);
			}
		if(e.getSource() == lbuttons[5]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind3].setText(t.append(labels[ind3].getText().charAt(0)).append("্").append(x[5]).toString());
				flag = 0; cnt--;
				
			}
			//else labels[3].setText(x[5]);
			}
		if(e.getSource() == lbuttons[6]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind3].setText(t.append(labels[ind3].getText().charAt(0)).append("্").append(x[6]).toString());
				flag = 0; cnt--;
				
			}
			//else labels[3].setText(x[6]);
			}
		if(e.getSource() == lbuttons[7]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind3].setText(t.append(labels[ind3].getText().charAt(0)).append("্").append(x[7]).toString());
				flag = 0; cnt--;
				
			}
			//else labels[3].setText(x[7]);
			}
		if(e.getSource() == lbuttons[8]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind3].setText(t.append(labels[ind3].getText().charAt(0)).append("্").append(x[8]).toString());
				flag = 0; cnt--;
				
			}
			//else labels[3].setText(x[8]);
			}
		if(e.getSource() == lbuttons[9]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind3].setText(t.append(labels[ind3].getText().charAt(0)).append("্").append(x[9]).toString());
				flag = 0; cnt--;
				
			}
			//else labels[3].setText(x[9]);
			}
		if(e.getSource() == lbuttons[10]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind3].setText(t.append(labels[ind3].getText().charAt(0)).append("্").append(x[10]).toString());
				flag = 0; cnt--;
				
			}
			//else labels[3].setText(x[10]);
			}
		if(e.getSource() == lbuttons[11]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind3].setText(t.append(labels[ind3].getText().charAt(0)).append("্").append(x[11]).toString());
				flag = 0; cnt--;
				
			}
			//else labels[3].setText(x[11]);
			}
		if(e.getSource() == lbuttons[12]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind3].setText(t.append(labels[ind3].getText().charAt(0)).append("্").append(x[12]).toString());
				flag = 0; cnt--;
				
			}
			//else labels[3].setText(x[12]);
			}
		if(e.getSource() == lbuttons[13]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind3].setText(t.append(labels[ind3].getText().charAt(0)).append("্").append(x[13]).toString());
				flag = 0; cnt--;
				
			}
			//else labels[3].setText(x[13]);
			}
		if(e.getSource() == lbuttons[14]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind3].setText(t.append(labels[ind3].getText().charAt(0)).append("্").append(x[14]).toString());
				flag = 0; cnt--;
				
			}
			//else labels[3].setText(x[14]);
			}
		if(e.getSource() == lbuttons[15]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind3].setText(t.append(labels[ind3].getText().charAt(0)).append("্").append(x[15]).toString());
				flag = 0; cnt--;
				
			}
			//else labels[3].setText(x[15]);
			}
		if(e.getSource() == lbuttons[16]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind3].setText(t.append(labels[ind3].getText().charAt(0)).append("্").append(x[16]).toString());
				flag = 0; cnt--;
				
			}
			//else labels[3].setText(x[16]);
			}
		if(e.getSource() == lbuttons[17]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind3].setText(t.append(labels[ind3].getText().charAt(0)).append("্").append(x[17]).toString());
				flag = 0; cnt--;
				
			}
			//else labels[3].setText(x[17]);
			}
		if(e.getSource() == lbuttons[18]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind3].setText(t.append(labels[ind3].getText().charAt(0)).append("্").append(x[18]).toString());
				flag = 0; cnt--;
				
			}
			//else labels[3].setText(x[18]);
			}
		if(e.getSource() == lbuttons[19]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind3].setText(t.append(labels[ind3].getText().charAt(0)).append("্").append(x[19]).toString());
				flag = 0; cnt--;
				
			}
			//else labels[3].setText(x[19]);
			}
		if(e.getSource() == lbuttons[20]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind3].setText(t.append(labels[ind3].getText().charAt(0)).append("্").append(x[20]).toString());
				flag = 0; cnt--;
				
			}
			//else labels[3].setText(x[20]);
			}
		if(e.getSource() == lbuttons[21]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind3].setText(t.append(labels[ind3].getText().charAt(0)).append("্").append(x[21]).toString());
				flag = 0; cnt--;
				
			}
			//else labels[3].setText(x[21]);
			}
		if(e.getSource() == lbuttons[22]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind3].setText(t.append(labels[ind3].getText().charAt(0)).append("্").append(x[22]).toString());
				flag = 0; cnt--;
				
			}
			//else labels[3].setText(x[22]);
			}
		if(e.getSource() == lbuttons[23]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind3].setText(t.append(labels[ind3].getText().charAt(0)).append("্").append(x[23]).toString());
				flag = 0; cnt--;
				
			}
			//else labels[3].setText(x[23]);
			}
		if(e.getSource() == lbuttons[24]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind3].setText(t.append(labels[ind3].getText().charAt(0)).append("্").append(x[24]).toString());
				flag = 0; cnt--;
				
			}
			//else labels[3].setText(x[24]);
			}
		if(e.getSource() == lbuttons[25]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind3].setText(t.append(labels[ind3].getText().charAt(0)).append("্").append(x[25]).toString());
				flag = 0; cnt--;
				
			}
			//else labels[3].setText(x[25]);
			}
		if(e.getSource() == lbuttons[26]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind3].setText(t.append(labels[ind3].getText().charAt(0)).append("্").append(x[26]).toString());
				flag = 0; cnt--;
				
			}
			//else labels[3].setText(x[26]);
			}
		if(e.getSource() == lbuttons[27]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind3].setText(t.append(labels[ind3].getText().charAt(0)).append("্").append(x[27]).toString());
				flag = 0; cnt--;
				
			}
			//else labels[3].setText(x[27]);
			}
		if(e.getSource() == lbuttons[28]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind3].setText(t.append(labels[ind3].getText().charAt(0)).append("্").append(x[28]).toString());
				flag = 0; cnt--;
				
			}
			//else labels[3].setText(x[28]);
			}
		if(e.getSource() == lbuttons[29]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind3].setText(t.append(labels[ind3].getText().charAt(0)).append("্").append(x[29]).toString());
				flag = 0; cnt--;
				
			}
			//else labels[3].setText(x[29]);
			}
		if(e.getSource() == lbuttons[30]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind3].setText(t.append(labels[ind3].getText().charAt(0)).append("্").append(x[30]).toString());
				flag = 0; cnt--;
				
			}
			//else labels[3].setText(x[30]);
			}
		if(e.getSource() == lbuttons[31]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind3].setText(t.append(labels[ind3].getText().charAt(0)).append("্").append(x[31]).toString());
				flag = 0; cnt--;
				
			}
			//else labels[3].setText(x[31]);
			}
		if(e.getSource() == lbuttons[32]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind3].setText(t.append(labels[ind3].getText().charAt(0)).append("্").append(x[32]).toString());
				flag = 0; cnt--;
				
			}
			//else labels[3].setText(x[32]);
			}
		if(e.getSource() == lbuttons[33]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind3].setText(t.append(labels[ind3].getText().charAt(0)).append("্").append(x[33]).toString());
				flag = 0; cnt--;
				
			}
			//else labels[3].setText(x[33]);
			}
		if(e.getSource() == lbuttons[34]){
			if(flag == 1) {
				StringBuilder t = new StringBuilder(); //labels[0].getText().charAt(0)
				labels[ind3].setText(t.append(labels[ind3].getText().charAt(0)).append("্").append(x[34]).toString());
				flag = 0; cnt--;
				
			}
			//else labels[3].setText(x[34]);
			}

		if(e.getSource() == lbuttons[35]) {labels[ind3].setText(labels[ind3].getText()+x[35]);cnt--;}
		if(e.getSource() == lbuttons[36]) {labels[ind3].setText(labels[ind3].getText()+x[36]);cnt--;}
		if(e.getSource() == lbuttons[37]){   labels[ind3].setText(labels[ind3].getText() + x[37]); cnt--;flag = 1;}
		if(e.getSource() == lbuttons[38])labels[ind3].setText(x[38]);
		if(e.getSource() == lbuttons[39])labels[ind3].setText(x[39]);
		if(e.getSource() == lbuttons[40])labels[ind3].setText(x[40]);
		if(e.getSource() == lbuttons[41])labels[ind3].setText(x[41]);
		if(e.getSource() == lbuttons[42])labels[ind3].setText(x[42]);
		if(e.getSource() == lbuttons[43])labels[ind3].setText(x[43]);
		if(e.getSource() == lbuttons[44])labels[ind3].setText(x[44]);
		if(e.getSource() == lbuttons[45])labels[ind3].setText(x[45]);
		if(e.getSource() == lbuttons[46])labels[ind3].setText(x[46]);
		if(e.getSource() == lbuttons[47])labels[ind3].setText(x[47]);
		if(e.getSource() == lbuttons[48])labels[ind3].setText(x[48]);
		
		if(e.getSource() == lbuttons[49]) {
			labels[ind3].setText(" ");
			cnt--;cnt--;
		}
		
	}
	
	if(cnt>4) {
		if(e.getSource() == lbuttons[49]) {
			cnt--;cnt--;
		}
	}
	
	cnt++;
	
	System.out.print(cnt);
	
}


	void action_on_ok() {
		
	
		
		ok.addActionListener(new ActionListener() {
			
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int proceed = 1,proceed2 = 1;
				System.out.println("ok = "+ cnt);
				if(cnt <4) {
					JOptionPane.showMessageDialog(null,"Not enough letter");
				}
				
				else if(cnt >= 4) {
					if(is_word_in_dict() == 0) {
						JOptionPane.showMessageDialog(null,"Not a valid word");
						proceed = 0;
					}
					if(proceed == 1) {
						wordCheck();
					 me = labels[ind0].getText() + labels[ind1].getText() + labels[ind2].getText() + labels[ind3].getText();
					if(win == 1) {
						JOptionPane.showMessageDialog(null,"You Won !!");
						proceed2 = 0;
					}
					if(proceed2 == 1) {
				
				step++;
				if(step == 1) {
				cnt = 0;
				ind0 = 4;
				ind1 = 5;
				ind2 = 6;
				ind3 = 7;
				}
				if(step == 2) {
					cnt = 0;
					ind0 = 8;
					ind1 = 9;
					ind2 = 10;
					ind3 = 11;
				}
				
				if(step == 3) {
				cnt = 0;
				ind0 = 12;
				ind1 = 13;
				ind2 = 14;
				ind3 = 15;
			}
				if(step == 4) {
					cnt = 0;
					ind0 = 16;
					ind1 = 17;
					ind2 = 18;
					ind3 = 19;
				}
				
				}
				}
			
			}
			}
			
		});
		
	}
	void hints() {
			
			

			tf.setBounds(300,100,50,50);
			//tf.setText(Character.toString(w.charAt(0)));
			//tf.setText(w);
			tf.setFont(new Font("kalpurush",Font.BOLD,25));
			tf.setOpaque(true);  
			tf.setForeground(Color.BLACK);
			tf.setBackground(Color.WHITE);
			//tf.setBorder(border);
			c.add(tf);
			
			for(int i = 0;i<4;i++) {
				hintlabel[i] = new JButton();
				hintlabel[i].setFont(f);

		            
				hintlabel[i].setOpaque(true);  
				hintlabel[i].setForeground(Color.BLACK);
				hintlabel[i].setBackground(Color.WHITE);
				hintlabel[i].setText(String.valueOf(i+1));
				
				c.add(hintlabel[i]);
				
			}
			
			JLabel ll = new JLabel();
			ll.setBounds(380,60,100,40);
			ll.setText("Hint:");
			ll.setForeground(green);
			ll.setFont(new Font("kalpurush",Font.BOLD,20));
			c.add(ll);
			
			hintlabel[0].setBounds(380,100,50,50);
			hintlabel[1].setBounds(430,100,50,50);
			hintlabel[2].setBounds(480,100,50,50);
			hintlabel[3].setBounds(530,100,50,50);
			
			 
			
			if(hint_checked == 0) {
			hintlabel[0].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					//tf.setText(Character.toString(w.charAt(0)));
					tf.setText(s1);
					hint_checked = 1;
					
				}
				
			});
			}
			if(hint_checked == 0) {
			hintlabel[1].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					tf.setText(s2);
					hint_checked = 1;
				}
				
			});
			}
			if(hint_checked == 0) {
			hintlabel[2].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					tf.setText(s3);
					hint_checked = 1;
				}
				
			});
			}
			if(hint_checked == 0) {
			hintlabel[3].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					tf.setText(s4);
					hint_checked = 1;
				}
				
			});
			}
	
			tf1.setBounds(300,150,100,50);
			tf1.setFont(f);
			//tf1.setText("র"+"্‌"+"র"+"্‌"+"ক");
			tf1.setText(s1);
			//c.add(tf1);
			
}

}
