package group3.mvc.model.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RelationRequest {
    private Long relationOwner;
    private Long related;
}