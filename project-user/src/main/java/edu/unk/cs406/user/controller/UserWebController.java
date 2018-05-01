package edu.unk.cs406.user.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.unk.cs406.user.exception.NotFoundException;
import edu.unk.cs406.user.group.dto.CreateGroupDTO;
import edu.unk.cs406.user.group.entity.GroupEntity;
import edu.unk.cs406.user.group.service.GroupService;
import edu.unk.cs406.user.profile.dto.CreateProfileDTO;
import edu.unk.cs406.user.profile.entity.ProfileEntity;
import edu.unk.cs406.user.profile.service.ProfileService;


@Controller
@RequestMapping("/user")
public class UserWebController {

	private final ProfileService ups;
	private final GroupService ugs;

	public UserWebController(ProfileService ups, GroupService ugs)
	{
		this.ups = Objects.requireNonNull(ups);
		this.ugs = Objects.requireNonNull(ugs);
	}

	@GetMapping("/")
	public String index(Model model)
	{
		List<ProfileEntity> profiles = this.ups.FindAllUserProfiles();
		if(profiles == null)
		{
			//throw new NotFoundException("Profiles null!");
		}
		
		List<GroupEntity> groups = this.ugs.find();
		
		if(groups == null)
		{
			throw new NotFoundException("Groups null!");
		}
		model.addAttribute("title", "User");
		model.addAttribute("Groups", groups);
		model.addAttribute("Profiles", profiles);
		
		return "user/index";
	}


	@GetMapping("/profile")
	public String profileIndex(Model model)
	{
		List<ProfileEntity> profiles = this.ups.FindAllUserProfiles();
		if(profiles == null)
		{
			throw new NotFoundException("Profiles null!");
		}
		model.addAttribute("Profiles", profiles);
		model.addAttribute("title", "Profile");
		
		return "user/profile/index";
	}

	@GetMapping("/profile/{id}")
	public String profileView(@PathVariable(value = "id", required = true) String id , Model m)
	{
		ProfileEntity ue = this.ups.GetUserProfile(id);
		List<String> Comments = new ArrayList<String>();
		Comments.add("Nice!");
		Comments.add("Awesome!");
		
		List<String> Events = new ArrayList<String>();
		Events.add("Party at Sujan's house at 8 friday!");
		Events.add("Concert - May 12 Saturday- omaha");
		
		List<String> Locations = new ArrayList<String>();
		Locations.add("Colorado");
		Locations.add("New york");
		Locations.add("Las Vegas");
		
		List<String> Subscriptions = new ArrayList<String>();
		Subscriptions.add("Emoji");
		Subscriptions.add("Funny");
		
		m.addAttribute("title", "Profile View");
		m.addAttribute("entity", ue);
		m.addAttribute("userList", "Subscriptions");
		m.addAttribute("Comments", Comments);
		m.addAttribute("Events", Events);
		m.addAttribute("Locations", Locations);
		m.addAttribute("Subscriptions", Subscriptions);

		return "user/profile/layout";
	}

	@GetMapping("/group")
	public String groupIndex(Model model)
	{
		List<GroupEntity> groups = this.ugs.find();
		if(groups == null)
		{
			//throw new NotFoundException("Groups null!");
		}
		model.addAttribute("Groups", groups);
		model.addAttribute("title", "Group");
		
		return "user/group/index";
	}

	@GetMapping("/group/{id}")
	public String groupView(@PathVariable(value = "id", required = true) String id , Model m)
	{
		GroupEntity ue = (GroupEntity) this.ugs.get(id);
		m.addAttribute("entity", ue);
		m.addAttribute("userList", "Subscriptions");
		m.addAttribute("Comments", ue.getComments());
		m.addAttribute("Events", ue.getEvents());
		m.addAttribute("Locations", ue.getLocations());
		m.addAttribute("Members", ue.getMembers());

		return "user/group/view";
	}
	
	@GetMapping("/create")
	public String addDummyData()
	{
//		CreateGroupDTO group1 = new CreateGroupDTO();
//		group1.setId(UUID.randomUUID().toString());
//		group1.setLabel("Group 1");
//		group1.setDescription("Test Description");
//		
//		CreateGroupDTO group2 = new CreateGroupDTO();
//		group2.setId(UUID.randomUUID().toString());
//		group2.setLabel("Group 2");
//		group2.setDescription("Test Description");
		
		
		CreateProfileDTO profile1 = new CreateProfileDTO();
		profile1.setId(UUID.randomUUID().toString());
		profile1.setLabel("Sujan");
		profile1.setPassword("CReate123!@#");
		profile1.setEmailID("snoop_suzan@yahoo.com");
		profile1.addDescription("Hi my Name is Sujan!");
		
	
	
		CreateProfileDTO profile2 = new CreateProfileDTO();
		profile2.setId(UUID.randomUUID().toString());
		profile2.setLabel("Eduardo Salas");
		profile2.setPassword("Salase123!@#");
		profile2.setEmailID("salase2@gmail.com");
		profile2.addDescription("My name is Eduardo");
		
		CreateProfileDTO profile3 = new CreateProfileDTO();
		profile3.setId(UUID.randomUUID().toString());
		profile3.setLabel("Paul Swenson");
		profile3.setPassword("PAssword12!@#");
		profile3.setEmailID("swensonpn@unk.edu");
		profile3.addDescription("I am a Professor");
	
		this.ups.CreateUserProfile(profile1);
		this.ups.CreateUserProfile(profile2);
		this.ups.CreateUserProfile(profile3);
//		this.ugs.create(group1);
//		this.ugs.create(group2);
//		
		return "redirect:/user/";
	}
	
	@GetMapping("/delete")
	public String delete(Model m)
	{
		this.ugs.deleteAll();
		this.ups.deleteAll();
		return "redirect:/user/";
	}
}
