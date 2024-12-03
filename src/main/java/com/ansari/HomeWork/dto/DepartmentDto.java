package com.ansari.HomeWork.dto;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
    private Long id;
    private String title;
    private boolean isActive;
    private LocalDate createdAt;
}
