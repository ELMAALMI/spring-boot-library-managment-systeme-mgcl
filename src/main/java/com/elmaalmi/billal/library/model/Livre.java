package com.elmaalmi.billal.library.model;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
//
@Data //generate setter & getter
@AllArgsConstructor // generate Constructor with all field
@NoArgsConstructor // generate no args
@Builder
public class Livre extends Document{
	@Column
	private String auteur;
	@Column
	private int nb_page;
	@OneToMany(mappedBy = "livre", cascade = CascadeType.ALL)
	@JsonIgnore
	protected List<Emprunt> emprunts;
	public String toString(){
		return "( id : "+id+" prix : "+prix+" auteur : "+auteur+" nb_page : "+nb_page+" )";
	}
}
