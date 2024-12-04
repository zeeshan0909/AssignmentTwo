package com.ansari.HomeWork.controller;
//week twogit
import com.ansari.HomeWork.dto.DepartmentDto;
import com.ansari.HomeWork.exception.ResourceNotFoundException;
import com.ansari.HomeWork.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {


    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    // GET: /departments
    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments() {
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    //GET: /departments/{id}
    @GetMapping(path = "/{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable Long id) {
        Optional<DepartmentDto> departmentDto = departmentService.getDepartmentById(id);
        return departmentDto.map(departmentDto1 -> ResponseEntity.ok(departmentDto1))
                .orElseThrow(() -> new ResourceNotFoundException("department ", id));

    }

    //POST: /departments
    @PostMapping
    public ResponseEntity<DepartmentDto> createNewDepartment(@RequestBody DepartmentDto departmentDto) {
        return new ResponseEntity<>(departmentService.createDepartment(departmentDto), HttpStatus.CREATED);
    }

    //PUT: /departments/{DepartmentId}
    @PutMapping(path = "/{departmentId}")
    public ResponseEntity<DepartmentDto> updateDepartmentById(@RequestBody DepartmentDto departmentDto, @PathVariable Long id) {
        return ResponseEntity.ok(departmentService.updateDepartmentById(departmentDto, id));
    }

    // DELETE: /departments
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteDepartment(@PathVariable Long id) {
        boolean deleted = departmentService.deleteDepartment(id);
        if (deleted) return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
    }

    //PATCH: /departmens/{DepartmentId}
    @PatchMapping(path = "/{id}")
    public ResponseEntity<DepartmentDto> updatePartialDepartmentById(@RequestBody Map<String, Object> updates,
                                                                     @PathVariable Long id) {
        DepartmentDto departmentDto = departmentService.updatePartialDepartmentById(updates, id);
        if(departmentDto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(departmentDto);
    }


}
