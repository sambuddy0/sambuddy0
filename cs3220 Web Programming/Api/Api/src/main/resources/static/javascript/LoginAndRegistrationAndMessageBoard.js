let userId = 0;
let userName;

var login = {
	
    init: function() {
		console.log("Login init");
		this.showLoginForm();
        this.addListener();
    },
    
	addListener: function() {
		console.log("Add Login Event Listener");
        $("#createAccount").on("click", function(event) {
			$('.errorMessage').text('');
			event.preventDefault();
            this.showRegistrationForm();
        }.bind(this));
        $("#backToLogin").on("click", function() {
			$('.errorMessage').text('');
            this.showLoginForm();
        }.bind(this));
        $("#login").on("click", function(event) {
			event.preventDefault()
			this.login();
		}.bind(this));
		$("#register").on("click", function(event) {
			event.preventDefault()
			this.register()
		}.bind(this));
    },
    
	showRegistrationForm: function() {
		console.log("Show Registration Form");
        $(".loginForm").hide();
        $(".registrationForm").show();
    },
    
	showLoginForm: function() {
		console.log("Show Login Form");
        $(".registrationForm").hide();
        $(".loginForm").show();
    },
    
	hideLoginAndRegister: function() {
		console.log("Hide Login and Registration Form");
		$(".registrationForm").hide();
        $(".loginForm").hide();
	},
    
    login: function() {
		console.log("Login Process");
		let formData = {
			"email": $("#email").val(),
			"password": $("#password").val()
		}
		console.log("Form Data: " + formData);
		$.ajax({
			url: '/api/validateUser',
			type: 'POST',
			contentType: 'application/json; charset=utf-8',
			data: JSON.stringify(formData),
			dataType: 'json',
			success: function(result) {
				$('.errorMessage').text('');
				userId = result;
				console.log("The current user is: " + userId);
				this.hideLoginAndRegister();
				messages.init();
				$('title').text('Message Board');
			}.bind(this),	
			error: function(xhr, status, error) {
				var errorMessage = xhr.responseJSON.message;
				console.log("xhr:" + xhr);
				console.log("status:" + status);
				console.log("error:" + error);
				$('.errorMessage').text(errorMessage);
				$('#email').val('');
				$('#password').val('');
			}			
		});	
	},

	register: function() {
		console.log("Registration Process");
		let formData = {
			"email": $("#registerEmail").val(),
			"name": $("#name").val(),
			"password": $("#registerPassword").val()
		}
		console.log("Form Data: " + formData);
		$.ajax({
			url: '/api/registerUser',
			type: 'POST',
			contentType: 'application/json; charset=utf-8',
			data: JSON.stringify(formData),
			dataType: 'json',
			success: function(result) {
				console.log("The current user is: " + result);
				this.showLoginForm();
				$(".errorMessage").text('');
				$("#registerEmail").val('');
				$("#name").val('');
				$("#registerPassword").val('');
			}.bind(this),	
			error: function(xhr, status, error) {
				var errorMessage = xhr.responseJSON.message;
				console.log("xhr:" + xhr);
				console.log("status:" + status);
				console.log("error:" + error);
				$('.errorMessage').text(errorMessage);
				$("#registerEmail").val('');
				$("#name").val('');
				$("#registerPassword").val('');
			}
		});
	}
}

function getMonthName(month) {
    const months = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
    return months[parseInt(month, 10) - 1]; 
}

