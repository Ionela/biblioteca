var bookId = 0;
var userId = 0;
var addUser = true;
$(function() {
	
	// show the add book dialog on click
	$("#add-book-img").click(function () {
		$(".input-add-carte").removeAttr("disabled");
		$("#add-carte-obs").removeAttr("disabled");
		// redefine the add book dialog
	    $("#dialog-add-carte").dialog({
	        autoOpen: false,
	        height: 650,
	        width: 600,
	        modal: true,
	        title: "Adauga Carte Noua",
	        buttons: {
	            "Adauga Carte": function() {
	                /*var bValid = true;
	                allFields.removeClass( "ui-state-error" );

	                bValid = bValid && checkLength( name, "username", 3, 16 );
	                bValid = bValid && checkLength( email, "email", 6, 80 );
	                bValid = bValid && checkLength( password, "password", 5, 16 );

	                bValid = bValid && checkRegexp( name, /^[a-z]([0-9a-z_])+$/i, "Username may consist of a-z, 0-9, underscores, begin with a letter." );
	                // From jquery.validate.js (by joern), contributed by Scott Gonzalez: http://projects.scottsplayground.com/email_address_validation/
	                bValid = bValid && checkRegexp( email, /^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i, "eg. ui@jquery.com" );
	                bValid = bValid && checkRegexp( password, /^([0-9a-zA-Z])+$/, "Password field only allow : a-z 0-9" );

	                if ( bValid ) {
	                    $( "#users tbody" ).append( "<tr>" +
	                        "<td>" + name.val() + "</td>" + 
	                        "<td>" + email.val() + "</td>" + 
	                        "<td>" + password.val() + "</td>" +
	                    "</tr>" ); 
	                    $( this ).dialog( "close" );
	                }*/
	            	
	            	// TODO: validate inputs 
	            	$.post("/Biblioteca/books/add",
	            			{
	            				"add-carte-titlu" : $("#add-carte-titlu").val(),
	            				"add-carte-autori": $("#add-carte-autori").val(),
	            				"add-carte-editura" : $("#add-carte-editura").val(),
	            				"add-carte-an" : $("#add-carte-an").val(),
	            				"add-carte-loc": $("#add-carte-loc").val(),
	            				"add-carte-isbn": $("#add-carte-isbn").val(),
	            				"add-carte-cota" : $("#add-carte-cota").val(),
	            				"add-carte-durata": $("#add-carte-durata").val(),
	            				"add-carte-obs" : $("#add-carte-obs").val()
	            			},
	            			function (data) {
	            				if (data == "success") {
	            					alert("Cartea a fost adaugata cu succes.");
	            					
	            					// reload books
	            					pageNr = $("#current").html();
	            			    	titlu = $("#input-filter-titlu").val();
	            			    	autori = $("#input-filter-autori").val();
	            			    	an = $("#input-filter-an").val();
	            			    	editura = $("#input-filter-editura").val();
	            			    	disponibil = $("#input-filter-disponibil").val();
	            					loadBooks(parseInt(pageNr), titlu, autori, an, editura, disponibil)
	            					
	            					$( "#dialog-add-carte").dialog( "close" );
	            				} else {
	            					alert("A aparut o eroare la adaugarea cartii.")
	            				}
	            			}
	            	);
	            },
	            Cancel: function() {
	                $( this ).dialog( "close" );
	            }
	        },
	        close: function() {
	        	$("#dialog-add-carte > div > [id^=add-carte-]").val("");
	        }
	    });
		
		
		$("#dialog-add-carte").dialog("open");
	});
	
	$(".book-details-img").click(function(){
		drepturi = $("#drepturi-user").val();
		bookId = $(this).parent().parent().attr("id");
		if (drepturi != 2){
			$(".input-add-carte").attr("disabled", "disabled");
			$("#add-carte-obs").attr("disabled", "disabled");
		} else {
			$(".input-add-carte").removeAttr("disabled");
			$("#add-carte-obs").removeAttr("disabled");
		}
		
		$.get("/Biblioteca/books/book/" + bookId,
    			{},
    			function (data) {
    				book = $.parseJSON(data);
    				$("#add-carte-titlu").val(book.titlu);
    				$("#add-carte-autori").val(book.autori);
    				$("#add-carte-editura").val(book.editura);
    				$("#add-carte-an").val(book.anAparitie);
    				$("#add-carte-loc").val(book.locAparitie);
    				$("#add-carte-durata").val(book.durataImprumut);
    				$("#add-carte-isbn").val(book.isbn);
    				$("#add-carte-cota").val(book.cota);
    				$("#add-carte-obs").val(book.observatii);
    			}
    	);
		
		if (drepturi != 2) {
			// define the view dialog for other users
		    $("#dialog-add-carte").dialog({
		        autoOpen: false,
		        height: 650,
		        width: 600,
		        modal: true,
		        title: "Detalii",
		        buttons: {
		            Cancel: function() {
		                $( this ).dialog( "close" );
		            }
		        },
		        close: function() {
		        	$("#dialog-add-carte > div > [id^=add-carte-]").val("");
		        }
		    });
		} else {
			// define the edit dialog for admin
		    $("#dialog-add-carte").dialog({
		        autoOpen: false,
		        height: 650,
		        width: 600,
		        modal: true,
		        title: "Editeaza informatiile cartii",
		        buttons: {
		            "Salveaza": function() {
		            	$.post("/Biblioteca/books/book/" + bookId,
		            			{
		            				"add-carte-titlu" : $("#add-carte-titlu").val(),
		            				"add-carte-autori": $("#add-carte-autori").val(),
		            				"add-carte-editura" : $("#add-carte-editura").val(),
		            				"add-carte-an" : $("#add-carte-an").val(),
		            				"add-carte-loc": $("#add-carte-loc").val(),
		            				"add-carte-isbn": $("#add-carte-isbn").val(),
		            				"add-carte-cota" : $("#add-carte-cota").val(),
		            				"add-carte-durata": $("#add-carte-durata").val(),
		            				"add-carte-obs" : $("#add-carte-obs").val()
		            			},
		            			function (data) {
		            				if (data == "success") {
		            					alert("Cartea a fost modificata cu succes.");
		            			    	
		            					// reload books
		            					pageNr = $("#current").html();
		            			    	titlu = $("#input-filter-titlu").val();
		            			    	autori = $("#input-filter-autori").val();
		            			    	an = $("#input-filter-an").val();
		            			    	editura = $("#input-filter-editura").val();
		            			    	disponibil = $("#input-filter-disponibil").val();
		            					loadBooks(parseInt(pageNr), titlu, autori, an, editura, disponibil)

		            					$( "#dialog-add-carte").dialog( "close" );
		            				} else {
		            					alert("A aparut o eroare la salvarea cartii.")
		            				}
		            			}
		            	);
		            },
		        	Cancel: function() {
		                $( this ).dialog( "close" );
		            }
		        },
		        close: function() {
		        	$("#dialog-add-carte > div > [id^=add-carte-]").val("");
		       
		        }
		    })
		}
		
		$("#dialog-add-carte").dialog("open");
	});
	
	$("#dialog-confirm-delete").dialog({
		autoOpen: false,
		resizable: true,
        height: 300,
        width: 400,
        modal: true,
        buttons: {
            "Sterge": function() {
            	$.ajax({
            		   url: "/Biblioteca/books/book/" + bookId,
            		   type: 'DELETE',
            		   }
            	).always(function(data){
   					if (data == "success") {
       					alert("Cartea a fost stearsa cu succes.");
       			    	
       					// reload books
       					pageNr = $("#current").html();
       			    	titlu = $("#input-filter-titlu").val();
       			    	autori = $("#input-filter-autori").val();
       			    	an = $("#input-filter-an").val();
       			    	editura = $("#input-filter-editura").val();
       			    	disponibil = $("#input-filter-disponibil").val();
       					loadBooks(parseInt(pageNr), titlu, autori, an, editura, disponibil)

       					$("#dialog-confirm-delete").dialog( "close" );
       				} else {
       					alert("A aparut o eroare la stergerea cartii.")
       				}            		
            	});            	
            },
            Cancel: function() {
                $( this ).dialog( "close" );
            }
        }
    });
	
	$(".book-delete-img").click(function(){
		bookId = $(this).parent().parent().attr("id");
		$("#dialog-confirm-delete").dialog("open");	
	});
	
	// show the add book dialog on click
	$("#import-books-img").click(function () {
		$("#dialog-import-books").dialog("open");
	});
	
	// load the books on page load
	loadBooks(1, "", "", "", "", "");
	
	// define the add book dialog
    $("#dialog-add-carte").dialog({
    	autoOpen:false
    });
    
    // define the import books dialog
    $("#dialog-import-books").dialog({
        autoOpen: false,
        height: 640,
        width: 600,
        modal: true,
        buttons: {
            "Incarca": function() {
            	// TODO: validate inputs
            	$("#form-import-books").submit();
            },
            Cancel: function() {
                $( this ).dialog( "close" );
            }
        },
        close: function() {
        	$("#dialog-import-books > div > input").val("");
        }
    });
    
    $(".page-button").mouseover(function() {
    	$(this).addClass("button-mouse-over");
    });
    
    $(".page-button").mouseout(function() {
    	$(this).removeClass("button-mouse-over");
    });
    
    // select a specific page
    $(".page-button").click(function() {
    	titlu = $("#input-filter-titlu").val();
    	autori = $("#input-filter-autori").val();
    	an = $("#input-filter-an").val();
    	editura = $("#input-filter-editura").val();
    	disponibil = $("#input-filter-disponibil").val();
    	
    	loadBooks(parseInt($(this).html()), titlu, autori, an, editura, disponibil);
    });
    
    // click previous page
    $("#previous-page").click(function() {
    	
    	if ($("#previous-1").html() == "") {
    		return;
    	}
    	
    	titlu = $("#input-filter-titlu").val();
    	autori = $("#input-filter-autori").val();
    	an = $("#input-filter-an").val();
    	editura = $("#input-filter-editura").val();
    	disponibil = $("#input-filter-disponibil").val();
    	
    	loadBooks(parseInt($("#current").html()) - 1, titlu, autori, an, editura, disponibil);
    });
    
    
    //clicl next page
    $("#next-page").click(function() {
    	
    	if ($("#next-1").html() == "") {
    		return;
    	}
    	
    	titlu = $("#input-filter-titlu").val();
    	autori = $("#input-filter-autori").val();
    	an = $("#input-filter-an").val();
    	editura = $("#input-filter-editura").val();
    	disponibil = $("#input-filter-disponibil").val();
    	
    	loadBooks(parseInt($("#current").html()) + 1, titlu, autori, an, editura, disponibil);
    });
    
    $("#filters>div>input").change(function(){
    	titlu = $("#input-filter-titlu").val();
    	autori = $("#input-filter-autori").val();
    	an = $("#input-filter-an").val();
    	editura = $("#input-filter-editura").val();
    	disponibil = $("#input-filter-disponibil").val();
    	
    	loadBooks(1, titlu, autori, an, editura, disponibil);    	
    });
    
    $("#export-pdf-img").click(function(){
    	pageNr = $("#current").html();
    	titlu = $("#input-filter-titlu").val();
    	autori = $("#input-filter-autori").val();
    	an = $("#input-filter-an").val();
    	editura = $("#input-filter-editura").val();
    	disponibil = $("#input-filter-disponibil").val();
    	
    	
    	window.location = "http://localhost:9999/Biblioteca/books/export?input-filter-page="+ pageNr + 
    		"&input-filter-titlu="+ titlu + 
    		"&input-filter-autori="+ autori +
    		"&input-filter-an="+ an +
    		"&input-filter-editura="+ editura +
    		"&input-filter-disponibil=" + disponibil;
    });
    
    $("tbody>tr").mouseover(function(){
    	$(this).addClass("trMouseOver");
    	$(this).children(':nth-child(6)').removeClass("book-menu-td-hidden");
    	$(this).children('td:nth-child(6)').removeClass("book-menu-td-hidden");
    });
    
    $("tbody>tr").mouseout(function(){
    	$(this).removeClass("trMouseOver");
    	$(this).children(':nth-child(6)').addClass("book-menu-td-hidden");
    	$(this).children('td:nth-child(6)').addClass("book-menu-td-hidden");
    });
    
    //_________________________________________________________________________________________________________//
    loadUsers();
    $("#dialog-confirm-delete-user").dialog({
		autoOpen: false,
		resizable: true,
        height: 300,
        width: 400,
        modal: true,
        buttons: {
            "Sterge": function() {
            	$.ajax({
            		   url: "/Biblioteca/users/user/" + userId,
            		   type: 'DELETE',
            		   }
            	).always(function(data){
   					if (data == "success") {
       					alert("Utilizatorul a fost sters cu succes.");
       					// reload users
       					loadUsers();
       					$("#dialog-confirm-delete-user").dialog("close");
       				} else {
       					alert("A aparut o eroare la stergerea utilizatorului.")
       				}            		
            	});            	
            },
            Cancel: function() {
                $( this ).dialog( "close" );
            }
        }
    });
	
	$("#delete-user").click(function(){
		userId = $("#user-drop-down").val();
		$("#dialog-confirm-delete-user").dialog("open");	
	});
	
	$("#dialog-add-user").dialog({
        autoOpen: false,
        height: 450,
        width: 600,
        modal: true,
        title: "Adauga / modifica utilizator",
        buttons: {
            "Salveaza": function() {
            	// add or update
            	url = "/Biblioteca/users/add";
            	if (!addUser) {
            		url = "/Biblioteca/users/user/" + userId;
            	}
            	
            	// TODO: validate inputs 
            	$.post(url,
            			{
            				"add-user-username" : $("#add-user-username").val(),
            				"add-user-password": $("#add-user-password").val(),
            				"add-user-nume" : $("#add-user-nume").val(),
            				"add-user-email" : $("#add-user-email").val(),
            				"add-user-telefon": $("#add-user-telefon").val(),
            				"add-user-adresa": $("#add-user-adresa").val(),
            				"add-user-drepturi" : $("#add-user-drepturi").val()
            			},
            			function (data) {
            				if (data == "success") {
            					alert("Utilizatorul a fost salvat cu succes.");
            					
            					loadUsers();
            					$( "#dialog-add-user").dialog( "close" );
            				} else {
            					alert("A aparut o eroare salvarea utilizatorului.")
            				}
            			}
            	);
            },
            Cancel: function() {
                $( this ).dialog( "close" );
            }
        },
        close: function() {
        	$("#dialog-add-user > div > [id^=add-user-]").val("");
        }
    });
	
	$("#add-user").click(function(){
		addUser = true;
		$("#dialog-add-user").dialog("open");
	});
	
	$("#edit-user").click(function(){
		addUser = false;
		$.get("/Biblioteca/users/user/" + userId,
    			{},
    			function (data) {
    				user = $.parseJSON(data);
    				$("#add-user-username").val(user.username);
    				$("#add-user-password").val(user.password);
    				$("#add-user-nume").val(user.nume);
    				$("#add-user-email").val(user.email);
    				$("#add-user-telefon").val(user.telefon);
    				$("#add-user-adresa").val(user.adresa);
    				$("#add-user-drepturi").val(user.drepturi);
    			}
    	);
		$("#dialog-add-user").dialog("open");
	})
})

