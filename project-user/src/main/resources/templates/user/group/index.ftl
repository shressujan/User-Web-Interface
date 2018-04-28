<#include "../theme.ftl">

<#macro inject_body>
			<#list Groups as group>
			<ul>
				<li><a href = "/users/profile/${group.getId()}">${group.getLabel()}</li>
			</ul>
		<#else>
				<div class="w3-panel w3-blue">
				  <p>No Items Found in the List</p>
				</div> 
			</#list>
</#macro>

<@template/>