// CISC 3130 
// Written by Sean Wy Tze Yap


// MovieLister is an implementation of the tree data structure, more specifically the binary search tree. 
public class MovieLister {
    // Constructor
    public MovieLister() {
	// sets the root of the tree to null 
	firstNode = null;
    }

    // Behaviors
    // read method takes in a csv file that contains a list of movies with its data
    public void read(Scanner in) {
	while (in.hasNext()) {
	    // line contains movieId, movieTitle, yearRelesed,  and movieGenre
	    String line = in.nextLine();
	    
	    // parse the line to get index of first and last comma
	    int firstCommaIndex = line.indexOf(',');
	    int lastCommaIndex = line.indexOf(',', firstCommaIndex+1);
	    // -1 if no more comma 
	    int nextComma = line.indexOf(',', lastCommaIndex+1); 
	    // obtain last comma 
	    while (nextComma != -1) {                // until no more comma left  
		lastCommaIndex = nextComma; 
		nextComma = line.indexOf(',', lastCommaIndex+1);	
	    }     	   
   	    // obtain title and year released which is in between first and last comma  
	    String movieTitleAndYear = line.substring(firstCommaIndex+1, lastCommaIndex);
	    int openParenthesisIndex = movieTitleAndYear.indexOf('(');
	    String year = movieTitleAndYear.substring(openParenthesisIndex+1, movieTitleAndYear.length()-1);
	    String title = movieTitleAndYear.substring(0, openParenthesisIndex-1);
	    
	    // make a new movie object using the data we parsed from the line
	    insert(title, year);
        }
    }

    // insert node into tree
    public void insert(String title, String year) {
	Movie newNode = new Movie(title, year);
	if (newNode == null) {             // no node in root
	    root = newNode;
	} 	
	else {
	    Movie current = root;          // start at root
	    Movie parent;
	    while (true) {                 // exits internally 
		parent = current;
		if (title.compareTo(current.getTitle() < 0) {     // go left (smaller)
		    current = current.getLeftChild();
		    if (current == null) {   // if end of the line
			parent.setLeftChild(newNode);
			return;
		    }
		}	
		else {                      // go right (bigger)
		    current = current.getRightChild();
		    if (current == null) {   // if end of the line
			parent.setRightChild(newNode);
			return;
		    }  
		}
	    }
	}
    }

    // find node 
    public Movie find(String title) {

    }

    // return a new tree data structure that contains a list of movies that meet the condition
    public MovieLister filter(String startTitle, String endTitle) {
	Movie start = find(startTitle);
	Movie end = find(endTitle);
	MovieLister newTree = new MovieLister();
		
    }
    // visit itself and print its values 
    public void print() {
	
    }
    // Fields 
    private Movie root;

}
