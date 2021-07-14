package edu.cnm.deepdive.tilematch.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import edu.cnm.deepdive.tilematch.model.entity.Game;
import java.util.List;

@Dao
public interface GameDao {

  @Query("SELECT * FROM game WHERE game_id = :gameId")
  LiveData<Game> select(long gameId);

  @Query("SELECT * FROM game WHERE user_id = :userId ORDER BY difficulty DESC")
  LiveData<List<Game>> selectByUser(long userId);
}
