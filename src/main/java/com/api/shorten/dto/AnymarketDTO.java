package com.api.shorten.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class AnymarketDTO {
	
	
}




@Data
class Invoice implements Serializable {
	
	private static final long serialVersionUID = -3426246484537205312L;

	private String accessKey;

	private String series;

	private String number;

	private String date;

	private String linkNfe;

	private String invoiceLink;

	private String cfop;
}

@Data
class Metadata implements Serializable{
	private static final long serialVersionUID = 4042518822770590949L;
	private String string;
}

@Data 
class Sku {
    private String partnerId;
}