const cards = document.querySelectorAll(".card");

cards.forEach(button => {
    button.addEventListener('click', playGame);
});

// Event handler for the play button
function playGame(event) {
    // Access the specific button that was clicked using event.target
    const hand = this.getAttribute('data-hand');

    const playRequest = {
        hand: hand
    };

    fetch("/api/game/play?explain=true", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(playRequest)
    })
        .then(response => response.json())
        .then(data => {
            // Handle the response data
            console.log(data);
        })
        .catch(error => {
            // Handle errors
            console.error('Error:', error);
        });
}

