package conexionHibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalle_cliente")
public class DetallesCliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "web")
	private String web;

	@Column(name = "tfno")
	private String tfno;

	@Column(name = "comentarios")
	private String comentarios;

	@OneToOne(mappedBy = "detallesCliente", cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private Cliente elCliente;

	public DetallesCliente() {

	}

	public DetallesCliente(String web, String tfno, String comentarios) {
		this.web = web;
		this.tfno = tfno;
		this.comentarios = comentarios;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getTfno() {
		return tfno;
	}

	public void setTfno(String tfno) {
		this.tfno = tfno;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public Cliente getElCliente() {
		return elCliente;
	}

	public void setElCliente(Cliente elCliente) {
		this.elCliente = elCliente;
	}

	@Override
	public String toString() {
		return "DetallesCliente [id=" + id + ", web=" + web + ", tfno=" + tfno + ", comentarios=" + comentarios + "]";
	}

}