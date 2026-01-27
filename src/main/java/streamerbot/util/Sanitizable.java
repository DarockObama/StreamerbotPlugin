package streamerbot.util;
import com.google.gson.Gson;

import java.util.Map;

public interface Sanitizable {

   Map<String, Object> sanitized(Gson gson);
}
