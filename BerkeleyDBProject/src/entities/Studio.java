package entities;

import com.sleepycat.persist.model.Entity;
import com.sleepycat.persist.model.PrimaryKey;
import com.sleepycat.persist.model.Relationship;
import com.sleepycat.persist.model.SecondaryKey;

import java.util.ArrayList;

@Entity
public class Studio {
    @PrimaryKey(sequence = "studio_pk")
    private int id;
    private String name_studio;
    private String country_studio;
    private String date;

    public Studio() {
    }

    public Studio(int id, String name_studio, String country_studio, String date) {
        this.id = id;
        this.name_studio = name_studio;
        this.country_studio = country_studio;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_studio() {
        return name_studio;
    }

    public void setName_studio(String name_studio) {
        this.name_studio = name_studio;
    }

    public String getCountry_studio() {
        return country_studio;
    }

    public void setCountry_studio(String country_studio) {
        this.country_studio = country_studio;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Studio{" +
                "id=" + id +
                ", name_studio='" + name_studio + '\'' +
                ", country_studio='" + country_studio + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

}