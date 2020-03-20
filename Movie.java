public class Movie {
    // Constructors - two different option of arguments to allow user more flexibility when instantiate new movie object  
    public Movie(String title, String releaseYear) {
	this.title = title;
	this.releaseYear = releaseYear;
    }
    public Movie(String title, String releaseYear, String[] genres, int movieId) {
	this(title, releaseYear);
	this.genres = genres;
	this.movieId = movieId;
    }
    public void setLeftChild(Movie newNode) {
        leftChild = newNode;
    }
    public void setRightChild(Movie newNode) {
	rightChild = newNode;
    }
    public Movie getLeftChild() { 
	return leftChild;
    }
    public Movie getRightChild() {
 	return rightChild;
    }

    // Fields
    private String title;
    private String releaseYear;
    private String[] genres;
    private int movieId;
    // References to left and right node
    private Movie leftChild;
    private Movie rightChild; 
}
