

document.addEventListener("DOMContentLoaded", function() {
	// get all of the elements with class removeTag (query selector)
	const removeTagButtonCollection = document.querySelectorAll('.removeTag')
	// add event listener to onclick for each to point to removeTag
	removeTagButtonList = Array.from(removeTagButtonCollection)
	removeTagButtonList.forEach( function(removeTagButton){
		removeTagButton.addEventListener('click', removeTag)
	})
	
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
	xhr.send()
}