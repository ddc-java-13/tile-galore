package edu.cnm.deepdive.tilegalore.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.tilegalore.model.entity.Game;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface GameDao {

  @Insert
  Single<Long> insert(Game game);

  @Insert
  Single<List<Long>> insert(Game... games);

  @Insert
  Single<List<Long>> insert(Collection<? extends Game> games);

  @Update
  Single<Integer> update(Game game);

  @Update
  Single<Integer> update(Game... games);

  @Update
  Single<Integer> update(Collection<? extends Game> games);

  @Delete
  Single<Integer> delete(Game game);

  @Delete
  Single<Integer> delete(Game... games);

  @Delete
  Single<Integer> delete(Collection<? extends Game> games);

  @Query("SELECT * FROM game WHERE game_id = :gameId")
  LiveData<Game> select(long gameId);

  @Query("SELECT * FROM game WHERE user_id = :userId ORDER BY difficulty DESC")
  LiveData<List<Game>> selectByUser(long userId);
}
