package ProblemB;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("DVDs")
public class DVD extends Product {
    private String genre;

    public DVD() {
    }

    public DVD(String name, String description, String genre) {
        super(name, description);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
