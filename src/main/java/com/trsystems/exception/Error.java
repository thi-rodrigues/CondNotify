package com.trsystems.exception;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@ToString
public class Error implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private LocalDateTime dataHoraErro;
	private String message;

	public LocalDateTime getDataHoraErro() {
		return dataHoraErro;
	}

	public void setDataHoraErro(LocalDateTime dataHoraErro) {
		this.dataHoraErro = dataHoraErro;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Error(LocalDateTime dataHoraErro, String message) {
		super();
		this.dataHoraErro = dataHoraErro;
		this.message = message;
	}
	
}
