package streamerbot.dinkdata;

import com.google.gson.Gson;
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

    @Override
    public Map<String, Object> sanitized(Gson gson) {
        Map<String, Object> map = super.sanitized(gson);

        map.put("collectionLog", gson.toJson(collectionLog));
        map.put("combatAchievementPoints", gson.toJson(combatAchievementPoints));
        map.put("achievementDiary", gson.toJson(achievementDiary));
        map.put("achievementDiaryTasks", gson.toJson(achievementDiaryTasks));
        map.put("barbarianAssault", gson.toJson(barbarianAssault));
        map.put("skills", gson.toJson(skills));
        map.put("questCount", gson.toJson(questCount));
        map.put("questPoints", gson.toJson(questPoints));
        map.put("slayer", gson.toJson(slayer));

        return map;
    }

    @Data
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
