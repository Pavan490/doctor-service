package com.longbow.doctor_service.service;

import com.longbow.doctor_service.dto.DoctorDto;

import java.util.List;
import java.util.Map;

public interface DoctorService {

    public DoctorDto createDoctor(DoctorDto doctorDto);
    public List<DoctorDto> getAllDoctors();
    public DoctorDto getByIdDoctor(Integer id);
    public DoctorDto updateDoctorById(Integer id, DoctorDto doctorDto);
    public DoctorDto doctorByIdUpdate(Integer id, Map<String ,Object> updates);
    public void deleteByIdDoctor(Integer id);
}
