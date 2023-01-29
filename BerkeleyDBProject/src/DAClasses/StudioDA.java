package DAClasses;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.persist.EntityStore;
import com.sleepycat.persist.PrimaryIndex;
import entities.Studio;

import java.util.List;
import java.util.Map;

public class StudioDA {
    // Index Accessors
    PrimaryIndex<Integer, Studio> id;

    public StudioDA(EntityStore store) throws DatabaseException {

        // Primary key for Studio class
        id = store.getPrimaryIndex(Integer.class, Studio.class);
    }

    public List<Studio> get(){
        return this.id.map().values().stream().toList();
    }

    public Studio save(Studio studio){
        Integer id = this.id.sortedMap().lastKey();
        id = id == null ? 0 : id + 1;
        studio.setId(id);
        return this.id.put(studio);
    }

}