package otakus_de_la_costa.grupo3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Group extends Messenger{
    private Long id;
    private String name;
    private String description;
    private Boolean active;
}