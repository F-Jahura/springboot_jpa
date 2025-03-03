package com.springboot.data_jpa.dto;

import com.springboot.data_jpa.entity.Client;
import com.springboot.data_jpa.entity.Order;
import lombok.Data;

import java.util.List;

@Data
public class ClientDto {
    private String regionCode;
    private String areaName;
    private String localityName;
    private String street;
    private int houseNumber;
    private int buildingNumber;
    private int officeNumber;
    private List<OrderDto> orderDtoList;
    //private OrderDto orderDto;


    public Client toClient() {
        Client client = new Client();

        for (OrderDto orderDto : orderDtoList) {
            client.setRegionCode(regionCode);
            client.setAreaName(areaName);
            client.setLocalityName(localityName);
            client.setStreet(street);
            client.setHouseNumber(houseNumber);
            client.setBuildingNumber(buildingNumber);
            client.setOfficeNumber(officeNumber);
            client.setOrderList(orderDto.toOrder(orderDtoList));        }
            return client;
        }
}
