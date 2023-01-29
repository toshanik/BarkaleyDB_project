package entities;

import com.sleepycat.persist.model.Entity;
import com.sleepycat.persist.model.PrimaryKey;
import com.sleepycat.persist.model.Relationship;
import com.sleepycat.persist.model.SecondaryKey;

import java.util.ArrayList;

@Entity
public class Anime {
    @PrimaryKey(sequence = "anime_pk")
    private int id;
    @SecondaryKey(relate = Relationship.ONE_TO_MANY, relatedEntity = Studio.class, name = "studio")
    private int id_studio;
    private String created;
    private String description;
    private String countries;
    private String genres;
    private String comments;

    public Anime() {
    }

    public Anime(int id, int id_studio, String created, String description,
                      String countries, String genres, String comments) {
        this.id = id;
        this.id_studio = id_studio;
        this.created = created;
        this.description = description;
        this.countries = countries;
        this.genres = genres;
        this.comments = comments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_studio() {
        return id_studio;
    }

    public void setId_studio(int id_studio) {
        this.id_studio = id_studio;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountries() {
        return countries;
    }

    public void setCountries(String countries) {
        this.countries = countries;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
    @Override
    public String toString() {
        return "Anime{" +
                "id=" + id +
                ", id_studio='" + id_studio + '\'' +
                ", created='" + created + '\'' +
                ", description='" + description + '\'' +
                ", countries='" + countries + '\'' +
                ", genres='" + genres + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }

}