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
@Table(name = "pedido", catalog = "vista_restaurante", schema = "")
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p"),
    @NamedQuery(name = "Pedido.findByIdPedido", query = "SELECT p FROM Pedido p WHERE p.idPedido = :idPedido"),
    @NamedQuery(name = "Pedido.findByPrato", query = "SELECT p FROM Pedido p WHERE p.prato = :prato"),
    @NamedQuery(name = "Pedido.findByQuantidade", query = "SELECT p FROM Pedido p WHERE p.quantidade = :quantidade"),
    @NamedQuery(name = "Pedido.findByObservacao", query = "SELECT p FROM Pedido p WHERE p.observacao = :observacao"),
    @NamedQuery(name = "Pedido.findByValor", query = "SELECT p FROM Pedido p WHERE p.valor = :valor"),
    @NamedQuery(name = "Pedido.findByIdComanda", query = "SELECT p FROM Pedido p WHERE p.idComanda = :idComanda"),
    @NamedQuery(name = "Pedido.findByIdCardapio", query = "SELECT p FROM Pedido p WHERE p.idCardapio = :idCardapio")})
public class Pedido implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pedido")
    private Integer idPedido;
    @Basic(optional = false)
    @Column(name = "prato")
    private String prato;
    @Basic(optional = false)
    @Column(name = "quantidade")
    private int quantidade;
    @Column(name = "observacao")
    private String observacao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "valor")
    private BigDecimal valor;
    @Basic(optional = false)
    @Column(name = "id_comanda")
    private int idComanda;
    @Basic(optional = false)
    @Column(name = "id_cardapio")
    private int idCardapio;

    public Pedido() {
    }

    public Pedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Pedido(Integer idPedido, String prato, int quantidade, BigDecimal valor, int idComanda, int idCardapio) {
        this.idPedido = idPedido;
        this.prato = prato;
        this.quantidade = quantidade;
        this.valor = valor;
        this.idComanda = idComanda;
        this.idCardapio = idCardapio;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        Integer oldIdPedido = this.idPedido;
        this.idPedido = idPedido;
        changeSupport.firePropertyChange("idPedido", oldIdPedido, idPedido);
    }

    public String getPrato() {
        return prato;
    }

    public void setPrato(String prato) {
        String oldPrato = this.prato;
        this.prato = prato;
        changeSupport.firePropertyChange("prato", oldPrato, prato);
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        int oldQuantidade = this.quantidade;
        this.quantidade = quantidade;
        changeSupport.firePropertyChange("quantidade", oldQuantidade, quantidade);
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        String oldObservacao = this.observacao;
        this.observacao = observacao;
        changeSupport.firePropertyChange("observacao", oldObservacao, observacao);
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        BigDecimal oldValor = this.valor;
        this.valor = valor;
        changeSupport.firePropertyChange("valor", oldValor, valor);
    }

    public int getIdComanda() {
        return idComanda;
    }

    public void setIdComanda(int idComanda) {
        int oldIdComanda = this.idComanda;
        this.idComanda = idComanda;
        changeSupport.firePropertyChange("idComanda", oldIdComanda, idComanda);
    }

    public int getIdCardapio() {
        return idCardapio;
    }

    public void setIdCardapio(int idCardapio) {
        int oldIdCardapio = this.idCardapio;
        this.idCardapio = idCardapio;
        changeSupport.firePropertyChange("idCardapio", oldIdCardapio, idCardapio);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPedido != null ? idPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.idPedido == null && other.idPedido != null) || (this.idPedido != null && !this.idPedido.equals(other.idPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "View.Pedido[ idPedido=" + idPedido + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
