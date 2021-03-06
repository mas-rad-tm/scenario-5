package ch.globaz.tmmas.personnesservice.domain.event;

import ch.globaz.tmmas.personnesservice.domain.model.Adresse;
import ch.globaz.tmmas.personnesservice.domain.model.Localite;
import ch.globaz.tmmas.personnesservice.domain.model.PersonneMorale;
import lombok.ToString;

import java.time.ZonedDateTime;

@ToString
public class AdresseCreeEvent implements DomainEvent{


    private Localite localite;
    private String rue;
    private Integer numero;
    private String complement;
    private String dateDebutValidite;
    private Boolean isActive;
    private String nssPersonne;


    public AdresseCreeEvent(Localite localite, String rue, Integer numero, String complement, String dateDebutValidite,
                            Boolean isActive, String nssPersonne) {
        this.localite = localite;
        this.rue = rue;
        this.numero = numero;
        this.complement = complement;
        this.dateDebutValidite = dateDebutValidite;
        this.isActive = isActive;
        this.nssPersonne = nssPersonne;
    }

    public static DomainEvent fromEntity(Adresse nouvelleAdresse) {

        return new AdresseCreeEvent(nouvelleAdresse.getLocalite(),
                nouvelleAdresse.getRue(),
                nouvelleAdresse.getNumero(),
                nouvelleAdresse.getComplement(),
                nouvelleAdresse.getDateDebutValidite().format(formatter),
                nouvelleAdresse.getIsActive(),
                nouvelleAdresse.getPersonneMorale().getNss().getNss());
    }
}
