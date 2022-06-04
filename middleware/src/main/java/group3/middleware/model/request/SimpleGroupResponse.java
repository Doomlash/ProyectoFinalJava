package group3.middleware.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpleGroupResponse {
    private Long id;
    private String name;
    private String description;
}
