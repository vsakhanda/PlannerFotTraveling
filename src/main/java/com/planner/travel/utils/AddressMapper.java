package com.planner.travel.utils;

import com.planner.travel.dto.AddressDTO;
import com.planner.travel.entity.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public AddressDTO addressToDTO(Address address) {
        AddressDTO dto = new AddressDTO();
        dto.setId(address.getId());
        dto.setPhone(address.getPhone());
        dto.setCity(address.getCity());
        dto.setCounrty(address.getCounrty());
        dto.setDescription(address.getDescription());
        dto.setRegion(address.getRegion());
        // Перетворення інших полів за потребою
        return dto;
    }

    public Address toEntity(AddressDTO addressDTO) {
        Address address = new Address();
        address.setId(addressDTO.getId());
        address.setPhone(addressDTO.getPhone());
        address.setCounrty(addressDTO.getCounrty());
        address.setRegion(address.getRegion());
        address.setCity(addressDTO.getCity());
        address.setDescription(addressDTO.getDescription());

        // Перетворення інших полів за потребою
        return address;
    }


}
