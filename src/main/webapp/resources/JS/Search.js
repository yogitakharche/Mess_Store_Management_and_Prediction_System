function searchProduct(str){
	let str=document.getElementById("Searchbyprod").value;
	let xhttp = new XMLHttpRequest();
	    xhttp.onreadystatechange=function(){
		if(this.readyState==4 && this.status==200){
			document.getElementById("view-product-table").innerHTML=this.responseText;
		}
	};
	xhttp.open("GET","addproduct?search="+str,true);
	xhttp.send();
}
