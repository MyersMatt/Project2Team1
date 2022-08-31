 const form = document.getElementById('form');
        
        form.addEventListener('submit', function(e) {
            // Prevent default behavior:
            e.preventDefault();
            // Create payload as new FormData object:
            const payload = new FormData(form);
            // Post the payload using Fetch:
            fetch('http://localhost:8080/Project2/api/user/updateUser/', {
            method: 'PATCH',
            body: payload,
            })
            .then(res => res.json())
            .then(data => console.log(data))
        })