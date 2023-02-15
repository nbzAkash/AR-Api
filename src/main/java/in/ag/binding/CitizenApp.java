package in.ag.binding;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CitizenApp {
	
	private String fname;
	private String email;
	private Long mobNo;
	private String gender;
	private LocalDate dob;
	private Long ssn;
	
	private Integer createdBy;
	private Integer updatedBy;

}
