// CISC 3130
// Written by Sean Wy Tze Yap

import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class MovieListerApp {
    public static void main(String[] args) throws IOException {
	// open a file that contains a list of movies
	Scanner in = new Scanner(new File("../data/movies.csv"));
	// create a MovieLister object, which is a binary search tree data structure
	MovieLister movieLister = new MovieLister();
	// movielister object reads in the file we opened
	movieLister.read(in);
	// subset of the movielister
	MovieLister subset-1 = movieLister.filter(" ", " ");
    }

}
