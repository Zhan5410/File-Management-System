package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.util.SystemParameters;

public class fms {
	private JFrame jframe = null;
	private ArrayList<JComponent> GUIConponent = null;

	private JButton jbt = null;

	private JTextField jtf_filepathway = null;
	private JTextArea jtf_information = null;
	private JTextArea jtf_filecontent = null;
	private JScrollPane jsp_filecontent = null;
	private JScrollPane jsp_information = null;
	private JComponent[] jtf = null;

    private JCheckBox[] jcheckbox = null;
    private JCheckBox jcb_filelength = null;
    private JCheckBox jcb_isfile = null;
    private JCheckBox jcb_isdirectory = null;
    private JCheckBox jcb_canread = null;
    private JCheckBox jcb_canwrite = null;
    private JCheckBox jcb_ishidden = null;
    private JCheckBox jcb_lastmodify = null;
    private JCheckBox jcb_getname = null;
    private JCheckBox jcb_getpath = null;
    private JCheckBox jcb_getabsolutepath = null;

    private ButtonGroup buttongroup = null;
    private JRadioButton[] jradiobutton = null;
    private JRadioButton jrb_1 = null;
    private JRadioButton jrb_2 = null;
	private JRadioButton jrb_usersetting = null;

	private JComboBox<String> jcob_foreground = null;
	private JComboBox<String> jcob_background = null;

	private JLabel jlbtextsize = null;
	private JLabel jlb_forecolor = null;
	private JLabel jlb_backcolor = null;
	private JLabel jlb_slider = null;

	private JSlider slider_text = null;

	private ActionListener[] JButtonActionListener = null;
	private ActionListener openfile = null;
	private ActionListener roadfile = null;
	private ActionListener encode = null;
	private ActionListener decode = null;
	
