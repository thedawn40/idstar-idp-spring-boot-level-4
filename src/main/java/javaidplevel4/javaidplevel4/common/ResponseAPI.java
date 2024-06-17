package javaidplevel4.javaidplevel4.common;

import lombok.*;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseAPI {
    private Integer code;
    private String message;
    private HttpStatus status;
    private Object data;
}
