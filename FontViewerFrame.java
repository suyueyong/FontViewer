import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JComponent;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.Color;
import java.awt.geom.Arc2D;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.QuadCurve2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class FontViewerFrame extends JFrame
{
	private String str = "The quick brown fox jumps over the lazy dog.";
	private JPanel HVPanel;
	private JPanel SSPanel;
	private JPanel HVSSPanel;
	private JPanel fontPanel;
	private JPanel textPanel;
	private JPanel buttonPanel;
	private JPanel verticalPanel;
	private JPanel horizontalPanel;
	private JPanel stylePanel;
	private JPanel sizePanel;
	private JLabel textLabel;
	private JPanel allPanel;
	private JButton button1,button2,button3,button4,button5;
	private ActionListener milistener;	
	private JRadioButton topButton;
	private JRadioButton centerButton;
	private JRadioButton bottomButton;
	private JRadioButton leftButton;
	private JRadioButton center2Button;
	private JRadioButton rightButton;
	private JCheckBox plainCheckbox;	
	private JCheckBox boldCheckbox;
	private JCheckBox italicCheckbox;
	private JComboBox sizeComboBox;
	private JComboBox fontComboBox;
	private JTextField textField;	
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenu helpMenu;
	private JMenuItem exitMenuItem;
	private JMenuItem viewHelpMenuItem;
	private JMenuItem aboutMenuItem;
	private ActionListener miListener;
	private DocumentListener docListener;
	
	public FontViewerFrame()
	{
		setTitle("Font Viewer");
		milistener = new FontViewerFrame.MIListener();
		menuBar();
		HPanel();
		VPanel();
		stylePanel();
		sizePanel();
		HVSSPanel();
		fontPanel();
		textPanel();
		allPanel();
		textLabel=new JLabel(str);
		add(textLabel,BorderLayout.CENTER);
		add(allPanel,BorderLayout.SOUTH);
		updateFont();
	}
	
	public void menuBar()
	{
      menuBar=new JMenuBar();
      miListener=new MIListener();      
      fileMenu=new JMenu("File");
      exitMenuItem=new JMenuItem("Exit");      
      fileMenu.add(exitMenuItem);
      helpMenu=new JMenu("Help");   
      viewHelpMenuItem=new JMenuItem("View Help");
      aboutMenuItem=new JMenuItem("About");      
      helpMenu.add(viewHelpMenuItem);
      helpMenu.add(aboutMenuItem);      
      menuBar.add(fileMenu);
      menuBar.add(helpMenu);
      exitMenuItem.addActionListener(miListener);
      viewHelpMenuItem.addActionListener(miListener);
      aboutMenuItem.addActionListener(miListener);      
      setJMenuBar(menuBar);
	}
	
		
	public void HPanel()
	{		
		horizontalPanel=new JPanel();
		horizontalPanel.setLayout(new GridLayout(1,3));
		horizontalPanel.setBorder(new TitledBorder(new EtchedBorder(), "Horizontal Alignment"));
		leftButton=new JRadioButton("Left");
		center2Button=new JRadioButton("Center");
		rightButton=new JRadioButton("Right");
		center2Button.setSelected(true);
	    leftButton.addActionListener(milistener);
		center2Button.addActionListener(milistener);
		rightButton.addActionListener(milistener);
		ButtonGroup horizontalGroup=new ButtonGroup();
		horizontalGroup.add(leftButton);
		horizontalGroup.add(center2Button);
		horizontalGroup.add(rightButton);
		horizontalPanel.add(leftButton);
		horizontalPanel.add(center2Button);
		horizontalPanel.add(rightButton);		
	}
	
	public void VPanel()
	{		
		verticalPanel=new JPanel();
		verticalPanel.setLayout(new GridLayout(1,3));
		verticalPanel.setBorder(new TitledBorder(new EtchedBorder(), "Vertical Alignment"));
		topButton=new JRadioButton("Top");
		centerButton=new JRadioButton("Center");
		bottomButton=new JRadioButton("Bottom");
		centerButton.setSelected(true);
		topButton.addActionListener(milistener);
		centerButton.addActionListener(milistener);
		bottomButton.addActionListener(milistener);
		ButtonGroup verticalGroup=new ButtonGroup();
		verticalGroup.add(topButton);
		verticalGroup.add(centerButton);
		verticalGroup.add(bottomButton);
		verticalPanel.add(topButton);
		verticalPanel.add(centerButton);
		verticalPanel.add(bottomButton);
	}
	
	public void stylePanel()
	{
		stylePanel=new JPanel();
		stylePanel.setLayout(new GridLayout(1,3));
		stylePanel.setBorder(new TitledBorder(new EtchedBorder(), "Style"));
		plainCheckbox=new JCheckBox("Plain");
		boldCheckbox=new JCheckBox("Bold");
		italicCheckbox=new JCheckBox("Italic");
		plainCheckbox.setSelected(true);
		plainCheckbox.addActionListener(milistener);
		boldCheckbox.addActionListener(milistener);
		italicCheckbox.addActionListener(milistener);
		stylePanel.add(plainCheckbox);
		stylePanel.add(boldCheckbox);
		stylePanel.add(italicCheckbox);		
	}
	
	public void sizePanel()
	{
		sizePanel=new JPanel();
		sizePanel.setLayout(new GridLayout(1,3));
		sizePanel.setBorder(new TitledBorder(new EtchedBorder(), "Size"));
		button2=new JButton("Grow");
		button3=new JButton("Shrink");
		sizeComboBox=new JComboBox();
	    int[] sizearray = { 8, 9, 10, 11, 12, 14, 16, 18, 20, 22, 24, 26, 28, 36, 48, 72 };

	    for (int i = 0; i < sizearray.length; i++)
	    {
	      sizeComboBox.addItem("" + sizearray[i]);
	    }

	    sizeComboBox.setSelectedItem("12");
		sizeComboBox.addActionListener(milistener);
		button2.addActionListener(milistener);
		button3.addActionListener(milistener);
		sizePanel.add(sizeComboBox);
		sizePanel.add(button2);
		sizePanel.add(button3);			
	}
	
	private void HVSSPanel()
	{
		HVSSPanel = new JPanel();
		HVSSPanel.setLayout(new GridLayout(2, 2));
	    HVSSPanel.add(sizePanel);
	    HVSSPanel.add(stylePanel);
	    HVSSPanel.add(horizontalPanel);
		HVSSPanel.add(verticalPanel);	
	}
	
	public void fontPanel()
	{
		fontPanel=new JPanel();
		fontPanel.setLayout(new GridLayout(1,3));
		fontPanel.setBorder(new TitledBorder(new EtchedBorder(), "Style"));		
		button4=new JButton("Next");
		button5=new JButton("Previous");
		fontComboBox=new JComboBox();
	    GraphicsEnvironment myfont = GraphicsEnvironment.getLocalGraphicsEnvironment();
	    Font[] fontarray = myfont.getAllFonts();
	    for (int i = 0; i < fontarray.length; i++)
	    {
	      String fontstr = fontarray[i].getFontName();
	      if ((fontstr.indexOf("Bold") == -1) && (fontstr.indexOf("Italic") == -1))
	      {
	        fontComboBox.addItem(fontstr);
	      }
	    }
		button4.addActionListener(milistener);
		button5.addActionListener(milistener);
		fontComboBox.addActionListener(milistener);
		fontPanel.add(fontComboBox);
		fontPanel.add(button4);
		fontPanel.add(button5);			
	}
	
	public void textPanel()
	{
		docListener=new FontViewerFrame.TextFieldDocumentListener();
		textPanel=new JPanel();
		textPanel.setLayout(new BorderLayout());
		textPanel.setBorder(new TitledBorder(new EtchedBorder(), "Enter Your Text Here:"));
	    textField=new JTextField(str,50);
	    textField.getDocument().addDocumentListener(docListener);
	    textPanel.add(textField);
	}
	
	public void allPanel()
	{
		allPanel=new JPanel();
		allPanel.setLayout(new BorderLayout());
		allPanel.add(textPanel,"North");
		allPanel.add(fontPanel,"Center");
		allPanel.add(HVSSPanel,"South");
		
	}
	
	  private void updateFont()
	  {
	    String str1 = textField.getText();

	    String str2 = (String)fontComboBox.getSelectedItem();

	    int i = Integer.parseInt((String)sizeComboBox.getSelectedItem());

	    int j = 0;
	    if (plainCheckbox.isSelected())
	    {
	      j += 0;
	    }
	    if (boldCheckbox.isSelected())
	    {
	      j++;
	    }
	    if (italicCheckbox.isSelected())
	    {
	      j += 2;
	    }

	    if (leftButton.isSelected())
	    {
	      textLabel.setHorizontalAlignment(2);
	    }
	    else if (center2Button.isSelected())
	    {
	      textLabel.setHorizontalAlignment(0);
	    }
	    else
	    {
	      textLabel.setHorizontalAlignment(4);
	    }

	    if (topButton.isSelected())
	    {
	      textLabel.setVerticalAlignment(1);
	    }
	    else if (centerButton.isSelected())
	    {
	      textLabel.setVerticalAlignment(0);
	    }
	    else
	    {
	      textLabel.setVerticalAlignment(3);
	    }

	    textLabel.setFont(new Font(str2, j, i));
	    textLabel.setText(str1);
	    textLabel.repaint();
	  }

	
	class MIListener implements ActionListener
	{
		MIListener()
		{
			
		}

	    public void actionPerformed(ActionEvent paramActionEvent)
	    {
	      String str = paramActionEvent.getActionCommand();

	      if (str.equals("Exit"))
	      {
	        System.exit(0);
	      }

	      if (str.equals("About"))
	      {
	        JOptionPane.showMessageDialog(null, "Font Viewer\nCreated by John Smith");
	      }

	      if (str.equals("Plain"))
	      {
	        if (!plainCheckbox.isSelected())
	        {
	          plainCheckbox.setSelected(true);
	        }
	        boldCheckbox.setSelected(false);
	        italicCheckbox.setSelected(false);
	      }

	      if (str.equals("Bold"))
	      {
	        if ((!boldCheckbox.isSelected()) && (!italicCheckbox.isSelected()))
	        {
	          plainCheckbox.setSelected(true);
	        }
	        else
	        {
	          plainCheckbox.setSelected(false);
	        }
	      }

	      if (str.equals("Italic"))
	      {
	        if ((!italicCheckbox.isSelected()) && (!boldCheckbox.isSelected()))
	        {
	          plainCheckbox.setSelected(true);
	        }
	        else
	        {
	          plainCheckbox.setSelected(false);
	        }
	      }

	      int i = fontComboBox.getSelectedIndex();

	      if ((str.equals("Next")) && (i < fontComboBox.getItemCount() - 1))
	      {
	        fontComboBox.setSelectedIndex(i + 1);
	      }

	      if ((str.equals("Previous")) && (i > 0))
	      {
	        fontComboBox.setSelectedIndex(i - 1);
	      }

	      int j = sizeComboBox.getSelectedIndex();

	      if ((str.equals("Grow")) && (j < sizeComboBox.getItemCount() - 1))
	      {
	        sizeComboBox.setSelectedIndex(j + 1);
	      }

	      if ((str.equals("Shrink")) && (j > 0))
	      {
	        sizeComboBox.setSelectedIndex(j - 1);
	      }

	      updateFont();
	    }
	}
	
	
	 class TextFieldDocumentListener
	    implements DocumentListener
	  {
	    TextFieldDocumentListener()
	    {
	    }

	    public void changedUpdate(DocumentEvent paramDocumentEvent)
	    {
	    }

	    public void insertUpdate(DocumentEvent paramDocumentEvent)
	    {
	    	updateFont();
	    }

	    public void removeUpdate(DocumentEvent paramDocumentEvent)
	    {
	    	updateFont();
	    }
	  }

}