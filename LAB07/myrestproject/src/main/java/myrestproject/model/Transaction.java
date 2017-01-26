package myrestproject.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(columnDefinition="timestamp default CURRENT_TIMESTAMP")
	private Date date;
	
	@OneToMany(mappedBy="transaction")
	private List<CarRepair> repairs;


	public Transaction() {
		super();
	}

	

	public Transaction(Date date, List<CarRepair> repairs) {
		super();
		this.date = date;
		this.repairs = repairs;
	}



	public Transaction(Integer id, Date date, List<CarRepair> repairs) {
		super();
		this.id = id;
		this.date = date;
		this.repairs = repairs;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<CarRepair> getRepairs() {
		return repairs;
	}

	public void setRepairs(List<CarRepair> repairs) {
		this.repairs = repairs;
	}


	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	@Override
	public String toString() {
		return "Transaction [id=" + id + ", date=" + date + ", repairs="
				+ repairs + "]";
	}



	
	
}
