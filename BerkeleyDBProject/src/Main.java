import com.sleepycat.persist.EntityCursor;
import config.Database;
import entities.Anime;
import entities.Studio;
import DAClasses.AnimeDA;
import DAClasses.StudioDA;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    private static final Random random = new Random();
    public static void Lab3(){
        System.out.println("Lab 3 Starting");
        Database.setup();
        AnimeDA animeDA = new AnimeDA(Database.getStore());
        StudioDA studioDA = new StudioDA(Database.getStore());

        Studio studio = new Studio();
        studio.setId(0);

        studioDA.save(studio);

        Anime one = new Anime(
                0,
                studio.getId(),
                "03/Oct/2013",
                "Kill la Kill - Kill la Kill - After the murder of her father, Ryuuko Matoi has been wandering the land in search of his killer.",
                "Japan",
                "Action Comedy School",
                "Good"
        );

        Anime two = new Anime(
                1,
                studio.getId(),
                "11.11.2022",
                "Fullmetal Alchemist - In order for something to be obtained, something of equal value must be lost.",
                "Japan",
                "Military Adventure Shounen Action Fantasy Drama Magic",
                "Cool"
        );

        Anime three = new Anime(
                2,
                studio.getId(),
                "12.12.2022",
                "Gate: Jieitai Kanochi nite, Kaku Tatakaeri - Gate: Jieitai Kanochi nite, Kaku Tatakaeri: Off-duty Japan Self-Defense Forces (JSDF) officer and otaku.",
                "Japan",
                "Adventure Military Fantasy Action",
                "Nice"
        );

        animeDA.save(one);
        animeDA.save(two);
        animeDA.save(three);

        List<Anime> animes = animeDA.get();
        System.out.println("Anime: ");
        System.out.println(animes);

        System.out.println("Anime with id = 2: ");
        System.out.println(animeDA.get(2));


        System.out.println("Anime for team with id = 1: ");
        System.out.println(animeDA.getByStudioID(1));

        System.out.println(animeDA.delete(2));
        System.out.println(animeDA.upcreated(one));

        System.out.println("Anime after deleting and updating: ");
        System.out.println(animeDA.get());
    }

    public static void Lab4() {

        Database.setup();
        AnimeDA animeDA = new AnimeDA(Database.getStore());
        StudioDA studioDA = new StudioDA(Database.getStore());

        Studio studio = new Studio();
        studioDA.save(studio);
        studio = new Studio();
        studioDA.save(studio);

        System.out.println("Studios: ");
        System.out.println(studioDA.get());

        for (int i = 0; i < 4; i++){
            Anime anime = new Anime(
                    0,
                    1,
                    "12.12.2022",
                    "Gate: Jieitai Kanochi nite, Kaku Tatakaeri - Gate: Jieitai Kanochi nite, Kaku Tatakaeri: Off-duty Japan Self-Defense Forces (JSDF) officer and otaku.",
                    "Japan",
                    "Adventure Military Fantasy Action",
                    "Nice"
            );
            animeDA.save(anime);
        }

        int target = 5;

        try (EntityCursor<Anime> entityCursor = animeDA.cursor()) {
            for (Anime anime: entityCursor){
                if (anime.getId() == target)
                {
                    System.out.println("Found anime with target id: ");
                    System.out.println(anime);
                }
            }
        }

        target = 2;

        System.out.println("Animes before updating: ");
        System.out.println(animeDA.get(target));

        try (EntityCursor<Anime> entityCursor = animeDA.cursor()) {
            for (Anime anime: entityCursor){
                if (anime.getId() == 2)
                {
                    entityCursor.upcreated(anime);
                }
            }
        }

        System.out.println("Animes after updating: ");
        System.out.println(animeDA.get(target));
    }

    public static void main(String[] args) {
        Lab3();
        Lab4();
    }
}