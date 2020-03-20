public class Movie {
    // Constructors - two different option of arguments to allow user more flexibility when instantiate new movie object  
    public Movie(String title, int releaseYear) {
	this.title = title;
	this.releaseYear = releaseYear;
    }
    public Movie(String title, int releaseYear, String[] genres, int movieId) {
	this(title, releaseYear);
	this.genres = genres;
	this.movieId = movieId;
    }
    public void setLeftNode(Movie newNode) {
        leftNode = newNode;
    }
    public void setRightNode(Movie newNode) {
	rightNode = newNode;
    }

    // Fields
    private String title;
    private int releaseYear;
    private String[] genres;
    private int movieId;
    // References to left and right node
    private Movie leftNode;
    private Movie rightNode; 
}
