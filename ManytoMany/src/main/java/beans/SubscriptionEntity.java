package beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class SubscriptionEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="sub_gen")
	@SequenceGenerator(name="sub_gen", sequenceName="sub_seq")
	private int SubsId;
	
	@Column(length=20)
	private String subsname;
	
	@ManyToMany(mappedBy="subscriptions")
	private Set<ReaderEntity> readers;
	
	public int getSubsId() {
		return SubsId;
	}
	public void setSubsId(int subsId) {
		SubsId = subsId;
	}
	public String getSubsname() {
		return subsname;
	}
	public void setSubsname(String subsname) {
		this.subsname = subsname;
	}
	public Set<ReaderEntity> getReaders() {
		return readers;
	}
	public void setReaders(Set<ReaderEntity> readers) {
		this.readers = readers;
	}

}
