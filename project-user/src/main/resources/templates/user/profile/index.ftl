<#include "../theme.ftl">

<#macro inject_body>
			<#list Profiles as profile>
			<ul>
				<li><a href = "/user/profile/${profile.getId()}">${profile.getLabel()}</li>
			</ul>
		<#else>
				<div class="w3-panel w3-blue">
				  <p>No Items Found in the List</p>
				</div> 
			</#list>
</#macro>

<@template/>