function loadBooks(pageNr, titlu, autori, an, editura, disponibil) {
	$.get("/Biblioteca/books/get/all",
			{
				"input-filter-page" : pageNr,
				"input-filter-titlu": titlu,
				"input-filter-autori" : autori,
				"input-filter-an" : an,
				"input-filter-editura": editura,
				"input-filter-disponibil": disponibil,
			},
			function (data) {
				$("#tabelCarti>tbody>tr>td:not(.book-menu)").html("");
				books = $.parseJSON(data);

				// populate the table
			    $.each(books[1], function(index, book){
			    	$("#tabelCarti tbody tr:nth-child(" + (index + 1) + ")").attr("id", book.idCarte);
			    	$("#tabelCarti tbody tr:nth-child(" + (index + 1) + ") td:nth-child("+ 1 + ")").html(book.titlu);
			    	$("#tabelCarti tbody tr:nth-child(" + (index + 1) + ") td:nth-child("+ 2 + ")").html(book.autori);
			    	$("#tabelCarti tbody tr:nth-child(" + (index + 1) + ") td:nth-child("+ 3 + ")").html(book.anAparitie);
			    	$("#tabelCarti tbody tr:nth-child(" + (index + 1) + ") td:nth-child("+ 4 + ")").html(book.editura);
			    	$("#tabelCarti tbody tr:nth-child(" + (index + 1) + ") td:nth-child("+ 5 + ")").html("");
			     });
			    
			    // build the navigation tab
			    totalPages = Math.floor(books[0] / 10) + 1;
			    $("#current").html(pageNr);
			    $(".page-button").html("");
			    $(".page-button").addClass("hiddenElement");
			    if (pageNr > 1) {
			    	$("#previous-1").html(pageNr - 1);
			    	$("#previous-1").removeClass("hiddenElement");
			    }
			    if (pageNr > 2) {
			    	$("#previous-2").html(pageNr - 2);
			    	$("#previous-2").removeClass("hiddenElement");
			    }
			    if (pageNr < totalPages) {
			    	$("#next-1").html(pageNr + 1);
			    	$("#next-1").removeClass("hiddenElement");
			    }
			    if (pageNr < totalPages - 1) {
			    	$("#next-2").html(pageNr + 2);
			    	$("#next-2").removeClass("hiddenElement");
			    }
			}
	);
}

function loadUsers() {
	drepturi = $("#drepturi-user").val();
    if (drepturi >=1) {
    	$.get("/Biblioteca/users/get/all",
    			{},
    			function(data) {
    				users = $.parseJSON(data);
    				$("#user-drop-down").html("");
    				
    				optionClass="";
    			    $.each(users, function(index, user){
    			    	optionClass="";
    			    	if (user.drepturi == 2) {
    			    		optionClass = "admin-font";
    			    	} else if (user.drepturi == 1) {
    			    		optionClass = "bibliotecar-font";
    			    	}
    			    	
    			    	optionClass = " class='" + optionClass + "' ";
    			    	$("#user-drop-down").append("<option " + optionClass + " value='" + user.idUser + "'>"+ user.nume +"</option>");
    			     });
    			})
    }
    
    $("#user-drop-down").change(function(){
    	userId = $(this).val();
    });
}