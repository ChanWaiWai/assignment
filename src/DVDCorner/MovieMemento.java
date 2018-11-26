/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVDCorner;

/**
 *
 * @author user
 */
class MovieMemento implements Memento{
    private Movie movie;
    private String title;
    private String director;
    private int numAvailable;
    private int length;
    private int dvdID;
    public MovieMemento(Movie movie){
        this.movie = movie;
        this.dvdID = movie.getDvdID();
        this.director = movie.getDirector();
        this.length = movie.getLength();
        this.numAvailable = movie.getNumAvailable();
        this.title = movie.getTitle();
    }
    
    @Override
    public int getDvdId() {
        return movie.getDvdID();
    }

    @Override
    public String getTitle() {
        return movie.getTitle();
    }

    @Override
    public DVD getDVD() {
        return (Movie)movie;
    }

    @Override
    public void restore() {
        movie.setDirector(director);
        movie.setNumAvailable(numAvailable);
    }
}
