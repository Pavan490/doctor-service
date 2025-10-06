package com.longbow.doctor_service.controller;

import com.longbow.doctor_service.dto.DoctorDto;
import com.longbow.doctor_service.service.DoctorService;
import com.longbow.doctor_service.utils.ResponseData;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @PostMapping("/create")
    public ResponseEntity<?> createDoctor(@Valid @RequestBody DoctorDto doctorDto){
        DoctorDto doctor=doctorService.createDoctor(doctorDto);
        Map<String,Object> doctorData=new HashMap<>();
        doctorData.put(ResponseData.RESULT,ResponseData.SUCCESS);
        doctorData.put(ResponseData.DATA,doctor);
        return ResponseEntity.status(HttpStatus.OK).body(doctorData);
    }
    @GetMapping("/getAll")
    public ResponseEntity<?> getAllDoctors(){
        List<DoctorDto> doctor=doctorService.getAllDoctors();
        Map<String,Object> doctorData=new HashMap<>();
        doctorData.put(ResponseData.RESULT,ResponseData.SUCCESS);
        doctorData.put(ResponseData.DATA,doctor);
        return ResponseEntity.status(HttpStatus.OK).body(doctorData);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getByIdDoctor(@PathVariable Integer id){
        DoctorDto doctor=doctorService.getByIdDoctor(id);
        Map<String,Object> doctorData=new HashMap<>();
        doctorData.put(ResponseData.RESULT,ResponseData.SUCCESS);
        doctorData.put(ResponseData.DATA,doctor);
        return ResponseEntity.status(HttpStatus.OK).body(doctorData);
    }
    @PutMapping ("/{id}/update")
    public ResponseEntity<?> updateDoctorById(@PathVariable Integer id, @RequestBody DoctorDto doctorDto){
        DoctorDto doctor=doctorService.updateDoctorById(id,doctorDto);
        Map<String,Object> doctorData=new HashMap<>();
        doctorData.put(ResponseData.RESULT,ResponseData.SUCCESS);
        doctorData.put(ResponseData.DATA,doctor);
        return ResponseEntity.status(HttpStatus.OK).body(doctorData);
    }
    @PatchMapping ("/{id}/patch")
    public ResponseEntity<?> doctorByIdUpdate(@PathVariable Integer id, @RequestBody Map<String, Object> updates){
        DoctorDto doctor=doctorService.doctorByIdUpdate(id,updates);
        Map<String,Object> doctorData=new HashMap<>();
        doctorData.put(ResponseData.RESULT,ResponseData.SUCCESS);
        doctorData.put(ResponseData.DATA,doctor);
        return ResponseEntity.status(HttpStatus.OK).body(doctorData);
    }
    @DeleteMapping ("/{id}/delete")
    public ResponseEntity<?> deleteByIdDoctor(@PathVariable Integer id){
        doctorService.deleteByIdDoctor(id);
        Map<String,Object> doctorData=new HashMap<>();
        doctorData.put(ResponseData.RESULT,ResponseData.SUCCESS);
        doctorData.put(ResponseData.DATA,"Successfully deleted");
        return ResponseEntity.status(HttpStatus.OK).body(doctorData);
    }

}
