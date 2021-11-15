package io.github.edsontofolo.springbootjpa.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class ComplementoAnuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String texto;
    @Column
    private String url;
    @OneToMany(mappedBy = "complementoAnuario", cascade = CascadeType.PERSIST)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<ComplementoAnuarioRamoUrl> complementoAnuarioRamoUrls;

    public void addComplementoAnuarioRamoUrl(ComplementoAnuarioRamoUrl complementoAnuarioRamoUrl) {
        if (this.complementoAnuarioRamoUrls == null) {
            this.complementoAnuarioRamoUrls = new ArrayList<>();
        }
        this.complementoAnuarioRamoUrls.add(complementoAnuarioRamoUrl);
        complementoAnuarioRamoUrl.setComplementoAnuario(this);
    }

}
