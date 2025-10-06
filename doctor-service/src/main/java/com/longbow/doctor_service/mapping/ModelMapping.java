package com.longbow.doctor_service.mapping;

import com.longbow.doctor_service.config.ModelConfig;
import com.longbow.doctor_service.dto.DoctorDto;
import com.longbow.doctor_service.entity.Doctor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ModelMapping {
@Autowired
private ModelMapper modelMapper;
    public  Doctor dtoToEntity(DoctorDto doctorDto){
        return modelMapper.map(doctorDto,Doctor.class);
    }

    public DoctorDto entityToDto(Doctor doctor){
  return modelMapper.map(doctor,DoctorDto.class);
    }
    public ModelMapper getModelMapper() {
        return modelMapper;
    }

}
