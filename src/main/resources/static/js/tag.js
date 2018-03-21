

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
});


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
	event.preventDefault();
	const theButtonAdd = event.target;
	const tagTitle = document.querySelector('#tag-input').value
	console.log(tagTitle);
	const xhr = new XMLHttpRequest()//ajax request 
	const bookTitle = document.querySelector('#bookTagID').value
	const tagLoop = document.querySelector('.tag-collection');
	const tagContainer = document.createElement('button');
	const booktitle = theButtonAdd.dataset.title;
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4 && xhr.status === 200) {
			console.log(xhr);
			tagContainer.innerText = tagTitle;
			console.log(tagContainer.innerText);
			tagLoop.appendChild(tagContainer); 
//			console.log(JSON.parse(xhr.responseText));//set res to json
		}
		
	}
	xhr.open('POST', '/add-tag?bookReviewTitle=' + bookTitle + '&tagName=' + tagTitle,true)
	//id and title are retrieved with the button press
	xhr.send()
}


