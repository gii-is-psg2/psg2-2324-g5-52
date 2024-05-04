package org.springframework.samples.petclinic.auth.payload.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtResponse {

	private String token;
	private String type = "Bearer";
	private Integer id;
	private String username;
	private List<String> roles;
	private String plan;

	public JwtResponse(String accessToken, Integer id, String username, List<String> roles, String plan) {
		this.token = accessToken;
		this.id = id;
		this.username = username;
		this.roles = roles;
		this.plan = plan;
	}

	@Override
	public String toString() {
		return "JwtResponse [token=" + token + ", type=" + type + ", id=" + id + ", username=" + username
				+ ", roles=" + roles + "]" + ", plan=" + plan;
	}

}
