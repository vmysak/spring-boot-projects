package org.zeksa.hibernate.labs.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Message {

	@Id
	@TableGenerator(name = "TABLE_MESSAGE_GEN", table = "SEQUENCE_TABLE", pkColumnName = "SEQ_NAME",
			valueColumnName = "SEQ_COUNT", pkColumnValue = "EMP_SEQ")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_MESSAGE_GEN")
	@Getter
	private Long id;

	@Getter
	@Setter
	private String authorId;

	@Getter
	@Setter
	private String text;

}
