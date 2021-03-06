package nl.hsleiden.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import nl.hsleiden.View;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Meer informatie over validatie:
 * http://hibernate.org/validator/
 *
 * @author Jordy van Dijk
 */
@Entity
@Table(name = "genres")
@NamedQueries({
        @NamedQuery(name = "Genre.getAll",
                    query = "SELECT g FROM Genre g"),

        @NamedQuery(name = "Genre.findByName",
                    query = "SELECT g FROM Genre g " +
                            "WHERE naam like :naam")
})
public class Genre {

    /**
     * Entity's unique identifier.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(View.Public.class)
    private long id;

    @NotEmpty
    @Length(min = 1, max = 255)
    @JsonView(View.Public.class)
    private String naam;

    @Length(max = 750)
    @JsonView(View.Public.class)
    private String beschrijving;

    /**
     * A no-argument constructor.
     */
    public Genre(){
    }

    @JsonCreator
    public Genre(@JsonProperty("naam") String naam,
                @JsonProperty("beschrijving") String beschrijving){
        this.naam = naam;
        this.beschrijving = beschrijving;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }
}
