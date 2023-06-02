package com.springboot.model;
import lombok.*;
import javax.persistence.*;

@Entity
@Table(name="customertbl")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="Customer_Name")
	private String cname;
	
	@Column(name="Occcuptaion")
	private String occupation;
	
	@OneToOne()
	@JoinColumn(name="user_id")
	private User user;
	
}
