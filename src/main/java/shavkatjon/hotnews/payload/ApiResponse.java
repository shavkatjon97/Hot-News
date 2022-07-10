package shavkatjon.hotnews.payload;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApiResponse {
    public ApiResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    String message;
    boolean success;
    Object data;
}
