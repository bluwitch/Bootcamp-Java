<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninja Gold</title>
<link rel="stylesheet"
	href="/webjars/bootstrap/4.5.3/css/bootstrap.min.css">
<script src="/webjars/bootstrap/4.5.3/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="./CSS/style.css">

</head>

<body>
	<div class="container p-2">

		<h1 class="text-center mt-4 mb-4">Ninja Gold</h1>

		<h2 class="ml-2">Your Gold:</h2>

		<div class="row">
			<div class="card col mx-4 p-4 text-center custom-container">
				<form action="/gold" method="post">
					<h2>Farm</h2>
					<p class="p-2 mb-5">(earns 10-20 gold)</p>
					<input type="hidden" name="lugar" value="farm" />
					<button type="submit" class="btn btn-info btn-warning">Find
						Gold!</button>
				</form>
			</div>

			<div class="card col mx-2 p-4 text-center custom-container">
				<form action="/gold" method="post">
					<h2>Cave</h2>
					<p class="p-2 mb-5">(earns 5-10 gold)</p>
					<input type="hidden" name="lugar" value="cave" />
					<button type="submit" class="btn btn-info btn-warning">Find
						Gold!</button>
				</form>


			</div>

			<div class="card col mx-2 p-4 text-center custom-container">
				<form action="/gold" method="post">
					<h2>House</h2>
					<p class="p-2 mb-5">(earns 2-5 gold)</p>
					<input type="hidden" name="lugar" value="house" />
					<button type="submit" class="btn btn-info btn-warning">Find
						Gold!</button>
				</form>

			</div>

			<div class="card col mx-2 p-4 text-center custom-container">
				<form action="/gold" method="post">
					<h2>Casino</h2>
					<p class="p-2">(earns/takes 0-50 gold)</p>
					<input type="hidden" name="lugar" value="casino" />
					<button type="submit" class="btn btn-info btn-warning">Find
						Gold!</button>
				</form>

			</div>
		</div>


	</div>

</body>

</html>