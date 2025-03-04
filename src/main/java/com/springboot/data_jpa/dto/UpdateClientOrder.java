package com.springboot.data_jpa.dto;

import lombok.Data;

@Data
public class UpdateClientOrder {
    private int clientID;
    private int orderID;
}
