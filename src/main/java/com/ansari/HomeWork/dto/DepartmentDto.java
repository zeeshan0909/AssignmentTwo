package com.ansari.HomeWork.dto;

import com.ansari.HomeWork.annotation.PasswordValidation;
import com.ansari.HomeWork.annotation.PrimaryNumberValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {

    private Long id;
    @NotBlank(message = "title should not be blanked")
    @Size(min = 3, max = 12, message = "number of char in title should be in range [3,10]")
    private String title;
    @JsonProperty("isActive")
    private boolean isActive;
    @PastOrPresent(message = "Date  of created depeartment is not in futhure")
    @NotNull
    private LocalDate createdAt;

    @PrimaryNumberValidation
    private Integer checkPrime;

    @PasswordValidation
    private String password;
}
