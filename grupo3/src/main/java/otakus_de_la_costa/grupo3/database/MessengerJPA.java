package otakus_de_la_costa.grupo3.database;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "messengers")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
public class MessengerJPA {
    @Id
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "sender")
    private List<MessageJPA> sent;

    @OneToMany(mappedBy = "receiver")
    private List<MessageJPA> received;
}