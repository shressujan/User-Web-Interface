<#macro inject_head>
</#macro>

<#macro inject_body>
</#macro>

<#macro template>
<!DOCTYPE html>
	<html lang="en">
		<head>
			<title>
				<#if title??>
					${title}
				<#else>
					No Title
				</#if>
			</title>	 
			<title>
				<#if title??>
					${title}
				<#else>
					No Title
				</#if>
			</title>	  
			  
		    <meta charset="UTF-8">
		    <link href="/css/w3.css" rel="stylesheet" type="text/css"/>
		    <link href="/css/theme.css" rel="stylesheet" type="text/css"/>    
		    <@inject_head/>
		</head>
		<body>
		    <header>
		        <div class="w3-top">
		            <div class="w3-bar w3-black w3-card">
		                <a href="/user/" class="w3-bar-item w3-button w3-padding-large">Home</a>
		                <h1 class="w3-bar-item w3-padding-large w3-medium">
		                	<#if title??>
								${title}
							<#else>
								No Title
							</#if>
		                </h1>
		                <!-- instance of org.springframework.web.servlet.support.RequestContext -->
			                <form>
			                		<input type="submit" class="w3-bar-item w3-button w3-padding-large w3-right" value="Create" formaction="/user/create" formmethod="get" class="w3-button w3-red"/>
			                </form>
			         
		            </div>
		        </div>
		    </header>
		    <main>
		     	<@inject_body/>
		    </main>	    
		</body>
	</html>
</#macro>