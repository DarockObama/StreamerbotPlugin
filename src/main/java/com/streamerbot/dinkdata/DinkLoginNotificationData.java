package com.streamerbot.dinkdata;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collections;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class DinkLoginNotificationData extends DinkNotificationData {
    Progress collectionLog = new Progress();
    Progress combatAchievementPoints = new Progress();
    Progress achievementDiary = new Progress();
    Progress achievementDiaryTasks = new Progress();
    BarbarianAssault barbarianAssault = new BarbarianAssault();
    SkillData skills = new SkillData();
    Progress questCount = new Progress();
    Progress questPoints = new Progress();
    SlayerData slayer = new SlayerData();

    DinkLoginNotificationData() {
        super(DinkNotificationType.LOGIN);
    }

    //@Data
    public static class SkillData {
        long totalExperience;
        int totalLevel;
        Map<String, Integer> levels;
        Map<String, Integer> experience;

        public SkillData() {
            this.totalExperience = 0;
            this. totalLevel = 0;
            this.levels = Collections.emptyMap();
            this.experience = Collections.emptyMap();
        }
    }

    @Data
    public static class BarbarianAssault {
        int highGambleCount;

        public BarbarianAssault(){
            this.highGambleCount = 0;
        }
    }

    @Data
    public static class SlayerData {
        int points;
        int streak;

        public SlayerData() {
            this.points = 0;
            this.streak= 0;
        }
    }
}
