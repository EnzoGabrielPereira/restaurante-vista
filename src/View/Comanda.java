/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
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
@Table(name = "comanda", catalog = "vista_restaurante", schema = "")
@NamedQueries({
    @NamedQuery(name = "Comanda.findAll", query = "SELECT c FROM Comanda c"),
    @NamedQuery(name = "Comanda.findByIdComanda", query = "SELECT c FROM Comanda c WHERE c.idComanda = :idComanda"),
    @NamedQuery(name = "Comanda.findByStatus", query = "SELECT c FROM Comanda c WHERE c.status = :status"),
    @NamedQuery(name = "Comanda.findByNumMesa", query = "SELECT c FROM Comanda c WHERE c.numMesa = :numMesa")})
public class Comanda implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_comanda")
    private Integer idComanda;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @Column(name = "num_mesa")
    private int numMesa;

    public Comanda() {
    }

    public Comanda(Integer idComanda) {
        this.idComanda = idComanda;
    }

    public Comanda(Integer idComanda, String status, int numMesa) {
        this.idComanda = idComanda;
        this.status = status;
        this.numMesa = numMesa;
    }

    public Integer getIdComanda() {
        return idComanda;
    }

    public void setIdComanda(Integer idComanda) {
        Integer oldIdComanda = this.idComanda;
        this.idComanda = idComanda;
        changeSupport.firePropertyChange("idComanda", oldIdComanda, idComanda);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        String oldStatus = this.status;
        this.status = status;
        changeSupport.firePropertyChange("status", oldStatus, status);
    }

    public int getNumMesa() {
        return numMesa;
    }

    public void setNumMesa(int numMesa) {
        int oldNumMesa = this.numMesa;
        this.numMesa = numMesa;
        changeSupport.firePropertyChange("numMesa", oldNumMesa, numMesa);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComanda != null ? idComanda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comanda)) {
            return false;
        }
        Comanda other = (Comanda) object;
        if ((this.idComanda == null && other.idComanda != null) || (this.idComanda != null && !this.idComanda.equals(other.idComanda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "View.Comanda[ idComanda=" + idComanda + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
