$(function() {
	
	// show the add book dialog on click
	$("#add-book-img").click(function () {
		$("#dialog-add-carte").dialog("open");
	});
	
	// show the add book dialog on click
	$("#import-books-img").click(function () {
		$("#dialog-import-books").dialog("open");
	});
	
	// load the books on page load
	loadBooks(1, "", "", "", "", "");
	
	// define the add book dialog
    $("#dialog-add-carte").dialog({
        autoOpen: false,
        height: 640,
        width: 600,
        modal: true,
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
    
    $(".page-button").click(function() {
    	titlu = $("#input-filter-titlu").val();
    	autori = $("#input-filter-autori").val();
    	an = $("#input-filter-an").val();
    	editura = $("#input-filter-editura").val();
    	disponibil = $("#input-filter-disponibil").val();
    	
    	loadBooks(parseInt($(this).html()), titlu, autori, an, editura, disponibil);
    });
    
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
				$("#tabelCarti>tbody>tr>td").html("");
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
			    $(".page-button").addClass("hiddenDiv");
			    if (pageNr > 1) {
			    	$("#previous-1").html(pageNr - 1);
			    	$("#previous-1").removeClass("hiddenDiv");
			    }
			    if (pageNr > 2) {
			    	$("#previous-2").html(pageNr - 2);
			    	$("#previous-2").removeClass("hiddenDiv");
			    }
			    if (pageNr < totalPages) {
			    	$("#next-1").html(pageNr + 1);
			    	$("#next-1").removeClass("hiddenDiv");
			    }
			    if (pageNr < totalPages - 1) {
			    	$("#next-2").html(pageNr + 2);
			    	$("#next-2").removeClass("hiddenDiv");
			    }
			}
	);
}