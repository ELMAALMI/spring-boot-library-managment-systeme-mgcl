package com.elmaalmi.billal.library.model;

import java.sql.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.*;

@Entity
//
@Data //generate setter & getter
@AllArgsConstructor // generate Constructor with all field
@NoArgsConstructor // generate no args
@Builder // builder
@Getter
@Setter
public class Emprunt {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private Date date_emprunt;
	private Date date_retour;

	@ManyToOne()
	@JoinColumn(name = "dic_id",insertable = false,updatable = false)
	private Dictionnaire dictionnaire;
	@ManyToOne()
	@JoinColumn(name = "livre_id",insertable = false,updatable = false)
	private Livre livre;
	@ManyToOne()
	@JoinColumn(name = "revue_id",insertable = false,updatable = false)
	private Revue revue;
	@ManyToOne()
	@JoinColumn(nullable = false,name = "adherent_id")
	private Adherent adherent;

}
