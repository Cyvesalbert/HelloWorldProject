package ht.networking;

import java.applet.AppletContext;
import java.awt.BorderLayout;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

// 
public class SiteSelector  extends JApplet{
	 private HashMap<String, URL> sites; // site names an URLs
	 private ArrayList<String> siteNames; // siteNames
	 private JList siteChooser; // list of sites to choose from
	 
	 // read parameters and set up GUI
	 public void init() {
		 sites = new HashMap<String, URL>(); // create hashmap
		 siteNames = new ArrayList<String>(); // create arrayList
		 
		 // obtain parameters from 
		 getSitesFromHTMLParameterset();
		 
		 
		 // create GUI components and lay out interface
		 add(new JLabel("Choose a site to browse"), BorderLayout.NORTH);
		 
		 siteChooser = new JList(siteNames.toArray()); // populate JList
		 siteChooser.addListSelectionListener(
				 new ListSelectionListener() {
					 // go to site user selected
					 public void valueChanged(ListSelectionEvent event) {
						 // get selected site name
						 Object object = siteChooser.getSelectedValue();
						 
						 // use site name to locate corresponding URL
						 URL newDocument = sites.get( object );
						 // get applet container
						 AppletContext browser = getAppletContext();
						 // tell applet container to change pages
						 browser.showDocument( newDocument );
					 }
				 }
				 );
		 
		 add(new JScrollPane(siteChooser), BorderLayout.CENTER);
	 }
	 
	 // obtain parameters from HTML document
	 private void getSitesFromHTMLParameterset() {
		 String title; // site title
		 String location; // location of site
		 URL url; // url of location
		 int counter = 0; // count number of sites
		 
		 title = getParameter( "title" + counter ); // get first site title
		 
		 // loop until no nmore parameters in HTML document
		 while(title != null) {
			 // obtain site location
			 location = getParameter( "location" + counter );
			 
			 try {
				 // place title/url in hashmap and title in arraylist
				 url = new URL(location); // convert location to url
				 sites.put(title, url); // put title/url in hashmap
				 siteNames.add(title); // put title in array list
			 }catch( MalformedURLException urlException) {
				 urlException.printStackTrace();
			 }
			 
			 ++counter;
			 title = getParameter("Title" + counter); /// get next site title
		 }
	 }
}
