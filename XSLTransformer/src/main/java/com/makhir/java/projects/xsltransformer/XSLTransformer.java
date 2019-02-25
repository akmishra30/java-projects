package com.makhir.java.projects.xsltransformer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Node;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.InputSource;

public class XSLTransformer implements ActionListener {
	private static JFrame mainScreen;
	private static JPanel mainPanel;
	private static JLayeredPane insertLayPan, resultLayPan, operationLayPan;
	private static JLabel xmlFileLabel, xslFileLabel;
	private static JFileChooser fileChooser;
	private static File xslFile, xmlFile;
	private static JButton xmlFileSelector, xslFileSelector, transformButton, saveButton, clearButton, formatButton;
	private static JTextArea textArea;
	private static JScrollPane scrollPane;

	static {
		initComponents();
	}

	/**
	 * Inits the components.
	 */
	private static void initComponents() {
		mainScreen = new JFrame("m@kh!r: XSLT Transformer");
		mainPanel = new JPanel();
		resultLayPan = new JLayeredPane();
		insertLayPan = new JLayeredPane();
		xmlFileLabel = new JLabel();
		xslFileLabel = new JLabel();
		operationLayPan = new JLayeredPane();
		// Initializing the file chooser component
		fileChooser = new JFileChooser();
		fileChooser.setMultiSelectionEnabled(true);
		/* Setting Current Directory */
		fileChooser.setCurrentDirectory(new File("."));
		fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
			public boolean accept(File f) {
				return f.getName().toLowerCase().endsWith(".xml") || f.getName().toLowerCase().endsWith(".xsl")
						|| f.isDirectory();
			}

			@Override
			public String getDescription() {
				return "XML or XSL File";
			}
		});
		xmlFileSelector = new JButton();
		xslFileSelector = new JButton();
		transformButton = new JButton();
		saveButton = new JButton();
		xmlFile = null;
		xslFile = null;
		textArea = new JTextArea();
		scrollPane = new JScrollPane();
		clearButton = new JButton();
		formatButton = new JButton();
	}

	public void createGUI() {
		// Main Screen height-width
		mainScreen.setSize(845, 630);

		// Main Panel height-width
		mainPanel.setBorder(new BevelBorder(BevelBorder.RAISED, Color.gray, Color.pink, Color.white, Color.white));
		mainPanel.setLayout(null);
		mainPanel.setSize(mainScreen.getSize().width - ScreenSizeConstants.mainPanelWidthDiff,
				mainScreen.getSize().height - ScreenSizeConstants.mainPanelHeightDiff);

		// ---- xmlFileLabel ----
		xmlFileLabel.setText("XML File");
		xmlFileLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		insertLayPan.add(xmlFileLabel, JLayeredPane.DEFAULT_LAYER);
		xmlFileLabel.setBounds(15, 25, 125, xmlFileLabel.getPreferredSize().height);

		// ---- xslFileLabel ----
		xslFileLabel.setText("XSL File");
		xslFileLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		insertLayPan.add(xslFileLabel, JLayeredPane.DEFAULT_LAYER);
		xslFileLabel.setBounds(15, 78, 125, 14);

		// ---- xmlFileSelector button ----
		xmlFileSelector.setText("Select XML File");
		xmlFileSelector.setFont(new Font("Tahoma", Font.BOLD, 12));
		xmlFileSelector.setToolTipText("Click here to select the xml file from your directory");
		insertLayPan.add(xmlFileSelector, JLayeredPane.DEFAULT_LAYER);
		xmlFileSelector.setBounds(18, 48, 160, 25);
		xmlFileSelector.addActionListener(this);

		// ---- xslFileSelector button ----
		xslFileSelector.setText("Select XSL File");
		xslFileSelector.setFont(new Font("Tahoma", Font.BOLD, 12));
		xslFileSelector.setToolTipText("Click here to select the xsl file from your directory");
		insertLayPan.add(xslFileSelector, JLayeredPane.DEFAULT_LAYER);
		xslFileSelector.setBounds(18, 100, 160, 26);
		xslFileSelector.addActionListener(this);

		// ---- File Selection layered panel
		insertLayPan.setBorder(new TitledBorder(null, "File Selection", TitledBorder.LEADING,
				TitledBorder.DEFAULT_POSITION, new Font("Tahoma", Font.BOLD, 12), Color.blue));
		insertLayPan.setBounds(10, 8, 200, 150);
		mainPanel.add(insertLayPan);

		// ---- Transformation button ----
		transformButton.setText("Transform");
		transformButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		transformButton.setToolTipText("Click here to transform the xml through xsl");
		operationLayPan.add(transformButton, JLayeredPane.DEFAULT_LAYER);
		transformButton.setBounds(18, 30, 160, 25);
		transformButton.addActionListener(this);

		// ---- Save button ----
		saveButton.setText("Save");
		saveButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		saveButton.setToolTipText("Click here to save the xml");
		operationLayPan.add(saveButton, JLayeredPane.DEFAULT_LAYER);
		saveButton.setBounds(18, 65, 160, 25);
		saveButton.addActionListener(this);

		// ---- Format button ----
		formatButton.setText("Format XML");
		formatButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		formatButton.setToolTipText("Click here to format xml");
		operationLayPan.add(formatButton, JLayeredPane.DEFAULT_LAYER);
		formatButton.setBounds(18, 100, 160, 25);
		formatButton.addActionListener(this);
		// ---- Clear button ----
		clearButton.setText("Clear");
		clearButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		clearButton.setToolTipText("Click here to clear result area");
		operationLayPan.add(clearButton, JLayeredPane.DEFAULT_LAYER);
		clearButton.setBounds(18, 138, 160, 25);
		clearButton.addActionListener(this);

		// ---- Operations layered panel
		operationLayPan.setBorder(new TitledBorder(null, "Operation", TitledBorder.LEADING,
				TitledBorder.DEFAULT_POSITION, new Font("Tahoma", Font.BOLD, 12), Color.blue));
		operationLayPan.setBounds(10, 158, 200, 190);
		mainPanel.add(operationLayPan);

		// Setting height and width of component
		resultLayPan.setBounds(220, 8, mainPanel.getSize().width - ScreenSizeConstants.resultLayPanWidthDiff,
				mainPanel.getSize().height - ScreenSizeConstants.resultLayPanHeightDiff);
		scrollPane.setBounds(20, 25, resultLayPan.getSize().width - ScreenSizeConstants.scrollPaneWidthDiff,
				resultLayPan.getSize().height - ScreenSizeConstants.scrollPaneHeightDiff);
		textArea.setBounds(5, 5, scrollPane.getSize().width - ScreenSizeConstants.textAreaWidthDiff,
				scrollPane.getSize().height - ScreenSizeConstants.textAreaHeightDiff);

		// ----- textArea ------
		textArea.setText("");
		// textArea.setBounds(5, 5, 520, 520);
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textArea.setLineWrap(true);

		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.add(textArea);
		// scrollPane.setBounds(20, 25, 560, 540);
		scrollPane.setAutoscrolls(true);
		scrollPane.setViewportView(textArea);
		resultLayPan.add(scrollPane, JLayeredPane.DEFAULT_LAYER);

		// Display result panel
		resultLayPan.setBorder(new CompoundBorder(new TitledBorder(null, "Transformation Result", TitledBorder.LEADING,
				TitledBorder.DEFAULT_POSITION, new Font("Tahoma", Font.BOLD, 12), Color.blue), null));
		// resultLayPan.setBounds(220, 8, 600, 582);
		mainPanel.add(resultLayPan);

		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		mainScreen.setLocation(screenWidth / 4, screenHeight / 4 - 200);
		mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainScreen.setVisible(true);
		mainScreen.getContentPane().add(mainPanel);

		final int initialWidth = mainScreen.getSize().width;
		final int initialHeight = mainScreen.getSize().height;
		mainScreen.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent event) {
				int width = Math.max(initialWidth, mainScreen.getWidth());
				int height = Math.max(initialHeight, mainScreen.getHeight());
				mainPanel.setSize(width - ScreenSizeConstants.mainPanelWidthDiff,
						height - ScreenSizeConstants.mainPanelHeightDiff);
				resultLayPan.setSize(mainPanel.getSize().width - ScreenSizeConstants.resultLayPanWidthDiff,
						mainPanel.getSize().height - ScreenSizeConstants.resultLayPanHeightDiff);
				scrollPane.setSize(resultLayPan.getSize().width - ScreenSizeConstants.scrollPaneWidthDiff,
						resultLayPan.getSize().height - ScreenSizeConstants.scrollPaneHeightDiff);
				textArea.setSize(scrollPane.getSize().width - ScreenSizeConstants.textAreaWidthDiff,
						scrollPane.getSize().height - ScreenSizeConstants.textAreaHeightDiff);
			}
		});
	}

	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		String message = "";
		int result = -1;
		textArea.setForeground(Color.BLACK); // Setting default color
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 12)); // Setting default
																// format
		if (command.equalsIgnoreCase("Select XML File")) {
			result = fileChooser.showOpenDialog(new JFrame());
		} else if (command.equalsIgnoreCase("Select XSL File")) {
			result = fileChooser.showOpenDialog(new JFrame());
		} else if (command.equalsIgnoreCase("Transform")) {
			if (xmlFile != null && xslFile != null) {
				try {
					// message = transform(xmlFile, xslFile);
					transform(xmlFile, xslFile);
					// textArea.setText(message);
				} catch (Exception e) {
					textArea.setFont(new Font("Tahoma", Font.BOLD, 12));
					textArea.setForeground(Color.RED);
					textArea.setText(e.getLocalizedMessage());
				}
			} else {
				if (xmlFile == null)
					JOptionPane.showMessageDialog(null, "Please, select xml file for transformation");
				else if (xslFile == null)
					JOptionPane.showMessageDialog(null, "Please, select xsl file for transformation");
				else
					JOptionPane.showMessageDialog(null, "Please, provide some valuable input");
			}
		} else if (command.equalsIgnoreCase("Save")) {
			JOptionPane.showMessageDialog(null, "Yet not implemented..!!");
		} else if (command.equalsIgnoreCase("Clear")) {
			textArea.setText("");
		} else if (command.equalsIgnoreCase("Format XML")) {
			try {
				if (textArea.getText().length() > 0)
					textArea.setText(formatXML(textArea.getText()));
			} catch (Exception e) {
				textArea.setFont(new Font("Tahoma", Font.BOLD, 12)); // "Tahoma",
																		// Font.BOLD,
																		// 12,
																		// Color.red
				textArea.setForeground(Color.RED);
				textArea.setText(e.getLocalizedMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "What is this?");
		}

		if (result == JFileChooser.APPROVE_OPTION) {
			File tempFile = fileChooser.getSelectedFile();
			if (tempFile != null && tempFile.getName().toLowerCase().endsWith(".xml"))
				xmlFile = tempFile;
			else if (tempFile != null && tempFile.getName().toLowerCase().endsWith(".xsl"))
				xslFile = tempFile;
			else
				JOptionPane.showMessageDialog(null, "Selected file " + fileChooser.getSelectedFile().getName()
						+ " may not useful for xsl transformation.");
		} else if (result == JFileChooser.CANCEL_OPTION) {
			JOptionPane.showMessageDialog(null, "You haven't select any file for transformation");
		}
	}

	/**
	 * Transform the xml with use of xslt
	 */
	public void transform(File xmlFile, File xslFile) {
		try {
			TransformerFactory factory = TransformerFactory.newInstance();
			Source xslt = new StreamSource(xslFile);
			Transformer transformer = factory.newTransformer(xslt);
			Source inputXML = new StreamSource(xmlFile);
			StringWriter writer = new StringWriter();
			Result result = new StreamResult(writer);
			if (xmlFile.exists() && xslFile.exists()) {
				StreamResult output = new StreamResult(writer);
				transformer.transform(inputXML, output);
				textArea.setText(formatXML(writer.toString()));
				;
			} else
				throw new Exception("XML or XSL File not found.");

		} catch (TransformerException e) {
			e.printStackTrace();
			StringWriter writer = new StringWriter();
			e.printStackTrace(new PrintWriter(writer));
			textArea.setFont(new Font("Tahoma", Font.PLAIN, 10));
			textArea.setForeground(Color.RED);
			textArea.setText(writer.toString());
			// throw e;
		} catch (Exception e) {
			// e.printStackTrace();
			StringWriter writer = new StringWriter();
			e.printStackTrace(new PrintWriter(writer));
			textArea.setFont(new Font("Tahoma", Font.BOLD, 12));
			textArea.setForeground(Color.BLACK);
			textArea.setText(writer.toString());
		}
	}

	/**
	 * This method format the xml with tagging and newline
	 */
	public String formatXML(String xml) throws Exception {
		try {
			InputSource src = new InputSource(new StringReader(xml));
			Node document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(src).getDocumentElement();
			boolean keepDeclaration = xml.startsWith("<?xml");
			DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
			DOMImplementationLS impl = (DOMImplementationLS) registry.getDOMImplementation("LS");
			LSSerializer writer = impl.createLSSerializer();
			writer.getDomConfig().setParameter("format-pretty-print", true); // Set
																				// this
																				// to
																				// true
																				// if
																				// the
																				// output
																				// needs
																				// to
																				// be
																				// beautified.
			writer.getDomConfig().setParameter("xml-declaration", keepDeclaration); // Set
																					// this
																					// to
																					// true
																					// if
																					// the
																					// declaration
																					// is
																					// needed
																					// to
																					// be
																					// outputted.
			LSOutput output = impl.createLSOutput();
			output.setEncoding("UTF-8");
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			output.setByteStream(stream);
			writer.write(document, output);
			return new String(stream.toByteArray(), "UTF-8");
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		try {
			new XSLTransformer().createGUI();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	class ScreenSizeConstants{
		static final int mainPanelWidthDiff = 10;
		static final int mainPanelHeightDiff = 10;
		static final int resultLayPanWidthDiff = -200;
		static final int resultLayPanHeightDiff = 2;
		static final int scrollPaneWidthDiff = 500;
		static final int scrollPaneHeightDiff = 50;
		static final int textAreaWidthDiff = 100;
		static final int textAreaHeightDiff = 200;
	}
}
