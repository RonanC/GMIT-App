package ie.gmit.gmit;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
 * This class deals with the notebook
 * We could change this from a list of strings to having many lists
 * for instance we could have more data with each list entry like note title
 * we could save drawings also
 * 
 * This notebook is serializable
 */

public class Notebook implements Serializable {
	private List<String> notebook = new ArrayList<String>();
	
	public Notebook(){
	}

	public List<String> getNotebook() {
		return notebook;
	}

	public void setNotebook(ArrayList<String> notebook) {
		this.notebook = notebook;
	}
	
	public void addNote(String note){
		notebook.add(note);
	}
	
	public String getNote(int index){
		return notebook.get(index);
	}
	
	public void editNote(int index, String newText){
		notebook.remove(index);
		notebook.add(index, newText);
	}
	
	public int getSize(){
		return notebook.size();
	}
	
	public void removeNote(int index){
		notebook.remove(index);
	}
	
	public void init(){
		notebook.add("First note");
		notebook.add("Second note");
		notebook.add("Third note");
		notebook.add("Fourth note");
		notebook.add("Fifth note");
		notebook.add("Sixth note");
		notebook.add("Seventh note");
		notebook.add("Eight note");
		notebook.add("Ninth note");
		notebook.add("Bananas");
	}
	
	public void load(FileInputStream fis) throws Exception{
		ObjectInputStream in = new ObjectInputStream(fis);
		notebook = (ArrayList<String>) in.readObject();
	}
	
	public void save(FileOutputStream fos) throws IOException{
		ObjectOutputStream out = new ObjectOutputStream(fos);
		out.writeObject(notebook);
	}
}