function convertDate(date){
	date = date.split("-");
	let formattedDate = date[2] +' '+ getMonthName(date[1]) +' '+ date[0]; 
	return formattedDate;
}
// LOGGED IN CONTENT
var messages = {
	
	init: function() {
		console.log("Message init");
		this.addListener();
		this.showTable();
		this.autoGenerateTable();
		messages.setUserName(); 
	},

	addListener: function() {
		console.log("Adding Messages Event Listener");
		$(".messageBoardBack").on("click", function() {
			$('.errorMessage').text('');
      		this.showTable();
      	}.bind(this));
		$("#addMessage").on("click", function() {
			$('.errorMessage').text("");
			this.showAddForm();
		}.bind(this));
		$("#logout").on("click", function() {
			this.logout();
		}.bind(this));
		$("#submitAdd").on("click", function() {
			this.addMessage();
		}.bind(this));
		$("#submitEdit").on("click", function() {
       		var messageId = $('input[name="messageId"]').val();
			console.log("messageidSubmitEdit: " + messageId);
			messages.editMessage(messageId);
		});
	},

	autoGenerateTable: function() {
		console.log("Generate Table");	
		$.ajax({
			url: '/api/messagesDto',
			contentType: 'application/json; charset=utf-8',
	        type: 'GET',
	        success: function(data) {
            	this.createMessageList(data, "#messageTable"); // Create the table
				$(".editMessageBtn").on("click", function() {  // creates event listeners for edit 
					var row = $(this).closest('.divTableRow');
	 				var messageId = row.find('.editMessageBtn').val();	
	 				var message = row.find('.messageContent').text()
	 				var authorOfMessageId = row.find("input[name='userId']").val();
	 				if (userId == authorOfMessageId) {	
						$('.errorMessage').text('');
	 					console.log("Message ID: " + messageId);
	 					console.log("Message: " + message);
						messages.showEditForm();
						$('input[name="messageId"]').val(messageId);
						$('#editMessageText').val(message);
					} else {
						$('.errorMessage').text("That's not your message!");
					}
				});
				$(".deleteMessage").on("click", function() { // creates event listener for delete
					var row = $(this).closest('.divTableRow');
	 				var messageId = row.find('.deleteMessage').val()
	 				var authorOfMessageId = row.find("input[name='userId']").val();

					console.log("Deleted message ID: " + messageId);
					if (userId == authorOfMessageId) {
						messages.deleteMessage(messageId);
					} else {
						$('.errorMessage').text("That's not your message!");
					}
				});
        	}.bind(this),
        	error: function() {
				$("#messageTable").text("");
				$(".errorMessage").text("No Data in table");
			} 
		});
	},
	
	createMessageList: function(messages, targetDiv){
		console.log("Create Message List");
		let messageList = $(targetDiv);
		messageList.empty();
		let table = $("<div class='divTable'></div>");
		let tableHeader = $("<div class='divTableHeading'><div class='divTableRow'><div class='divTableHead'>Name</div><div class='divTableHead'>Message</div><div class='divTableHead'>Date</div><div class='divTableHead'>Edit</div><div class='divTableHead'>Delete</div></div>");
		let tableBody = $("<div class='divTableBody'></div>");
		$.each(messages, function(index, message) {
			var formattedDate = convertDate(message.date);
			let row = $("<div class='divTableRow'></div>");
			let nameCell = $("<div class='divTableCell'></div>").text(message.userName);
			let hiddenUserId = $("<input type='hidden' name='userId' value=''>").val(message.userId);
			let messageCell = $("<div class='divTableCell messageContent'></div>").text(message.message);
			let dateCell = $("<div class='divTableCell'></div>").text(formattedDate);
			let editCell = $("<div class='divTableCell'></div>");
			let deleteCell = $("<div class='divTableCell'></div>");
			let editButton = $("<button value = '' class='editMessageBtn btn btn-primary'>Edit</button>").val(message.id);
			let deleteButton = $("<button value ='' class='deleteMessage btn btn-primary'>Delete</button></div>").val(message.id);
			editCell.append(editButton);
			deleteCell.append(deleteButton);
			nameCell.append(hiddenUserId);
			row.append(nameCell);
			row.append(messageCell);
			row.append(dateCell);
			row.append(editCell);
			row.append(deleteCell);	
			tableBody.append(row);
		});
		table.append(tableHeader);
		table.append(tableBody);
		messageList.append(table);
	},
	
	setUserName: function() {
		console.log("Set User Name");
		$.ajax({
			url: 'api/getUserById/'+userId,
			contentType: 'application/json; charset=utf-8',
	        type: 'GET',
	        success: function(data) {
				userName = data.name;
				console.log("name:" + userName);
				$('.welcome').text(userName);
			},
			else: function(){
				$(".errorMessage").text('Error');
			}
		});
	},

	showTable: function() {
		console.log("Show Message Table");
        $(".editMessage").hide();
        $(".addMessage").hide();
        $(".messageBoard").show();
    },
	
    showEditForm: function() {
		console.log("Show Edit Message Form");
        $(".messageBoard").hide();
        $(".addMessage").hide();
        $(".editMessage").show();
    },
	
    showAddForm: function() {
		console.log("Show Add Message Form");
		$(".messageBoard").hide();
		$(".editMessage").hide();
		$(".addMessage").show();
	},
	
	logout: function() {
		console.log("Logout");
		window.location.href = '/';
	},
	
	addMessage: function() {
		console.log("Add Message Process");
		let formData = {
			"userName": userName,
			"message": $("#addMessageText").val(),
			"userId": userId
		}
		console.log("Form Data: " + formData);
		$.ajax({
			url: '/api/addMessage',
			type: 'POST',
			contentType: 'application/json; charset=utf-8',
			data: JSON.stringify(formData),
			dataType: 'json',
			success: function(result) {
				$('.errorMessage').text('');
				console.log("Message added: " + result);
				$("#addMessageText").val("");
				this.autoGenerateTable();
				this.showTable();
			}.bind(this),	
			error: function(xhr, status, error) {
				console.log("xhr:" + xhr);
				console.log("status:" + status);
				console.log("error:" + error);
				$('.errorMessage').text('Please fill out all fields!');
			}			
		});
	},
	
	deleteMessage: function(messageId) {
		console.log("Delete Message Process - ID: " + messageId);
		messageId = parseFloat(messageId.replace(/,/g, ''));
	
		$.ajax({
			url: '/api/deleteMessage/'+messageId,
			type: 'DELETE',
			success: function(result) {
				this.autoGenerateTable();
				this.showTable();
			}.bind(this),	
			error: function(xhr, status, error) {
				console.log("xhr:" + xhr);
				console.log("status:" + status);
				console.log("error:" + error);
			}	
		});
	},
	
	editMessage: function(messageId) {
		console.log("Edit Message Process - ID: " + messageId);
		this.messageId = parseFloat(messageId.replace(/,/g, ''));
		let formData = {
			"userId": userId,
			"message": $("#editMessageText").val()
		}
		console.log("Form Data: " + formData);
		$.ajax({
			url: '/api/editMessage/'+messageId,
			type: 'PATCH',
			contentType: 'application/json; charset=utf-8',
			data: JSON.stringify(formData),
			dataType: 'json',
			success: function(result) {
				console.log("The current message ID is: " + result); // This result should be undefined because API is not returning anything
				this.autoGenerateTable();
				this.showTable();

			}.bind(messages),	
			error: function(xhr, status, error) {
				console.log("xhr:" + xhr);
				console.log("status:" + status);
				console.log("error:" + error);
				$('.errorMessage').text('Please fill out all fields!');
			}	
		});
	}
}

// Init
$(document).ready(function(){
    // waiting for the page to finish rendering and then it will finish the js function
    login.init();
});