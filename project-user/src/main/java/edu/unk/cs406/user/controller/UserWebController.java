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
			//throw new NotFoundException("Groups null!");
		}
		model.addAttribute("title", "User");
		model.addAttribute("Groups", groups);
		model.addAttribute("Profiles", profiles);
		
		return "user/index";
	}


	@GetMapping("/profile/")
	public String profileIndex(Model model)
	{
		List<ProfileEntity> profiles = this.ups.FindAllUserProfiles();
		if(profiles == null)
		{
			//throw new NotFoundException("Profiles null!");
		}
		model.addAttribute("Profiles", profiles);
		model.addAttribute("title", "Profile");
		
		return "user/profile/index";
	}

	@GetMapping("/profile/{id}")
	public String profileView(@PathVariable(value = "id", required = true) String id , Model m)
	{
		ProfileEntity ue = this.ups.GetUserProfile(id);
		List<String> strArr = new ArrayList<String>();
		strArr.add("Test Data");
		
		m.addAttribute("title", "Profile View");
		m.addAttribute("entity", ue);
		m.addAttribute("userList", "Subscriptions");
		m.addAttribute("Comments", strArr);
		m.addAttribute("Events", strArr);
		m.addAttribute("Locations", strArr);
		m.addAttribute("Subscriptions", strArr);

		return "user/profile/view";
	}

	@GetMapping("/group/")
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
	public String addDummyData(Model m)
	{
//		CreateGroupDTO group1 = new CreateGroupDTO();
//		group1.setLabel("Group 1");
//		group1.setDescription("Test Description");
//		
//		CreateGroupDTO group2 = new CreateGroupDTO();
//		group2.setLabel("Group 2");
//		group2.setDescription("Test Description");
		
		CreateProfileDTO profile1 = new CreateProfileDTO();
		profile1.setId(UUID.randomUUID().toString());
		profile1.setLabel("Profile 1");
		profile1.setPassword("CReate123!@#");
		profile1.setEmailID("snoop@yahoo.com");
		profile1.addDescription("Test Description");
		
		CreateProfileDTO profile2 = new CreateProfileDTO();
		profile2.setId(UUID.randomUUID().toString());
		profile2.setLabel("Profile 2");
		profile2.setPassword("CReatS123!@#");
		profile2.setEmailID("helloop@yahoo.com");
		profile2.addDescription("Test Description");
		
		//this.ugs.create(group1);
		//this.ugs.create(group2);
		this.ups.CreateUserProfile(profile1);
		this.ups.CreateUserProfile(profile2);
		
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
