<#include "./theme.ftl">

<#macro inject_body>
		<h2><a href="/user/profile/">Profile</a></h2>
		<#list Profiles as profile>
			<ul>
				<li><a href="/user/profile/${profile.getId()}">${profile.getLabel()}</li>
			</ul>
		<#else>
				<div class="w3-panel w3-blue">
				  <p>No Items Found in the List</p>
				</div> 
		</#list>
		
		<h2><a href="/user/group/">Group</a></h2>
		<#list Groups as group>
			<ul>
				<li><a href="/user/group/${group.getId()}">${group.getLabel()}</li>
			</ul>
		<#else>
				<div class="w3-panel w3-blue">
				  <p>No Items Found in the List</p>
				</div> 
		</#list>
		<form>
			<input type="submit" value="Delete" formaction="/user/delete" formmethod="delete" class="w3-button w3-red"/>
		</form>
</#macro>

<@template/>