package com.elmaalmi.billal.library.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Data //generate setter & getter
@AllArgsConstructor // generate Constructor with all field
@NoArgsConstructor // generate no args
@Builder // builder
public class Adherent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank
	private String nom;
	@NotBlank
	private String prenom;
	@NotBlank
	private String adresse;
	@NotBlank
	@Column(unique = true)
	private String cin;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date_naissance;
	@OneToMany(mappedBy = "adherent", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Emprunt> emprunts;

}
