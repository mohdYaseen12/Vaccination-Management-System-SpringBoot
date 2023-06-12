package com.example.vaccineManagementSystem.Dtos.RequestDtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssociateDocDto {
    private Integer docId;
    private Integer centerId;
}
