package com.eam.protocolo.http.models.dtos;

import lombok.Data;

@Data
public class PersonDTO {

    private String phoneNumber;
    private String address;
    private String documentNumber;
    private String email;
    private String name;
}
