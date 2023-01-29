package entities;

import com.sleepycat.persist.model.Entity;
import com.sleepycat.persist.model.PrimaryKey;
import com.sleepycat.persist.model.Relationship;
import com.sleepycat.persist.model.SecondaryKey;

import java.util.ArrayList;

@Entity
public class Voiceover {
    @PrimaryKey(sequence = "voiceover_pk")
    private int id;
    private String name_voiceover;
    private String participants;
    private String information;
    private String link;

    public Voiceover() {
    }

    public Voiceover(int id, String name_voiceover, String participants,
                      String information, String link) {
        this.id = id;
        this.name_voiceover = name_voiceover;
        this.participants = participants;
        this.information = information;
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_voiceover() {
        return name_voiceover;
    }

    public void setName_voiceover(String name_voiceover) {
        this.name_voiceover = name_voiceover;
    }

    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Voiceover{" +
                "id=" + id +
                ", name_voiceover='" + name_voiceover + '\'' +
                ", participants='" + participants + '\'' +
                ", information='" + information + '\'' +
                ", link='" + link + '\'' +
                '}';
    }

}