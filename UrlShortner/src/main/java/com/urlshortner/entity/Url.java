package com.urlshortner.entity;

import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

import lombok.NoArgsConstructor;
import lombok.Data;

@Entity
@Data
@NoArgsConstructor
public class Url {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long urlId;
	
	private String longUrl;
	
	private String shortUrl;
	
}
