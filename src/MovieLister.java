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
	Movie current = root;
	String currentTitle = current.getTitle();
	while (currentTitle != title) {                      // until we reach the desired title or cant find it
	    if (currentTitle.compareTo(title) < 0)           // go left because value is less than parent
		current = current.getLeftChild();
	    else 
		current = current.getRightChild();           // go right because value is more than parent
	    if (current == null) 
		return null;
	    currentTitle = current.getTitle();               // update title to new value after we assign new value to current
	}
	return current;
    }

    // return a new tree data structure that contains a list of movies that meet the condition
    public MovieLister filter(String startTitle, String endTitle) {
	Movie start = find(startTitle);         // smaller
	Movie end = find(endTitle); 		// bigger
	Movie current = start.getRightChild();  // doesnt include start 
	MovieLister newTree = new MovieLister();

 	// small to big so we traverse right until we reach target
	while (!current.equals(end)) {          // for the sake of simplicity we assume that theres a valid start and end
	    if (current == null)                // reached a leaf so we have to go back to root  
		current = root;                 // assuming we reached the left subtree of the root instead of the right bc then we would have found the value already since right is the largest 
	    newTree.insert(current.getTitle(), current.getYear());
	    current = current.getRightChild();
	}
	return newTree;
    }
	
    // visit itself and print its values 
    public void print() {
	
    }
    // Fields 
    private Movie root;

}
