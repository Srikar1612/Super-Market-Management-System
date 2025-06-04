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

function manageEmployees(){
	fetch('GetEmployeesList')
	.then(response => response.json())
	.then(data =>{
		const table=document.getElementById("employeeList");
		table.innerHTML='<tr><th>Id</th><th>Name</th><th>Status</th></tr>';
		data.forEach(employee=>{
		const tr=document.createElement('tr');
		tr.innerHTML=`<td>${employee.id}</td><td>${employee.name}</td>
			<td>
		<input type="checkbox" ${employee.status=='Active'?'checked':''} onChange="updateStatus('${employee.id}',this.checked)">
		</td>`;
		table.appendChild(tr);
		});
	})
	.catch(error => console.error("Error loading employees:", error));
}
window.onload=manageEmployees;
function updateStatus(id,bstatus){
	const status=(bstatus)?"Active":"Inactive";
	fetch('UpdateEmployeeStatus', {
	    method: 'POST',
	    headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
	    body: `id=${id}&status=${status}`})
	    .then(response=>response.json())
	    .then(data=>{
	    	if(!data.success){
	    		alert("failed to update status");
	    	}
	    })
	    .catch(error => console.error("Error updating status:", error));
	    
}
