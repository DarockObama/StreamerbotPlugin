package streamerbot.dinkdata;

import lombok.Data;

@Data
public class Progress {
    int completed;
    int total;

    public Progress() {
        this.completed = 0;
        this.total = 0;
    }
}
