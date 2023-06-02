package com.springboot.model;
import lombok.*;
import javax.persistence.*;

@Entity
@Table(name="usersmentor")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="user_name")
	private String uname;
	
	
}
