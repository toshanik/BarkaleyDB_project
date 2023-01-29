package DAClasses;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.persist.*;
import entities.Anime;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

public class AnimeDA {
    // Index Accessors
    PrimaryIndex<Integer, Anime> id;
    SecondaryIndex<Integer, Integer, Anime> id_studio;

    public AnimeDA(EntityStore store) throws DatabaseException {

        // Primary key for Anime class
        id = store.getPrimaryIndex(Integer.class, Anime.class);
        id_studio = store.getSecondaryIndex(id, Integer.class, "studio");
    }
    public EntityCursor<Anime> cursor(){
        return this.id.entities();
    }

    public List<Anime> get(){
        return this.id.map().values().stream().toList();
    }

    public Anime get(Integer id){
        return this.id.get(id);
    }

    public List<Anime> getByStudioID(Integer id_studio){
        EntityJoin<Integer, Anime> join = new EntityJoin<>(this.id);
        join.addCondition(this.id_studio, id_studio);
        try (ForwardCursor<Anime> entities = join.entities()) {
            return StreamSupport.stream(entities.spliterator(), false).toList();
        }
        catch (DatabaseException exc){
            return new ArrayList<>();
        }
    }

    public Anime save(Anime anime){
        Integer id = this.id.sortedMap().lastKey();
        id = id == null ? 0 : id + 1;
        anime.setId(id);
        return this.id.put(anime);
    }


    public Anime upcreated(Anime anime){
        return this.id.put(anime);
    }

    public boolean delete(Integer id){
        return this.id.delete(id);
    }
}