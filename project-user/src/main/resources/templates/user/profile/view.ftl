<#include "../theme.ftl">

<#macro inject_body>
		<h2>${entity.getLabel()}</h2>
		<h3>Description</h3>
		<p>${entity.getDescription()}<p>
		<h3>Likes: 34</h3>
		<h3>Comments</h3>
			<#list Comments as comment>
				<ul>
					<li>${comment}</li>
				</ul>
			<#else>
				<div class="w3-panel w3-blue">
				  <p>No Comments</p>
				</div> 
			</#list>
		<h3>Locations</h3>
			<#list Locations as location>
				<ul>
					<li>${location}</li>
				</ul>
			<#else>
				<div class="w3-panel w3-blue">
				  <p>No Locations</p>
				</div> 
			</#list>
		<h3>Events</h3>
			<#list Events as event>
				<ul>
					<li>${event}</li>
				</ul>
			<#else>
				<div class="w3-panel w3-blue">
				  <p>No Events</p>
				</div> 
			</#list>
		<h3>${userList}</h3>
			<#list Subscriptions as subscription>
				<ul>
					<li>${subscription}</li>
				</ul>
			<#else>
				<div class="w3-panel w3-blue">
				  <p>No members</p>
				</div> 
			</#list>
		<h3>Content</h3>
</#macro>

<@template/>