	private void set() {
		jframe = new JFrame(SystemParameters.systemname);

		GUIConponent = new ArrayList<JComponent>(); 

        jcheckbox = new JCheckBox[]{jcb_filelength,
									jcb_isfile,
									jcb_isdirectory,
									jcb_canread,
									jcb_canwrite,
									jcb_ishidden,
									jcb_lastmodify,
									jcb_getname,
									jcb_getpath,
									jcb_getabsolutepath
        };
        dochkeckbox();

		dotext();
		jtf = new JComponent[]{jtf_filepathway,
							   jsp_information,
							   jsp_filecontent
		};

		doactionlistener();
		JButtonActionListener = new ActionListener[]{openfile,
													 roadfile,
													 encode,
													 decode
		};

        doradio();
        for(int i=0 ; i<jradiobutton.length ; i++){
            jradiobutton[i].setActionCommand(String.valueOf(i));
            jradiobutton[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    if(jradiobutton[Integer.valueOf(e.getActionCommand())].isSelected()){
                        jtf_filecontent.setForeground(SystemParameters.textstyle[Integer.valueOf(e.getActionCommand())][0]);
                        jtf_filecontent.setBackground(SystemParameters.textstyle[Integer.valueOf(e.getActionCommand())][1]);
                        jtf_information.setForeground(SystemParameters.textstyle[Integer.valueOf(e.getActionCommand())][0]);
                        jtf_information.setBackground(SystemParameters.textstyle[Integer.valueOf(e.getActionCommand())][1]);
						jcob_foreground.setEnabled(false);
						jcob_background.setEnabled(false);
                    }
                }
            }); 
        }
		jrb_usersetting = new JRadioButton("自訂");
		jrb_usersetting.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jcob_foreground.setEnabled(true);
				jcob_background.setEnabled(true);
			}
			
		});

		
		slider_text = new JSlider(JSlider.HORIZONTAL,0,100,12);
		slider_text.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				Font font = jtf_information.getFont().deriveFont((float)slider_text.getValue());
				jtf_information.setFont(font);
				jtf_filecontent.setFont(font);
				jlbtextsize.setText(String.valueOf(slider_text.getValue()));
			}
			
		});



		docombobox();



		jlb_forecolor = new JLabel(SystemParameters.objText[7]);
		jlb_backcolor = new JLabel(SystemParameters.objText[8]);
		jlb_slider = new JLabel(SystemParameters.objText[9]);
		

		

		jlbtextsize = new JLabel(String.valueOf(slider_text.getValue()));
		

	}

	private void docombobox(){
		jcob_foreground = new JComboBox<String>();
		jcob_background = new JComboBox<String>();
		for(int i=0 ; i<SystemParameters.objcolor.length ; i++){
			jcob_foreground.addItem(SystemParameters.objcolor[i]);
			jcob_background.addItem(SystemParameters.objcolor[i]);
		}
		jcob_foreground.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String color_foreground = (String)jcob_foreground.getSelectedItem();
				String color_background = (String)jcob_background.getSelectedItem();
				changetextcolor(color_foreground,color_background);
			}
			
		});
	};

	private void changetextcolor(String forecolor,String backcolor){
		jtf_filecontent.setForeground(getcolor(forecolor));
        jtf_filecontent.setBackground(getcolor(backcolor));
        jtf_information.setForeground(getcolor(forecolor));
        jtf_information.setBackground(getcolor(backcolor));
	};

	private Color getcolor(String color){
		switch (color) {
			case "黑色":
				return Color.BLACK;
			case "黃色":
				return Color.YELLOW;
			case "灰色":
				return Color.GRAY;
			case "綠色":
				return Color.GREEN;
			case "紅色":
				return Color.RED;
			case "藍色":
				return Color.BLUE;
			default:
				return null;
		}
	};

    private void doradio(){
		jrb_1 = new JRadioButton("樣式1",true);
        jrb_2 = new JRadioButton("樣式2",true);
        buttongroup = new ButtonGroup();
        jradiobutton = new JRadioButton[]{jrb_1,jrb_2};

        for(int i=0 ; i<jradiobutton.length ; i++){
            buttongroup.add(jradiobutton[i]);
        }
    }

    private void dochkeckbox(){
        for(int i=0 ; i<jcheckbox.length ; i++){
            jcheckbox[i] = new JCheckBox(SystemParameters.objfile[i],true);
            jcheckbox[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    readfile();
                }
            });
        }
    }

    private void readfile(){
        File f = new File(jtf_filepathway.getText());
		StringBuffer sb = new StringBuffer();

		sb.append(f.getName() + "檔案資訊如下：\n");
		sb.append("=======================\n");
		if(jcheckbox[0].isSelected()){sb.append(SystemParameters.objfile[0] + "：" + f.length() + "位元組\n");}
		if(jcheckbox[1].isSelected()){sb.append(SystemParameters.objfile[1] + "：" + (f.isFile()?"是檔案":"不是檔案") + "\n");}
		if(jcheckbox[2].isSelected()){sb.append(SystemParameters.objfile[2] + "：" + (f.isDirectory()?"是目錄":"不是目錄") + "\n");}
		if(jcheckbox[3].isSelected()){sb.append(SystemParameters.objfile[3] + "：" + (f.canRead()?"可讀取":"不可讀取") + "\n");}
		if(jcheckbox[4].isSelected()){sb.append(SystemParameters.objfile[4] + "：" + (f.canWrite()?"可寫入":"不可寫入") + "\n");}
		if(jcheckbox[5].isSelected()){sb.append(SystemParameters.objfile[5] + "：" + (f.isHidden()?"是隱藏檔案":"不是隱藏檔案") + "\n");}
		if(jcheckbox[6].isSelected()){sb.append(SystemParameters.objfile[6] + "：" + f.lastModified() + "\n");}
		if(jcheckbox[7].isSelected()){sb.append(SystemParameters.objfile[7] + "：" + f.getName() + "\n");}
		if(jcheckbox[8].isSelected()){sb.append(SystemParameters.objfile[8] + "：" + f.getPath() + "\n");}
		if(jcheckbox[9].isSelected()){sb.append(SystemParameters.objfile[9] + "：" + f.getAbsolutePath() + "\n");}

        jtf_information.setText(sb.toString());
		jtf_filecontent.setText(roaddata(jtf_filepathway.getText()).toString());
    }

    private void dotext(){
	    jtf_filepathway = new JTextField("",24);
	    jtf_information = new JTextArea("");
	    jsp_information = new JScrollPane(jtf_information);
	    jtf_filecontent = new JTextArea("");
	    jsp_filecontent = new JScrollPane(jtf_filecontent);
	}
	
	private void run() {
		jframe.setSize(800, 600);
		jframe.setLayout(new GridBagLayout());
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//handle lable
		for(int i=0 ; i<3 ; i++) {
			JLabel jbl = new JLabel(SystemParameters.objText[i]);
			GUIConponent.add(jbl);
		}

		//handle text
		for(int i=0 ; i<jtf.length ; i++){
			GUIConponent.add(jtf[i]);
		}

		//handle button
		for(int i=0 ; i<4 ; i++){
			jbt = new JButton(SystemParameters.objText[i+3]);
			jbt.addActionListener(JButtonActionListener[i]);
			GUIConponent.add(jbt);
		}

        //handle checkbox
        for(int i=0 ; i<jcheckbox.length ; i++){
            GUIConponent.add(jcheckbox[i]);
        }

		//handle radiobutton
        for(int i=0 ; i<jradiobutton.length ; i++){
            GUIConponent.add(jradiobutton[i]);
        }

		buttongroup.add(jrb_usersetting);
		GUIConponent.add(jrb_usersetting);

		//handle Label
		GUIConponent.add(jlb_forecolor);
		GUIConponent.add(jlb_backcolor);
		GUIConponent.add(jlb_slider);

		//handle combobox
		GUIConponent.add(jcob_foreground);
		GUIConponent.add(jcob_background);

		//handle silder
		GUIConponent.add(slider_text);
		GUIConponent.add(jlbtextsize);

 		//add
		for(int i=0 ; i<GUIConponent.size() ; i++){
			addComponent(i);
		}
		
		jframe.setVisible(true);
	}

	private void doactionlistener(){
		openfile = new ActionListener() {
			public void actionPerformed(ActionEvent e){
				System.out.println("open file");
				JFileChooser jfc = new JFileChooser();
				int returnvalue = jfc.showOpenDialog(jframe);
				if(returnvalue == JFileChooser.APPROVE_OPTION){
					File file = jfc.getSelectedFile();
					jtf_filepathway.setText(file.getAbsolutePath());
				}
				else{
					jtf_filepathway.setText("open command cancelled by user");
				}
			}
		};

	  	roadfile = new ActionListener() {
			public void actionPerformed(ActionEvent e){
				System.out.println("roadfile");
				File f = new File(jtf_filepathway.getText());
				StringBuffer sb = new StringBuffer();

				sb.append(f.getName() + "檔案資訊如下：\n");
				sb.append("=======================\n");
				sb.append(SystemParameters.objfile[0] + "：" + f.length() + "位元組\n");
				sb.append(SystemParameters.objfile[1] + "：" + (f.isFile()?"是檔案":"不是檔案") + "\n");
				sb.append(SystemParameters.objfile[2] + "：" + (f.isDirectory()?"是目錄":"不是目錄") + "\n");
				sb.append(SystemParameters.objfile[3] + "：" + (f.canRead()?"可讀取":"不可讀取") + "\n");
				sb.append(SystemParameters.objfile[4] + "：" + (f.canWrite()?"可寫入":"不可寫入") + "\n");
				sb.append(SystemParameters.objfile[5] + "：" + (f.isHidden()?"是隱藏檔案":"不是隱藏檔案") + "\n");
				sb.append(SystemParameters.objfile[6] + "：" + f.lastModified() + "\n");
				sb.append(SystemParameters.objfile[7] + "：" + f.getName() + "\n");
				sb.append(SystemParameters.objfile[8] + "：" + f.getPath() + "\n");
				sb.append(SystemParameters.objfile[9] + "：" + f.getAbsolutePath() + "\n");

				jtf_information.setText(sb.toString());
				jtf_filecontent.setText(roaddata(jtf_filepathway.getText()).toString());
			}
		};

		encode = new ActionListener() {
			public void actionPerformed(ActionEvent e){

			}
		};

		decode = new ActionListener() {
			public void actionPerformed(ActionEvent e){

			}
		};

	}

	private StringBuffer roaddata(String pathway){
		StringBuffer sb = new StringBuffer();
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(pathway)));
			String text = "";

			while ((text = br.readLine())!=null) {
				sb.append(text + "\n");
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb;
	}

    private void addComponent(int i) {		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = SystemParameters.gbc[i][0];
		c.gridy = SystemParameters.gbc[i][1];
		c.gridwidth = SystemParameters.gbc[i][2];
		c.gridheight = SystemParameters.gbc[i][3];
		c.weightx = SystemParameters.gbc[i][4];
		c.weighty = SystemParameters.gbc[i][5];
		c.fill = SystemParameters.gbc[i][6];
		c.anchor = SystemParameters.gbc[i][7];
		jframe.add(GUIConponent.get(i),c);
	}




	public static void main(String[] args) {
		fms obj = new fms();
		obj.set();
		obj.run();
	}
}

