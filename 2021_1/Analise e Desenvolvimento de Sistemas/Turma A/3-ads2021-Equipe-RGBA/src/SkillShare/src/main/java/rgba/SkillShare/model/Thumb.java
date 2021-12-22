package rgba.SkillShare.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;

/**
 *  Classe que define o arquivo do tipo thumb 
 *  @author Nicholas Roque
 */
@Entity(name="thumb")
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString
public class Thumb {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JsonIgnore
    @OneToOne(mappedBy = "thumb")
    private Destaque destaque;

    @JsonIgnore
    @OneToOne(mappedBy = "thumb")
    private Evento evento;
    
    @JsonIgnore
    @OneToOne(mappedBy = "thumb")
    private Curso curso;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_arquivo",referencedColumnName = "id")
    private Arquivo arquivo;
}
