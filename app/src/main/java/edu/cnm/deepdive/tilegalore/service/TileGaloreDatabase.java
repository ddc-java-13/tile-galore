package edu.cnm.deepdive.tilegalore.service;

import android.app.Application;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import edu.cnm.deepdive.tilegalore.model.dao.GameDao;
import edu.cnm.deepdive.tilegalore.model.dao.UserDao;
import edu.cnm.deepdive.tilegalore.model.entity.Game;
import edu.cnm.deepdive.tilegalore.model.entity.User;
import edu.cnm.deepdive.tilegalore.service.TileGaloreDatabase.Converters;
import java.util.Date;

@Database(
    entities = {Game.class, User.class},
    version = 1,
    exportSchema = true
)
@TypeConverters({Converters.class})
public abstract class TileGaloreDatabase extends RoomDatabase {

  private static final String DB_NAME = "tileGalore-db";

  private static Application context;

  public static void setContext(Application context) {
    TileGaloreDatabase.context = context;
  }

  public static TileGaloreDatabase getInstance() {
    return InstanceHolder.INSTANCE;
  }

  public abstract GameDao getGameDao();

  public abstract UserDao getUserDao();

  private static class InstanceHolder {

    private static final TileGaloreDatabase INSTANCE =
        Room.databaseBuilder(context, TileGaloreDatabase.class, DB_NAME)
        .build();

  }

  public static class Converters {

    @TypeConverter
    public static Long toLong(Date value) {
      return(value != null) ? value.getTime() : null;
    }

    @TypeConverter
    public static Date toDate(Long value) {
      return(value != null) ? new Date(value) : null;
    }

  }



}
