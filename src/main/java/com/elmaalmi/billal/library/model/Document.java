package com.elmaalmi.billal.library.model;



import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data //generate setter & getter
@AllArgsConstructor // generate Constructor with all field
@NoArgsConstructor // generate no args
public class Document {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long id;
	@NotNull
	protected double prix;
}
