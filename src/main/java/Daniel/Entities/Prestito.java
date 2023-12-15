package Daniel.Entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

public class Prestito {
    @Id
    @GeneratedValue
    private UUID numero_tessera;

}
