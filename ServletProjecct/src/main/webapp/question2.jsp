<!DOCTYPE html>
<html>
<head>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;700&display=swap"
	rel="stylesheet">
<meta charset="UTF-8">
<title>2. Html & Servlet Communication</title>
</head>

<style>
html {
	overflow: hidden;
}

* {
	background-color: #523249;
	color: white;
	margin: 0px;
	font-family: Poppins, Century Gothic;
	font-size: 20px;
}

input[type=text] {
	width: 50vw;
	border-style: none;
	background-color: white;
	color: #815355;
	font-size: 20px;
	padding: 20px;
	border-radius: 15px;
	margin-top:20px;
}

.radioButtons, label{
	margin: 10px 40px 10px 40px;
	font-size: 22px;
}

input[type=submit] {
	border-style: none;
	background-color: #815355;
	cursor: pointer;
	padding: 20px 42px;
	border-radius: 15px;
	color: white;
	margin: 10px 40px 10px 40px;
}

input[type=button] {
	border: 3px solid #AAAAAA;
	border-radius: 100%;
}
.textinput {
	margin: 10px 40px 10px 40px;
}

.submitinput {
	margin: 10px 40px 10px 40px;
}

.nextProject {
	border: none;
	background-color: #815355;
	cursor: pointer;
	padding: 20px 42px;
	color: white;
	width: 100vw;
	bottom: 0px;
	position: absolute;
}

.greet {
	margin: 10px 40px 10px 40px;
}
.message {
	font-size: 50px;
	margin: 10px 40px 10px 40px;
	font-weight: bolder;
}
</style>


<body>
	<form action="tryGreet" method="post">
		<div class="textinput">
			<p>Enter Your Name :</p>
			<input type="text" name="Name" placeholder="Name" autocomplete="off">
			<br>
		</div>
		<br>
		
		
		
		<div class="radioButtons">
		Which fan you are 
			<div>
				<input type="radio" id="Thala" name="fav_actor" value="Thala">
				  <label for="Thala">Thala</label>
			</div>
			<div>
				<input type="radio" id="Thalapathy" name="fav_actor"
					value="Thalapathy">   <label for="Thalapathy">Thalapathy</label>
			</div>
			<div>
				<input type="radio" id="None" name="fav_actor" value="None">
				  <label for="None">None</label>
			</div>
		</div>
		
		<div>
			<input type="submit" value="go">
		</div>
	</form>
	<p class="greet">${GreetHere}</p>
	<div class="message">${message}</div>
	
	<a href="Question2/autoUpdate.jsp"><button class="nextProject">Next project</button></a>
</body>
</html>
