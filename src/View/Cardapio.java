/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author enzog
 */
@Entity
@Table(name = "cardapio", catalog = "vista_restaurante", schema = "")
@NamedQueries({
    @NamedQuery(name = "Cardapio.findAll", query = "SELECT c FROM Cardapio c"),
    @NamedQuery(name = "Cardapio.findByIdCardapio", query = "SELECT c FROM Cardapio c WHERE c.idCardapio = :idCardapio"),
    @NamedQuery(name = "Cardapio.findByNomPrato", query = "SELECT c FROM Cardapio c WHERE c.nomPrato = :nomPrato"),
    @NamedQuery(name = "Cardapio.findByPrecPrato", query = "SELECT c FROM Cardapio c WHERE c.precPrato = :precPrato")})
public class Cardapio implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cardapio")
    private Integer idCardapio;
    @Basic(optional = false)
    @Column(name = "nom_prato")
    private String nomPrato;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "prec_prato")
    private BigDecimal precPrato;

    public Cardapio() {
    }

    public Cardapio(Integer idCardapio) {
        this.idCardapio = idCardapio;
    }

    public Cardapio(Integer idCardapio, String nomPrato, BigDecimal precPrato) {
        this.idCardapio = idCardapio;
        this.nomPrato = nomPrato;
        this.precPrato = precPrato;
    }

    public Integer getIdCardapio() {
        return idCardapio;
    }

    public void setIdCardapio(Integer idCardapio) {
        Integer oldIdCardapio = this.idCardapio;
        this.idCardapio = idCardapio;
        changeSupport.firePropertyChange("idCardapio", oldIdCardapio, idCardapio);
    }

    public String getNomPrato() {
        return nomPrato;
    }

    public void setNomPrato(String nomPrato) {
        String oldNomPrato = this.nomPrato;
        this.nomPrato = nomPrato;
        changeSupport.firePropertyChange("nomPrato", oldNomPrato, nomPrato);
    }

    public BigDecimal getPrecPrato() {
        return precPrato;
    }

    public void setPrecPrato(BigDecimal precPrato) {
        BigDecimal oldPrecPrato = this.precPrato;
        this.precPrato = precPrato;
        changeSupport.firePropertyChange("precPrato", oldPrecPrato, precPrato);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCardapio != null ? idCardapio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cardapio)) {
            return false;
        }
        Cardapio other = (Cardapio) object;
        if ((this.idCardapio == null && other.idCardapio != null) || (this.idCardapio != null && !this.idCardapio.equals(other.idCardapio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "View.Cardapio[ idCardapio=" + idCardapio + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
