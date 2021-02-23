package democonsumer.message;

import lombok.*;

import java.io.Serializable;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Sample implements Serializable {
    private Long   id;
    private String message;
}
