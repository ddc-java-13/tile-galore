package edu.cnm.deepdive.tilematch.model.pojo;

import androidx.room.TypeConverter;
import edu.cnm.deepdive.tilematch.model.entity.User;

public enum SkillLevel {
  EASY, SEASONED, VETERAN;

  @TypeConverter
  public static Integer skillLevelToInteger(SkillLevel value) {
    return (value != null) ? value.ordinal() : null;
  }

  @TypeConverter
  public static SkillLevel integerToSkillLevel(Integer value) {
    return (value != null) ? SkillLevel.values()[value] : null;
  }
}
