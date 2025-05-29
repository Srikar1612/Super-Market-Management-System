/**
 * 
 */
function fetchDetails(){
	const de_ID=document.getElementById("de_ID").value;
	if(de_ID){
		fetch(`fetchUser?de_ID=${encodeURIComponent(de_ID)}`)
		.then(response=>response.json())
		.then(data =>{
			if(data){
				document.getElementById("de_Name").value=data.name;
				document.getElementById("de_Phone").value=data.phone;
				document.getElementById("de_Email").value=data.email;
				document.getElementById("de_Age").value=data.age;
			}
			 else {
	                alert("No user found with this ID.");
	                document.getElementById("de_Name").value = "";
	                document.getElementById("de_Phone").value = "";
	                document.getElementById("de_Email").value = "";
	                document.getElementById("de_Age").value = "";
	            }
	        })
	        .catch(error => {
	            console.error("Fetch error:", error);
	        });
	}
}

function conf(){
	const name = document.getElementById("de_Name").value;
	const str="Are you sure you want to delete" +name;
	if(confirm(str)){
		return true;
	}
	else{
		return false;
	}
}