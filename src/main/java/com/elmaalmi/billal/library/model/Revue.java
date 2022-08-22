package com.elmaalmi.billal.library.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//
@Data //generate setter & getter
@AllArgsConstructor // generate Constructor with all field
@NoArgsConstructor // generate no args
public class Revue extends Document{
	@Column()
	private String ref;
	@Column()
	private Date annee_pub;
	@OneToMany(mappedBy = "revue", cascade = CascadeType.ALL,orphanRemoval = true)
	@JsonIgnore
	protected List<Emprunt> emprunts;
	public String toString(){
		return "( id : "+id+" prix :"+prix+" ref :"+ref+" annee pub : "+annee_pub+")";
	}
}
