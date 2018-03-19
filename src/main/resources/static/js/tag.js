

document.addEventListener("DOMContentLoaded", function() {
	// get all of the elements with class removeTag (query selector)
	const removeTagButtonCollection = document.querySelectorAll('.removeTag')
	// add event listener to onclick for each to point to removeTag
	removeTagButtonList = Array.from(removeTagButtonCollection)
	removeTagButtonList.forEach( function(removeTagButton){
		removeTagButton.addEventListener('click', removeTag)
	})
	
});

addTag
document.addEventListener("DOMContentLoaded", function() {
	const addTagButton = document.querySelector('#addButton');
	addTagButton.addEventListener('click',addTag)
})


function removeTag(event) {
	const theButton = event.target
	const theDivWrappingTheButton = theButton.parentElement
	console.log(theButton)
	const id = theButton.dataset.id
	const title = theButton.dataset.title
	// do ajax request to /remove-tag?id={id}&bookReviewTitle={title}
	const xhr = new XMLHttpRequest()//ajax request 
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4 && xhr.status === 200) {
			console.log(xhr.response);
//			
//			// delete the tag from DOM
			theDivWrappingTheButton.parentElement.removeChild(theDivWrappingTheButton)
		}
	}
	xhr.open('GET', 'http://localhost:8080/delete-tag?id=' + encodeURI(id) + '&bookReviewTitle=' + encodeURI(title),true)
	//id and title are retrieved with the button press
	xhr.send()
}


function addTag(event){
	const theButtonAdd = event.target;
	const tagTitle = docuement.querySelector('#tag-input').value
	const bookId = document.querySelector('#boodTagID').value
	console.log(tagTitle);
	const xhr = new XMLHttpRequest()//ajax request 
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4 && xhr.status === 200) {
			console.log(xhr.response);

			
		}
	}
	xhr.open('GET', 'http://localhost:8080/add-tag?id=' + encodeURI(id) + '&bookReviewTitle=' + encodeURI(title),true)
	//id and title are retrieved with the button press
	xhr.send()
	
	
}



