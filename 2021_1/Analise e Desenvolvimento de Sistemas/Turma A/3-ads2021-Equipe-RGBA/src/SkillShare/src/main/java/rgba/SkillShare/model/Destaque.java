package rgba.SkillShare.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;
/**
 *  Classe que define as postagens de destaques.
 *  @author Nicholas Roque
 */
@Entity(name = "destaque")
@NoArgsConstructor @Getter @Setter @AllArgsConstructor @ToString
public class Destaque {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false, columnDefinition="TEXT")
    private String sinopse;

    @Column(nullable = false, columnDefinition="TEXT")
    private String conteudo;
    
    @Column
    private String fonte;
    
    @Column
    private LocalDateTime data = LocalDateTime.now();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_thumb",referencedColumnName = "id")
    private Thumb thumb;

    /** 
    *  Cria uma instância da classe Destaque.
    * @param titulo -> titulo do destaque
    * @param sinopse -> sinopse do destaque
    * @param conteudo -> conteudo do destaque
    * @author Nicholas Roque
    */

    public Destaque(String titulo,String sinopse,String conteudo,String fonte) {
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.conteudo = conteudo;
        this.fonte = fonte;

    }

}