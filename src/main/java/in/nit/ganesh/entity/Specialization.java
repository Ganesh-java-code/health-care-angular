package in.nit.ganesh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.resource.beans.internal.FallbackBeanInstanceProducer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Specialization {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "spec_id_col")
	private Integer id;
	
	@Column(
			name = "spec_code_col",
			nullable = false,
			length = 10,
			unique = true
			)
	private String SpecCode;
	
	@Column(
			name = "spec_name_col",
			length = 60,
			nullable = false,
			unique = true
			)
	private String SpecName;
	
	@Column(
			name = "spec_note_col",
			nullable = false,
			length = 350			
			)
	private String SpecNote;

}
