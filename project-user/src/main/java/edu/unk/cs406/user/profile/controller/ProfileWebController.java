package edu.unk.cs406.user.profile.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.unk.cs406.user.entity.User;
import edu.unk.cs406.user.entity.UserEntity;
import edu.unk.cs406.user.profile.dto.CreateUserProfileDTO;
import edu.unk.cs406.user.profile.service.UserProfileService;

@Controller
@RequestMapping("/user/profile")
public class ProfileWebController {
	
	private UserProfileService ups;
	
	public ProfileWebController(UserProfileService ups)
	{
		this.ups = Objects.requireNonNull(ups);
	}

	@GetMapping("/get/{id}")
	public String getProfile(@PathVariable(value = "id", required = true) String id)
	{
		UserEntity ue = this.ups.GetUserProfile(id);
		return null;
	}
	
	@PostMapping("/create")
	public String CreateProfile(@ModelAttribute CreateUserProfileDTO dto)
	{
		this.ups.CreateUserProfile(dto);
		return null;
	}
	
	@GetMapping("/get/{label}")
	public String findProfileByLabel(@PathVariable(value = "label", required =  true)String label)
	{
		UserEntity ue =  (UserEntity) Objects.requireNonNull(this.ups.FindUserProfileByLabel(label));
		return null;
	}
	
	@GetMapping("/get")
	public String getProfiles(Model modle)
	{
		List<UserEntity> ues = this.ups.FindAllUserProfiles();
		//Do something here  with the model
		
		return null;
	}
	
	@PutMapping("/update/{id}")
	public String updateProfile(@PathVariable (value = "id", required = true) String id, Model model)
	{
		UserEntity ue = Objects.requireNonNull(this.ups.GetUserProfile(id));
//		model.addAttribute(attributeName, attributeValue);
		return null;
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteProfile(@PathVariable(value = "id", required =  true)String id)
	{
		this.ups.DeleteUserProfile(id);
		return null;
	}
}
