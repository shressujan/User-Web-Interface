package edu.unk.cs406.user.profile.controller;

//import java.util.List;
//import java.util.Objects;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import edu.unk.cs406.user.entity.User;
//import edu.unk.cs406.user.entity.UserEntity;
//import edu.unk.cs406.user.exception.NotFoundException;
//import edu.unk.cs406.user.profile.dto.CreateProfileDTO;
//import edu.unk.cs406.user.profile.dto.UpdateProfileDTO;
//import edu.unk.cs406.user.profile.entity.ProfileEntity;
//import edu.unk.cs406.user.profile.service.ProfileService;


//@Controller
//@RequestMapping("/user/profile")
public class ProfileWebController {
//
//	private final ProfileService ups;
//
//	public ProfileWebController(ProfileService ups)
//	{
//		this.ups = Objects.requireNonNull(ups);
//	}
//
//	@GetMapping("/")
//	public String index(Model model)
//	{
//		List<ProfileEntity> users = this.ups.FindAllUserProfiles();
//		if(users == null)
//		{
//			throw new NotFoundException("Users null!");
//		}
//		model.addAttribute("Profiles", users);
//		return "user/profile/index";
//	}
//	@GetMapping("/{id}")
//	public String getProfile(@PathVariable(value = "id", required = true) String id , Model m)
//	{
//		ProfileEntity ue = this.ups.GetUserProfile(id);
//		m.addAttribute("entity", ue);
//		m.addAttribute("userList", "Subscriptions");
//		m.addAttribute("Comments", ue.getComments());
//		m.addAttribute("Events", ue.getEvents());
//		m.addAttribute("Locations", ue.getLocations());
//		m.addAttribute("Subscriptions", ue.getSubscriptions());
//		
//		return "user/profile/view";
//	}
//
//	@GetMapping("/create")
//	public String CreateProfileForm(Model model)
//	{
//		model.addAttribute("title", "Create");
//		return "user/profile/create";
//	}
//	@PostMapping("/create")
//	public String CreateProfile(@ModelAttribute CreateProfileDTO dto)
//	{
//		this.ups.CreateUserProfile(dto);
//		return "redirect:/user/profile/get/"+dto.getId();
//	}
//
//	@GetMapping("/get/{label}")
//	public String findProfileByLabel(@PathVariable(value = "label", required =  true)String label, Model model)
//	{
//		ProfileEntity upe =  Objects.requireNonNull(this.ups.FindUserProfileByLabel(label));
//		model.addAttribute("Profile", upe);
//		return "user/profile/get";
//	}
//
////	@GetMapping("/get")
////	public String getProfiles(Model model)
////	{
////		List<ProfileEntity> lpe = this.ups.FindAllUserProfiles();
////		model.addAttribute("Profiles", lpe);
////
////		return "users/profile";
////	}
//
//	@GetMapping("/update/{id}")
//	public String updateProfileForm(@PathVariable (value = "id", required = true) String id, Model model)
//	{
//		model.addAttribute("profile", this.ups.GetUserProfile(id));
//	//	model.addAttribute("title", this.ups.GetUserProfile(id).getLabel());
//		return "user/profile/update";
//	}
//	
//	@SuppressWarnings("unlikely-arg-type")
//	@PutMapping("/update/{id}")
//	public String updateProfile(@ModelAttribute UpdateProfileDTO userDTO, Model model)
//	{
//		if(userDTO == null)
//		{
//			throw new NotFoundException("userDTO  is null!!");
//		}
//		if(userDTO.getLabel().equals(""))
//		{
//			userDTO.setLabel(null);
//		}
//		if(userDTO.getPassword().equals(""))
//		{
//			userDTO.setPassword(null);
//		}
//		if(userDTO.getEmailID().equals(""))
//		{
//			userDTO.setEmailID(null);
//		}
//		if(userDTO.getDescription().equals(""))
//		{
//			userDTO.setDescription(null);
//		}
//		if(userDTO.getSubscriptions().equals(""))
//		{
//			userDTO.setSubscriptions(null);
//		}
//		if(userDTO.getLikes().equals(""))
//		{
//			userDTO.setLike(null);
//		}
//		if(userDTO.getComments().equals(""))
//		{
//			userDTO.setComment(null);
//		}
//		if(userDTO.getLocations().equals(""))
//		{
//			userDTO.setLocation(null);
//		}
//		if(userDTO.getEvents().equals(""))
//		{
//			userDTO.setEvent(null);
//		}
//		this.ups.UpdateUserProfile(userDTO);
//		model.addAttribute("profile", this.ups.GetUserProfile(userDTO.getId()));
//		model.addAttribute("title", this.ups.GetUserProfile(userDTO.getId()).getLabel());
//		return "redirect:/user/profile/index";
//	}
//
//	@DeleteMapping("/delete/{id}")
//	public String deleteProfile(@PathVariable(value = "id", required =  true)String id)
//	{
//		this.ups.DeleteUserProfile(id);
//		return "redirect:/user/profile/index";
//	}
}
