package edu.cnm.deepdive.tilematch.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import edu.cnm.deepdive.tilematch.model.pojo.SkillLevel;
import java.util.Date;


@Entity
public class User {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "user_id")
  private long id;

  @NonNull
  private Date timestamp = new Date();

  @NonNull
  @ColumnInfo(name = "user_name")
  private String userName;

  @NonNull
  @ColumnInfo(index = true)
  private SkillLevel skill;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @NonNull
  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(@NonNull Date timestamp) {
    this.timestamp = timestamp;
  }

  @NonNull
  public String getUserName() {
    return userName;
  }

  public void setUserName(@NonNull String userName) {
    this.userName = userName;
  }

  @NonNull
  public SkillLevel getSkill() {
    return skill;
  }

  public void setSkill(@NonNull SkillLevel skill) {
    this.skill = skill;
  }
}
