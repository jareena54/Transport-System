<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="managerCreation.Managerbean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.navbar {
	background-color: gray;
	overflow: hidden;
	display: flex;
	justify-content: space-around;
}

.navbar li {
	float: left;
}

.navbar li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 20px;
	text-decoration: none;
	transition: background-color 0.3s;
}

.navbar li a:hover {
	background-color: #fff;
	color: gray;
}

.navbar li {
	text-align: center;
	list-style-type: none;
}

header a {
	text-decoration: none;
}

body {
	font-family: Arial, sans-serif;
}

h1 {
	font-size: 28px;
}

h2 {
	font-size: 24px;
}

p, a {
	font-size: 18px;
}

table {
	width: 70%;
	margin: 20px;
	padding: 40px;
	border-collapse: collapse;
}
.tableformat{
width: 130%;
}
td {
	vertical-align: top;
}
th{
border: 2px solid black;
}
.tdd{
text-align:center;
border: 1px; 
border: 2px solid black;
}

section {
	background-color: #6b8e23;
	font-size: 18px;
	color: white;
	border: 2px solid black;
	padding: 20px;
	border-radius: 10px;
	height: 170%;
	box-shadow: 10px 10px 10px solid black
}

.section {
	border: 2px soild black;
}

.image-container {
	float: right;
	margin: 20px;
	width: 20px;
}

.from {
	font-size: 30px;
	height: 300px;
	margin: 20px;
}

.from>input {
	font-size: 20px;
}

.button {
	background-color: blue;
	border-radius: 10px;
	width: 100px;
	height: 38px;
}

.select>option {
	font-size: 38px;
}
</style>
</head>
<body>
<header>
		<nav>
			<ul class="navbar">
				<li class="inside"><a href="Homepage.html">Home</a></li>
				<li><a href="recenttrucks.html">Recently
						Installed Trucks</a></li>
				<li><a href="Status">Status</a></li>
				<li><a href="Towardshere.html">Towards Here</a></li>
				<li><a href="Services.html">Services</a></li>
				<li><a href="ContactUs.html">Contact Us</a></li>
			</ul>
			<h1>Most Convenient & Reliable Transport Services</h1>
			<p>
				<a href="details.html">Click here for details</a>
			</p>
		</nav>
	</header>
	<table>
		<tr>
			<td>
				<main>
					<section class="section">


						<table >
							<tr>
								<td>
									<h1>Welcome to Our Truck Tracking Company</h1>
									
									<table border="2px" class="tableformat">
									<tr>
									<th>UserName</th>
									<th>Password</th>
									<th>Date_of_Joining</th>
									<th>DAte Of Birth</th>
									<th>Salary</th>
									<th>Remove</th>
									
									</tr>
									<tr>
									<%Managerbean m=(Managerbean)request.getAttribute("managerbean"); %>
									<td class="tdd">
								<%out.println(m.getUsername()); %>
								</td>
								<td class="tdd"><%out.println(m.getPassword()); %></td>
								<td class="tdd"><%out.println(m.getDate_of_joining());%></td>
								<td class="tdd" ><%out.println(m.getDate_of_birth()); %></td>
								<td class="tdd"><%out.println(m.getSal()); %></td>
								<td class="tdd"><a href="Managerdeleting">Delete</a></td>
									
									</tr>
									</table>

								</td>
							</tr>
						</table>
						</div>
						</div>
					</section>
				</main>
			</td>
			<td>
				<!-- Moved the image container div outside the main tag -->
				<div class="image-container">
					<img alt="image" src="th.jpg"> <img alt="image" src="th.jpg">

				</div>
			</td>
		</tr>
	</table>


</body>
</html>