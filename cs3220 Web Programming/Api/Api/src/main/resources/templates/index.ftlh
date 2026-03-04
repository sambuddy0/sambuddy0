<#import "/spring.ftl" as spring />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="./javascript/LoginAndRegistrationAndMessageBoard.js" type="text/javascript"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<link rel="stylesheet" type="text/css" href="./css/Styles.css">
</head>
<body>
	<div class="loginForm">
		<form action="" method="post">
			<div class="center header">Login</div>
			<br />
			<div class="divTable">
				<div class="divTableBody">
					<div class="divTableRow">
						<div class="divTableCell">
							<label for="email">Email:</label>
						</div>
						<div class="divTableCell">
							<input type="email" id="email" name="email">
						</div>
					</div>
					<div class="divTableRow">
						<div class="divTableCell">
							<label for="password">Password:</label>
						</div>
						<div class="divTableCell">
							<input type="password" id="password" name="password">
						</div>
					</div>
				</div>
			</div>
			<br />
			<div class="center">
				<div class="errorMessage"></div>
				<br/>
				<button id="login" class="btn btn-primary">Login</button>
				<button id="createAccount" class="btn btn-primary">Register</button>
			</div>
		</form>
	</div>
	
	<div class="registrationForm">
		<form action="" method="post">
			<div class="center header">Register</div>
			<br />
			<div class="divTable">
				<div class="divTableBody">
					<div class="divTableRow">
						<div class="divTableCell">
							<label for="email">Email:</label>
						</div>
						<div class="divTableCell">
							<input type="email" id="registerEmail" name="email">
						</div>
					</div>
					<div class="divTableRow">
						<div class="divTableCell">
							<label for="name">Name:</label>
						</div>
						<div class="divTableCell">
							<input type="text" id="name" name="name">
						</div>
					</div>
					<div class="divTableRow">
						<div class="divTableCell">
							<label for="password">Password:</label>
						</div>
						<div class="divTableCell">
							<input type="password" id="registerPassword" name="password">
						</div>
					</div>
				</div>
			</div>
				<div class="errorMessage"></div>
			<br />
			<div class="center">
				<button id="backToLogin" class="btn btn-primary">Login</button>
				<button id="register" class="btn btn-primary">Register</button>
			</div>
		</form>
	</div>

<!-- ====================================================================================== -->

	<div class="messageBoard">
		<div class="center">Welcome <span class="welcome"></span> !</div>
			<br />
			<div class="center">
				<button id="addMessage" class="btn btn-primary">Add Message</button>
				<button id="logout" class="btn btn-primary">Logout</button>
	
				<br />
	    			<div class="errorMessage"></div>
	    			<div class="emptyTable"></div>
	    		<br />
			</div>
			<br />
			<div class="center" id="messageTable">
		</div>
	</div>
	
	<div class="editMessage">
		<div class="center">
			<div class="header"><div class="welcome"></div>Edit your message!</div>
			<input type="hidden" name="messageId" value="">
			<textarea id="editMessageText" name="editMessageText" rows="4" cols="50"></textarea>
			<br/>
			<div class="errorMessage"></div>
			<button class=" messageBoardBack btn btn-primary">Back</button>
			<button id="submitEdit" class="btn btn-primary">Edit Message</button>
		</div>
	</div>
	
	<div class="addMessage">
		<div class="center">
			<div class="header"><div class="welcome"></div>Add new message!</div>			
			<input type="hidden" id="messageId" value="">
			<textarea id="addMessageText" name="addMessageText" rows="4" cols="50"></textarea>
			<br/>
			<div class="errorMessage"></div>
			<button class="messageBoardBack btn btn-primary">Back</button>
			<button id="submitAdd" class="btn btn-primary">Add Message</button>
		</div>
	</div>
	
</body>
</html>