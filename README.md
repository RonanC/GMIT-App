GMIT Android Application
====================
GMIT - Mobile Programming - Lecturer: Brian Costello  
GMIT Android App project - 2nd May 2014 (Semester 4)

 
 Features:
-----
 MAIN ICONS
 *	Student Portal:
 	Uses a webview to display GMIT's student portal url
 	Students can access all their GMIT services here
 	
 *	SU News:
 	Uses a webview to display GMIT's SU Facebook feed
 	Students can get all their SU news here
 	
 *	Bus:
 	Uses a webview to display the GMIT bus stop bus times
 	Students can find out immediately what buses are coming
 	This page implements a refresh textView at the bottom to refresh the page
 	
 *	Gallery:
 	Uses a GridView with an ImageView to display all the images using an adapter
 	Tap on an image to bring you to the fullscreen page, where you can rotate
 	Tap back to reverse, (ViewPager for swiping to be added later)
 	
 *	Map:
 	Uses a Fragment to hold the Google Map
 	This app is linked with the Google Console API via a key
 	This key allows this app to download map images for display
 	All of GMIT's campuses are located with a GMIT icon
 	Various GMIT facilities are shown with blue pins
 	Red pins for student relevant places of interest non affiliated with GMIT
 	Students can find out quickly where various GMIT related places are located
 	
 *	Clubs/Socs:
 	Uses a ListView with an ArrayAdapter to inflate it
 	Tap on a club/society to view its page (yet to be filled out), which shows text, an image and a link to their facebook
 	At the moment it is a generic page with a link to the SU Societies page
 	
 	
 *	Contact:
 	Uses a ListView with an ArrayAdapter to inflate it
 	Tap on any of the contacts to bring up the phone dialog for you to call said contact
 	All contact information is correct
 	This is great for GMIT students, parents and prospective students alike
 	
 *	Notes:
 	Uses a ListView with an ArrayAdapter to inflate it
 	It gets its list from the Notebook class which handles all the notebook functionality
 	As of now its only one string of text, but could be further enhanced for saving title text and paint drawings/images
 	The notebook is loaded on launch and saved on finish
 	When a note is created the book is saved,
 	You must have one note created for a save file to be created and thus for the load to work
 	You can specify wheather to save on internal memory (default) or SD card
 	You can also specify the name of your notebook (default: notebook.ser), when you change the name then it is a new notebook
 	Keep note of previous note book names if you wish to retrieve them later
 	Tap a note to edit it
 	Long press a note to remove it
 	Add a new note from the options menu
 	Change your note preferences in the "AppApp Prefs" option on the notes pages
 	
 	This notes feature is great for students as they can keep important facts/details they need to remember in one place
 	
 	
 *	Courses:
 	Uses a ListView with an ArrayAdapter to inflate it
 	Show the five schools within GMIT
 	Tap on a school to bring you to the schoolInfo page which shows a text view outlining the school

OPTIONS: 
-----
 *	Share:
 	Brings up a dialog with various places to share the app
 	
 *	Sponsors:
 	Outlines the sponsors of GMIT
 	
 *	Scholarships:
 	Outlines the Scholarships of GMIT
 	
 *	Facilities:
 	Outlines the Facilities of GMIT
 		
 *	Fixtures & Results:
 	Uses a webview to display GMIT's GAA fixtures
 	
 *	About:
 	Uses a Text view and images to describe GMIT
 	
 *	Test:
 	Uses RadioGroup, RadioButtons, Dynamically added buttons, Spinners and EditViews to showcase the notification feature
 	This notification shows icons, longtext, shorttext, heading, defualt sound
 	A tap on any of the icons brings you to the about page
 	This notification feature will be used by the SU to push important info to students
 	
 	
 Extra Information:
-----
 *	Most of the testing was done on a Nexus 4 device, to see my vision test it with this emulator.
 	it seems to be okay with other devices though (tested with emulator).
 *	GMIT Icon made with the 2 official colours, made into a button with a bevel for added effect.
 *	All pages have a back arrow button implemented in the action bar beside the app Icon
 * 	Menus taken off most pages, where appropriate
 * 	Code is up on GitHub for others to view
 *	If you uninstall the app, the notes are deleted as well as the preferences
 
 
 Installation Instructions:
-----
 *	open apk up on your phone
 
 
 Running the Application:
-----
 *	Running the application is simple, follow the instructions above in order to install the app
 *	Once installed read through the features list above to get a feel for the app features
 *	This app is very intuitive and straight forward
 *	The only thing I would state is that notes are saved to individual notebooks,
 	you can get the notebooks back if you remember their name, or find them in your file manager
 	when you uninstall the app, the notes are deleted
 * 	Most importantly, enjoy the app, make life easier for yourself, and tell everyone about it! :)
 
 
  Developer:
-----
 *	Developed by GMIT student Ronan Connolly (G00274374) in conjunction with GMIT for a Mobile Programming project - (May 2014)
 
