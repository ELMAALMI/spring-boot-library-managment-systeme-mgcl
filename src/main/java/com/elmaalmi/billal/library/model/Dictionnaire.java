package com.elmaalmi.billal.library.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;

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
public class Dictionnaire extends Document {
	@Column()
	private String langue;
	@OneToMany(mappedBy = "dictionnaire", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Emprunt> emprunts;
	@Override
	public String toString(){
		return "( id : "+id+" prix : "+prix+" lanque : "+langue+" )";
	}
}
