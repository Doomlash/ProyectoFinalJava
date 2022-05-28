package otakus_de_la_costa.grupo3.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupRequest {
    private String name;
    private String description;
    private Long userId;
}