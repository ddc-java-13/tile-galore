package edu.cnm.deepdive.tilegalore.model.pojo;

import androidx.room.TypeConverter;

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
